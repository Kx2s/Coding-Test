import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] ans = {0, sequence.length};
        
        int s = 0;
        int e = 0;
        int sum = 0;
        
        do {
            if (e == sequence.length || sum >= k)
                sum -= sequence[s++];
            else if (s == e || sum <= k)
                sum += sequence[e++];
            
            if (sum == k && e-s <= ans[1] - ans[0]) {
                ans[0] = s;
                ans[1] = e-1;
            }
        } while (s<e);
        
        return ans;
    }
}