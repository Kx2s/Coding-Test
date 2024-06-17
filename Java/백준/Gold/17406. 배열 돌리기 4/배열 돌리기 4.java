import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int ans = Integer.MAX_VALUE;
    static int[] my = new int[]{0, 1, 0, -1};
    static int[] mx = new int[]{1, 0, -1, 0};
    static int[][] arr;
    static int[][] info;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        info = new int[K][3];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken())-1;
            info[i][1] = Integer.parseInt(st.nextToken())-1;
            info[i][2] = Integer.parseInt(st.nextToken());
        }

        start(0, new boolean[K]);
        System.out.println(ans);
    }

    public static void start (int dep, boolean[] visit){
        if (dep == visit.length)
            for (int[] a : arr) {
                int tmp = 0;
                for (int i : a)
                    tmp += i;
                ans = Math.min(ans, tmp);
            }


        for (int i=0; i<visit.length; i++){
            if(!visit[i]){
                visit[i] = true;
                turn(info[i], true);
                start(dep+1, visit);
                turn(info[i], false);
                visit[i] = false;
            }
        }
    }

    public static void turn (int[] info, boolean tf){
        if (info[2] == 0)
            return;

        int r = info[0];
        int c = info[1];
        int s = info[2];

        int y = tf? r-s : r+s;
        int x = tf? c-s : c+s;
        int sv1 = 0;
        int sv2 = 0;
        int vec = tf? 0 : 3;

        while (vec > -1 && vec < 4){
            sv1 = arr[y][x];
            arr[y][x] = sv2;
            sv2 = sv1;

            y += my[vec];
            x += mx[vec];

            if (Math.abs(y-r) == s && Math.abs(x-c) == s)
                if (tf)
                    vec++;
                else
                    vec--;
        } arr[y][x] = sv1;
        turn (new int[]{r,c, s-1}, tf);
    }
}