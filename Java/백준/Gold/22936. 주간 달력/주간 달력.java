//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> start = new HashMap<>();
        Map<Integer, Integer> end = new HashMap<>();
        int[] days = new int [50002];
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken())+1;

            start.put(S, start.getOrDefault(S, 0) + 1);
            end.put(E, end.getOrDefault(E, 0) + 1);
        }

        int cnt = 0;
        int max = 0;
        int total = 0;
        int s=0, e=0;
        for (int i = 1; i < days.length; i++) {
            cnt += start.getOrDefault(i, 0) - end.getOrDefault(i, 0);
            days[i] = cnt;
            total += days[i];

            if (i >= N*7) {
                total -= days[i - N * 7];
                if (total > max) {
                    max = total;
                    s = Math.max(0, i - (N * 7) + 1);
                    e = i + 1;
                }
            }
        }

        int ans = 0;
        for (int i = s+1; i<=e; i++)
            if ((i - s) % 7 == 0)
                ans += days[i-1];
            else
                ans += end.getOrDefault(i, 0);

        System.out.println(ans);
    }
}