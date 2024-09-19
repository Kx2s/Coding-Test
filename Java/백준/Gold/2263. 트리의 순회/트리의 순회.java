//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] in, pre, post;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        in = new int[N];
        post = new int[N];
        pre = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            in[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            post[i] = Integer.parseInt(st.nextToken());

        getPre(0, N-1, 0, N-1);
        System.out.println(sb);
    }

    static void getPre(int is, int ie, int pi, int pe) {
        if (is>ie && pi>pe)
            return;

        int top = post[pe];
        int im = 0;
        for (int i = is; i <= ie; i++)
            if (top == in[i]) {
                im = i;
                break;
            }

        sb.append(top).append(" ");
        getPre(is, im-1, pi, pi+im-1-is);
        getPre(im+1, ie, pe-1-(ie-im-1), pe-1);
    }
}