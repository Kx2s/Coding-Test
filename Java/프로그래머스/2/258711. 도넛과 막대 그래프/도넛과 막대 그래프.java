import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(int[][] edges) {
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        boolean[] visited = new boolean[1000001];
        int[] ans = new int[4];

        for (int[] e : edges){
            ArrayList<Integer> value;
            if (graph.containsKey(e[0]))
                value = graph.get(e[0]);
            else
                value = new ArrayList<>();
            value.add(e[1]);
            graph.put(e[0], value);
            visited[e[1]] = true;
        }

        for(int i=1; i<visited.length; i++)
            if (!visited[i])
                if (graph.containsKey(i) && graph.get(i).size()>1) {
                    ans[0] = i;
                    break;
                }

        for (int spot : graph.get(ans[0])){
            int tmp = spot;
            while (true) {
                if (!graph.containsKey(tmp)){
                    ans[2]++;
                    break;
                }
                else if (graph.get(tmp).size() > 1) {
                    ans[3]++;
                    break;
                }
                tmp = graph.get(tmp).get(0);
                if (tmp == spot){
                    ans[1]++;
                    break;
                }
            }
        }
        return ans;
    }
}