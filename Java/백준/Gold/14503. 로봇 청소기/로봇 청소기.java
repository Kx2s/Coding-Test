import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int[] mx = new int[] {0, 1, 0, -1};
    static int[] my = new int[] {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans=0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        while (arr[r][c] != 1) {
            if (arr[r][c] == 0) {
                arr[r][c] = 2;
                ans++;
            }

            if (needCleaning(r,c)){
                d = (d+3)%4;
                int y = r+my[d];
                int x = c+mx[d];
                if (arr[y][x] == 0){
                    r = y;
                    c = x;
                }
            }
            else {
                r -= my[d];
                c -= mx[d];
            }
        }
        System.out.println(ans);
    }

    public static boolean needCleaning(int y, int x){
        for (int i=0; i<4; i++)
            if (arr[y+my[i]][x+mx[i]] == 0)
                return true;
        return false;
    }
}