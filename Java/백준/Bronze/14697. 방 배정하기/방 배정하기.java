//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.StringTokenizer;
import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for (int a = 0; a<=N; a+=A) 
            for (int b = 0; b <= N-a; b += B)
                for (int c = 0; c <= N-a-b; c += C)
                    if (a + b + c == N) {
                        System.out.println(1);
                        exit(0);
                    }
        System.out.println(0);
    }
}