import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int s : scoville)
            q.offer(s);

        int before = -1;
        int ans = 0;
        while (!q.isEmpty()) {
            int now = q.poll();

            if (now >= K) {
                return before==-1? ans : ans+1;
            }
            else if (before == -1){
                before = now;
                continue;
            }

            q.offer(before+now*2);
            ans++;
            before = -1;
        }
        return -1;
    }
}