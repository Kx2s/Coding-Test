import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            Map<String, Integer> close = new HashMap<>();
            int N = Integer.parseInt(br.readLine());
            for (int i=0; i<N; i++) {
                String[] s = br.readLine().split(" ");
                int tmp;
                if (close.get(s[1]) == null) tmp = 1;
                else tmp = close.get(s[1])+1;
                close.put(s[1], tmp);
            }

            int ans = 1;
            for (int c : close.values())
                ans *= c+1;

            sb.append(ans-1).append("\n");
        }
        System.out.println(sb);
    }
}