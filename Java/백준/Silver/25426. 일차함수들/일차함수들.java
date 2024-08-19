//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> q = new PriorityQueue<>();
        long ans = 0;

        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            q.offer(Long.parseLong(st.nextToken()));
            ans += Long.parseLong(st.nextToken());
        }

        int cnt = 1;
        while (!q.isEmpty())
            ans += q.poll() * cnt++;
        System.out.println(ans);
    }
}
