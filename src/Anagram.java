import java.util.*;

public class Anagram {
    public static List<Integer> findAnagrams(String s, String p) {
        int i=0;
        Map<Character, Integer> pMap = new HashMap<>();
        while(i<p.length()) {
            pMap.putIfAbsent(p.charAt(i), 0);
            pMap.put(p.charAt(i), pMap.get(p.charAt(i)) + 1);
            i++;
        }
        int j=0,k=0;
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> sMap = new HashMap<>();
        while(j<s.length()-p.length()) {
            if(k<p.length()) {
                sMap.putIfAbsent(s.charAt(k), 0);
                sMap.put(s.charAt(k), sMap.get(s.charAt(k)) + 1);
//                if(pMap.get(s.charAt(k)) == 0) {
//                    pMap.remove(s.charAt(k));
//                }
            } else {
                sMap.put(s.charAt(j), sMap.get(s.charAt(j)) - 1);
//                if(pMap.get(s.charAt(j)) == 0) {
//                    pMap.remove(s.charAt(j));
//                }
                sMap.putIfAbsent(s.charAt(k), 0);
                sMap.put(s.charAt(k), sMap.get(s.charAt(k)) + 1);
                j++;
            }
            if(isAnagram(sMap, pMap)) {
                result.add(j);
            }
            k++;
        }
        return result;
    }

    private static boolean isAnagram(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        int count = 0;
        for (Character ch : map1.keySet()) {
            if(map1.get(ch) != 0) {
                if((map2.get(ch) == null || !map2.get(ch).equals(map1.get(ch)))) return false;
                count++;
            }
        }
        return count == map2.size();
    }

    public static void main(String[] args) {
        findAnagrams("cbaebabacd", "abc");
    }


    static int xorTest(String x, String y) {
        int yxor = y.charAt(0);
        for (int i = 1; i < y.length(); i++) {
            yxor ^= y.charAt(i);
        }
//        yxor ^= y.charAt(0);
//        int xor = y.charAt(1);
//        for (int i = 2; i < y.length(); i++) {
//            xor ^= y.charAt(i);
//        }
//        System.out.println(yxor + ":::" + xor);
        for (int i = 0; i < x.length(); i++) {
            yxor ^= x.charAt(i);
        }
        return yxor;
    }
    public static boolean checkAnagram(String s1, String s2)
    {
        // Remove all the white space, convert to lower case & character array
        char[] arr1 = s1.replaceAll("\\s", "").toLowerCase().toCharArray();
        char[] arr2 = s2.replaceAll("\\s", "").toLowerCase().toCharArray();
        if (arr1.length != arr2.length)
            return false;

        int xor = 0;

        for (int i = 0; i < arr1.length; i++)
        {
            xor ^= arr1[i] ^ arr2[i];
        }

        return xor == 0? true: false;
    }
}
