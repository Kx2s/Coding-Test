//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] cnt = new int[20];
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            String two = Integer.toBinaryString(num);

            for (int j = 0; j < two.length(); j++)
                if (two.charAt(two.length() - j - 1) == '1')
                    cnt[j]++;
        }

        System.out.println(Arrays.stream(cnt).max().getAsInt());
    }
}