//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.List;

public class Main {
    static List<Character> gather = List.of('a', 'e', 'i', 'o', 'u');
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;

        while (!(str=br.readLine()).equals("#")){
            if (gather.contains(str.charAt(0)))
                sb.append(str).append("ay").append("\n");
            else {
                int idx = 1;
                while (idx<str.length() && !gather.contains(str.charAt(idx)))
                    idx++;
                sb.append(str.substring(idx)).append(str, 0, idx).append("ay").append("\n");
            }
        }
        System.out.println(sb);
    }
}