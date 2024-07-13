import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N, tmp;

        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            tmp = -1;
            if (N == 0) break;

            for (int i = 0; i < N; i++) {
                int now = Integer.parseInt(st.nextToken());
                if (now == tmp)
                    continue;
                sb.append(now).append(" ");
                tmp = now;
            }
            sb.append("$\n");
        }
        System.out.print(sb);
    }
}