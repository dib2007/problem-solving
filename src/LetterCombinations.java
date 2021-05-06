import java.util.*;

public class LetterCombinations {

    public static List<String> letterCombinations(String digits) {

        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        if(digits.length() == 0) return new ArrayList<>();
        Queue<String> queue = new ArrayDeque<>();
        char[] chars = digits.toCharArray();
        add(queue, "", map.get(chars[0]));
        for (int i=1;i<chars.length;i++) {
            List<String> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                String str = queue.poll();
                add(list, str, map.get(chars[i]));
            }
            queue.addAll(list);
        }
        return new ArrayList<>(queue);
    }

    static void add(Collection<String> collection, String str1, String str2) {
        for (char ch : str2.toCharArray()) {
            collection.add(str1 + ch);
        }
    }

    public static void main(String[] args) {
        List<String> result = letterCombinations("7");
        result.forEach(System.out::println);
    }
}
