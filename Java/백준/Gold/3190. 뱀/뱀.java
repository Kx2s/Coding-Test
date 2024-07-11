import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int K;
    static int vec = 1;
    static int[][] visited;
    static int[] my = new int[] {-1,0,1,0};
    static int[] mx = new int[] {0,1,0,-1};
    static Map<Integer, Integer> conver = new HashMap<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        visited = new int[N][N];

        for (int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken())-1;
            int x = Integer.parseInt(st.nextToken())-1;
            visited[y][x] = 2;
        }

        int L = Integer.parseInt(br.readLine());
        for (int i=0; i<L; i++){
            st = new StringTokenizer(br.readLine());
            conver.put(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0)=='L'? -1:1);
        }
        System.out.println(start(0,0));
    }

    static int start(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y,x});

        int time = 0;
        while (true) {
            if (conver.containsKey(time))
                vec = (vec + conver.get(time) + 4) % 4;

            time++;
            y+=my[vec];
            x+=mx[vec];

            if (!check(y,x))
                break;

            if (visited[y][x] == 0) {
                int[] tmp = q.poll();
                visited[tmp[0]][tmp[1]] = 0;
            }
            q.offer(new int[] {y,x});
            visited[y][x] = 1;
        }
        return time;
    }
    static boolean check (int y, int x){
        return 0<=y && y<N && 0<=x && x<N && visited[y][x] != 1;
    }
}