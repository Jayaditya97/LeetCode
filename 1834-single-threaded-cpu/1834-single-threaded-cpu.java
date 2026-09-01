class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] sortedTasks = new int[n][3];
        for (int i = 0; i < n; i++) {
            sortedTasks[i][0] = tasks[i][0]; 
            sortedTasks[i][1] = tasks[i][1]; 
            sortedTasks[i][2] = i;         


        }
        Arrays.sort(sortedTasks, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[2], b[2]);
            
        });

        int[] result = new int[n];
        int resultIndex = 0;
        int taskIndex = 0;
        long currentTime = 0;

        while (resultIndex < n) {
            if (minHeap.isEmpty() && taskIndex < n && currentTime < sortedTasks[taskIndex][0]) {
                currentTime = sortedTasks[taskIndex][0];
            }
            while (taskIndex < n && sortedTasks[taskIndex][0] <= currentTime) {
                minHeap.offer(sortedTasks[taskIndex]);
                taskIndex++;


            }
            if (!minHeap.isEmpty()) {
                int[] currentTask = minHeap.poll();
                int processingTime = currentTask[1];
                int originalIndex = currentTask[2];

                result[resultIndex++] = originalIndex;

                currentTime += processingTime;


            }

        }
        return result;
    }
}