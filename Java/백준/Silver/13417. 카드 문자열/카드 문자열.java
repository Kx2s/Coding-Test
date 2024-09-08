//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Character> q;
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            q = new LinkedList<>();
            q.offer(st.nextToken().charAt(0));

            while (st.hasMoreTokens()) {
                char now = st.nextToken().charAt(0);

                if (q.peekFirst() < now)
                    q.offerLast(now);
                else
                    q.offerFirst(now);
            }
            while (!q.isEmpty())
                sb.append(q.poll());
            sb.append("\n");
        }
        System.out.println(sb);
    }
}