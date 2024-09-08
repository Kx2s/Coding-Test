//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] arr = br.readLine().toCharArray();

        for (int i = K-1; i < N; i++)
            sb.append(arr[i]);

        for (int i=0; i<K-1; i++)
            if ((N-K+1)%2==0)
                sb.append(arr[i]);
            else
                sb.append(arr[K-2-i]);

        System.out.println(sb);
    }
}