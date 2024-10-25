import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> ans = new HashSet<>();
        
        for (int i=1; i<=elements.length; i++) {
            int sum = 0;
            int s = 0;
            int e = 0;
            while (e < elements.length*2){
                if (e-s < i)
                    sum += elements[e++ % elements.length];
                else {
                    sum -= elements[s++ % elements.length];
                    sum += elements[e++ % elements.length];
                }
                ans.add(sum);
            }
        }
        
        return ans.size();
    }
}