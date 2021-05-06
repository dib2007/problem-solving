import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RomanToInteger {
    //https://leetcode.com/problems/roman-to-integer/

    public int romanToInt(String s) {
        Stack<Integer> stack = new Stack<>();
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int num = 0;
        for (char ch : s.toCharArray()) {
            if(!stack.isEmpty() && map.get(ch) <= stack.peek()) {
                int temp = stack.pop();
                while (!stack.isEmpty()) {
                    temp -= stack.pop();
                }
                num+=temp;
            }
            stack.push(map.get(ch));
        }

        if (!stack.isEmpty()) {
            int temp = stack.pop();
            while (!stack.isEmpty()) {
                temp -= stack.pop();
            }
            num+=temp;
        }
        return num;
    }

    public static void main(String[] args) {
        RomanToInteger obj = new RomanToInteger();
        System.out.println(obj.romanToInt("MCMXCIV"));
    }
}
