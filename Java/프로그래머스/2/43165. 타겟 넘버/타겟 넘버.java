import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int ans = 0;
        Queue<Sum> q = new LinkedList<>();
        q.offer(new Sum(numbers[0], 1));
        q.offer(new Sum(-numbers[0], 1));

        while (!q.isEmpty()){
            Sum s = q.poll();

            if (s.idx == numbers.length){
                if (s.num == target)
                    ans++;
                continue;
            }

            q.offer(new Sum(s.num+numbers[s.idx], s.idx+1));
            q.offer(new Sum(s.num-numbers[s.idx], s.idx+1));
        }
        return ans;
    }

    class Sum {
        int num, idx;

        Sum(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }
}