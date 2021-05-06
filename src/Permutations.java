import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Permutations {
    //https://leetcode.com/problems/permutations/

    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> availableNums = IntStream.of(nums).boxed().collect(Collectors.toList());
        List<List<Integer>> permutations = new ArrayList<>();
        permuteInternal(availableNums, permutations, new ArrayList<>());
        return permutations;
    }

    private static void permuteInternal(List<Integer> availableNums, List<List<Integer>> permutations, List<Integer> permutation) {
        if(availableNums.size() == 0) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }
        List<Integer> temp = new ArrayList<>(availableNums);
        for (int i : availableNums) {
            temp.remove(Integer.valueOf(i));
            permutation.add(i);
            permuteInternal(temp, permutations, permutation);
            temp.add(i);
            permutation.remove(Integer.valueOf(i));
        }
    }

    public static void main(String[] args) {
        permute(new int[]{1}).forEach(System.out::println);
    }

}
