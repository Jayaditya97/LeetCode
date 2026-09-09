import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Step 1: Count task frequencies
        int[] countMap = new int[26];
        for (char task : tasks) {
            countMap[task - 'A']++;
        }

        // Step 2: Max-Heap (PriorityQueue ordered in descending order)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int count : countMap) {
            if (count > 0) {
                maxHeap.offer(count);
            }
        }

        // Step 3: Cooldown queue storing [remaining_count, ready_time]
        Queue<int[]> cooldownQueue = new LinkedList<>();
        int time = 0;

        // Step 4: Simulate CPU time steps
        while (!maxHeap.isEmpty() || !cooldownQueue.isEmpty()) {
            time++;

            // Execute the task with highest frequency
            if (!maxHeap.isEmpty()) {
                int remainingCount = maxHeap.poll() - 1;
                if (remainingCount > 0) {
                    // Enter cooldown until (current time + n)
                    cooldownQueue.offer(new int[]{remainingCount, time + n});
                }
            }

            // Check if any task has completed its cooling period
            if (!cooldownQueue.isEmpty() && cooldownQueue.peek()[1] == time) {
                maxHeap.offer(cooldownQueue.poll()[0]);
            }
        }

        return time;
    }
}
