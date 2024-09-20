import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int[] queue1, int[] queue2) {        
        long sum1 = Arrays.stream(queue1).sum();
        long sum = sum1 + Arrays.stream(queue2).sum();
        if (sum%2 != 0)
            return -1;
        
        int[] queue = new int[queue1.length*3];
        System.arraycopy(queue1, 0, queue, 0, queue1.length);
        System.arraycopy(queue2, 0, queue, queue1.length, queue1.length);
        System.arraycopy(queue1, 0, queue, queue1.length*2, queue1.length);
        
        int ans = 0;
        int l = 0;
        int r = queue1.length-1;
        
        while (true) {
            if (sum1 < sum/2) {
                if (r == queue1.length*3 - 1)
                    return -1;
                sum1 += queue[++r];
            }
            
            else if (sum1 > sum/2) {
                sum1 -= queue[l++];
            }
            else return ans;
            ans++;
        }
    }
}