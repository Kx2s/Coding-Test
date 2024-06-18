import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static int[][] ans;
    static boolean[][] visited;

    static int[] my = {0, 0, -1, 1};
    static int[] mx = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int idx = 1;

        while ((N = Integer.parseInt(br.readLine())) != 0){
            arr = new int[N][N];
            ans = new int[N][N];
            visited = new boolean[N][N];

            for (int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++)
                    arr[i][j] = Integer.parseInt(st.nextToken());
            }
            ans[0][0] = arr[0][0];
            visited[0][0] = true;

            bfs();
            sb.append("Problem ").append(idx++).append(": ").append(ans[N-1][N-1]).append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, arr[0][0]});

        while (!q.isEmpty()){
            int[] poll = q.poll();

            for (int i=0; i<4; i++){
                int dy = poll[0]+my[i];
                int dx = poll[1]+mx[i];
                if (condition(dy, dx))
                    if (!visited[dy][dx] || arr[dy][dx] + poll[2] < ans[dy][dx]){
                        visited[dy][dx] = true;
                        ans[dy][dx] = arr[dy][dx] + poll[2];
                        q.add(new int[]{dy, dx, ans[dy][dx]});
                    }
            }
        }
    }

    public static boolean condition(int y, int x){
        return 0<=y && y<N && 0<=x && x<N;
    }
}