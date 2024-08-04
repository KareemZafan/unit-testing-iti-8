package org.iti.app_tests;

import org.iti.app.MyStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class MyStackTests {

    private MyStack myStack;

    @BeforeEach
    void setUp() {
        myStack = new MyStack();
    }

    @Test
    void testPushElementsToStack() {
        myStack.push(1).push(2).push(3).push(400);
        assertEquals(4, myStack.getSize());
        assertEquals(400, myStack.getPeek());
        assertEquals(List.of(1, 2, 3, 400), myStack.getStackElements());
    }

    @Test
    void testPopElementsFromStack() {
        assertTrue(myStack.getStackElements().isEmpty());
        var ex = assertThrowsExactly(IllegalStateException.class, () -> myStack.pop());
        assertEquals("Empty Stack!", ex.getMessage());
        myStack.push(1).push(2).push(3).push(400).push(10000);
        assertFalse(myStack.getStackElements().isEmpty());
        int prevSize = myStack.getSize();
        assertEquals(10000, myStack.pop());
        assertEquals(myStack.getSize(), prevSize - 1);
        assertEquals(List.of(1, 2, 3, 400), myStack.getStackElements());
        assertEquals(400, myStack.getPeek());


    }

    @Test
    void testGettingPeekElementOfStack() {
        assertTrue(myStack.getStackElements().isEmpty());
        var ex = assertThrowsExactly(IllegalStateException.class, () -> myStack.getPeek());
        assertEquals("Empty Stack!", ex.getMessage());
        myStack.push(1).push(2).push(3).push(400).push(10000);
        assertFalse(myStack.getStackElements().isEmpty());
        assertEquals(10000, myStack.getPeek());
        assertEquals(10000, myStack.pop());
        assertEquals(400, myStack.pop());
        myStack.push(250);
        assertEquals(250, myStack.getPeek());
        assertEquals(List.of(1, 2, 3, 25), myStack.getStackElements());
    }
}

