import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int ans = 0;
        Map<String, Integer> index = new HashMap<>();
        for (int i=0; i<want.length; i++)
            index.put(want[i], i);
        
        int l=0;
        A:for (int i=0; i<discount.length; i++) {
            if (index.containsKey(discount[i]))
                number[index.get(discount[i])]--;
            
            if (i-l >= 10){
                if(index.containsKey(discount[l]))
                    number[index.get(discount[l])]++;
                l++;
            }
            
            for (int n : number)
                if (n != 0)
                    continue A;
            ans++;
        }
        return ans;
    }
}