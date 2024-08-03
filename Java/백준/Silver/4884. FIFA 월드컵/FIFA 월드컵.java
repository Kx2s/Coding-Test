//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.text.Format;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            long G = Long.parseLong(st.nextToken());
            long T = Long.parseLong(st.nextToken());
            long A = Long.parseLong(st.nextToken());
            long D = Long.parseLong(st.nextToken());
            long X = 0, Y;

            if (G == -1 && T == -1 && A == -1 && D == -1)
                break;

            long opp = G*A+D;
            long tmp = 1;
            while (tmp<opp) {
                X += tmp;
                tmp *= 2;
            }

            Y = tmp-opp;
            X += League(T) * G;

            sb.append(G).append("*").append(A).append("/").append(T).append("+").append(D)
                    .append("=").append(X).append("+").append(Y).append("\n");
        }
        System.out.println(sb);
    }
    public static long League (long a){
        long result = 0;
        for (; a>0;)
            result += --a;
        return result;
    }
}