import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> total = new TreeMap<>();
        Map<String, Integer> inOut = new HashMap<>();
        StringTokenizer st;

        for (String re : records) {
            st = new StringTokenizer(re);
            String[] time = st.nextToken().split(":");
            int min = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            String number = st.nextToken();

            if (inOut.containsKey(number)){
                int inTime = min - inOut.get(number);
                total.put(number, total.getOrDefault(number, 0) + inTime);
                inOut.remove(number);
            }
            else
                inOut.put(number, min);
        }

        int maxTime = 23*60 + 59;
        for (Map.Entry<String, Integer> entry : inOut.entrySet()) {
            int inTime = maxTime - entry.getValue();
            total.put(entry.getKey(), total.getOrDefault(entry.getKey(), 0) + inTime);
        }

        int[] ans = new int[total.size()];
        int i = 0;
        for (int t : total.values()){
            double overTime = Math.max(0, t - fees[0]);
            ans[i++] = fees[1] + (int) Math.ceil(overTime/fees[2])*fees[3];
        }
        
        return ans;
    }
}