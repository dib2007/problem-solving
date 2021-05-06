import java.util.Stack;

class StockSpanner {

    static class Node {
        int price;
        int val;

        public Node(int price, int val) {
            this.price = price;
            this.val = val;
        }
    }


    Stack<Node> stack = new Stack<>();

    public StockSpanner() {

    }

    public int next(int price) {
        int result = 1;
        while(!stack.isEmpty() && stack.peek().price <= price) {
            Node node = stack.pop();
            result+=node.val;
        }
        stack.push(new Node(price, result));
        return result;
    }

    public static void main(String[] args) {
        StockSpanner spanner = new StockSpanner();
        System.out.println(spanner.next(100));
        System.out.println(spanner.next(80));
        System.out.println(spanner.next(60));
        System.out.println(spanner.next(70));
        System.out.println(spanner.next(60));
        System.out.println(spanner.next(75));
        System.out.println(spanner.next(85));
    }
}