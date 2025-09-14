package com.abc.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Administrator
 * @Date 2025/9/14 20:30
 * @Version 1.0
 */
public class RandomizedSet {

    List<Integer> nums;
    Map<Integer, Integer> map;
    public RandomizedSet() {
        nums= new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        nums.add(val);
        map.put(val, nums.size()-1);
        return true;

    }

    public boolean remove(int val) {
        if (!map.containsKey(val)){
            return false;
        }
        int index = map.get(val);
        map.put(nums.get(nums.size()-1),index);
        nums.set(index,nums.get(nums.size()-1));
        nums.remove(nums.size()-1);
        map.remove(val);
        return true;

    }

    public int getRandom() {
        return nums.get((int)(Math.random()*nums.size()));
    }

}
