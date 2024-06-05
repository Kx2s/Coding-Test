import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            swit(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int idx = 0;
        while (idx < N) {
            sb.append(arr[idx++]).append(" ");
            if (idx%20 == 0)
                sb.append("\n");
        }
        System.out.print(sb);
    }

    static void swit(int g, int num){
        if (g == 1) {
            int idx = 1;
            int tmp = num-1;
            while (tmp < N){
                arr[tmp] = arr[tmp]==1? 0:1;
                tmp = (num * ++idx)-1;
            }
        }
        else {
            int l = num-1;
            int r = num-1;
            while ((l>=0 && r < N)) {
                if (arr[l] != arr[r])
                    break;
                int tmp = arr[l] == 1 ? 0 : 1;
                arr[l] = tmp;
                arr[r] = tmp;

                l--; r++;
            }
        }
    }
}