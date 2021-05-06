import java.util.ArrayDeque;
import java.util.Queue;

public class FruitCollection {

    public static int totalFruit(int[] tree) {
        int maxCollection = 1;
        int index=-1;
        int previous = tree[0];
        int currentCollection = 1;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(tree[0]);
        for (int i=1;i<tree.length;i++) {
            currentCollection++;
            if(previous != tree[i]) {
                if(queue.size() == 2) {
                    if(!queue.contains(tree[i])) {
                        currentCollection = i - index +1;
                    }
                    queue.remove();
                }
                queue.add(tree[i]);
                index = i;
                previous = tree[i];
            }
            if (currentCollection > maxCollection) maxCollection = currentCollection;
        }
        return maxCollection;
    }

    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
    }
}
