//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int X = N;
        int Y = N;

        for (int i=0; i<C; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            int mx = Math.min(X, x);
            int my = Math.min(Y, y);

            if (X*my >= Y*mx)
                Y = my;
            else
                X = mx;
        }
        System.out.println(X*Y);
    }
}