//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.Random;
//import java.util.Set;
//
//public class MagicSquare {
//
//    public static Set<Integer> allNumbers = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
//
//    // Complete the formingMagicSquare function below.
//    static int formingMagicSquare(int[][] s) {
//        int row = 0,col = 0;
//        int minDiff = Integer.MAX_VALUE;
//        Set<Integer> usedNumbers = new HashSet<>();
//        for (int i = 1; i<=9;i++) {
//            usedNumbers.add(i);
//            int diff = form(s, row, col+1, Math.abs(s[row][col] - i), usedNumbers);
//            if (diff >= 0 && diff < minDiff) {
//                minDiff = diff;
//            }
//        }
//    }
//
//    static int form(int[][] s, int row, int col, int diffSoFar, Set<Integer> usedNumbers) {
//        if(col > 2) row++;
//        if(row > 2) return -1;
//        int numToAssign = pickRandom(usedNumbers);
//        usedNumbers.add(numToAssign);
//        diffSoFar += Math.abs();
//    }
//
//    static int pickRandom(Set<Integer> usedNumbers) {
//        Set<Integer> diffSet = new HashSet<>(allNumbers);
//        diffSet.removeAll(usedNumbers);
//        int size = diffSet.size();
//        int item = new Random().nextInt(size); // In real life, the Random object should be rather more shared than this
//        int i = 0;
//        for(Object obj : diffSet)
//        {
//            if (i == item)
//                return (Integer) obj;
//            i++;
//        }
//        throw new IllegalStateException();
//    }
//
//    public static void main(String[] args) {
//
//    }
//
//
//}
