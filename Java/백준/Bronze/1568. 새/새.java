import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 1;
        int ans = 0;

        while (N != 0){
            if (N >= cnt) {
                N -= cnt;
                cnt++;
                ans++;
            }
            else
                cnt = 1;
        }
        System.out.println(ans);
    }
}