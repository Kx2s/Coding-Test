import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Map<String, Boolean> map = new HashMap<>();
        for (String num : phone_book)
            map.put(num, true);
        
        for (String num : phone_book)
            for (int i=1; i<num.length(); i++) {
                String tmp = num.substring(0,i);
                if (map.containsKey(tmp))
                    return false;
            }
        return true;
    }
}