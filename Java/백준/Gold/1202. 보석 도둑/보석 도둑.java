import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long ans = 0;

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Jewel> J = new ArrayList<>();
        Integer[] C = new Integer[K];

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            J.add(new Jewel(m, v));
        }

        for (int i=0; i<K; i++)
            C[i] = Integer.parseInt(br.readLine());
        Arrays.sort(C);

        int cnt = 0;
        PriorityQueue<Jewel> q = new PriorityQueue<>(J);
        PriorityQueue<Jewel> qMax = new PriorityQueue<>((a,b)->b.v - a.v);

        while (cnt < K) {
            Jewel j = null;
            if (q.isEmpty() || (j = q.poll()).m > C[cnt]){
                if (!qMax.isEmpty())
                    ans += qMax.poll().v;

                if (j != null)
                    q.add(j);
                cnt++;
                continue;
            }
            qMax.add(j);
        }
        System.out.println(ans);
    }

    static class Jewel implements Comparable<Jewel>{
        int m;
        int v;

        Jewel(int m, int v) {
            this.m = m;
            this.v = v;
        }

        public int compareTo(Jewel o) {
            if (this.m == o.m)
                return o.v - this.v;
            return this.m - o.m;
        }
    }
}
