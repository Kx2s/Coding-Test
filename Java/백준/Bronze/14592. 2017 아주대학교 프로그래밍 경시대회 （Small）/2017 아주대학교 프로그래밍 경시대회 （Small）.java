import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] players = new int[N][4];

        for (int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] tmp = new int[4];
            tmp[0] = Integer.parseInt(st.nextToken());
            tmp[1] = Integer.parseInt(st.nextToken());
            tmp[2] = Integer.parseInt(st.nextToken());
            tmp[3] = i+1;
            players[i] = tmp;
        }
        Arrays.sort(players, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0])
                    return b[0] - a[0];
                else if (a[1] != b[1])
                    return a[1] - b[1];
                else
                    return a[2] - b[2];
            }
        });

        System.out.println(players[0][3]);
    }
}