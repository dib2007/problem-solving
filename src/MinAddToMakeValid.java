import java.util.Stack;

public class MinAddToMakeValid {
    public static int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();
        int minAddition = 0;
        for (char c : S.toCharArray()) {
            if(c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) minAddition++;
                else stack.pop();
            }
        }
        return minAddition+stack.size();
    }

    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("()))(("));
    }
}
