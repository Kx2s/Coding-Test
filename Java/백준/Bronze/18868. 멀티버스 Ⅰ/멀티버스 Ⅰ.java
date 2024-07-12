import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int M;
    static int N;
    static int[][] planet;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        planet = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                planet[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<N; i++)
            for (int j=i+1; j<N; j++)
                if (checkPlanet(i, j))
                    ans++;
        System.out.println(ans);
    }

    static boolean checkPlanet(int p1, int p2){
        for(int i=0; i<M; i++)
            for (int j=i+1; j<M; j++) {
                if (!((planet[p1][i] > planet[p1][j]) && (planet[p2][i] > planet[p2][j])) &&
                        !((planet[p1][i] < planet[p1][j]) && (planet[p2][i] < planet[p2][j])) &&
                        !((planet[p1][i] == planet[p1][j]) && (planet[p2][i] == planet[p2][j]))) {
                    return false;
                }
            }
        return true;
    }
}