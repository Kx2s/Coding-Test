import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int ans = 32800000;
        int cnt = 0;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i =0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        for (int i=0; i<N-1; i++) {
            int tmp = arr[i+1] - arr[i];
            if (tmp < ans){
                ans = tmp;
                cnt = 1;
            }
            else if (tmp == ans)
                cnt++;
        }

        System.out.println(ans+" "+cnt);
    }
}