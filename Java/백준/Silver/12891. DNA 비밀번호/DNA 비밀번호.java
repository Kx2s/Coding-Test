//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] need = new int[4];
    static int[] has = new int[4];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String DNA = br.readLine();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++)
            need[i] = Integer.parseInt(st.nextToken());

        for (int i=0; i<P; i++)
            has[revert(DNA.charAt(i))]++;
        if (check())
            ans++;

        for (int i=P; i<S; i++) {
            has[revert(DNA.charAt(i))]++;
            has[revert(DNA.charAt(i-P))]--;
            if (check())
                ans++;
        }
        System.out.println(ans);
    }

    public static boolean check(){
        for (int i=0; i<4; i++)
            if (need[i] > has[i])
                return false;
        return true;
    }

    public static int revert (char c){
        int result = 0;

        switch(c) {
            case 'C':
                result = 1;
                break;
            case 'G':
                result = 2;
                break;
            case 'T':
                result = 3;
                break;
        }
        return result;
    }
}