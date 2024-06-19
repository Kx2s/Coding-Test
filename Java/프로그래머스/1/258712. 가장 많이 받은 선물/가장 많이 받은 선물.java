import java.util.Arrays;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int[] ans = new int [friends.length];
        int[] scores = new int[friends.length];
        int[][] arr = new int[friends.length][friends.length];

        for (int i=0; i<gifts.length; i++) {
            String[] give = gifts[i].split(" ");

            int idx1 = Arrays.asList(friends).indexOf(give[0]);
            int idx2 = Arrays.asList(friends).indexOf(give[1]);
            scores[idx1]++;
            scores[idx2]--;
            arr[idx1][idx2]++;
        }

        for (int i=0; i<friends.length; i++) {
            for (int j=i+1; j<friends.length; j++) {
                if (arr[i][j] > arr[j][i])
                    ans[i]++;
                else if (arr[i][j] < arr[j][i])
                    ans[j]++;
                else {
                    if (scores[i] > scores[j])
                        ans[i]++;
                    else if (scores[i] < scores[j])
                        ans[j]++;
                }
            }
        }
        return Arrays.stream(ans).max().getAsInt();
    }
}