//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Bus> q = new PriorityQueue<>();

        int N = Integer.parseInt(st.nextToken());

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            q.offer(new Bus(st.nextToken(), false));
            q.offer(new Bus(st.nextToken(), true));
        }

        int ans = 0;
        int cnt = 0;

        while (!q.isEmpty()) {
            Bus bus = q.poll();

            if (!bus.stayed) {
                cnt++;
                ans = Math.max(ans, cnt);
            }
            else
                cnt--;
        }
        System.out.println(ans);
    }

    static class Bus implements Comparable<Bus> {
        String time;
        boolean stayed;

        Bus(String time, boolean stay) {
            this.time = time;
            this.stayed = stay;
        }

        @Override
        public int compareTo(Bus b) {
            if (this.time.equals(b.time))
                return this.stayed ? 0 : 1;
            return this.time.compareTo(b.time);
        }
    }
}