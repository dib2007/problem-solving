import java.util.ArrayList;
import java.util.List;

public class Combinations {

    //https://leetcode.com/problems/combinations/

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combineInternal(n, k, result, new ArrayList<>());
        return result;
    }

    static void combineInternal(int n, int k, List<List<Integer>> combinations, List<Integer> combination) {
        if (n==0) {
            if (k==0) {
                combinations.add(new ArrayList<>(combination));
            }
            return;
        }
        combination.add(n);
        combineInternal(n-1, k-1, combinations, combination);
        combination.remove(Integer.valueOf(n));
        combineInternal(n-1, k, combinations, combination);
    }

    public static void main(String[] args) {
        combine(1,1).forEach(System.out::println);
    }
}
