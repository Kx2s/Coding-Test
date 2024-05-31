import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int P = Integer.parseInt(br.readLine());
        
        for (int T = 1; T <= P; T++) {
            int ans = 0;
            int max = 0;
            
            ArrayList<Integer> li = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            
            while (st.hasMoreTokens()) {
                int cur = Integer.parseInt(st.nextToken());
                if (cur > max) {
                    max = cur;
                    li.add(cur);
                }
                else
                    for (int i = 0; i < li.size(); i++)
                        if (li.get(i) > cur) {
                            ans += li.size() - i;
                            li.add(i, cur);
                            break;
                        }
            }
            bw.write(T+" "+ans);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}