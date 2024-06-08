import java.io.*;
import java.util.Arrays;

public class Main {
    static int[] sum1 = new int [1000001];
    static int[] sum2 = new int [1000001];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int want = Integer.parseInt(br.readLine());

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[] sum1 = sumPizza(inputPizza(n));
        int[] sum2 = sumPizza(inputPizza(m));

        int ans = sum1[want] + sum2[want];
        for (int i=1; i<want; i++)
            ans += sum1[i] * sum2[want-i];
        System.out.println(ans);
    }

    public static int[] inputPizza(int num) throws IOException{
        int[] result = new int[num*2];
        for (int i = 0; i<num; i++) {
            int size = Integer.parseInt(br.readLine());
            result[i] = size;
            result[i+num] = size;
        }
        return result;
    }

    public static int[] sumPizza(int[] pizza) {
        int sum = 0;
        int[] result = new int[1000001];
        for (int i = 0; i<pizza.length/2; i++) {
            int tmp = 0;
            sum += pizza[i];
            for (int j = 0; j<pizza.length/2; j++) {
                tmp += pizza[i+j];
                result[tmp]++;
            }
        }
        result[sum] = 1;
        return result;
    }
}