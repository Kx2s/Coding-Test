import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack <Tower> stack = new Stack<>();

        for (int i=1; i<=N; i++){
            int now = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek().h < now)
                stack.pop();

            if (stack.isEmpty())
                sb.append(0);
            else
                sb.append(stack.peek().idx);
            sb.append(" ");

            stack.push(new Tower(i, now));
        }
        System.out.println(sb);
    }

    static class Tower {
        int idx;
        int h;

        Tower(int idx, int h) {
            this.idx = idx;
            this.h = h;
        }
    }
}