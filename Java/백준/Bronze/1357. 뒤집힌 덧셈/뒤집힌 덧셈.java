//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String X = new StringBuffer(st.nextToken()).reverse().toString();
        String Y = new StringBuffer(st.nextToken()).reverse().toString();

        String sum = String.valueOf(Integer.parseInt(X) + Integer.parseInt(Y));
        String rever = new StringBuilder(sum).reverse().toString();
        System.out.println(rever.replaceFirst("^0+", ""));
    }
}