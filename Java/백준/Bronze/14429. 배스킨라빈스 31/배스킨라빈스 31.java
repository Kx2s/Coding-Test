import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer, Integer> map = new TreeMap<>();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for (int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int len = (j-1)/(m+1)+1;
            if (!map.containsKey(len))
                map.put((j-1)/(m+1)+1, i);
        }
        System.out.println(map.get(map.firstKey())+" "+ map.firstKey()*2);
    }
}