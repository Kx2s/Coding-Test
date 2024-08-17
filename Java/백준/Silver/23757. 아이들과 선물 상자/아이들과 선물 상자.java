//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean ans = true;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++)
            q.offer(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int want = Integer.parseInt(st.nextToken());
            int box = q.poll();

            if (want > box) {
                ans = false;
                break;
            }
            q.offer(box-want);
        }
        System.out.println(ans? 1:0);
    }
}