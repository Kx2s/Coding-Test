import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] ans = new int[N+1];
        int[][] arr = new int[N+1][3];

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int contry = Integer.parseInt(st.nextToken());
            for (int j=0; j<3; j++)
                arr[contry][j] = Integer.parseInt(st.nextToken());
        }

        for (int i=1; i<=N; i++)
            for (int j=i+1; j<=N; j++)
                for (int k=0; k<3; k++)
                    if (arr[i][k] < arr[j][k]) {
                        ans[i]++;
                        break;
                    }
                    else if (arr[i][k] > arr[j][k]) {
                        ans[j]++;
                        break;
                    }

        System.out.println(ans[M]+1);
    }
}