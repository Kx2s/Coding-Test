import java.io.*;
import java.time.LocalDate;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int D = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LocalDate ld = LocalDate.of(2009, M, D);
        String day = ld.getDayOfWeek().toString();

        sb.append(day.substring(0,1));
        sb.append(day.substring(1,day.length()).toLowerCase());

        System.out.println(sb);
    }
}