import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp1 = new int[31];
        int[] dp2 = new int[31];

        dp1[1] = 1;
        dp1[2] = 3;
        dp1[3] = 5;
        dp1[4] = 11;

        dp2[1] = 1;
        dp2[2] = 3;
        dp2[3] = 1;
        dp2[4] = 5;

        for (int i=5; i<=N; i++) {
            dp1[i] = dp1[i - 1] + (dp1[i - 2] * 2);
            dp2[i] = dp2[i-2] + (dp2[i-4]*2);
        }
        
        if (N<2)
            System.out.println(dp1[N]);
        else
            System.out.println(dp2[N] + ((dp1[N] - dp2[N])/2));
    }
}