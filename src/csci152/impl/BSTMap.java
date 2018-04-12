package csci152.impl;

import csci152.adt.KeyValuePair;
import csci152.adt.Map;

public class BSTMap<K extends Comparable, V> implements Map<K, V> {

    private TreeNode<KeyValuePair<K, V>> root;
    private int size;

    public BSTMap() {
        root = null;
        size = 0;
    }

    public boolean contains(K key) {
        return containsHelper(root, key);
    }

    private boolean containsHelper(TreeNode<KeyValuePair<K, V>> node, K key) {
        boolean check;

        if (node == null) {
            return false;
        }

        if (node.getValue().getKey().compareTo(key) > 0) {
            check = containsHelper(node.getLeft(), key);
        } else {
            check = containsHelper(node.getRight(), key);
        }

        if (node.getValue().getKey().equals(key)) {
            check = true;
        }

        return check;
    }

    @Override
    public void define(K key, V value) {
        KeyValuePair pair = new KeyValuePair(key, value);
        TreeNode<KeyValuePair<K, V>> newRoot = root;

        if (size == 0) {
            root = new TreeNode(pair);
            size++;
            return;
        }

        while (true) {
            if (newRoot.getValue().getKey().compareTo(key) > 0) {
                if (newRoot.getLeft() == null) {
                    newRoot.setLeft(new TreeNode(pair));
                    size++;
                    return;
                } else {
                    newRoot = newRoot.getLeft();
                }
            } else if (newRoot.getValue().getKey().compareTo(key) < 0) {
                if (newRoot.getRight() == null) {
                    newRoot.setRight(new TreeNode(pair));
                    size++;
                    return;
                } else {
                    newRoot = newRoot.getRight();
                }
            } else {
                newRoot.setValue(pair);
                return;
            }
        }


    }

    @Override
    public V getValue(K key) {
        TreeNode<KeyValuePair<K, V>> newRoot = root;

        if (size == 0) {
            return null;
        }

        while (true) {
            K tempKey = newRoot.getValue().getKey();
            if (tempKey.compareTo(key) > 0) {
                if (newRoot.getLeft() == null) {
                    return null;
                } else {
                    newRoot = newRoot.getLeft();
                }
            } else if (tempKey.compareTo(key) < 0) {
                if (newRoot.getRight() == null) {
                    return null;
                } else {
                    newRoot = newRoot.getRight();
                }
            } else {
                return newRoot.getValue().getValue();
            }
        }
    }

//    void remove(int data){
//        root = remove(root ,data);
//    }
//
//    private TreeNode remove(TreeNode<KeyValuePair<K,V>> newRoot, K key) {
//        TreeNode cur = newRoot;
//        if(cur == null){
//            return cur;
//        }
//        K tempKey = newRoot.getValue().getKey();
//        if (key.compareTo(newRoot.getValue().getKey()) < 0) {
//            newRoot = removeHelper(key, newRoot.getLeft());
//        } else if (key.compareTo(newRoot.getValue().getKey()) > 0) {
//            newRoot = removeHelper(key, newRoot.getRight());
//        } else {
//            if (newRoot.getLeft() == null && newRoot.getRight() == null) {
//                newRoot = null;
//            } else if (newRoot.getRight() == null) {
//                newRoot = newRoot.getLeft();
//            } else if (newRoot.getLeft() == null) {
//                newRoot = newRoot.getRight();
//            } else {
//                TreeNode<KeyValuePair<K, V>> temp = MinRight(newRoot.getRight());
//                newRoot.setValue(temp.getValue());
//                newRoot.setRight(removeHelper(temp.getValue().getKey(), newRoot.getRight()));
//            }
//        }
//        return newRoot;
//    }
//
//    private TreeNode findMinFromRight(TreeNode node) {
//        while(node.left != null){
//            node = node.left;
//        }
//        return node;
//    }


    @Override
    public V remove(K key) {
        if (!contains(key)) {
            return null;
        }

        TreeNode<KeyValuePair<K, V>> newRoot = root;
        TreeNode<KeyValuePair<K, V>> parent = null;
        V result = null;
        boolean isOnLeft = false;

        if (size == 0) {
            return null;
        }

        while (true) {
            K tempKey = newRoot.getValue().getKey();
            if (tempKey.compareTo(key) > 0) {
                parent = newRoot;
                newRoot = newRoot.getLeft();
                isOnLeft = true;
            } else if (tempKey.compareTo(key) < 0) {
                parent = newRoot;
                newRoot = newRoot.getRight();
                isOnLeft = false;
            } else {
                result = newRoot.getValue().getValue();
                break;
            }
        }


        if (newRoot.getLeft() == null && newRoot.getRight() == null) {
            if (isOnLeft) {
                parent.setLeft(null);
            } else {
                //parent.setRight(null);
            }
        } else if (newRoot.getLeft() != null && newRoot.getRight() == null) {
            if (isOnLeft) {
                parent.setLeft(newRoot.getLeft());
            } else {
                parent.setRight(newRoot.getLeft());
            }
        } else if (newRoot.getRight() != null && newRoot.getLeft() == null) {
            if (isOnLeft) {
                parent.setLeft(newRoot.getRight());
            } else {
                parent.setRight(newRoot.getRight());
            }

        } else if (newRoot.getLeft() != null && newRoot.getRight() != null) {
            TreeNode<KeyValuePair<K, V>> lowest = newRoot.getRight();
            TreeNode<KeyValuePair<K, V>> parentOfLowest = newRoot;


            while (lowest.getLeft() != null) {
                parentOfLowest = lowest;
                lowest = lowest.getLeft();
            }

            if (lowest.getRight() != null) {
                parentOfLowest.setLeft(lowest.getRight());
            } else {
                parentOfLowest.setLeft(null);
            }
            newRoot.setValue(lowest.getValue());
        }

        size--;
        return result;
    }

    @Override
    public KeyValuePair<K, V> removeAny() throws Exception {
        if (size == 0) throw new Exception("Map is empty!");
        KeyValuePair<K, V> pair = null;

        if (size == 1) {
            pair = root.getValue();
            size--;

        } else {
            pair = root.getValue();
            remove(root.getValue().getKey());
        }
        return pair;
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

    @Override
    public String toString() {
        return toStringHelper(root) ;
        //+ "\nSize: " + getSize()
    }

    private String toStringHelper(TreeNode<KeyValuePair<K, V>> node) {
        if (node == null) {
            return " ";
        }

        return toStringHelper(node.getLeft()) + node.getValue() + toStringHelper(node.getRight());
    }
}