import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] c = new char[50];

        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++){
            String tmp = br.readLine();
            for (int j=0; j<tmp.length(); j++)
                if (c[j] == 0)
                    c[j] = tmp.charAt(j);
                else if (c[j] != tmp.charAt(j))
                    c[j] = '?';
        }
        
        for (char cc : c) {
            if (cc == 0)
                break;
            sb.append(cc);
        }
        System.out.println(sb);
    }
}