import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int ans = 0;
    static int[] my = new int[] {1, 0, -1, 0};
    static int[] mx = new int[] {0, 1, 0, -1};


    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        start(0, arr);
        System.out.println(ans);
    }

    public static void start(int dep, int[][] arr){
        if (dep == 5){
            int max = 0;
            for (int i=0; i<N; i++)
                max = Math.max(max, Arrays.stream(arr[i]).max().getAsInt());
            ans = Math.max(ans, max);
            return;
        }

        for (int i=0; i<4; i++)
            start(dep+1, moveNumber(i, arr));
    }

    public static int[][] moveNumber(int vec, int[][] arr){
        int start = vec<2? 0:N-1;
        int end = vec<2? N:-1;
        int x = start;
        int y = start;
        int[][] newArr = new int[N][N];

        while (x != end || y != end){
            if (x == end)
                x = start;
            else if (y == end)
                y = start;

            int tmp = arr[y][x];
            int newY = y;
            int newX = x;
            while((x += mx[vec]) != end && (y += my[vec]) != end){
                if (arr[y][x] == 0)
                    continue;

                if (tmp == arr[y][x]){
                    newArr[newY][newX] = tmp*2;
                    newY += my[vec];
                    newX += mx[vec];
                    tmp = 0;
                }
                else{
                    if (tmp != 0){
                        newArr[newY][newX] = tmp;
                        newY += my[vec];
                        newX += mx[vec];
                    }
                    tmp = arr[y][x];
                }
            }
            if (tmp != 0)
                newArr[newY][newX] = tmp;

            x += my[vec];
            y += mx[vec];
        }
        return newArr;
    }
}