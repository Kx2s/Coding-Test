import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        for (int i=0; i<N; i++) {
            int s = 0;
            int e = N - 1;
            while (s < e)
                if (s == i) s++;
                else if (e == i) e--;
                else
                    if (arr[s]+arr[e] < arr[i])
                        s++;
                    else if (arr[s]+arr[e] > arr[i])
                        e--;
                    else if (arr[s]+arr[e] == arr[i]){
                        ans++;
                        break;
                    }
                    else
                        break;
        }
        System.out.println(ans);
    }
}