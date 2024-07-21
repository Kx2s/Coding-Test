import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr;
    static long[][] ans;

    static int[] my = new int[] {0, 0, -1, 1};
    static int[] mx = new int[] {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        ans = new long[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);

        System.out.println(ans[0][0] == -1 ? 0 : ans[0][0]);
    }

    public static long dfs(int y, int x) {
        if (y == N-1 && x == M-1)
            return 1;
        else if (ans[y][x] != 0)
            return ans[y][x];


        for (int i=0; i<4; i++) {
            int dy = y + my[i];
            int dx = x + mx[i];
            if (check(dy, dx) && arr[y][x] > arr[dy][dx]){
                long tmp = dfs(dy, dx);
                if (tmp != -1)
                    ans[y][x] += tmp;
            }
        }

        if (ans[y][x] == 0)
            ans[y][x] = -1;
        return ans[y][x];
    }

    public static boolean check(int y, int x) {
        return 0<=y && y<N && 0<=x && x<M;
    }
}