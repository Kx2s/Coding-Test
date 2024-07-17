import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;
        int min = 101;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int dis = 0;
            for (int j=1; j<=M; j++) {
                dis += Integer.parseInt(st.nextToken());
                if (dis >= K) {
                    if (min > j) {
                        min = j;
                        ans = i;
                    }
                    break;
                }
            }
        }
        System.out.println(ans+" "+min);
    }
}