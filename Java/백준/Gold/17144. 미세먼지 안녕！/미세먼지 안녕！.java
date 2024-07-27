import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int R, C, T, Pos;

    static int[] my = new int[] {0, 1, 0, -1};
    static int[] mx = new int[] {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        int[][] arr = new int[R][C];

        for (int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == -1)
                    Pos = i-1;
            }
        }

        for (int i=0; i<T; i++) {
            arr = diff(arr);
            cycle(arr);
        }

        int ans = 0;
        for (int i=0; i<R; i++)
            ans += Arrays.stream(arr[i]).sum();

        System.out.println(ans+2);
    }

    public static int[][] diff (int[][] arr) {
        int[][] result = new int[R][C];

        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++) {
                if (arr[i][j] == 0)
                    continue;
                else if (arr[i][j] == -1) {
                    result[i][j] = -1;
                    continue;
                }

                int dust = arr[i][j];

                for (int k=0; k<4; k++) {
                    int y = i+my[k];
                    int x = j+mx[k];

                    if (check(y,x) && result[y][x] != -1) {
                        result[y][x] += arr[i][j]/5;
                        dust -= arr[i][j]/5;
                    }
                }
                result[i][j] += dust;
            }
        }
        return result;
    }

    public static void cycle (int[][] arr){
        int pos = Pos;

        for (int i=-1; i<2; i+=2){
            int y = pos;
            int x = 1;
            int idx = 0;
            int tmp1 = 0;
            int tmp2 = 0;
            while (arr[y][x] != -1){
                tmp1 = arr[y][x];
                arr[y][x] = tmp2;
                tmp2 = tmp1;


                if (!check(y+my[idx], x+mx[idx]))
                    idx = (idx+4+i)%4;

                y += my[idx];
                x += mx[idx];
            }
            pos++;
        }
    }

    public static boolean check(int y, int x){
        return 0<=y && y<R && 0<=x && x<C;
    }
}