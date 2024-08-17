//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Pair> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken())-1;
            map.put(tmp, new Pair(i, 0));
            arr[i] = tmp;
        }

        for (int i = 0; i < N; i++) {
            int num = arr[i];

            Pair change = map.get(i);
            Pair now = map.get(num);

            int dis = Math.abs(i - change.idx);
            now.dis += dis;
            change.dis += dis;

            arr[i] = i;
            arr[change.idx] = num;

            now.idx = change.idx;
            change.idx = i;

            map.put(num, now);
            map.put(i, change);
        }

        for (int i=0; i<N; i++)
            sb.append(map.get(i).dis).append(" ");
        System.out.println(sb);
    }

    static class Pair {
        int idx;
        int dis;
        Pair(int idx, int dis) {
            this.idx = idx;
            this.dis = dis;
        }
    }
}