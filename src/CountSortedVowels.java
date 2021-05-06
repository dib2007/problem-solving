import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountSortedVowels {
    //
    //https://leetcode.com/problems/count-sorted-vowel-strings/

    public static int countVowelStrings(int n) {
        List<String> vowels = Arrays.asList("a","e","i","o","u");
        return countVowelStringsInternal(0, vowels, n, 0);
    }

    private static int countVowelStringsInternal(int start, List<String> vowels, int n, int count) {
        if(n==0) {
            return ++count;
        }
        for (int i = start; i < vowels.size(); i++) {
            count = countVowelStringsInternal(i, vowels, n-1, count);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countVowelStrings(33));
    }
}
