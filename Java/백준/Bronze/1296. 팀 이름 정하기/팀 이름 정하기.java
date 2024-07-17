import java.io.*;
import java.util.TreeMap;

public class Main {
    static int L, O, V, E;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer, String> map = new TreeMap<>();

        String name = br.readLine();
        int N = Integer.parseInt(br.readLine());
        search(name);
        int l = L;
        int o = O;
        int v = V;
        int e = E;

        for (int i=0; i<N; i++) {
            String team = br.readLine();
            search(team);
            int tmp = ((l+L+o+O)*(l+L+v+V)*(l+L+e+E)*(o+O+v+V)*(o+O+e+E)*(v+V+e+E))%100;
            if (map.containsKey(tmp))
                map.put(tmp, map.get(tmp).compareTo(team) > 0 ? team : map.get(tmp));
            else
                map.put(tmp, team);
        }

        System.out.println(map.lastEntry().getValue());
    }

    public static void search(String name){
        L = 0;
        O = 0;
        V = 0;
        E = 0;

        for (char n : name.toCharArray()) {
            switch (n) {
                case 'L':
                    L++;
                    break;
                case 'O':
                    O++;
                    break;
                case 'V':
                    V++;
                    break;
                case 'E':
                    E++;
                    break;
            }
        }
    }
}