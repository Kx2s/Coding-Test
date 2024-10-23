import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int ans = 0, idx = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int t : tangerine)
            map.put(t, map.getOrDefault(t, 0)+1);
        Integer[] v = new Integer[map.size()];

        for (int m : map.values())
            v[idx++] = m;
        Arrays.sort(v, Collections.reverseOrder());

        for (int i=0; i<v.length; i++) {
            sum += v[i];
            if (sum >= k) {
                ans = i+1;
                break;
            }
        }

        return ans;
    }
}