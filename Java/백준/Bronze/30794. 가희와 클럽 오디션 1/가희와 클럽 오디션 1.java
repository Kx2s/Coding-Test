import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int lv = Integer.parseInt(st.nextToken());
        int ans = 0;
        int num = 0;
        switch(st.nextToken()){
            case "perfect":
                num+= 400;
            case "great" :
                num+= 200;
            case "cool":
                num+= 200;
            case "bad" :
                num+= 200;
            case "miss" :
                ans = lv*num;
        }
        System.out.println(ans);
    }
}