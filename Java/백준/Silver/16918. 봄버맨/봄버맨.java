//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int R, C, N;
    static char[][] all;
    static char[][] bombs;

    static int[] my = {0, 0, -1, 1};
    static int[] mx = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        all = new char[R][C];
        bombs = new char[R][C];

        for (int i=0; i<R; i++)
            Arrays.fill(all[i], 'O');

        for (int i =0; i<R; i++){
            String s = br.readLine();
            for (int j=0; j<C; j++){
                char tmp = s.charAt(j);
                bombs[i][j] = tmp;
            }
        }

        char[][] first = Bomb(bombs);
        char[][] second = Bomb(first);

        if (N == 1)
            Print(bombs);
        else if (N%2 == 0)
            Print(all);
        else {
            if (N/2%2 == 1)
                Print(first);
            else
                Print(second);
        }

    }

    public static char[][] Bomb(char[][] arr){
        List<Pair> li = new ArrayList<>();
        char[][] result = new char[R][C];
        for (int i=0; i<R; i++){
            for (int j=0; j<C; j++){
                result[i][j] = 'O';
                if (arr[i][j] == 'O')
                    li.add(new Pair(i, j));
            }
        }

        for (Pair p : li) {
            result[p.y][p.x] = '.';
            for (int i=0; i<4; i++) {
                int y = p.y + my[i];
                int x = p.x + mx[i];
                if (check(y, x))
                    result[y][x] = '.';
            }
        }
        return result;
    }

    public static boolean check(int y, int x){
        return 0<=y && y<R && 0<=x && x<C;
    }

    public static void Print(char[][] arr){
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<R; i++) {
            for (int j = 0; j < C; j++)
                sb.append(arr[i][j]);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static class Pair {
        int y, x;
        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}