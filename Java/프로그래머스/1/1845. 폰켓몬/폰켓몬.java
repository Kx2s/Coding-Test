import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        
        for (int n : nums)
            if (!map.containsKey(n))
                map.put(n, true);
        
        return Math.min(nums.length/2, map.size());
    }
}