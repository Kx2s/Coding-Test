import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int ans = 0;
    static int[] my = new int[] {-1,1,0,0};
    static int[] mx = new int[] {0,0,-1,1};
    static int[][] arr;
    static List<int[]> bio = new ArrayList<int[]>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2)
                    bio.add(new int[]{i,j});
            }
        }

        start(0,0,0);
        System.out.println(ans);
    }
    public static void start(int y, int x, int dep){
        if (dep == 3){
            bio();
            return;
        }

        for (int i=y; i<N; i++) {
            int j = i==y? x : 0;
            for (; j<M; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    start(i, j + 1, dep + 1);
                    arr[i][j] = 0;
                }
            }
        }

    }

    public static void bio (){
        int[][] map = new int[N][M];
        for (int i=0; i<N; i++)
            map[i] = arr[i].clone();

        for (int[] b : bio)
            dfs(b[0], b[1], map);

        int tmp = safe(map);
        if (ans < tmp)
            ans = tmp;
    }

    public static void dfs (int y, int x, int[][] map){
        for (int i=0; i<4; i++) {
            int dy = y+my[i];
            int dx = x+mx[i];
            if (0<=dy && dy<N && 0<=dx && dx<M && map[dy][dx] == 0) {
                map[dy][dx] = 2;
                dfs(dy, dx, map);
            }
        }
    }
    public static int safe (int[][] map){
        int result = 0;

        for (int i=0; i<N; i++)
            for (int j=0; j<M; j++)
                if (map[i][j] == 0)
                    result++;

        return result;
    }
}