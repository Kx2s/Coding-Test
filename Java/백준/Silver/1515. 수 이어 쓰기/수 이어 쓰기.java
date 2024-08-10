//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();

        int num = 0;
        while (st != "") {
            num++;
            String numStr = String.valueOf(num);
            int idx;

            while ((idx= numStr.indexOf(st.substring(0, 1))) != -1) {
                st = st.substring(1);
                numStr = numStr.substring(idx + 1);
                if (st == "")
                    break;
            }
        }
        System.out.println(num);
    }
}