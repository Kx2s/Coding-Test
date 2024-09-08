//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int idx = 0;
        int cnt = 0;
        int ans = 0;
        boolean tf = false;
        while (idx < s.length())
            if (s.charAt(idx++) == '(') {
                cnt++;
                tf = false;
            }
            else
                if (tf){
                    cnt--;
                    ans++;
                }
                else{
                    tf = true;
                    ans += --cnt;
                }
        System.out.println(ans);
    }
}