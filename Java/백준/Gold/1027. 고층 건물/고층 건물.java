import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] view = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        for (int i=0; i<N; i++) {
            for (int j=i+1; j<N; j++) {
                boolean tf = true;
                double h = (double) (arr[j] - arr[i]) / (j-i);

                for (int k=i+1; k<j; k++) {
                    double value = h*(k-i) + arr[i];

                    if (arr[k] >= value){
                        tf = false;
                        break;
                    }
                }
                if (tf) {
                    view[i]++;
                    view[j]++;
                }
            }
        }
        int ans=0;
        for (int v : view)
            ans = Math.max(ans, v);
        System.out.println(ans);
    }
}