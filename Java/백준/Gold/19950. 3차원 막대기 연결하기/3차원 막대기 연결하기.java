//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[][] xyz = new int[2][3];
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 3; j++)
                xyz[i][j] = Integer.parseInt(st.nextToken());

        double dis = getDistance(xyz);
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int K = Integer.parseInt(st.nextToken());
            sum += K;
            max = Math.max(max, K);
        }

        if (sum >= dis && max - (sum-max) <= dis)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    public static double getDistance(int[][] xyz) {
        double result = 0;

        for (int i = 0; i < 3; i++)
            result += Math.pow(xyz[0][i]-xyz[1][i], 2);
        return Math.sqrt(result);
    }
}