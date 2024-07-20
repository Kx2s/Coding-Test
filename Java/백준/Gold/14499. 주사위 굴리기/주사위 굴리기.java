import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, x, y, K;
    static int[][] arr;
    static int[] my = new int[] {0, 0, -1, 1};
    static int[] mx = new int[] {1, -1, 0, 0};
    static StringBuilder sb = new StringBuilder();

    static int up=0, down=0;
    static int[] val = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<K; i++)
            dice(Integer.parseInt(st.nextToken()) - 1);

        System.out.println(sb);
    }

    public static void dice(int vec) {
        int dy = y + my[vec];
        int dx = x + mx[vec];

        if (!check(dy, dx))
            return;
        y = dy;
        x = dx;

        int vecR = vec<2? (vec+1)%2 : (vec+1)%2+2;
        int d = down;
        int u = up;
        down = val[vec];
        up = val[vecR];
        val[vec] = u;
        val[vecR] = d;

        if (arr[dy][dx] == 0)
            arr[dy][dx] = down;
        else {
            down = arr[dy][dx];
            arr[dy][dx] = 0;
        }
        sb.append(up).append("\n");
    }

    public static boolean check(int y, int x) {
        return 0<=y && y<N && 0<=x && x<M;
    }
}