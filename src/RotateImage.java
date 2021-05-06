import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class RotateImage {

    //https://leetcode.com/problems/rotate-image/

    static class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return row == pair.row &&
                    col == pair.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    public static void rotate(int[][] matrix) {
        Set<Pair> completed = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int row = i;
                int col = j;
                int num = matrix[row][col];
                while (!completed.contains(new Pair(row, col))) {
                    completed.add(new Pair(row, col));
                    int temp = matrix[col][matrix[0].length-1-row];
                    matrix[col][matrix[0].length-1-row] = num;
                    int tempRow = row;
                    row = col;
                    col = matrix[0].length-1-tempRow;
                    num = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1}};
        rotate(arr);
        System.out.println(Arrays.deepToString(arr));
    }
}
