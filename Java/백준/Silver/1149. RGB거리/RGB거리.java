import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][3];

        for (int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<3; j++){
                int cost = Integer.parseInt(st.nextToken());
                dp[i][j] = Math.min(dp[i-1][(j+2)%3]+cost, dp[i-1][(j+4)%3]+cost);
            }
        }
        System.out.println(Arrays.stream(dp[N]).min().getAsInt());
    }
}