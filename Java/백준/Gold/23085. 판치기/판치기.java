//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Pan> q = new LinkedList<>();
        int cnt = 0;
        int ans = -1;

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[N+1];

        String coin = br.readLine();
        for (int i = 0; i < N; i++)
            if (coin.charAt(i) == 'H')
                cnt++;

        visited[cnt] = true;
        q.offer(new Pan(cnt, 0));
        while (!q.isEmpty()) {
            Pan p = q.poll();
            int T = N - p.remain;
            if (p.remain == 0){
                ans = p.cnt;
                break;
            }

            for (int i = 1; i<=K; i++){
                if (p.remain < i || T < K-i)
                    continue;

                int tmp = (p.remain - i)+(K-i);
                if (!visited[tmp]) {
                    visited[tmp] = true;
                    q.offer(new Pan(tmp, p.cnt + 1));
                }
            }
        }
        System.out.println(ans);
    }

    static class Pan{
        int remain, cnt;

        public Pan(int remain, int cnt) {
            this.remain = remain;
            this.cnt = cnt;
        }
    }
}