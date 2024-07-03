import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr1 = new int[N];
        int[] arr2 = new int[N];

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int idx = 0;
            while(st.hasMoreTokens()){
                int now = Integer.parseInt(st.nextToken());
                int max = Math.max(
                        idx!=0? arr1[idx-1] : 0,
                        idx!=i? arr1[idx] : 0);
                arr2[idx++] = now+max;
            }
            arr1 = arr2.clone();
        }
        System.out.println(Arrays.stream(arr1).max().getAsInt());
    }
}