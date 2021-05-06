import java.util.*;

public class SudokuSolver {
    //https://leetcode.com/problems/sudoku-solver/
    public static void solveSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowPool = new HashMap<>();
        Map<Integer, Set<Character>> colPool = new HashMap<>();
        Map<Node, Set<Character>> boxPool = new HashMap<>();
        Set<Node> visited = new HashSet<>();
        solve(board, rowPool, colPool, boxPool, 0, 0, visited);
    }

    private static boolean solve(char[][] board, Map<Integer, Set<Character>> rowPool, Map<Integer, Set<Character>> colPool, Map<Node, Set<Character>> boxPool, int row, int col, Set<Node> visited) {
        List<Integer[]> list = getValidAdjacent(board, row, col);
        if (list.size() == 0) return false;
        Set<Character> availableForRow = rowPool.get(row);
        Set<Character> availableForCol = colPool.get(col);
        Set<Character> availableForBox = boxPool.get(new Node(row, col));

        Set<Character> available = new HashSet<>(availableForRow);
        available.retainAll(availableForCol);
        available.retainAll(availableForBox);
        if (available.size() == 0) return false;
        boolean result = false;
        for (Integer[] cell : list) {
            for (char c : available) {
                rowPool.get(row).remove(c);
                colPool.get(col).remove(c);
                boxPool.get(new Node(row/3, col/3)).remove(c
                );
                board[row][col] = c;
                solve(board, rowPool, colPool, boxPool, cell[0], cell[1]);
            }
        }
    }

    private static List<Integer[]> getValidAdjacent(char[][] board, int row, int col) {
        List<Integer[]> result = new ArrayList<>();
        if (row-1>=0 && col-1>=0) {
            result.add(new Integer[]{row-1, col-1});
        } else if(row-1>=0) {
            result.add(new Integer[]{row-1, col});
        } else if(row-1>=0 && col+1 < board[0].length) {
            result.add(new Integer[]{row-1, col+1});
        } if (col-1>=0 && board[row][col-1] != '.') {
            result.add(new Integer[]{row, col-1});
        } else if(col+1 <= board[0].length) {
            result.add(new Integer[]{row, col+1});
        } else if(row+1 < board.length && col-1 >=0) {
            result.add(new Integer[]{row+1, col-1});
        } else if(row+1 < board.length) {
            result.add(new Integer[]{row+1, col});
        } else if(row+1 < board.length && col+1 < board[0].length) {
            result.add(new Integer[]{row+1, col+1});
        }
        return result;
    }

    static class Node {
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }


}
