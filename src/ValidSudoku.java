import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class ValidSudoku {
    //https://leetcode.com/problems/valid-sudoku/


    public static boolean isValidSudoku(char[][] board) {
        Set<Number> set = new HashSet<>();
        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[0].length;j++) {
                if (board[i][j] != '.' && set.contains(new Number(board[i][j], i, j))) {
                    return false;
                } else {
                    set.add(new Number(board[i][j], i, j));
                }
            }
        }
        return true;
    }

    static class Number {
        char number;
        int row;
        int col;

        public Number(char number, int row, int col) {
            this.number = number;
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Number number1 = (Number) o;
            return number == number1.number && (
                    row == number1.row ||
                    col == number1.col ||
                    (row/3 == number1.row/3 && col/3 == number1.col/3));
        }

        @Override
        public int hashCode() {
            return Objects.hash(number);
        }
    }

    public static void main(String[] args) {
        char[][] borad = new char[][]{{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(borad));
        Set<Number> set = new HashSet<>();
        set.add(new Number('8', 0, 0));
        System.out.println(set.contains(new Number('8', 3, 0)));
    }
}
