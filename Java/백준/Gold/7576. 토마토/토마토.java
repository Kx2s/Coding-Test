import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] visited;

    static int[] my = new int[] {0, 0, -1, 1};
    static int[] mx = new int[] {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Pair> tomatoes = new ArrayList<Pair>();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int [N][M];
        visited = new boolean[N][M];
        
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++){
                int tomato = Integer.parseInt(st.nextToken());
                arr[i][j] = tomato;
                if (tomato == 1) {
                    tomatoes.add(new Pair(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
        System.out.println(bfs(tomatoes));
    }

    public static int bfs (List<Pair> tomatoes){
        Queue<Pair> q = new LinkedList<Pair>();
        int day = 0;
        for (Pair p : tomatoes)
            q.add(p);

        while (!q.isEmpty()) {
            Pair p = q.poll();
            
            for (int i=0; i<4; i++) {
                int dy = p.y + my[i];
                int dx = p.x + mx[i];
                if (check(dy, dx)){
                    q.add(new Pair(dy, dx, p.day+1));
                    visited[dy][dx] = true;
                    arr[dy][dx] = 1;
                }
            }
            day = p.day;
        }
        for (int[] a : arr)
            for (int i : a)
                if (i == 0)
                    return -1;
        return day;
    }

    public static boolean check(int y, int x){
        return 0<=y && y<N && 0<=x && x<M && arr[y][x] == 0 && !visited[y][x];
    }

    static class Pair{
        int x;
        int y;
        int day;

        Pair(int y, int x, int day){
            this.y = y;
            this.x = x;
            this.day = day;
        }
    }
}