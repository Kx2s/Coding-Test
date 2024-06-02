import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;
        while (!".".equals(str = br.readLine())) {
            str = str.replaceAll("[a-z, A-Z]", "").replaceAll(" ", "");

            while (str.contains("[]") || str.contains("()"))
                str = str.replace("[]", "").replace("()", "");

            sb.append(".".equals(str)? "yes" : "no");
            sb.append("\n");
        }
        System.out.print(sb);
    }
}