import java.util.*;

public class WordSubset {

    public static List<String> wordSubsets(String[] A, String[] B) {
        List<String> result = new ArrayList<>();
        Map<Character, Integer> wordMaxCountMap = new HashMap<>();
        for (String b : B) {
            Map<Character, Integer> countMap = new HashMap<>();
            for (char c : b.toCharArray()){
                countMap.putIfAbsent(c, 0);
                int currentCount = countMap.get(c) + 1;
                countMap.put(c, currentCount);
                wordMaxCountMap.putIfAbsent(c, 0);
                if(currentCount > wordMaxCountMap.get(c)) wordMaxCountMap.put(c, currentCount);
            }
        }
        for (String a : A) {
            boolean universal = true;
            Map<Character, Integer> countMap = new HashMap<>();
            for (char c : a.toCharArray()){
                countMap.putIfAbsent(c, 0);
                countMap.put(c, countMap.get(c) + 1);
            }
            for(Map.Entry<Character, Integer> e : wordMaxCountMap.entrySet()) {
                if(!countMap.containsKey(e.getKey()) || countMap.get(e.getKey()) < e.getValue()) {
                    universal = false;
                    break;
                }
            }
            if (universal) {
                result.add(a);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> result = wordSubsets(new String[]{"amazon","apple","facebook","google","leetcode"}, new String[]{"ec","oc","ceo"});
        result.forEach(System.out::println);
    }

}
