import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        int[] vote = new int[N];

        for (int i=0; i<N; i++)
            A[i] = Integer.parseInt(br.readLine());

        for (int i=0; i<M; i++) {
            int b = Integer.parseInt(br.readLine());
            for (int j = 0; j < N; j++)
                if (A[j] <= b){
                    vote[j]++;
                    break;
                }
        }
        
        int mx = 0;
        int ans = 0;
        for (int i=0; i<N; i++)
            if (mx < vote[i]) {
                mx = vote[i];
                ans = i;
            }

        System.out.println(ans+1);
    }
}