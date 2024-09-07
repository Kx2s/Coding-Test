//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> select = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int total = (N+1)*N/2;
        boolean[] visited = new boolean[N + 1];
        boolean[] num = new boolean[total+1];
        num[1] = true;

        int day = 0;
        for (int i = 1; i < num.length; i++){
            if (num[i] && !visited[i-day]){
                visited[i-day] = true;
                select.add(i-day);
                day = i;
                continue;
            }

            int mul = 2;
            while (i*mul < num.length)
                num[i*mul++] = true;
        }

        if (!num[total])
            sb.append("NO");
        else{
            sb.append("YES\n");
            for (int s : select)
                sb.append(s).append(" ");
        }
        System.out.println(sb);
    }
}