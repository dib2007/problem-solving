import java.util.*;

public class SnakeLadder {

    public static int snakesAndLadders(int[][] board) {
        int[] flatCell = flatCell(board);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        Set<Integer> discovered = new HashSet<>();
        Map<Integer, Integer> distance = new HashMap<>();
        distance.put(1,0);
        discovered.add(1);
        while (!queue.isEmpty()) {
            Integer front = queue.poll();
            if (front == board.length * board.length) return distance.get(front);
            for (int i = 1; i <= 6 && front + i <= board.length * board.length; i++) {
                int landingCell = front+i;
                if (flatCell[landingCell-1] != -1) {
                    landingCell = flatCell[landingCell-1];
                }
                if (!discovered.contains(landingCell)) {
                    distance.put(landingCell, distance.get(front) + 1);
                    queue.add(landingCell);
                    discovered.add(landingCell);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[][] arr = {{-1, -1, -1, -1, -1, -1},
//                {-1, -1, -1, -1, -1, -1},
//                {-1, -1, -1, -1, -1, -1},
//                {-1, 35, -1, -1, 13, -1},
//                {-1, -1, -1, -1, -1, -1},
//                {-1, 15, -1, -1, -1, -1}};
        int[][] arr = {{-1,1,2,-1}
                ,{2,13,15,-1},
                {-1,10,-1,-1},
                {-1,6,2,8}};
        System.out.println(snakesAndLadders1(arr));
        //System.out.println(Arrays.toString(flatCell(arr)));
    }

    public static int[] flatCell(int[][] board) {
        int row = board.length - 1;
        int col = 0;
        int cell = 0;
        int[] flatCell = new int[board.length * board.length];
        while (cell < board.length * board.length) {
            flatCell[cell] = board[row][col];
            if ((board.length - row - 1) % 2 == 0) {
                if (col == board.length - 1) row--;
                else col++;
            } else {
                if (col == 0) row--;
                else col--;
            }
            cell++;
        }
        return flatCell;
    }

    public static int snakesAndLadders1(int[][] board) {

        //corner case
        if(board == null || board.length == 0)return 0;

        int n = board.length;
        int k = 1;

        boolean[] visited = new boolean[n*n + 1];
        int[] nums = new int [n*n + 1];

        while(k <= n*n){

            int row = n - 1 - (k -1)/n;
            int col =((k-1)/n % 2 == 0)?(k-1) % n : (n-1)-(k-1) % n;

            nums[k++]= board[row][col];
        }

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        int steps = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int cur = queue.poll();

                if(cur == n*n) return steps;
                for(int j = 1; j <= 6 && cur + j <= n*n; j++){
                    int num1 = nums[cur + j];
                    int loca = (num1 == -1) ? cur+j: num1;

                    if(!visited[loca]){
                        visited[loca] = true;
                        queue.offer(loca);
                    }
                }
            }

            steps++;
        }
        return -1;
    }

}
