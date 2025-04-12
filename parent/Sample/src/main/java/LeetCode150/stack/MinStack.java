package LeetCode150.stack;

import java.util.ArrayList;
import java.util.Stack;

class MinStack {

    Stack<Integer> data;
    Stack<Integer> min;

    public MinStack() {
        data = new Stack<>();
        min = new Stack<>();
    }

    public void push(int val) {
        if ( !data.isEmpty() ) {
            int cMin = min.peek();
            if ( val < cMin ) {
                cMin = val;
            }
            data.push(val);
            min.push(cMin);
            return;
        }
        data.push(val);
        min.push(val);
    }

    public void pop() {
        data.pop();
        min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack s = new MinStack();

        s.push(-2);
        s.push(0);
        s.push(-3);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
