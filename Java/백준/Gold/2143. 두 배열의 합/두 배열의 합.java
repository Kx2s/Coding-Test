//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        Map<Integer, Integer> mapA;
        Map<Integer, Integer> mapB;

        int T = Integer.parseInt(br.readLine());
        mapA = getSum(Integer.parseInt(br.readLine()));
        mapB = getSum(Integer.parseInt(br.readLine()));

        long ans = 0;
        for (Map.Entry<Integer, Integer> entry : mapA.entrySet())
            if (mapB.containsKey(T - entry.getKey()))
                ans += (long) mapB.get(T - entry.getKey()) * entry.getValue();
        System.out.println(ans);
    }

    public static Map<Integer, Integer> getSum(int n) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        int[] A = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            int sum = 0;
            for (int j = i; j>=0; j--) {
                sum += A[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        return map;
    }
}
