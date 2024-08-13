//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        selected = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        select(0, new int[M]);

        System.out.println(sb);
    }

    public static void select (int cnt, int[] sel) {
        if (cnt == M) {
            sb.append(Arrays.toString(sel).replace("[", "").replace("]", "").replace(",", "")).append("\n");
            return;
        }

        for (int i=0; i<N; i++) {
            if (!selected[i]) {
                selected[i] = true;
                sel[cnt] = arr[i];
                select(cnt + 1, sel);
                selected[i] = false;
            }
        }
    }
}