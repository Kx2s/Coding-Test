import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int idx = 0, max = 0, ans = 0;


        int N = Integer.parseInt(br.readLine());
        Pair[] pairs = new Pair[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pairs[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        
        for (int i=1; i<N-1; i++) {
            int tmp = distance(pairs[i-1], pairs[i])
                    + distance(pairs[i], pairs[i+1])
                    - distance(pairs[i-1], pairs[i+1]);
            if (max < tmp){
                max = tmp;
                idx = i;
            }
        }

        for (int i=1; i<N; i++){
            if (i == idx){
                ans += distance(pairs[i-1], pairs[i+1]);
                i++;
            }
            else
                ans += distance(pairs[i-1], pairs[i]);
        }
        System.out.println(ans);
    }

    public static int distance (Pair p1, Pair p2){
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    static class Pair {
        int y, x;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}