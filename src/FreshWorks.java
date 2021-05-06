import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FreshWorks {


    //input_string=“abbcfba” distinct_array=[a,b,c,f]
    //“abbcffba” “abbcfaabc”

//
//    abbcf
//    abbcfb
//    abbcb

    public static String distinct(String str, char[] distinct) {
        int len = distinct.length;
        int f = 0;
        int e = len;
        Map<Character, Integer> countMap = new HashMap<>();
        Set<Character> charSet = new HashSet<>();
        int minSize = Integer.MAX_VALUE;
        int start = -1;
        int end = -1;
        for(int i=0;i<len;i++) {
            charSet.add(str.charAt(i));
            countMap.putIfAbsent(str.charAt(i), 0);
            countMap.put(str.charAt(i), countMap.get(str.charAt(i)) + 1);
        }
        if(charSet.size() == len) return str.substring(0, len);
        while (e<str.length()) {
            charSet.add(str.charAt(e));
            countMap.putIfAbsent(str.charAt(e), 0);
            countMap.put(str.charAt(e), countMap.get(str.charAt(e)) + 1);
            e++;
            while (charSet.size() == len) {
                if (e - f < minSize) {
                    minSize = e - f;
                    start = f;
                    end = e;
                }
                countMap.put(str.charAt(f), countMap.get(str.charAt(f)) - 1);
                if (countMap.get(str.charAt(f)) == 0) {
                    charSet.remove(str.charAt(f));
                    countMap.remove(str.charAt(f));
                }
                f++;
            }
        }
        return minSize>str.length()?"":str.substring(start, end);
    }

    public static void main(String[] args) {
        System.out.println(distinct("abcfffss", new char[]{'a','b','c','f'}));
    }
}
