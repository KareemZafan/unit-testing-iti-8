package org.iti.app;

import java.util.ArrayList;
import java.util.List;

public class MyStack {
    private ArrayList<Integer> stack;

    public MyStack() {
        stack = new ArrayList<>();
    }

    public MyStack push(int element) {
        stack.add(element);
        return this;
    }

    public int getSize() {
        return stack.size();
    }

    public int getPeek() {
        if (stack.isEmpty()) throw new IllegalStateException("Empty Stack!");
        return stack.get(getSize() - 1);
    }

    public List<Integer> getStackElements() {
        return stack;
    }

    public int pop() {
        if (stack.isEmpty()) throw new IllegalStateException("Empty Stack!");
        int poppedElement = stack.get(getSize() - 1);
        stack.remove(getSize() - 1);
        return poppedElement;
    }
}
