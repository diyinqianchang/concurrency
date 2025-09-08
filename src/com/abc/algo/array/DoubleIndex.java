package com.abc.algo.array;

import com.abc.algo.QuickSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author Administrator
 * @Date 2025/9/7 15:19
 * @Version 1.0
 */
public class DoubleIndex {


    public int removeDuplicates(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length){
            if (nums[fast] != nums[slow]){
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        System.out.println(Arrays.toString(nums));
        return slow + 1;
    }

    public void moveZeroes(int[] nums) {
        if (nums.length == 0){
            return;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length){
            if (nums[fast] != 0){
                nums[slow] = nums[fast];
                if (slow != fast){
                    nums[fast] = 0;
                }
                slow++;
            }
            fast++;
        }
        System.out.println(Arrays.toString(nums));
    }


    public List<List<Integer>> threeSum(int[] nums,int target) {
        Arrays.sort(nums);
//        int sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//        }
//        System.out.println(sum);
        long min = Arrays.stream(nums).filter(i -> i < 0).mapToLong(Long::valueOf).reduce(0,Long::sum);
        long max = Arrays.stream(nums).filter(i -> i > 0).mapToLong(Long::valueOf).reduce(0,Long::sum);
        System.out.println(min);
        System.out.println(max);
        if (target < min || target > max){
            return new ArrayList<>();
        }
//        List<List<Integer>> lists = threeSumClosest(nums, 4, 0, target);
//        System.out.println(lists);
//        return lists;
        return new ArrayList<>();
    }

    public List<List<Integer>> threeSumClosest(int[] nums, int n, int start, int target) {
        System.out.println("nums:" + Arrays.toString(nums) + " start: " + start + " target: " + target + " n: " + n);
        List<List<Integer>> res = new ArrayList<>();
        int size = nums.length;
        if (n < 2 || size < 2){
            return res;
        }
        if (target < nums[start]){
            return res;
        }
        if (n == 2){
            int lo = start, hi = size - 1;
            while (lo < hi){
                int sum = nums[lo] + nums[hi];
                System.out.println("sum: "+sum + " target: "+ target);
                int left = nums[lo], right = nums[hi];
                if (sum < target){
                    while (lo < hi && nums[lo] == left){
                        lo++;
                    }
                }else if (sum > target){
                    while (lo < hi && nums[hi] == right){
                        hi--;
                    }
                }else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[lo]);
                    list.add(nums[hi]);
                    res.add(list);
                    while (lo < hi && nums[lo] == left){
                        lo++;
                    }
                    while (lo < hi && nums[hi] == right){
                        hi--;
                    }
                }
            }
        }else {
            for (int i = start; i < size; i++) {
                int numNo = n - 1;
                int nextTarget = target - nums[i];
                List<List<Integer>> temp = threeSumClosest(nums,numNo, i + 1, nextTarget);
                if (numNo == 2){
                    System.out.println(temp + " " + nextTarget);
                }
                for (List<Integer> list : temp) {
                    list.add(nums[i]);
                    res.add(list);
                }
                while (i < size - 1 && nums[i] == nums[i + 1]){
                    i++;
                }
            }
        }
        return res;
    }





    public static void main(String[] args) {
        DoubleIndex doubleIndex = new DoubleIndex();
        int[] nums = {-1000000000,-1000000000,-1000000000,-1000000000};
        doubleIndex.threeSum(nums,294967296);
    }

}
