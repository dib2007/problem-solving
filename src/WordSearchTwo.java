import java.util.*;

public class WordSearchTwo {

    public static List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        Set<Cell> visited = new HashSet<>();
        TrieNode root = new TrieNode();
        for (String str : words) {
            insert(root, str);
        }
        StringBuilder builder = new StringBuilder();
        for(Map.Entry<Character, TrieNode> entry : root.children.entrySet()) {
            //System.out.println(entry.getKey());
            for (int i = 0;i<board.length;i++) {
                for (int j=0;j<board[0].length;j++) {
                    if (board[i][j] == entry.getKey()) {
                        board[i][j] = entry.getKey();
                        visited.add(new Cell(i, j));
                        builder.append(entry.getKey());
                        result.addAll(getPossibleStrings(entry.getValue(), board, i, j, visited, builder));
                        visited.remove(new Cell(i, j));
                        builder.setLength(builder.length()-1);
                        //System.out.println("\n");
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    private static List<String> getPossibleStrings(TrieNode node, char[][] board, int row, int col, Set<Cell> visited, StringBuilder builder) {
        List<String> list = new ArrayList<>();
        if(node.isEOC) {
            //System.out.println(builder.toString());
            list.add(builder.toString());
        }
        for(Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            Cell adjacentCell = isAdjacent(board, entry.getKey(), row, col, visited);
            if (adjacentCell != null) {
                visited.add(adjacentCell);
                builder.append(entry.getKey());
                //System.out.println(entry.getKey());
                //System.out.println(adjacentCell.row + " " + adjacentCell.col);
                list.addAll(getPossibleStrings(entry.getValue(), board, adjacentCell.row, adjacentCell.col, visited, builder));
                visited.remove(adjacentCell);
                builder.setLength(builder.length()-1);
            }
        }
        return list;
    }

    private static Cell isAdjacent(char[][] board, Character ch, int row, int col, Set<Cell> visited) {
        //if(isValidCell(row-1, col-1, board) && board[row-1][col-1] == ch && !visited.contains(new Cell(row-1, col-1))) return new Cell(row-1, col-1);
        if(isValidCell(row-1, col, board) && board[row-1][col] == ch && !visited.contains(new Cell(row-1, col))) return new Cell(row-1, col);
        //if(isValidCell(row-1, col+1, board) && board[row-1][col+1] == ch && !visited.contains(new Cell(row-1, col+1))) return new Cell(row-1, col+1);
        if(isValidCell(row, col-1, board) && board[row][col-1] == ch && !visited.contains(new Cell(row, col-1))) return new Cell(row, col-1);
        if(isValidCell(row, col+1, board) && board[row][col+1] == ch && !visited.contains(new Cell(row, col+1))) return new Cell(row, col+1);
        //if(isValidCell(row+1, col-1, board) && board[row+1][col-1] == ch && !visited.contains(new Cell(row+1, col-1))) return new Cell(row+1, col-1);
        if(isValidCell(row+1, col, board) && board[row+1][col] == ch && !visited.contains(new Cell(row+1, col))) return new Cell(row+1, col);
        //if(isValidCell(row+1, col+1, board) && board[row+1][col+1] == ch && !visited.contains(new Cell(row+1, col+1))) return new Cell(row+1, col+1);
        return null;
    }

    private static boolean isValidCell(int row, int col, char[][] board) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }


    public static class Cell {
        int row;
        int col;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return row == cell.row &&
                    col == cell.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    public static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEOC;
    }

    static void insert(TrieNode root, String str) {
        TrieNode current = root;
        for (char ch : str.toCharArray()){
            current = current.children.computeIfAbsent(ch, c -> new TrieNode());
        }
        current.isEOC = true;
    }

    public static void main(String[] args) {
        System.out.println(findWords(new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}}, new String[]{"oath","pea","eat","rain"}));
        System.out.println(findWords(new char[][]{{'a','b'},{'c','d'}}, new String[]{"abcd"}));
    }

}
