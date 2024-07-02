import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> top = new HashMap<>();
        Map<Integer, Integer> bottom = new HashMap<>();

        for (int i=0; i<N/2; i++) {
            int b = Integer.parseInt(br.readLine());
            int t = Integer.parseInt(br.readLine());

            bottom.put(b, bottom.getOrDefault(b, 0) + 1);
            top.put(t, top.getOrDefault(t, 0) + 1);
        }

        TreeMap<Integer, Integer> ans = new TreeMap<>();
        int topsum = 0;
        int bottomsum = N/2;
        for (int i=1; i<=H; i++){
            int sum = topsum+bottomsum;
            ans.put(sum, ans.getOrDefault(sum, 0) + 1);
            bottomsum -= bottom.getOrDefault(i, 0);
            topsum += top.getOrDefault(H-i, 0);
        }
        System.out.println(ans.firstKey()+" "+ans.get(ans.firstKey()));
    }
}