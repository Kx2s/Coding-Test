import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int first = parse(br.readLine().charAt(0));
        char[] arr = br.readLine().toCharArray();
        long[][] dp = new long[arr.length+1][9];
        dp[0][first*3 + first] = 1;

        for (int i=1; i<dp.length; i++) {
            int now = parse(arr[i-1]);
            for (int j=0; j<3; j++)
                for (int k=0; k<3; k++)
                    dp[i][j*3+now] += dp[i-1][k*3+j];
            dp[i][now*3+now] -= dp[i-1][(now*3+now+3)%9];

            for (int j=0; j<9; j++)
                dp[i][j] = (dp[i][j] + dp[i-1][j]) % 1000000007;
        }
        System.out.println((Arrays.stream(dp[dp.length-1]).sum())%1000000007 - 1);
    }

    public static int parse (char c){
        if (c=='R')
            return 0;
        else if (c=='P')
            return 1;
        else
            return 2;
    }
}