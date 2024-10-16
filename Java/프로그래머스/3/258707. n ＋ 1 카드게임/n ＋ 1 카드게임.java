import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        Set<Integer> hand = new HashSet<>();
        Set<Integer> drow = new HashSet<>();
        int n = cards.length;
        int idx = 0;
        int ans = 1;

        for (int i =0; i<n/3; i++) {
            int tmp = cards[idx++];
            if(hand.contains(n-tmp+1)) {
                ans++;
                hand.remove(n-tmp+1);
            }
            else
                hand.add(tmp);
        }


        A:for (int i=0; i<ans&& ans<n/3+1; i++) {
            for (int j=0; j<2; j++) {
                if (coin <= 0)
                    break A;

                int tmp = cards[idx++];
                if (hand.contains(n-tmp+1)) {
                    hand.remove(n-tmp+1);
                    coin--;
                    ans++;
                }
                else
                    drow.add(tmp);
            }

            if (i+1 == ans && coin >= 2) {
                for (int d : drow) {
                    if (drow.contains(n-d+1)) {
                        drow.remove(n-d+1);
                        drow.remove(n);
                        coin -= 2;
                        ans++;
                        break;
                    }
                }
            }
        }

        return coin>=0? ans : ans-1;
    }
}