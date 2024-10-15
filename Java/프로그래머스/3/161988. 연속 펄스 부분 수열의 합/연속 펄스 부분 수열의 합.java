class Solution {
    public long solution(int[] sequence) {
        long ans = 0;
        
        for (int i=-1; i<2; i+=2)
            ans = Math.max(pulse(i, sequence), ans);
        
        return ans;
    }
    
    long pulse (int pul, int[] arr) {
        long sum = 0;
        long result = 0;
        
        for (int a : arr) {
            int tmp = a * pul;
            sum += tmp;
            
            if (sum < 0)
                sum = 0;
            
            result = Math.max(sum, result);
            pul *= -1;
        }
        return result;
    }
}