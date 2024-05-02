
package algo.heap;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {

    List<Integer> maxHeap;

    public MaxHeap(List<Integer> nums) {
        maxHeap = new ArrayList<>(nums);
        for (int i = parent(size()-1); i >= 0 ; i--) {
            siftDown(i);
        }
    }

    int left(int i) {
        return 2 * i + 1;
    }

    int right(int i) {
        return 2 * i + 2;
    }

    int parent(int i) {
        //向下取整
        return (i - 1) / 2;
    }

    int peek() {
        return maxHeap.get(0);
    }

    int size() {
        return maxHeap.size();
    }

    void push(int val) {
        maxHeap.add(val);
        siftUp(size() - 1);
    }

    private void swap(int i, int j) {
        int tmp = maxHeap.get(i);
        maxHeap.set(i, maxHeap.get(j));
        maxHeap.set(j, tmp);
    }

    void siftUp(int i) {
        while (true) {
            int p = parent(i);
            if (p < 0 || maxHeap.get(i) <= maxHeap.get(p)) {
                break;
            }
            swap(i, p);
            i = p;
        }
    }

    int pop() {
        if (size() == 0) {
            throw new IndexOutOfBoundsException();
        }
        swap(0, size() - 1);
        int val = maxHeap.remove(size() - 1);
        siftDown(0);
        return val;
    }

    private void siftDown(int i) {
        while (true) {
            int l = left(i), r = right(i), ma = i;
            if (l < size() && maxHeap.get(l) > maxHeap.get(ma)) {
                ma = l;
            }
            if (r < size() && maxHeap.get(r) > maxHeap.get(ma)) {
                ma = r;
            }
            if (ma == i) {
                break;
            }
            swap(i, ma);
            i = ma;
        }
    }


}