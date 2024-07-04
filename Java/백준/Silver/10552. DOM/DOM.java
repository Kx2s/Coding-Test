import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> ch = new HashMap<>();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[M+1];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int like = Integer.parseInt(st.nextToken());
            int hate = Integer.parseInt(st.nextToken());

            if (!ch.containsKey(hate))
                ch.put(hate, like);
        }

        int ans = 0;
        while (ch.containsKey(P)){
            visited[P] = true;
            P = ch.get(P);
            ans++;
            if (visited[P]){
                ans = -1;
                break;
            }
        }
        System.out.println(ans);
    }
}