//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = (Integer.parseInt(br.readLine())-1)%28+1;
            String call;

            if(N < 16)
                call = Integer.toBinaryString(N);
            else
                call = Integer.toBinaryString(15-(N-15));
            call = String.format("%04d", Integer.parseInt(call));

            for (int j = 0; j < call.length(); j++)
                sb.append(call.charAt(j)=='1'? "딸기":"V");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}