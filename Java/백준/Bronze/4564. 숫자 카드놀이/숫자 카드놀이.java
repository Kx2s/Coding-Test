//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String S;
        while (!(S=br.readLine()).equals("0")){
            sb.append(S).append(" ");
            while (S.length()>1){
                int tmp = 1;
                for (int i=0; i<=S.length()-1; i++)
                    tmp *= S.charAt(i) - '0';
                
                S = String.valueOf(tmp);
                sb.append(S).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}