import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int ans = 100000;
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int cnt = bfs(N, K);

        System.out.println(ans);
        System.out.println(cnt);

    }

    static int bfs(int N, int K) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{N, 0});
        visited[N] = true;
        int result = 0;

        while (!q.isEmpty()){
            int[] tmp = q.poll();

            if (tmp[1] > ans)
                break;
            if (tmp[0] == K) {
                result++;
                ans = tmp[1];
            }
            else {
                visited[tmp[0]] = true;
                if (check(tmp[0]+1))
                    q.add(new int[]{tmp[0] + 1, tmp[1] + 1});
                if(check(tmp[0]-1))
                    q.add(new int[]{tmp[0] - 1, tmp[1] + 1});
                if(check(tmp[0]*2))
                    q.add(new int[]{tmp[0] * 2, tmp[1] + 1});
            }
        }
        return result;
    }

    static boolean check(int N){
        return 0<=N && N<=100000 && !visited[N];
    }
}