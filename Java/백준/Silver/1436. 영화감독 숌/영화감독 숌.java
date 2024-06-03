import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];

        int idx = 1;
        int cnt = 666;
        while(arr[N] == 0){
            if (String.valueOf(cnt).contains("666"))
                arr[idx++] = cnt;
            cnt++;
        }
        System.out.println(arr[N]);
    }
}