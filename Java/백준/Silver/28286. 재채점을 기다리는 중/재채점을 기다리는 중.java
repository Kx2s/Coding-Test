//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.*;

public class Main {
    static int ans = 0;
    static int[] cor;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        cor = new int[N];
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            cor[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        check(arr);
        dfs(K, arr);

        System.out.println(ans);
    }

    public static void dfs(int dep, int[] arr){
        if (dep == 0)
            return;

        for (int i = 0; i < arr.length; i++) {
            dfs(dep-1, push(i, arr));
            dfs(dep-1, pull(i, arr));
        }
    }

    public static int[] push (int idx, int[] arr){
        int[] result = arr.clone();
        result[idx] = 0;
        for (int i = idx+1; i < arr.length; i++)
            result[i] = arr[i-1];

        check(result);
        return result;
    }

    public static int[] pull (int idx, int[] arr){
        int[] result = arr.clone();
        result[arr.length-1] = 0;
        for (int i= idx; i<arr.length-1; i++)
            result[i] = arr[i+1];

        check(result);
        return result;
    }

    public static void check(int[] arr) {
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == cor[i])
                cnt++;
        }
        ans = Math.max(ans, cnt);
    }
}