package csci152.impl;

import csci152.adt.KeyValuePair;
import csci152.adt.Map;

public class LLStackMap<K, V> implements Map<K, V> {

    private LinkedListStack<KeyValuePair<K, V>> pairs;

    public LLStackMap() {
        pairs = new LinkedListStack();
    }

    @Override
    public void define(Object key, Object value) {
        KeyValuePair pair = new KeyValuePair(key, value);
        if (!containsKey(key)) {
            pairs.push(pair);
            //System.out.println(pairs.getSize());
        } else {
            remove(key);
            pairs.push(pair);
        }
    }

    public boolean containsKey(Object key) {
        int size = pairs.getSize();
        boolean result = false;
        LinkedListStack<KeyValuePair<K, V>> pairsTemp = new LinkedListStack();

        for (int i = 0; i < size; i++) {
            try {
                KeyValuePair x = pairs.pop();
                pairsTemp.push(x);
                if (key.equals(x.getKey())) {
                    result = true;
                }
            } catch (Exception ex) { }
        }
        for (int i = 0; i < size; i++) {
            try {
                KeyValuePair x = pairsTemp.pop();
                pairs.push(x);
            } catch (Exception ex) {
            }
        }
        //System.out.println(result);
        return result;
    }


    @Override
    public Object getValue(Object key) {
        int size = pairs.getSize();
        LinkedListStack<KeyValuePair<K, V>> pairsTemp = new LinkedListStack();
        Object result = null;
        for (int i = 0; i < size; i++) {
            try {
                KeyValuePair x = pairs.pop();
                if (key.equals(x.getKey())) {
                    result =  x.getValue();
                }
                pairsTemp.push(x);
            } catch (Exception ex) {
            }
        }
        int size1 = pairs.getSize();
        for (int i = 0; i < size1; i++) {
            try {
                KeyValuePair x = pairsTemp.pop();
                pairs.push(x);
            } catch (Exception ex) {
            }
        }
        return result;
    }

    @Override
    public Object remove(Object key) {
        LinkedListStack<KeyValuePair<K, V>> pairsTemp = new LinkedListStack();
        int size = pairs.getSize();
        //System.out.println(pairs.getSize());
        Object result = null;

        for (int i = 0; i < size; i++) {
            try {
                KeyValuePair x = pairs.pop();
                if (key.equals(x.getKey())) {
                    result = x.getValue();
                } else {
                    pairsTemp.push(x);
                }
            } catch (Exception ex) {
            }
        }

        int size1 = pairsTemp.getSize();
        for (int i = 0; i < size1; i++) {
            try {
                KeyValuePair x = pairsTemp.pop();
                pairs.push(x);
            } catch (Exception ex) {
            }
        }
        return result;
    }

    @Override
    public KeyValuePair removeAny() throws Exception {
        if (pairs.getSize() == 0) {
            throw new Exception("Map is empty");
        } else {
            return pairs.pop();
        }
    }

    @Override
    public int getSize() {
        return pairs.getSize();
    }

    @Override
    public void clear() {
        pairs = new LinkedListStack();
    }

    public String toString() {
        LinkedListStack<KeyValuePair<K, V>> pairsTemp = new LinkedListStack();
        String message = "{";
        int size = pairs.getSize();
        for (int i = 0; i < size; i++) {
            try {
                KeyValuePair x = pairs.pop();
                pairsTemp.push(x);
                message += x + " ";
            } catch (Exception ex) {
            }
        }
        int size1 = pairsTemp.getSize();
        for (int i = 0; i < size1; i++) {
            try {
                KeyValuePair x = pairsTemp.pop();
                pairs.push(x);
            }
            catch (Exception ex) {

            }
        }
        message += "}";

        return message += "\nSize: " + getSize();
    }
}
