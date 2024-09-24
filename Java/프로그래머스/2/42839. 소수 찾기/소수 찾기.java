import java.util.*;

class Solution {
    int ans;
    boolean[] arr;
    public int solution(String numbers) {
        arr = new boolean[(int) Math.pow(10, numbers.length()+1)];
        arr[0] = true;
        arr[1] = true;
        int idx = 1;
        while (++idx < arr.length) {
            if (arr[idx])
                continue;
            int cnt = 2;
            while (idx*cnt < arr.length)
                arr[idx*cnt++] = true;
        }
        seach(0, numbers);

        return ans;
    }
    
    public void seach(int num, String str) {    
        if (!arr[num]){
            ans++;
            arr[num]=true;
        }
        
        if (str.length() == 0)
            return;
        
        for (int i=0; i<str.length(); i++)
            seach(num*10+str.charAt(i)-'0', str.substring(0, i)+str.substring(i+1, str.length()));
    }
}