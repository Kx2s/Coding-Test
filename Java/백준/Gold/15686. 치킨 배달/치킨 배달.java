//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, ans = Integer.MAX_VALUE;
    static int[] select;
    static List<Pair> home = new ArrayList<>();
    static List<Pair> chicken = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        select = new int[M];


        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                int now = Integer.parseInt(st.nextToken());
                if (now == 1)
                    home.add(new Pair(i, j));
                else if (now == 2)
                    chicken.add(new Pair(i, j));
            }
        }
        selectChicken(0, 0);
        System.out.println(ans);
    }

    public static void selectChicken(int idx, int dep){
        if (dep == M){
            dist();
            return;
        }
        else if (idx >= chicken.size())
            return;

        for (int i=idx; i<chicken.size(); i++) {
            select[dep] = i;
            selectChicken(i+1, dep+1);
            select[dep] = -1;
        }
        selectChicken(idx+1, dep);
    }

    public static void dist(){
        int sum = 0;

        for (int i=0; i<home.size(); i++) {
            Pair h = home.get(i);
            int tmp = 50*50;

            for (int j=0; j<M; j++) {
                Pair c = chicken.get(select[j]);
                tmp = Math.min(tmp, Math.abs(h.x - c.x) + Math.abs(h.y-c.y));
            }
            sum += tmp;
        }
        ans = Math.min(ans, sum);
    }

    static class Pair {
        int y, x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}