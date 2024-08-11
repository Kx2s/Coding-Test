//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int f = 0;
        int e = 0;

        for (int i =0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push" :
                    arr[e++] = Integer.parseInt(st.nextToken());
                    break;

                case "pop" :
                    if (f==e)
                        sb.append(-1).append("\n");
                    else {
                        sb.append(arr[f]).append("\n");
                        f++;
                    }
                    break;

                case "size" :
                    sb.append(e-f).append("\n");
                    break;

                case "empty" :
                    sb.append(f==e? 1:0).append("\n");
                    break;

                case "front" :
                    sb.append(f==e? -1:arr[f]).append("\n");
                    break;

                case "back" :
                    sb.append(f==e? -1:arr[e-1]).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}