//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeMap <Integer, Integer> levels = new TreeMap<>();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            levels.put(x, levels.getOrDefault(x, 0) + 1);
        }

        int team = levels.firstKey();
        int cnt = levels.pollFirstEntry().getValue();
        while (K > 0 && !levels.isEmpty()){
            Map.Entry<Integer, Integer> now = levels.pollFirstEntry();
            K -= (now.getKey() - team) * cnt;
            team = now.getKey();
            if (K > 0)
                cnt += now.getValue();
        }

        if (K >= cnt)
            team += K/cnt;
        else {
            while (K < 0) {
                K += cnt;
                team--;
            }
        }
        System.out.println(team);
    }
}