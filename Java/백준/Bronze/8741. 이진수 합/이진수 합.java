import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++)
            sb.append(1);
        for (int i=0; i<k-1; i++)
            sb.append(0);
        System.out.println(sb);
    }
}