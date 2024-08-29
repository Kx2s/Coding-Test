//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> dis = new HashSet<>();
        double ans = -1;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        double R = Double.parseDouble(st.nextToken());

        int[] piles = new int[N];
        double[] flags = new double[M];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++)
            piles[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++)
            flags[i] = Double.parseDouble(st.nextToken())/2;
        Arrays.sort(flags);

        for (int i=0; i<N; i++)
            for (int j=i+1; j<N; j++)
                dis.add(Math.abs(piles[i] - piles[j]));

        for (Integer d : dis) {
            int s = 0;
            int e = flags.length - 1;
            while (s <= e) {
                int m = (s + e) / 2;
                double now = d * flags[m];

                if (now > R)
                    e = m-1;
                else {
                    s = m + 1;
                    ans = Math.max(ans, now);
                }
            }
        }
        if (ans == -1)
            System.out.println(-1);
        else
            System.out.printf("%.1f", ans);
    }
}