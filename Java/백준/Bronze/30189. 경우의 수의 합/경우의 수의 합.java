import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i=0; i<=N+M; i++)
            ans +=solve(N, M, i);

        System.out.println(ans);
    }

    public static int solve (int N, int M, int sum){
        int result = 0;
        for (int i = 0; i<=N; i++)
            for (int j=0; j<=M; j++)
                if (i+j == sum)
                    result++;

        return result;
    }
}