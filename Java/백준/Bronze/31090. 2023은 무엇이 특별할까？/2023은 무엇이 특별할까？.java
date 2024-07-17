import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());

            if((N+1)%(N%100)== 0)
                sb.append("Good\n");
            else
                sb.append("Bye\n");
        }

        System.out.println(sb);
    }
}