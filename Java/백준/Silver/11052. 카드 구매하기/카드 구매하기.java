import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++){
            int won = Integer.parseInt(st.nextToken());
            for (int j=1; j<=i/2; j++)
                won = Math.max(won, dp[j]+dp[i-j]);
            dp[i] = won;
        }
        System.out.println(dp[N]);
    }
}