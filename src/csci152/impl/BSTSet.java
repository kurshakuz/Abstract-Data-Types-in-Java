package csci152.impl;

import csci152.adt.Set;

/**
 *
 * @author Master
 * @param <T>
 */
public class BSTSet<T extends Comparable> implements Set<T> {

    private TreeNode<T> root;
    private int size;

    public BSTSet() {
        root = null;
        size = 0;
    }

    @Override
    public void add(T value) {
        TreeNode<T> node = new TreeNode(value);
        TreeNode<T> newRoot = root;

        if (size == 0) {
            root = node;
            size++;
            return;
        }

        if (contains(value)) {
            return;
        }

        addHelper(newRoot, value);

    }

    private void addHelper(TreeNode<T> newRoot, T value) {
        if (newRoot.getValue().compareTo(value) > 0) {
            if (newRoot.getLeft() == null) {
                newRoot.setLeft(new TreeNode(value));
                size++;
            } else {
                addHelper(newRoot.getLeft(), value);
            }
        } else {
            if (newRoot.getRight() == null) {
                newRoot.setRight(new TreeNode(value));
                size++;
            } else {
                addHelper(newRoot.getRight(), value);
            }
        }
    }

    @Override
    public boolean contains(T value) {
        return containsHelper(root, value);
    }

    private boolean containsHelper(TreeNode<T> node, T value) {
//        if ((node.getLeft() == null) && (node.getRight() == null)) {
//            if (node.getValue() == value) {
//                return true;
//            } else {
//                return false;
//            }
//        }

        boolean check;

        if (node == null) {
            return false;
        }

        if (node.getValue().compareTo(value) > 0) {
            check = containsHelper(node.getLeft(), value);
        } else {
            check = containsHelper(node.getRight(), value);
        }

        if (node.getValue().equals(value)) {
            check = true;
        }

        return check;
    }

    @Override
    public boolean remove(T value) {
        if (!contains(value)) {
            return false;
        }

        TreeNode<T> result = root;
        TreeNode<T> parent = null;

        boolean isOnLeft = false; //(parent.getValue().compareTo(result.getValue()) > 0);
         
        while(true) {
            if (result.getValue().compareTo(value) > 0) {
                parent = result;
                result = result.getLeft();
                isOnLeft = true;
            } else if (result.getValue().compareTo(value) < 0) {
                parent = result;
                result = result.getRight();
                isOnLeft = false;
            } else break;
        }
        //Case of no children
        if (result.getLeft() == null && result.getRight() == null) {
            if (isOnLeft) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
            
            
            
        //Case of one child
        } else if (result.getLeft() != null && result.getRight() == null) {
            if (isOnLeft) {
                parent.setLeft(result.getLeft());
            } else {
                parent.setRight(result.getLeft());
            }
        } else if (result.getRight() != null && result.getLeft() == null) {
            if (isOnLeft) {
                parent.setLeft(result.getRight());
            } else {
                parent.setRight(result.getRight());
            }
            
            
        } else if (result.getLeft() != null && result.getRight() != null) {
            //Case of two children
            TreeNode<T> lowest = result.getRight();
            TreeNode<T> parentOfLowest = result;
            while (lowest.getLeft() != null) {
                parentOfLowest = lowest;
                lowest = lowest.getLeft();
            }
            
            if (lowest.getRight() != null) {
                parentOfLowest.setLeft(lowest.getRight());
            } else {
                parentOfLowest.setLeft(null);
            }
            result.setValue(lowest.getValue());
        }
        size--;
        return true;

//        if ((result.getLeft() == null) && (result.getRight() == null)) {
//            result.getParent().setRight(null);
//            result.getParent().setLeft(null);
//            return true;
//        }
//        
//        System.out.println(result);
//        TreeNode<T> temp = result;
////        TreeNode<T> parent = null;
//        while (!(temp.getRight() == null)) {
////            parent = temp;
//            temp = temp.getRight();
//        }
//        result.setValue(temp.getValue());
//        result.setRight(null);
//        
////        System.out.println(result);
//        return true;
    }

    private TreeNode<T> removeHelper(TreeNode<T> node, T value) {
//        TreeNode<T> result = node;
//        TreeNode<T> parentTemp = null;
//        if (node.getValue().compareTo(value) > 0) {
//            result = removeHelper(node.getLeft(), value);
//            final TreeNode<T> parent = node;
//            parentTemp = parent;
//        } else if (node.getValue().compareTo(value) < 0) {
//            result = removeHelper(node.getRight(), value);
//            final TreeNode<T> parent = node;
//            parentTemp = parent;
//        }
//        result.setValue(value);
//        result.setParent(parentTemp);  
        return null;
    }

    @Override
    public T removeAny() throws Exception {
        if (size == 0) throw new Exception("Set is empty!");

        T value = null;
        if (size == 1) {
            value = root.getValue();
            size = 0;
        } else {
            value = root.getValue();
            remove(value); 
        }
        return value;
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
        return toStringHelper(root) + "\nSize: " + getSize() ;
    }

    private String toStringHelper(TreeNode<T> node) {
        if (node == null) {
            return " ";
        }
        
        return toStringHelper(node.getLeft()) + node.getValue() + toStringHelper(node.getRight());
    }

}
