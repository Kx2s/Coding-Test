import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        int[] dp0 = new int[41];
        int[] dp1 = new int[41];

        dp0[0] = 1;
        dp0[2] = 1;

        dp1[1] = 1;
        dp1[2] = 1;

        for (int i = 3; i<= 40; i++) {
            dp0[i] = dp0[i-1] + dp0[i-2];
            dp1[i] = dp1[i-1] + dp1[i-2];
        }
        for (int i=0; i<T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp0[n]).append(" ").append(dp1[n]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}