//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static char[] str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        str = br.readLine().toCharArray();

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken())-1;
            int r = Integer.parseInt(st.nextToken())-1;

            if (num == 1)
                sb.append(Query1(l, r)).append("\n");
            else
                Query2(l, r);
        }
        System.out.println(sb);
    }

    public static int Query1 (int l, int r){
        char now = ' ';
        int result = 0;

        for (int i = l; i <= r; i++)
            if (now != str[i]){
                result++;
                now = str[i];
            }
        return result;
    }

    public static void Query2 (int l, int r){
        int next;

        for (int i = l; i <= r; i++){
            next = str[i] + 1;
            if (next > 'Z')
                next = 'A';
            str[i] = (char)next;
        }
    }
}