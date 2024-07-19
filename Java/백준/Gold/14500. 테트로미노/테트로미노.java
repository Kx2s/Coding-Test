import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, ans;
    static int[][] arr;
    static boolean[][] visited;

    static int[] my = new int[] {0, 1, 0, -1};
    static int[] mx = new int[] {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<N; i++)
            for (int j=0; j<M; j++)
                fuck(i, j);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                match(i, j, 1, arr[i][j]);
                visited[i][j] = false;
            }
            Arrays.fill(visited[i], true);
        }
        System.out.println(ans);
    }

    public static void match(int y, int x, int dep, int sum){
        if (dep == 4) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int i=0; i<4; i++) {
            int dy = y + my[i];
            int dx = x + mx[i];

            if (check(dy, dx)){
                visited[dy][dx] = true;
                match(dy, dx, dep+1, sum+arr[dy][dx]);
                visited[dy][dx] = false;
            }
        }
    }

    public static void fuck (int y, int x){
        for (int i=0; i<4; i++) {
            int sum = arr[y][x];
            for (int j=0; j<4; j++) {
                int dy = y + my[j];
                int dx = x + mx[j];
                if (i==j)
                    continue;
                else if (!check(dy, dx))
                    break;
                sum += arr[dy][dx];
            }
            ans = Math.max(ans, sum);
        }
    }

    public static boolean check(int y, int x) {
        return 0<=y && y<N && 0<=x && x<M && !visited[y][x];
    }
}