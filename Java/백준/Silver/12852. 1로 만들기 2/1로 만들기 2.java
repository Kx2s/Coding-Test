import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[1000001];
        List<List<Integer>> li = new ArrayList<>();

        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        li.add(new ArrayList<>());
        li.add(new ArrayList<>(Arrays.asList(1)));
        li.add(new ArrayList<>(Arrays.asList(1, 2)));
        li.add(new ArrayList<>(Arrays.asList(1, 3)));

        for (int i = 4; i < N + 1; i++) {
            int min = dp[i - 1];
            int idx = i - 1;

            if (i % 3 == 0) {
                if (min > dp[i / 3]) {
                    min = dp[i / 3];
                    idx = i / 3;
                }
            }
            if (i % 2 == 0)
                if (min > dp[i / 2]) {
                    min = dp[i / 2];
                    idx = i / 2;
                }
            dp[i] = dp[idx] + 1;

            List<Integer> tmp = new ArrayList<>(li.get(idx));
            tmp.add(i);
            li.add(tmp);
        }

        System.out.println(dp[N]);
        for (int i = li.get(N).size() - 1; i >= 0; i--) {
            System.out.print(li.get(N).get(i) + " ");
        }

    }
}