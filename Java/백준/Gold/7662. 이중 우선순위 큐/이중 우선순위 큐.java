import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i<T; i++)
            sb.append(testCase(Integer.parseInt(br.readLine()))).append("\n");
        System.out.println(sb);
    }

    public static String testCase(int N) throws IOException{
        PriorityQueue<Integer>[] q = new PriorityQueue[2];
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st;

        q[0] = new PriorityQueue<>();
        q[1] = new PriorityQueue<>((a, b) -> a<b? 1 : -1);

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            if (st.nextToken().equals("I")){
                int tmp = Integer.parseInt(st.nextToken());
                q[0].add(tmp);
                q[1].add(tmp);

                map.put(tmp, map.getOrDefault(tmp, 0)+1);
            }
            else {
                int tmp = Integer.parseInt(st.nextToken()) == 1 ? 1 : 0;
                while (!q[tmp].isEmpty()) {
                    int key = q[tmp].poll();
                    if (map.containsKey(key)) {
                        if (map.get(key) == 1)
                            map.remove(key);
                        else
                            map.put(key, map.get(key)-1);
                        break;
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        if (map.isEmpty())
            return "EMPTY";
        else
            for (int key : map.keySet()){
                min = Math.min(min, key);
                max = Math.max(max, key);
            }
        return max +" "+ min;
    }
}