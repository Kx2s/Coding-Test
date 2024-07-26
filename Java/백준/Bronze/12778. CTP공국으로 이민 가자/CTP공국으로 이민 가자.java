import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            char test = st.nextToken().charAt(0);

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<M; j++){
                if (test == 'C'){
                    int tmp = st.nextToken().charAt(0) - 'A';
                    sb.append(tmp + 1).append(" ");
                }
                else {
                    int tmp = Integer.parseInt(st.nextToken()) + 64;
                    sb.append((char)tmp).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}