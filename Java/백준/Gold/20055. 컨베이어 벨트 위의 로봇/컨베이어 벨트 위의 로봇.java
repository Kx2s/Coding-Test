import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int K;
    static int[] A;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N*2];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N*2; i++)
            A[i] = Integer.parseInt(st.nextToken());

        System.out.println(start());
    }

    public static int start (){
        Queue<Integer> q = new LinkedList<Integer>();

        int result = 0;
        int cnt = 0;
        int up = 0;
        int end = N-1;
        do{
            //벨트 이동
            up = idx(up-1);
            end = idx(end-1);

            //로봇 이동
            int size = q.size();
            for (int i=0; i<size; i++){
                int tmp = q.poll();
                if (tmp == end)
                    continue;

                if (A[idx(tmp+1)] != 0 && !q.contains(idx(tmp+1))){
                    if (--A[idx(tmp+1)] == 0)
                        cnt++;
                    if (idx(tmp+1) != end)
                        q.offer(idx(tmp + 1));
                }
                else
                    q.offer(tmp);
            }

            //로봇 추가
            if (A[up] != 0) {
                if (--A[idx(up)] == 0)
                    cnt++;
                q.add(up);
            }
            result++;
        } while (cnt < K);
        return result;
    }

    public static int idx(int i) {
        return ((2*N) + i) % (2*N);
    }
}