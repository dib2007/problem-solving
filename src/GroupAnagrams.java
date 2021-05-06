import java.util.*;

public class GroupAnagrams {
    //https://leetcode.com/problems/group-anagrams/

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<Chars, List<String>> map = new HashMap<>();
        for (String str :strs) {
            Integer[] arr = new Integer[26];
            Arrays.fill(arr, 0);
            for (char ch : str.toCharArray()) {
                arr[ch - 'a']++;
            }
            Chars chars = new Chars(arr);
            map.putIfAbsent(chars, new ArrayList<>());
            map.get(chars).add(str);
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Chars, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    static class Chars {
        Integer[] chars;

        public Chars(Integer[] chars) {
            this.chars = chars;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Chars chars1 = (Chars) o;
            return Arrays.equals(chars, chars1.chars);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(chars);
        }
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }

}
