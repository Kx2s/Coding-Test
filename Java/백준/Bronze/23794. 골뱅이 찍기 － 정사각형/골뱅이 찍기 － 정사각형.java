//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        sb.append(floor(N));

        String wall = "@";
        for (int i=0; i<N; i++)
            wall += " ";
        wall += "@\n";

        for (int i=0; i<N; i++)
            sb.append(wall);
        sb.append(floor(N));

        System.out.println(sb);
    }

    public static String floor (int N) {
        StringBuilder result = new StringBuilder("@@");
        while (N-- > 0)
            result.append("@");
        result.append("\n");
        return result.toString();
    }
}