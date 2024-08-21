//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] D;
    static int[] need;
    static List<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            D = new int[N+1];

            need = new int[N+1];
            graph = new List[N+1];
            for (int j=1; j<=N; j++)
                graph[j] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++)
                D[j] = Integer.parseInt(st.nextToken());

            for (int j = 1; j <= K; j++){
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                need[Y]++;
                graph[X].add(Y);
            }
            sb.append(build(Integer.parseInt(br.readLine()))).append("\n");
        }
        System.out.println(sb);
    }

    public static int build (int W){
        Queue<Building> q = new LinkedList<>();
        int[] times = new int[N+1];

        for (int i=1; i<=N; i++)
            if (need[i] == 0) {
                q.offer(new Building(i, D[i]));
                times[i] = D[i];
            }

        while (!q.isEmpty()){
            Building b = q.poll();
            if (b.to == W)
                break;

            for (int g : graph[b.to]) {
                times[g] = Math.max(times[g], b.time + D[g]);
                if (--need[g] == 0)
                    q.offer(new Building(g, times[g]));
            }
        }
        return times[W];
    }

    static class Building{
        int to, time;

        Building(int to, int time) {
            this.to = to;
            this.time = time;
        }
    }
}