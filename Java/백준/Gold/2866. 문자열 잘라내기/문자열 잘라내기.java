//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map <String, Boolean> map = new HashMap<>();

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        StringBuilder[] strs = new StringBuilder[C];
        for (int i = 0; i < C; i++)
            strs[i] = new StringBuilder();

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++)
                strs[j].append(s.charAt(j));
        }

        for (int i=0; i < R; i++){
            map.clear();
            for (int j=0; j < C; j++)
                strs[j].deleteCharAt(0);

            for (int j=0; j < C; j++) {
                if (map.containsKey(strs[j].toString())){
                    System.out.println(i);
                    return;
                }
                else
                    map.put(strs[j].toString(), true);
            }
        }
    }
}