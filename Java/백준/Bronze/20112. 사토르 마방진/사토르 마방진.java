//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++)
                arr[i][j] = s.charAt(j);
        }

        for (int i = 0; i < N - 1; i++)
            for (int j = i + 1; j < N; j++)
                if (arr[i][j] != arr[j][i]) {
                    System.out.println("NO");
                    return;
                }
        System.out.println("YES");
    }
}