import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        int[] t = new int[302];
        int[] w = new int[301];

        for (int i=1; i<302; i++)
            t[i] = t[i-1] + i;
        for (int i=1; i<301; i++)
            w[i] = w[i-1] + (t[i+1]*i);

        for (int i=0; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            sb.append(w[n]).append("\n");
        }
        System.out.println(sb);
    }
}