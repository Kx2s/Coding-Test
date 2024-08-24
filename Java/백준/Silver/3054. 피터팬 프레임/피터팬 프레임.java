//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] arr = br.readLine().toCharArray();

        for (int i= -2; i<3; i++) {
            if (Math.abs(i) == 0){
                int wp = 0;
                boolean isChar = true;
                sb.append("#");
                
                for (int j=0; j<arr.length*4; j++)
                    if (j%2==1){
                        if (isChar)
                            sb.append(arr[j / 4]);
                        else {
                            sb.append(wp % 3 == 0 ? '#' : wp/3 == arr.length / 3 ? '#' : '*');
                            wp++;
                        }
                        isChar = !isChar;
                    }
                    else
                        sb.append('.');
            }
            else {
                String p;
                String w;
                sb.append('.');
                if (Math.abs(i)==1){
                    p = "#.#.";
                    w = "*.*.";
                }
                else {
                    p = ".#..";
                    w = ".*..";
                }

                for (int j=1; j<=arr.length; j++)
                    if (j%3 == 0)
                        sb.append(w);
                    else
                        sb.append(p);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}