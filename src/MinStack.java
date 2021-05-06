import java.util.Stack;

class MinStack {

    /** initialize your data structure here. */
    Stack<Long> stack = new Stack<>();
    long min = Long.MAX_VALUE;

    public MinStack() {

    }

    public void push(long x) {
        if(stack.isEmpty()) {
            stack.push(x);
            min = x;
        } else {
            if(x < min) {
                long temp = 2*x - min;
                min = x;
                x = temp;
            }
            stack.push(x);
        }
    }

    public void pop() {
        long val = stack.pop();
        if (val < min) {
            min = 2 * min - val;
        }
    }

    public long top() {
        long val = stack.peek();
        return Math.max(val, min);
    }

    public long getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-2147483648);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}