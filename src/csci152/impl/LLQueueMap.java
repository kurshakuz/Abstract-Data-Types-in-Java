package csci152.impl;

import csci152.adt.KeyValuePair;
import csci152.adt.Map;

public class LLQueueMap<K, V> implements Map {

    private LinkedListQueue<KeyValuePair<K, V>> pairs;

    public LLQueueMap() {
        pairs = new LinkedListQueue();
    }

    @Override
    public void define(Object key, Object value) {
        KeyValuePair pair = new KeyValuePair(key, value);

        if (!containsKey(key)) {
            pairs.enqueue(pair);
        } else {
            remove(key);
            pairs.enqueue(pair);
            //pair.setValue(value);
        }
    }

    private boolean containsKey(Object key) {
        int size = pairs.getSize();
        for (int i = 0; i < size; i++) {
            try {
                KeyValuePair x = pairs.dequeue();
                pairs.enqueue(x);
                if (key.equals(x.getKey())) {
                    return true;
                }
            } catch (Exception ex) { }
        }
        return false;
    }

    @Override
    public Object getValue(Object key) {
        int size = pairs.getSize();
        for (int i = 0; i < size; i++) {
            try {
                KeyValuePair x = pairs.dequeue();
                pairs.enqueue(x);
                if (key.equals(x.getKey())) {
                    return x.getValue();
                }
            } catch (Exception ex) {
            }
        }
        return null;
    }

    @Override
    public Object remove(Object key) {
        int size = pairs.getSize();
        for (int i = 0; i < size; i++) {
            try {
                KeyValuePair x = pairs.dequeue();
                if (key.equals(x.getKey())) {
                    return x.getValue();
                } else {
                    pairs.enqueue(x);
                }
            } catch (Exception ex) {
            }
        }
        return null;
    }

    @Override
    public KeyValuePair removeAny() throws Exception {
        if (pairs.getSize() == 0) {
            throw new Exception("Map is empty");
        } else {
            return pairs.dequeue();
        }
    }

    @Override
    public int getSize() {
        return pairs.getSize();
    }

    @Override
    public void clear() {
        pairs = new LinkedListQueue();
    }


    public String toString() {
        String message = "{";
        for (int i = 0; i < pairs.getSize(); i++) {
            try {
                KeyValuePair x = pairs.dequeue();
                message += x + " ";
                pairs.enqueue(x);
            } catch (Exception ex) {
                //OWubKA
            }

        }
        message += "}";

        return message += "\nSize: " + getSize();
    }
    }
