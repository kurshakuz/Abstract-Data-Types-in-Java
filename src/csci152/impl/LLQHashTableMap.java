package csci152.impl;

import csci152.adt.HashTableMap;
import csci152.adt.HashTableStats;
import csci152.adt.KeyValuePair;

import static java.lang.Math.abs;

public class LLQHashTableMap<K, V> implements HashTableMap<K, V> {

    private LinkedListQueue<KeyValuePair<K, V>>[] buckets;
    private int size;
    private int k;

    public LLQHashTableMap(int numberOfBuckets) {
        buckets = new LinkedListQueue[numberOfBuckets];
        size = 0;
        k = numberOfBuckets;
    }

    @Override
    public int getNumberOfBuckets() {
        return k;
    }

    @Override
    public int getBucketSize(int index) throws Exception {
        if (buckets[index].getSize() == 0) {
            throw new Exception("Bucket is empty!");
        } else {
            return buckets[index].getSize();
        }
    }

    @Override
    public double getLoadFactor() {
        return (size / k);
    }

    @Override
    public double getBucketSizeStandardDev() {
        int sumOfSizes = 0;
        double sumOfDifferences = 0;
        for (int i = 0; i < k; i++) {
            int size;
            if (buckets[i] == null) {
                size = 0;
            } else {
                size = buckets[i].getSize();
            }
            sumOfSizes += size;
        }
        double meanSize = (sumOfSizes/k);

        for (int i = 0; i < k; i++) {
            int size;
            if (buckets[i] == null) {
                size = 0;
            } else {
                size = buckets[i].getSize();
            }
            sumOfDifferences += (Math.pow((meanSize - size), 2));
        }

        return Math.sqrt(sumOfDifferences/k);
    }

    @Override
    public String bucketsToString() {
        String result = "";

        for(int i = 0; i < k; i++) {
            if (buckets[i] == null) {
                result += " " + "\n";
            } else {
                result += buckets[i] + "\n";
            }
        }
        result += "Size: " + size;
        return result;
    }

    @Override
    public void define(K key, V value) {
        int hash = key.hashCode();
        hash = abs(hash);

        if (!contains(key)) {
            int index = (hash % k);
            KeyValuePair pair = new KeyValuePair(key, value);
            if (buckets[index] == null) {
                buckets[index] = new LinkedListQueue();
                buckets[index].enqueue(pair);
                size++;
            } else {
                buckets[index].enqueue(pair);
                size++;
            }
        }
    }

    public boolean contains(K key) {
        int hash = abs(key.hashCode());
        int index = (hash % k);
        boolean result = false;

        if (getSize() == 0) return false;
        if (buckets[index] == null) return false;

        int size0 = buckets[index].getSize();
        for (int i = 0; i < size0; i++) {
            try {
                KeyValuePair<K, V> val = buckets[index].dequeue();
                buckets[index].enqueue(val);
                if (val.getKey().equals(key)) {
                    return true;
                }
            } catch (Exception ex) {
            }
        }
        return false;
    }

    @Override
    public V getValue(K key) {
        int hash = abs(key.hashCode());
        int index = (hash % k);
        V result = null;
        if (getSize() == 0) return null;
        if (buckets[index] == null) return null;

        int size0 = buckets[index].getSize();
        for (int i = 0; i < size0; i++) {
            try {
                KeyValuePair<K, V> val = buckets[index].dequeue();
                buckets[index].enqueue(val);
                if (val.getKey().equals(key)) {
                    result = val.getValue();
                }
            } catch (Exception ex) {
            }
        }

        return result;
    }

    @Override
    public V remove(K key) {
        V result = null;
        if (!contains(key)) {
            return null;
        } else {
            int hash = abs(key.hashCode());
            int index = (hash % k);
            int size0 = buckets[index].getSize();
            for (int i = 0; i < size0; i++) {
                try {
                    KeyValuePair<K, V> temp = buckets[index].dequeue();
                    if (temp.getKey().equals(key)) {
                        size--;
                        result = temp.getValue();
                    } else {
                        buckets[index].enqueue(temp);
                    }
                } catch (Exception e) {
                }

            }
            return result;
        }
    }

    @Override
    public KeyValuePair<K, V> removeAny() throws Exception {
        KeyValuePair<K, V> temp = null;
        if (getSize() == 0) throw new Exception("Set is empty!");

        for (int i = 0; i < k; i++) {
            if (buckets[i].getSize() != 0) {
                temp = buckets[i].dequeue();
                size--;
                return temp;
            }
        }
        return temp;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        buckets = new LinkedListQueue[k];
        size = 0;
    }

    public String toString() {
        String result = "";
        for(int i = 0; i < k; i++){
            result +=  buckets[i] + "\n";
        }
        result += "Size: " + size;
        return result;
    }


}
