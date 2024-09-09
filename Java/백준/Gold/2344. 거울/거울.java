//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr;

    static int[] my = new int[] {1, 0, -1, 0};
    static int[] mx = new int[] {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+2][M+2];
        int[][] ans = new int[2*N+2*M][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++)
                if(Integer.parseInt(st.nextToken()) == 1)
                    arr[i][j] = -1;
        }

        int vec = 0;
        int y=0, x=0;
        for (int i= 1; i <= 2*N+2*M; i++) {
            y += my[vec];
            x += mx[vec];

            if (check(y, x)) {
                vec = (vec + 3) % 4;
                i--;
                continue;
            }
            arr[y][x] = i;
            ans[i-1] = light(y, x);
        }

        for (int[] a : ans)
            sb.append(arr[a[0]][a[1]]).append(" ");
        System.out.println(sb);
    }

    public static int[] light (int y, int x){
        int vec;
        if (y == 0)
            vec = 0;
        else if (x == M+1)
            vec = 1;
        else if (y == N+1)
            vec = 2;
        else
            vec = 3;

        do {
            if (arr[y][x] == -1)
                vec = vec%2==0? vec+1 : vec-1;

            y += my[vec];
            x += mx[vec];
        }while (y!=0 && x!=0 && y!=N+1 && x!=M+1);

        return new int[] {y, x};
    }

    public static boolean check (int y, int x){
        return (y==0 && x == 0) || (y==N+1 && x == M+1) || (y==0 && x == M+1) || (y==N+1 && x == 0);
    }
}