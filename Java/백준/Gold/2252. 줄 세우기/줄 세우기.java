//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] needs = new int[N + 1];
        List<Integer>[] graph = new List[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            needs[B]++;
            if (graph[A] == null)
                graph[A] = new ArrayList<>();
            graph[A].add(B);
        }

        for (int i = 1; i <= N; i++)
            if (needs[i] == 0)
                q.offer(i);

        while (!q.isEmpty()) {
            int now = q.poll();
            sb.append(now).append(" ");

            if (graph[now] == null)
                continue;
            for (int g : graph[now])
                if (--needs[g] == 0)
                    q.offer(g);
        }
        System.out.println(sb);
    }
}