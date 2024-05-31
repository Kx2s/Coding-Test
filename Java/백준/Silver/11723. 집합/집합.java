import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[21];
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cal = st.nextToken();
            int idx = st.hasMoreElements()? Integer.parseInt(st.nextToken()) : 0;
            switch (cal) {
                case "add" :
                    arr[idx] = 1;
                    break;
                case "remove" :
                    arr[idx] = 0;
                    break;
                case "toggle" :
                    arr[idx] = arr[idx] == 1 ? 0 : 1;
                    break;
                case "all" :
                    Arrays.fill(arr, 1);
                    break;
                case "empty" :
                    arr = new int[21];
                    break;
                case "check" :
                    bw.write(arr[idx] == 1 ? "1" : "0");
                    bw.newLine();
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}