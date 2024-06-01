import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int ans = 3000;
    static int[] mx = {-1,1,0,0};
    static int[] my = {0,0,-1,1};
    static int[][] arr;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j =0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        start(1, 1,0, 0);
        System.out.print(ans);
    }

    public static void start (int x, int y, int sum, int ea) {
        if (ea == 3) {
            ans = Math.min(ans, sum);
            return;
        }
        for (int i=y; i<N-1; i++) {
            int j = i==y ? x:1;

            for (; j < N-1; j++) {
                if (check(j, i)) {
                    int tmp = visited(j, i, true);
                    start(j+2, i, sum + tmp, ea + 1);
                    visited(j, i, false);
                }
            }
        }
    }

    public static int visited(int x, int y, boolean tf) {
        int result = arr[y][x];
        visit[y][x] = tf;
        for (int i = 0; i < 4; i++) {
            visit[y+my[i]][x+mx[i]] = tf;
            result += arr[y+my[i]][x+mx[i]];
        }
        return result;
    }

    public static boolean check(int x, int y) {
        if (visit[y][x])
            return false;

        for (int i = 0; i < 4; i++){
            if (visit[y+my[i]][x+mx[i]])
                return false;
        }
        return true;
    }
}