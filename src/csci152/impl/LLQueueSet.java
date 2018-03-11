/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Queue;
import csci152.adt.Set;

/**
 *
 * @author Master
 * @param <T>
 */
public class LLQueueSet<T> implements Set<T> {

    Queue<T> queue = new LinkedListQueue();

    @Override
    public void add(T value) {
        for (int i = 0; i < queue.getSize(); i++) {
            try {
                T x = queue.dequeue();
                queue.enqueue(x);
                if (x.equals(value)) {
                    return;
                }
            } catch (Exception ex) {
                //blabla
            }
        }
        queue.enqueue(value);
//
//        Node newNode = new Node(value);
//
//        if (size == 0) {
//            back = newNode;
//            front = newNode;
//            size++;
//        } else {
//            Node temp = front;
//            while (temp.getLink() != null) {
//                if (newNode.getValue() != temp.getValue()) {
//                    temp = temp.getLink();
//                } else {
//                    return;
//                }
//            }
//            size++;
//            back.setLink(newNode);
//            back = newNode;
//        }
    }

    @Override
    public boolean contains(T value) {
        for (int i = 0; i < queue.getSize(); i++) {
            try {
                T x = queue.dequeue();
                queue.enqueue(x);

                if (x.equals(value)) {
                    return true;
                }
            } catch (Exception ex) {
                //ablafk
            }
        }
        return false;
    }

    @Override
    public boolean remove(T value) {
        if (contains(value)) {
            for (int i = 0; i < queue.getSize(); i++) {
                try {
                    T x = queue.dequeue();
                    if (x != value) {
                        queue.enqueue(x);
                    } else {
                        return true;
                    }
                } catch (Exception ex) {
                }
            }
        }
        return false;
    }

    @Override
    public T removeAny() throws Exception {
        if (getSize() != 0) {
            T x = queue.dequeue();
            return x;
        } else {
            throw new Exception("set is empty");
        }
    }

    @Override
    public int getSize() {
        return queue.getSize();
    }

    @Override
    public void clear() {
        queue.clear();
    }

    @Override
    public String toString() {
        String message = "{";
        for (int i = 0; i < queue.getSize(); i++) {
            try {
                T x = queue.dequeue();
                message += x + " ";
                queue.enqueue(x);
            } catch (Exception ex) {
                //OWubKA
            }

        }
        message += "}";

        return message += "\nSize: " + getSize();

    }

}
