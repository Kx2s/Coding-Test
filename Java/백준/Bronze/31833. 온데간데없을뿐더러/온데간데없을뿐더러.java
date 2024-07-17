import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long X = Long.parseLong(br.readLine().replace(" ", ""));
        long Y = Long.parseLong(br.readLine().replace(" ", ""));

        System.out.println(Math.min(X,Y));
    }
}