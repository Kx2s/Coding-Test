import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] dp = new int[30000];
        for (int i=1; i<30000; i++)
            dp[i] = dp[i-1] + i;

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<T; i++){
            int N = Integer.parseInt(st.nextToken());
            sb.append(3*dp[N/3] + 7*dp[N/7] - 21*dp[N/21]).append("\n");
        }
        System.out.println(sb);
    }
}