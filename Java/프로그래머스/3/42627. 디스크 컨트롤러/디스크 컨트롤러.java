import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<Disk> startQ = new PriorityQueue<>();
        PriorityQueue<Disk> timeQ = new PriorityQueue<>((a, b) -> a.time-b.time);
        for (int[] j : jobs)
            startQ.offer(new Disk(j[0], j[1]));

        int now = 0;
        int total = 0;
        while (!startQ.isEmpty()) {
            Disk d = startQ.peek();

            if (timeQ.isEmpty()){
                timeQ.offer(d);
                now = Math.max(now, d.start);
                startQ.poll();
            }
            else if (now >= d.start) {
                timeQ.offer(d);
                startQ.poll();
            }
            else {
                Disk time = timeQ.poll();
                now += time.time;
                total += now - time.start;
            }
        }

        while (!timeQ.isEmpty()) {
            Disk time = timeQ.poll();
            now += time.time;
            total += now - time.start;
        }
        

        return total/jobs.length;
    }

    class Disk implements Comparable<Disk> {
        int start;
        int time;

        Disk(int start, int time) {
            this.start = start;
            this.time = time;
        }
        public int compareTo(Disk o) {
            return this.start - o.start;
        }
    }
}