import java.util.Stack;

import static java.lang.System.exit;

class Solution {
    int max = 0;
    long ans = 0;
    Stack<Integer> del = new Stack<>();
    Stack<Integer> pick = new Stack<>();

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        max = cap;
        for (int i=0; i<n; i++){
            del.push(deliveries[i]);
            pick.push(pickups[i]);
        }
        while (!del.isEmpty() || !pick.isEmpty())
            ans += Math.max(start(del), start(pick))*2;

        return ans;
    }

    public int start(Stack<Integer> stack) {
        int result = 0;
        int contain = 0;

        while (!stack.isEmpty()) {
            int p = stack.pop();
            if (p == 0)
                continue;

            result = Math.max(result, stack.size()+1);
            if (contain + p > max) {
                int remain = contain + p - max;
                contain += p - remain;
                stack.push(remain);
            }
            else
                contain += p;

            if (contain == max)
                break;
        }
        return result;
    }
}