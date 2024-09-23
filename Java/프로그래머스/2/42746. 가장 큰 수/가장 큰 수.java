import java.util.PriorityQueue;

class Solution {
    public String solution(int[] numbers) {
        PriorityQueue<Str> q = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        
        for (int n : numbers)
            q.offer(new Str(n));
        
        while (!q.isEmpty())
            sb.append(q.poll().s);
        
        return sb.charAt(0)=='0'? "0" : sb.toString();
    }
    
    class Str implements Comparable<Str> {
        String s;
        
        public Str (int num) {
            this.s = String.valueOf(num);
        }
        
        public int compareTo(Str S) {
            return (this.s + S.s).compareTo(S.s+this.s) * -1;
        }
    }
}