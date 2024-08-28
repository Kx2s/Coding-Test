//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] need = new int[N+1];
        List<Integer>[] next = new List[N + 1];
        for (int i = 1; i <= N; i++)
            next[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            need[B]++;
            next[A].add(B);
        }

        for (int i=1; i <= N; i++)
            if (need[i] == 0)
                q.offer(i);

        while (!q.isEmpty()) {
            int now = q.poll();
            sb.append(now).append(" ");

            for (int n : next[now])
                if (--need[n] == 0)
                    q.offer(n);
        }
        System.out.println(sb);
    }
}