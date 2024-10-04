import java.util.*;

class Solution {
    int[] my = new int[] {-1, 1, 0, 0};
    int[] mx = new int[] {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int ans = -1;
        Queue<Player> q = new LinkedList<>();
        q.offer(new Player(0, 0, 1));
        
        while (!q.isEmpty()) {
            Player p = q.poll();
            
            if (p.y == maps.length-1 && p.x == maps[0].length-1){
                ans = p.cnt;
                break;
            }
            
            for (int i=0; i<4; i++) {
                int dy = p.y + my[i];
                int dx = p.x + mx[i];
                
                if (0<=dx && dx<maps[0].length && 0<=dy && dy<maps.length && maps[dy][dx] != 0){
                    maps[dy][dx] = 0;
                    q.offer(new Player(dy, dx, p.cnt+1));
                }
            }
        }
        return ans;
    }

    class Player {
        int y, x, cnt;
        
        Player(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }
}