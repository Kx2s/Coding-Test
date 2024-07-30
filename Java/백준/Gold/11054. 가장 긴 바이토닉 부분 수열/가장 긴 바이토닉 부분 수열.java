import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+2];
        int[] arrR = new int[N+2];
        int[][] dp = new int[2][];

        for (int i = 1; i <= N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            arr[i] = tmp;
            arrR[N-i+1] = tmp;
        }

        dp[0] = start(arr);
        dp[1] = start(arrR);

        int ans = 0;
        for (int i = 1; i<=N; i++)
            ans = Math.max(ans, dp[0][i] + dp[1][N-i+1]);

        System.out.println(ans-1);
    }

    public static int[] start(int[] arr){
        int[] dp = new int[arr.length];

        for (int i=1; i<arr.length; i++){
            int idx = i;
            while(idx != 0){
                idx--;
                if (arr[idx] < arr[i])
                    dp[i] = Math.max(dp[i], dp[idx] + 1);
            }
        }
        return dp;
    }
}