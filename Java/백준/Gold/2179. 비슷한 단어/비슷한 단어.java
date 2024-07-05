import java.io.*;
import java.util.*;

public class Main {
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        List<String> maxs = new ArrayList<>();
        int max = 1;

        for (int i=0; i<N; i++){
            String in = br.readLine();
            arr[i] = in;
            for (int j=max; j<=in.length(); j++){
                String tmp = in.substring(0, j);
                int value = map.getOrDefault(tmp, 0)+1;
                max = value!=1? Math.max(max, tmp.length()) : max;
                map.put(tmp, value);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet())
            if (entry.getValue() != 1 && entry.getKey().length() == max)
                maxs.add(entry.getKey());

        int cnt = 0;
        for (String a : arr) {
            if (a.length() <  max)
                continue;
            if (maxs.contains(a.substring(0, max))){
                cnt++;
                maxs.clear();
                maxs.add(a.substring(0, max));
                System.out.println(a);
                if (cnt == 2)
                    break;
            }
        }
    }
}