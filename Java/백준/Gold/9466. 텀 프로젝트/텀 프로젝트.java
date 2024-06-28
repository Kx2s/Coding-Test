import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Set<Integer> ans;

        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            ans = new HashSet<>();
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            arr = new int[N];
            visited = new boolean[N];

            for (int j=0; j<N; j++)
                arr[j] = Integer.parseInt(st.nextToken())-1;

            //팀구성 시작
            for (int j=0; j<N; j++)
                if (!visited[j]) {
                    Set<Integer> team = new HashSet<>(List.of(j));
                    visited[j] = true;
                    dfs(j, team);
                    ans.addAll(team);
                }
            sb.append(N - ans.size()).append("\n");
        }
        System.out.println(sb);
    }

    public static int dfs(int now, Set<Integer> team) {
        if(team.contains(arr[now]))
            return arr[now];

        else if (!visited[arr[now]]){
            visited[arr[now]] = true;
            team.add(arr[now]);

            int result = dfs(arr[now], team);
            if (result != -1 && result != arr[now])
                return result;
        }
        team.remove(now);
        return -1;
    }
}