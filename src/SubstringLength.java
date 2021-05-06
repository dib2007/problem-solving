import java.util.HashMap;
import java.util.Map;

public class SubstringLength {

        public static int lengthOfLongestSubstring(String s) {
            if (s.length() == 0) return 0;
            int max = 1;
            int diff = 1;
            Map<Character, Integer> indexMap = new HashMap<>();
            indexMap.put(s.charAt(0), 0);
            for(int j=1, i=0; j<s.length(); j++) {
                if(indexMap.containsKey(s.charAt(j)) && indexMap.get(s.charAt(j)) >= i) {
                    diff = j - (indexMap.get(s.charAt(j)) + 1) +1;
                    i = indexMap.get(s.charAt(j)) +1;
                } else {
                    diff++;
                    if(diff > max) {
                        max = diff;
                    }
                }
                indexMap.put(s.charAt(j), j);
            }
            return max;
        }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

}
