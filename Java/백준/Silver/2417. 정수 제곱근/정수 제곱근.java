import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double N = Double.parseDouble(br.readLine());
        double s = 0;
        double e = Math.pow(2, 32);

        while (s < e){
            long mid = (long)(s + e) / 2;
            double pow = Math.pow(mid, 2);
            if (N <= pow)
                e = mid;
            else
                s = mid+1;
        }
        System.out.println((long)Math.ceil(s));
    }
}