import java.util.*;

public class GenerateParentheses {
//    https://leetcode.com/problems/generate-parentheses/

    public static List<String> generateParenthesis(int n) {
        Set<String> res = new HashSet<>();
        generateParenthesisInternal(n, n, "", res);
        return new ArrayList<>(res);
    }

    private static void generateParenthesisInternal(int left, int right, String str, Set<String> result) {
        if (left == 0 && right == 0) result.add(str);
        if(left > 0) generateParenthesisInternal(left-1, right, str + "(", result);
        if(right>left) generateParenthesisInternal(left, right-1, str + ")", result);
    }

    public static void main(String[] args) {
        List<String> strs =generateParenthesis(5);
        ///strs.forEach(System.out::println);

        String[] strss = new String[]{"(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"};
        Arrays.sort(strss);
        Arrays.stream(strss).forEach((e) -> System.out.print(e + ","));
        Collections.sort(strs);
        System.out.println("");
        strs.forEach((e) -> System.out.print(e + ","));
    }
}