import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> li = new ArrayList<>();
        Map<String, Integer> due = new HashMap<>();
        String[] Today = today.split("\\.");

        for (String term : terms){
            StringTokenizer st = new StringTokenizer(term);
            due.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        for (int i=0; i< privacies.length; i++) {
            StringTokenizer st = new StringTokenizer(privacies[i]);
            String[] tmp = st.nextToken().split("\\.");
            int add = due.get(st.nextToken());

            int[] day = new int[3];
            for (int j=0; j<3; j++)
                day[j] = Integer.parseInt(tmp[j]);

            day[2] = (day[2]+27)%28;
            if (day[2] == 0){
                day[2] = 28;
                day[1]--;
            }
            day[1] += add;
            while(day[1] > 12) {
                day[1] -= 12;
                day[0]++;
            }
            for (int j=0; j<3; j++) {
                if (day[j] < Integer.parseInt(Today[j])){
                    li.add(i+1);
                    break;
                }
                else if (day[j] > Integer.parseInt(Today[j]))
                    break;
            }
        }

        int[] ans = new int[li.size()];
        for (int i=0; i<li.size(); i++)
            ans[i] = li.get(i);

        return ans;
    }
}