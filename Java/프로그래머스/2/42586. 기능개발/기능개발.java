import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> ans = new ArrayList<>();
        int day=1;
        int idx=0;
        int cnt=0;
        while (idx < progresses.length) {
            if (progresses[idx] + speeds[idx]*day < 100){
                day++;
                if (cnt!=0){
                    ans.add(cnt);
                    cnt = 0;
                }
                continue;
            }
            cnt++;
            idx++;
        }
        ans.add(cnt);
        
        int[] result = new int[ans.size()];
        for (int i=0; i<result.length; i++)
            result[i] = ans.get(i);    
        return result;
    }
}