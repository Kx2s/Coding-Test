import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] my = {-1, 1, 0, 0};
    static int[] mx = {0, 0, -1, 1};
    static int[][] arr;
    static int[][] visit;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visit = new int[N][M];
        visit[0][0] = 1;

        for (int i=0; i<N; i++) {
            String line = br.readLine();
            for (int j=0; j<M; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }
        bfs(0, 0);
        System.out.print(visit[N-1][M-1]);
    }

    public static void bfs(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x, 1});

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            for (int i=0; i<4; i++) {
                int dy = tmp[0]+my[i];
                int dx = tmp[1]+mx[i];
                if(check(dy,dx) && arr[dy][dx]==1) {
                    if (visit[dy][dx] == 0 || visit[dy][dx] > tmp[2]+1) {
                        visit[dy][dx] = tmp[2] + 1;
                        q.add(new int[]{dy, dx, tmp[2] + 1});
                    }
                }
            }
        }

    }

    public static boolean check(int y, int x) {
        if (0<=y && y<N && 0<=x && x<M)
            return true;
        return false;
    }
}