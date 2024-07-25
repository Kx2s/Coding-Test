import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[][] water = new boolean[2][10];
        int ans = 100;

        int r = Integer.parseInt(st.nextToken())-1;
        int c = Integer.parseInt(st.nextToken())-1;

        for (int i=0; i<10; i++) {
            String line = br.readLine();
            for (int j=0; j<10; j++)
                if (line.charAt(j) == 'o') {
                    water[0][i] = true;
                    water[1][j] = true;
                }
        }

        for (int i=0; i<10; i++) {
            if (water[0][i])
                continue;
            for (int j=0; j<10; j++)
                if (!water[1][j])
                    ans = Math.min(ans, Math.abs(r - i) + Math.abs(c - j));
        }
        System.out.println(ans==100? 0 : ans);
    }
}