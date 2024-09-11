//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] hole = new boolean[N+2][M+2];
        int[][] dp = new int[N+2][M+2];
        dp[1][1] = 1;

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            hole[x][y] = true;
        }

        for (int j=1; j<=M; j++) {
            int side = j%2 == 1 ? -1 : 0;
            for (int i=1; i<=N; i++){
                if (hole[i][j])
                    continue;
                dp[i+1][j] = (dp[i][j]+dp[i+1][j]) % 1000000007;
                dp[i+side][j+1] = (dp[i][j]+dp[i+side][j+1]) % 1000000007;
                dp[i+side+1][j+1] = (dp[i][j]+dp[i+side+1][j+1]) % 1000000007;
            }
        }
        System.out.println(dp[N][M]%1000000007);
    }
}