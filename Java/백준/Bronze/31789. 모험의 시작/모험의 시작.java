import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            if (c <= X && p > S) {
                sb.append("YES");
                break;
            }
        }

        if (sb.length() == 0)
            sb.append("NO");

        System.out.println(sb);
    }
}