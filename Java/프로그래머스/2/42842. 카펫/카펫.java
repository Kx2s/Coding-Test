class Solution {
    public int[] solution(int brown, int yellow) {
        int[] ans = new int[2];
        
        int y = 0;
        while (++y<=Math.sqrt(yellow)) {
            if (yellow%y != 0)
                continue;
            
            int x = yellow/y;
            
            if ((x+y+2)*2 == brown){
                ans[0] = x+2;
                ans[1] = y+2;
                break;
            }
        }
        return ans;
    }
}