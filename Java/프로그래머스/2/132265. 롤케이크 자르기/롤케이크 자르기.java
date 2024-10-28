import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int ans = 0;
        int meCnt = 0;
        int broCnt = 0;
        int[] me = new int[10001];
        int[] bro = new int[10001];
        
        for (int t : topping)
            if (bro[t]++ == 0)
                broCnt++;
        
        for (int t : topping) {
            if(me[t]++ == 0)
                meCnt++;
            if(--bro[t] == 0)
                broCnt--;
            
            if (meCnt == broCnt)
                ans++;
        }
        return ans;
    }
}