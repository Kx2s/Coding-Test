//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        arr = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                String now = st.nextToken();
                if (!now.equals("0"))
                    arr[i][j] = now.equals("+");
            }
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            sb.append(relation(b, c)).append("\n");
        }
        System.out.println(sb);
    }

    public static char relation(int b, int c) {
        for (int i = 0; i<arr.length; i++) {
            if (i == b || i == c)
                continue;

            if (arr[i][c] != arr[i][b])
                return '-';
        }
        return '+';
    }
}