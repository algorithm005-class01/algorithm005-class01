import java.util.Stack;

public class LeetCode_155_0082 {

    Stack<Integer> store;
    Stack<Integer> min;
    /** initialize your data structure here. */
    public LeetCode_155_0082() {
        store = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        store.push(x);
        if (min.isEmpty() || min.peek() > x) min.push(x);
        else min.push(min.peek());
    }

    public void pop() {
        store.pop();
        min.pop();
    }

    public int top() {
        return store.peek();
    }

    public int getMin() {
        return min.peek();
    }

}
