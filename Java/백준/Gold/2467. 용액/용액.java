//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int min = Integer.MAX_VALUE;
        int idx1 = 0;
        int idx2 = 0;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        a:for (int i = 0; i < N-1; i++){
            int abi = Math.abs(arr[i]);
            int s = i+1;
            int e = N-1;
            while (s<=e){
                int mid = (s + e)/2;

                if (Math.abs(arr[i]+arr[mid]) < min) {
                    min = Math.abs(arr[i]+arr[mid]);
                    idx1 = i;
                    idx2 = mid;
                }

                if (abi > Math.abs(arr[mid]))
                    s = mid+1;
                else if (abi < Math.abs(arr[mid]))
                    e = mid-1;
                else
                    break a;
            }
        }
        System.out.println(arr[idx1] +" "+arr[idx2]);
    }
}