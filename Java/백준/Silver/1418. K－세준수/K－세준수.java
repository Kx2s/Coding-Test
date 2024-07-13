import java.io.*;

public class Main {
    static int N, K;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 1;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        for (int i=2; i<=N; i++)
            ans += fac(i, 2);

        System.out.println(ans);
    }

    static public int fac (int n, int div){
        if (div > K)
            return 0;

        while (n%div == 0)
            n /= div;

        if (n == 1)
            return 1;
        else
            return fac(n, div+1);
    }
}