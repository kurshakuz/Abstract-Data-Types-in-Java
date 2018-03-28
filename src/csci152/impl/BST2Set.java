/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Set;

/**
 *
 * @author Master
 */
public class BST2Set<T extends Comparable> implements Set<T> {

    private OnOffTreeNode<T> root;
    private int size;

    public BST2Set() {
        root = null;
        size = 0;
    }

    @Override
    public void add(T value) {
        OnOffTreeNode<T> node = new OnOffTreeNode(value);
        OnOffTreeNode<T> newRoot = root;
        //if (root.isActive()) {

        if (size == 0) {
            root = node;
            size++;
            return;
        }
        if (contains(value)) {
            return;
        }

        addHelper(newRoot, value);

        //}
    }

    private void addHelper(OnOffTreeNode<T> newRoot, T value) {
        if (newRoot.getValue().compareTo(value) > 0) {
            if (newRoot.getLeft() == null) {
                newRoot.setLeft(new OnOffTreeNode(value));
                size++;
            } else {
                addHelper(newRoot.getLeft(), value);
            }
        } else if (newRoot.getValue().compareTo(value) < 0) {
            if (newRoot.getRight() == null) {
                newRoot.setRight(new OnOffTreeNode(value));
                size++;
            } else {
                addHelper(newRoot.getRight(), value);
            }
        }
        newRoot.setActive(true);
    }

    @Override
    public boolean contains(T value) {
        return containsHelper(root, value);
    }

    private boolean containsHelper(OnOffTreeNode<T> node, T value) {
        boolean check = false;

        if (node == null) {
            return false;
        }

        if (node.getValue().compareTo(value) > 0) {
            check = containsHelper(node.getLeft(), value);
        } else {
            check = containsHelper(node.getRight(), value);
        }

        if (node.getValue().equals(value)) {
            if (node.isActive()) {
                check = true;
            }
        }

        return check;
    }

    @Override
    public boolean remove(T value) {
        OnOffTreeNode<T> newRoot = root;
        while (newRoot != null) {
            if (newRoot.getValue().equals(value)) {
                newRoot.setActive(false);
                size--;
                return true;
            } else {
                if (newRoot.getValue().compareTo(value) > 0) {
                    newRoot = newRoot.getLeft();
                } else if (newRoot.getValue().compareTo(value) < 0) {
                    newRoot = newRoot.getRight();
                }
            }
        }
        return false;
    }

    @Override
    public T removeAny() throws Exception {
//        if (size == 0) throw new Exception("Set is empty!");
//
//        T value = null;
//        if (size == 1) {
//            value = root.getValue();
//            size = 0;
//        } else {
//            value = root.getValue();
//            remove(value); 
//        }
//        return value;

        T value = null;
        if (size == 0) throw new Exception("The set is empty");

        value = removeAnyHelper(root);
        return value;
    }

    public T removeAnyHelper(OnOffTreeNode<T> node) {
        if (node == null) {
            return null;
        }

        if (node.isActive()) {
            size--;
            node.setActive(false);
            return node.getValue();
        }

        T removedNode = removeAnyHelper(node.getLeft());

        if (removedNode != null) {
            return removedNode;
        } else {
            return removeAnyHelper(node.getRight());
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    public String toString() {
        return toStringHelper(root);// + "\nSize: " + getSize();
    }

    private String toStringHelper(OnOffTreeNode<T> node) {
        if (node == null) {
            return " ";
        }

        if (node.isActive()) {
            return toStringHelper(node.getLeft()) + node.getValue() + toStringHelper(node.getRight());
        } else {
            return toStringHelper(node.getLeft()) + toStringHelper(node.getRight());
        }
    }

}
