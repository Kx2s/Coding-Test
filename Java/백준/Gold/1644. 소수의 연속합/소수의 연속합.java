//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> decimal = getDecimal(N);

        if (decimal.isEmpty()) {
            System.out.println(0);
            return;
        }
        int s=0;
        int e=1;
        int ans = 0;
        int sum=decimal.get(0);
        while (s<e){
           if (sum < N) {
               if (e == decimal.size())
                   break;
               sum += decimal.get(e++);
           }

           else if (sum > N)
               sum -= decimal.get(s++);

           else {
               ans++;
               sum -= decimal.get(s++);
           }
        }

        System.out.println(ans);
    }

    public static List<Integer> getDecimal(int N){
        boolean[] decimal = new boolean[N+1];
        List<Integer> result = new ArrayList<>();
        Arrays.fill(decimal, true);

        for (int i = 2; i <= N; i++) {
            if (!decimal[i])
                continue;
            result.add(i);

            int cnt = 2;
            while (i*cnt <= N)
                decimal[i*cnt++] = false;
        }
        return result;
    }
}