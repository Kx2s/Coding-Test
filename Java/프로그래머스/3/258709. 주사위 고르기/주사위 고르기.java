import java.util.*;

class Solution {
    int half, max=0;
    int[][] Dice;
    int[] ans;
    Set<Integer> pick = new HashSet<>();
    List<Integer> pickList;
    List<Integer> unpickList;

    public int[] solution(int[][] dice) {
        Dice = dice;
        half = dice.length/2;
        ans = new int[half];

        select(0, 0);
        return ans;
    }

    public void select (int dep, int cur) {
        if (dep == half){
            victory();
            return;
        }

        for (int i = cur; i<half*2; i++) {
            pick.add(i);
            select(dep+1, i+1);
            pick.remove(i);
        }
    }

    public void victory () {
        pickList = new ArrayList<>();
        unpickList = new ArrayList<>();
        findCase(0, 0, 0, true);
        findCase(0, 0, 0, false);
        Collections.sort(unpickList);

        int vic = 0;
        for (int pick : pickList) {
            int mid, s = 0, e = unpickList.size();
            while (s < e) {
                mid = (s + e) / 2;

                if (pick <= unpickList.get(mid))
                    e = mid;
                else
                    s = mid+1;
            }
            vic += e;
        }
        if (vic > max) {
            max = vic;
            int idx=0;
            for (int p : pick)
                ans[idx++] = p+1;
        }
    }

    public void findCase (int dep, int sum, int cur, boolean tf) {
        if (dep == half) {
            if (tf)
                unpickList.add(sum);
            else
                pickList.add(sum);
            return;
        }

        for (int i = cur; i<half*2; i++) {
            if (pick.contains(i) == tf)
                continue;

            for (int j=0; j<Dice[i].length; j++)
                findCase(dep+1, sum+Dice[i][j], i+1, tf);
        }
    }
}