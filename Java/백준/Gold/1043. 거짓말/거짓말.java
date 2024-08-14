//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer>[] people;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        people = new List[N+1];
        for (int i = 0; i <= N; i++)
            people[i] = new ArrayList<>();
        List<Integer>[] partys = new List[M];

        st = new StringTokenizer(br.readLine());
        int truth = Integer.parseInt(st.nextToken());
        int[] truths = new int[truth];
        for (int i=0; i<truth; i++)
            truths[i] = Integer.parseInt(st.nextToken());

        for (int i=0; i<M; i++) {
            List<Integer> party = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++)
                party.add(Integer.parseInt(st.nextToken()));
            partys[i] = party;

            for (int j = 0; j < n; j++)
                for (int k = j + 1; k < n; k++) {
                    people[party.get(k)].add(party.get(j));
                    people[party.get(j)].add(party.get(k));
                }
        }

        Map <Integer, Boolean> ban = ban(truths);
        int ans = 0;
        for (List<Integer> p : partys)
            for (int pp : p)
                if (ban.containsKey(pp)) {
                    ans++;
                    break;
                }
        System.out.println(M-ans);
    }

    public static Map ban (int[] arr){
        Map<Integer, Boolean> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        for (int a : arr) {
            q.offer(a);
            map.put(a, true);
        }

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int p : people[now]) {
                if (!map.containsKey(p)) {
                    map.put(p, true);
                    q.offer(p);
                }
            }
        }
        return map;
    }
}