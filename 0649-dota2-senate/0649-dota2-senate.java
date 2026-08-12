import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> rq = new LinkedList<>();
        Queue<Integer> dq = new LinkedList<>();
        int n = senate.length();

        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                rq.offer(i);
            } else {
                dq.offer(i);
            }
        }

        while (!rq.isEmpty() && !dq.isEmpty()) {
            int rIndex = rq.poll();
            int dIndex = dq.poll();

            if (rIndex < dIndex) {
                rq.offer(rIndex + n);
            } else {
                dq.offer(dIndex + n);
            }
        }

        return rq.isEmpty() ? "Dire" : "Radiant";
    }
}