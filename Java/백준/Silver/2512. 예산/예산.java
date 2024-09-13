//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int sum = 0;

        int N = Integer.parseInt(br.readLine());
        int[] cost = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            sum += cost[i];
        }
        Arrays.sort(cost);
        int M = Integer.parseInt(br.readLine());

        if (sum <= M) {
            System.out.println(cost[N - 1]);
            return;
        }

        int s = 0;
        int e = N-1;
        while (s<=e) {
            int mid = (s+e)/2;

            if (cost[mid] <= M/(N-s)){
                for (int i = s; i<=mid; i++)
                    M -= cost[i];
                s = mid+1;
                e = N-1;
            }
            else
                e = mid-1;
        }
        System.out.println(M/(N-s));
    }
}