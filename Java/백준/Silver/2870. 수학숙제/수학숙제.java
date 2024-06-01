import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> li = new ArrayList<>();

        for (int i=0; i<N; i++) {
            String[] arr = br.readLine().replaceAll("[a-z]", " ").split(" ");

            for (String s : arr)
                if (!s.isEmpty()) {
                    String tmp = s.replaceFirst("^0+", "");
                    li.add(tmp.isEmpty()? "0" : tmp);
                }
        }
        Collections.sort(li, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length())
                    for (int i = 0; i<o1.length(); i++)
                        if (o1.charAt(i) != o2.charAt(i))
                            return o1.charAt(i) - o2.charAt(i);
                return o1.length() - o2.length();
            }
        });
        for (String l : li)
            System.out.println(l.isEmpty()? "0" : l);
    }
}