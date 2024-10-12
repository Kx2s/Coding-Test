import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Boolean> map = new TreeMap<>();
        StringTokenizer st;

        for (String oper : operations) {
            st = new StringTokenizer(oper);
            if (st.nextToken().equals("I")){
                map.put(Integer.parseInt(st.nextToken()), true);
                continue;
            }
            
            if (map.isEmpty())
                continue;
            
            if (st.nextToken().equals("-1"))
                map.remove(map.firstKey());
            else 
                map.remove(map.lastKey());            
        }

        int[] ans = new int[2];
        if (!map.isEmpty()){
            ans[0] = map.lastKey();
            ans[1] = map.firstKey();
        }        
        return ans;
    }
}