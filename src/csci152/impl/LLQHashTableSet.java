package csci152.impl;

import csci152.adt.HashTableSet;
import csci152.adt.HashTableStats;
import csci152.adt.Set;
import csci152.impl.LinkedListQueue;

import java.util.Objects;

import static java.lang.Math.abs;

public class LLQHashTableSet<T> implements HashTableSet<T> {

    private LinkedListQueue<T>[] buckets;
    private int size;
    private int k;

    public LLQHashTableSet(int numberOfBuckets) {
        buckets = new LinkedListQueue[numberOfBuckets];
        size = 0;
        k = numberOfBuckets;
    }

    @Override
    public void add(T value) {
        int hash = value.hashCode();
        hash = abs(hash);
        if (!contains(value)) {
            int index = (hash % k);
            if (buckets[index] == null) {
                buckets[index] = new LinkedListQueue();
                buckets[index].enqueue(value);
                size++;
            } else {
                buckets[index].enqueue(value);
                size++;
            }
        }

    }

    @Override
    public boolean contains(T value) {
        int hash = abs(value.hashCode());
        int index = (hash % k);
        boolean result = false;
        if (getSize() == 0) return false;
        if (buckets[index] == null) return false;

        int size0 = buckets[index].getSize();
        for (int i = 0; i < size0; i++) {
            try {
                T val = buckets[index].dequeue();
                buckets[index].enqueue(val);
                if (val.equals(value)) {
                    return true;
                }
            } catch (Exception ex) {
            }
        }
        return false;
    }

    @Override
    public boolean remove(T value) {
        boolean result = false;
        if (!contains(value)) {
            return false;
        } else {
            int hash = abs(value.hashCode());
            int index = (hash % k);
            for (int i = 0; i < buckets[index].getSize(); i++) {
                try {
                    T temp = buckets[index].dequeue();
                    int hashTemp = abs(value.hashCode());
                    if (Objects.equals(temp, value)) {
                        size--;
                        result = true;
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
    public T removeAny() throws Exception {
        T temp = null;
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
        //System.out.println(meanSize);

        for (int i = 0; i < k; i++) {
            int size;
            if (buckets[i] == null) {
                size = 0;
            } else {
                size = buckets[i].getSize();
            }
            sumOfDifferences += (Math.pow((meanSize - size), 2));
            //System.out.println("!" + sumOfDifferences + "!");
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
}
