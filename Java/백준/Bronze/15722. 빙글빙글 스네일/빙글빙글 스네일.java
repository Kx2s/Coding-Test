//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] vecY = {1, 0, -1, 0};
    static int[] vecX = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] pos = new int[] {0, 0};
        int cnt =0;

        int N = Integer.parseInt(br.readLine());

        while (N > 0){
            for (int i=0; i<cnt/2+1; i++) {
                pos[0] += vecX[cnt % 4];
                pos[1] += vecY[cnt % 4];
                if (--N == 0)
                    break;
            }
            cnt++;
        }
        System.out.println(pos[0]+" "+pos[1]);
    }
}