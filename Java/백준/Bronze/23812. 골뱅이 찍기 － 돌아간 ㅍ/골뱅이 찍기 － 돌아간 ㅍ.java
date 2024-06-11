import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb  = new StringBuilder();
    StringBuilder s1 = new StringBuilder();
    StringBuilder s2 = new StringBuilder();

    int N = Integer.parseInt(br.readLine());
    for (int i=0; i<N; i++) {
        s1.append("@");
        s2.append(" ");
    }

    for (int i=0; i<N*5; i++) {
        sb.append(s1);
        for (int j = 0; j < 3; j++)
            if ((i / N) % 2 == 0)
                sb.append(s2);
            else
                sb.append(s1);

        sb.append(s1);
        sb.append('\n');
    }

        System.out.println(sb);
    }
}