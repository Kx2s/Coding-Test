import java.util.*;

class Solution {
    int[] my = {1, -1, 0, 0};
    int[] mx = {0, 0, -1, 1};
    boolean[][] visited;

    public int[] solution(String[] maps) {
        List<Integer> foods = new ArrayList<>();
        visited = new boolean[maps.length][maps[0].length()];

        for (int i=0; i<maps.length; i++)
            for (int j=0; j<maps[0].length(); j++) {
                char now = maps[i].charAt(j);
                if (now != 'X' && !visited[i][j]){
                    visited[i][j] = true;
                    foods.add(bfs(i, j, maps));
                }
            }

        int[] ans = new int[foods.size()];
        for (int i=0; i<foods.size(); i++)
            ans[i] = foods.get(i);
        Arrays.sort(ans);

        return foods.isEmpty() ? new int[]{-1} : ans;
    }

    public int bfs(int y, int x, String[] maps) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(y, x));
        int sum = maps[y].charAt(x) - '0';

        while (!q.isEmpty()) {
            Pair p = q.poll();

            for (int i=0; i<4; i++) {
                int dy = p.y + my[i];
                int dx = p.x + mx[i];

                if (0<=dy && dy<maps.length && 0<=dx && dx<maps[0].length()
                        && !visited[dy][dx] && maps[dy].charAt(dx) != 'X'){
                    visited[dy][dx] = true;
                    sum += maps[dy].charAt(dx) - '0';
                    q.offer(new Pair(dy, dx));
                }
            }
        }
        return sum;
    }

    class Pair {
        int y, x;

        public Pair (int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}