package miui.browser.db;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

import miui.browser.util.Log;

/**
 * xiezhilin
 * <p>
 */
public class LeetCode_deque_0010 {

    public void test() {
        Deque deque = new LinkedList();
        for (int i = 0; i < 10; i++) {
            deque.add(i);
        }
        deque.addFirst(1);
        deque.addLast(100);
        boolean hasValue100 = deque.contains(100);
        Log.d("Test", "hasValue100:" + hasValue100);
        boolean firstValue = deque.element() == deque.getFirst();
        Log.d("Test", "firstValue:" + firstValue);
        Iterator iterator = deque.descendingIterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            if (deque.getLast() == object) {
                iterator.remove();
            }
        }

        deque.offer(101);
        deque.offerFirst(102);
        //Retrieves, but does not remove
        Object peekObject = deque.peek();
        Log.d("Test", "peekObject:" + peekObject);
        //Retrieves and removes the head of the queue
        Object pollObject = deque.poll();
        Log.d("Test", "pollObject :" + pollObject);
        //Pops an element from the stack represented by this list. remove
        Object popObject = deque.pop();
        Log.d("Test", "popObject:" + popObject);
        deque.push(200);
        Iterator iterator1 = deque.iterator();
        while (iterator1.hasNext()) {
            Object object = iterator1.next();
            Log.d("Test", "object:" + object);
        }
    }
}
