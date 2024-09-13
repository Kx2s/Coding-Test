//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;

        int n = Integer.parseInt(br.readLine());

        while (n>=0) {
            ans = (ans + n/2+1)%1000000;
            n -= 3;
        }
        System.out.println(ans);
    }
}