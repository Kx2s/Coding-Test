//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int ans;

        String str1 = br.readLine();
        String str2 = br.readLine();
        int[][] dp = new int[str1.length()+1][str2.length()+1];

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1]+1;
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        ans = dp[str1.length()][str2.length()];

        int y = str1.length();
        int x = str2.length();
        while (dp[y][x] > 0) {
            if (str1.charAt(y-1) == str2.charAt(x-1)) {
                sb.append(str1.charAt(y-1));
                y--;
                x--;
            }
            else
                if (dp[y-1][x] > dp[y][x-1])
                    y--;
                else
                    x--;

        }
        System.out.println(ans);
        System.out.println(sb.reverse());
    }
}