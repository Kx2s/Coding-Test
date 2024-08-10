//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int[] using;

        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            using = new int[201];

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken())-1;
                int t = Integer.parseInt(st.nextToken())-1;

                if (s > t) {
                    int tmp = s;
                    s = t;
                    t = tmp;
                }

                for (int k=s/2; k<=t/2; k++)
                    using[k]++;
            }
            sb.append(Arrays.stream(using).max().getAsInt()*10).append("\n");
        }
        System.out.println(sb);
    }
}