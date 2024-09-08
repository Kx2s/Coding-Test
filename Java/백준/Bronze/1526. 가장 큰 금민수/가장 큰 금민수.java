//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp;

        String N = br.readLine();

        int ans = Integer.parseInt(N);

        A:while (ans >= 4) {
            tmp = String.valueOf(ans);
            for (int i = 0; i < tmp.length(); i++)
                if (tmp.charAt(i) != '4' && tmp.charAt(i) != '7') {
                    ans--;
                    continue A;
                }

            if (Integer.parseInt(N) >= ans) {
                System.out.println(ans);
                return;
            }
        }
    }
}