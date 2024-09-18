//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        double ans = Double.MAX_VALUE;
        int x = 0;
        int y = 0;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());

            x += arr[i][0];
            y += arr[i][1];
        }
        sb.append(x).append(" ").append(y).append("\n");

        for(int i = 0; i < N; i++)
            ans = Math.min(ans, Math.pow(x - arr[i][0], 2) + Math.pow(y - arr[i][1], 2));

        sb.append(String.format("%.2f", Math.sqrt(ans)));
        System.out.println(sb);
    }
}