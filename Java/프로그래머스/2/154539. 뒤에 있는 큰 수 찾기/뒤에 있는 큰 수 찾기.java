import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        int idx = numbers.length;
        int[] ans = new int[numbers.length];
        
        while (--idx >= 0){
            while (!stack.isEmpty() &&stack.peek() <= numbers[idx])
                stack.pop();
            
            if (stack.isEmpty())
                ans[idx] = -1;
            else
                ans[idx] = stack.peek();

            stack.push(numbers[idx]);
        }
        return ans;
    }
}