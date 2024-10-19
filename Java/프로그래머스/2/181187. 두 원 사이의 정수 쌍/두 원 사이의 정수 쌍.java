import java.util.*;

class Solution {
    public long solution(int r1, int r2) {
        long ans=0;
        for (long i=1; i<=r2; i++) {
            long x1 = (long) Math.ceil(Math.sqrt(Math.pow(r1, 2) - i*i));
            long x2 = (long) Math.floor(Math.sqrt(Math.pow(r2, 2) - i*i));
            ans += x2 - x1 + 1;
        }
        return ans*4;
    }
}