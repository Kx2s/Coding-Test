//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double L = Double.parseDouble(br.readLine());

        System.out.println((int)Math.ceil(L/5));
    }
}