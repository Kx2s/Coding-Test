//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int cnt = 0;
        int day = N*24*60;
        int time = 15*60;

        while (time < day+(24*60)) {
            for (int i=0; i<3 && time < day+(24*60); i++) {
                if (time >= day) {
                    cnt++;
                    int now = time - day;
                    sb.append(String.format("%02d:%02d", now/60, now%60)).append("\n");
                }
                time += 3*60;
            }
            time+= 15*60+K;
        }
        System.out.println(cnt);
        System.out.println(sb);
    }
}