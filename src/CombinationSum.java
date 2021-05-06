import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        getCombination(0, candidates, target, new ArrayList<Integer>(), result);
        return result;
    }

    private static void getCombination(int i, int[] candidates, int target, ArrayList<Integer> combination, List<List<Integer>> result) {
        if(target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        if (i == candidates.length) return;
        if(candidates[i] <= target) {
            combination.add(candidates[i]);
            getCombination(i, candidates, target - candidates[i], combination, result);
            combination.remove(combination.size()-1);
        }
        getCombination(i+1, candidates, target, combination, result);
    }

    public static void main(String[] args) {
        List<List<Integer>> result = combinationSum(new int[]{1}, 1);
        result.forEach(System.out::println);
    }
}
