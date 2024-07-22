import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static char[][] arr;
    static boolean[][][] visited;

    static int[] my = new int[] {0, 0, -1, 1};
    static int[] mx = new int[] {-1, 1, 0, 0};

    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        visited = new boolean[2][N][N];

        for (int i=0; i<N; i++) {
            String s = br.readLine();
            for (int j=0; j<N; j++)
                arr[i][j] = s.charAt(j);
        }

        int ans1 = 0;
        int ans2 = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                ans1 += bfs(i, j, 0);
                ans2 += bfs(i, j, 1);
            }
        }
        sb.append(ans1).append(" ").append(ans2);
        System.out.println(sb);
    }

    public static int bfs (int y, int x, int color){
        if (visited[color][y][x])
            return 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(y, x));
        visited[color][y][x] = true;

        while (!q.isEmpty()){
            Pair p = q.poll();

            for (int i=0; i<4; i++) {
                int dy = p.y + my[i];
                int dx = p.x + mx[i];

                if (check(dy, dx, color)) {
                    if (same(arr[p.y][p.x], arr[dy][dx], color)) {
                        visited[color][dy][dx] = true;
                        q.add(new Pair(dy, dx));
                    }
                }
            }
        }
        return 1;
    }

    public static boolean check(int y, int x, int color){
        return 0<=y && y<N && 0<=x && x<N && !visited[color][y][x];
    }

    public static boolean same (char a, char b, int color){
        if (color == 1)
            return (a=='B' && b=='B') || (a!='B' && b!='B');
        else
            return a == b;
    }

    static class Pair {
        int x, y;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}