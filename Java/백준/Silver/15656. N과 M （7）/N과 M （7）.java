//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        dfs(0, new int[M]);
        System.out.println(sb);
    }

    public static void dfs (int dep, int[] select){
        if (dep == M) {
            for (int a : select)
                sb.append(a).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 0; i<N; i++) {
            select[dep] = arr[i];
            dfs(dep+1, select);
        }
    }
}