import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] arr;
    static int[][][] min;
    static boolean[][] visited;

    static int[] mx = new int[] {0, 0, -1, 1};
    static int[] my = new int[] {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        min = new int[N][M][2];
        visited = new boolean[N][M];

        for (int i=0; i<N; i++){
            String s = br.readLine();
            for (int j=0; j<M; j++)
                arr[i][j] = s.charAt(j) - '0';
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Player> q = new LinkedList<>();
        q.add(new Player(0, 0, 1, 0));
        min[0][0][0] = 1;
        min[0][0][1] = 1;

        while (!q.isEmpty()) {
            Player p = q.poll();

            for (int i=0; i<4; i++) {
                int y = p.y + my[i];
                int x = p.x + mx[i];
                if (condition(y, x)) {
                    if (arr[y][x] == 1 && p.wall == 0 && (min[y][x][1] == 0 || min[y][x][1] > p.dis + 1)) {
                        min[y][x][p.wall] = p.dis + 1;
                        q.add(new Player(y, x, p.dis + 1, 1));
                    } else if (arr[y][x] == 0 && (min[y][x][p.wall] == 0 || min[y][x][p.wall] > p.dis + 1)) {
                        min[y][x][p.wall] = p.dis + 1;
                        q.add(new Player(y, x, p.dis + 1, p.wall));
                    }
                }
            }
        }
        if (min[N-1][M-1][0] == 0 && min[N-1][M-1][1] == 0)
            return -1;
        else if (min[N-1][M-1][0] == 0)
            return min[N-1][M-1][1];
        else if (min[N-1][M-1][1] == 0)
            return min[N-1][M-1][0];
        else
            return Math.min(min[N-1][M-1][0], min[N-1][M-1][1]);
    }

    public static boolean condition (int y, int x){
        return 0<=y && y<N && 0<=x && x<M;
    }

    static class Player{
        int x, y, dis;
        int wall;

        Player(int y, int x, int dis, int wall){
            this.x = x;
            this.y = y;
            this.dis = dis;
            this.wall = wall;
        }
    }
}