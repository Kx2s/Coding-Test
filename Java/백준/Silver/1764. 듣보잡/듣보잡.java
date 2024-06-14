import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> listen = new HashMap<>();
        List<String> ans = new ArrayList<>();

        for(int i=0; i<N; i++)
            listen.put(br.readLine(),1);

        for (int i=0; i<M; i++) {
            String tmp = br.readLine();
            if (listen.containsKey(tmp))
                ans.add(tmp);
        }
        Collections.sort(ans);

        System.out.println(ans.size());
        for (String a : ans)
            System.out.println(a);

    }
}