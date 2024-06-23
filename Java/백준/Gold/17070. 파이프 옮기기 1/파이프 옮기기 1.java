import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static int[][][] dp;

    static int[] mx = new int[] {1, 1, 0};
    static int[] my = new int[] {0, 1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dp = new int[N][N][3];
        dp[0][1][0] = 1;

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<N; i++)
            for (int j=1; j<N; j++)
                for (int k=0; k<3; k++) {
                    int dy = i+my[k];
                    int dx = j+mx[k];
                    if (!condition(dy, dx))
                        continue;
                    if (k==1 && (arr[i+1][j]==1 || arr[i][j+1]==1))
                        continue;
                    dp[dy][dx][k] = pip(i, j, k);
                }
        
        int ans = 0;
        for (int i=0; i<3; i++)
            ans += dp[N-1][N-1][i];
        System.out.println(ans);
    }
    
    public static boolean condition(int y, int x){
        return 0<=y && y<N && 0<=x && x<N && arr[y][x] != 1;
    }

    public static int pip (int y, int x, int type){
        int result=0;

        for (int i=-1; i<=1; i++) {
            int tmp = type + i;
            if (0<=tmp && tmp<3){
                result += dp[y][x][tmp];
            }
        }
        return result;
    }
}