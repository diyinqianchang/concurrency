package com.abc.algo;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @Author Administrator
 * @Date 2022/2/19 23:11
 * @Version 1.0
 */
public class BinarySearch {

    private static int search(int[] nums,int low,int high,int val){

        while (low<=high){
            int mid = (low+high)>>>1;
            if (nums[mid]==val){
                return mid;
            }else if (nums[mid]<val){
                low = mid+1;
            }else {
                high=mid-1;
            }
        }
        return -1;
    }

    // 查找第一个值等于给定值的元素
    private static int search1(int[] nums,int low,int high,int val){

        while (low<=high){
            int mid = (low+high)>>>1;
            System.out.println(mid);
            if (nums[mid] > val){
                high=mid-1;
            }else if (nums[mid]<val){
                low = mid+1;
            }else {
                if (mid==0 || nums[mid-1]!=val){
                    return mid;
                }
               high = mid-1;
            }
        }
        return -1;
    }


    private static int search(int[] nums,int val){
        return search1(nums,0,nums.length-1,val);
    }

    private static int search2(int[] nums,int val){
        if (nums.length==0){
            return -1;
        }
        int left = 0, right = nums.length-1;
        while (left <= right){
            int mid = left + (right-left) / 2;
            if (nums[mid] > val){
                right = mid-1;
            }else if (nums[mid]<val){
                left = mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    private static int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
               left = mid + 1;
            }else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                right = mid - 1;
            }
        }
        if (left >= nums.length || left < 0){
            return -1;
        }
        return nums[left] == target ? left : -1;
    }

    private static int rightBound(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            }else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (right < 0 || right >= nums.length){
            return -1;
        }
        return nums[right] == target ? right : -1;
    }


    public static int shipWithinDays(int[] weights, int days) {
        if (weights.length == 0){
            return 0;
        }
        int total = Arrays.stream(weights).sum();
        int max = Arrays.stream(weights).max().getAsInt();
        int left = max,right = total;
        while (left <= right){
            int mid = left + (right - left) / 2;
            int tempDays = 1;
            int dayWeight = 0;
            System.out.println("mid: "+mid);
            for (int weight : weights) {
                dayWeight += weight;
                if (dayWeight > mid){
                    tempDays++;
                    dayWeight = weight;
                }
            }
            if (tempDays > days){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        int[] res = new int[nums1.length];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b)->b[1]-a[1]);
        for (int i = 0; i < nums2.length; i++) {
            queue.offer(new int[]{i, nums2[i]});
        }
        int left = 0, right = nums1.length - 1;
        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int index = poll[0];
            int val = poll[1];
            if (val < nums1[right]){
                res[index] = nums1[right];
                right--;
            }else {
                res[index] = nums1[left];
                left++;
            }

        }
        return res;
    }


    public static int minAddToMakeValid(String s) {
        // 一个左括号需要一个右括号 有括号多需要补左括号
        int res = 0;
        int need= 0;
        for (int i = 0; i < s.length() ; i++) {
            char c = s.charAt(i);
            if (c == '('){
                need++;
            }else {
                need--;
                if (need == -1){
                    res++;
                    need = 0;
                }
            }
        }
        return res+need;
    }


    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];

        return res;
    }

    public static int[] nextGreaterElement(int[] nums){
//        2,1,2,4,3
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length-1; i >=0 ; i--) {
            System.out.println(stack);
            while (!stack.isEmpty() && stack.peek() <= nums[i]){
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        System.out.println(Arrays.toString(res));
        return res;
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        for (int i = temperatures.length-1; i >=0 ; i--) {
            while (!stack.isEmpty() && stack.peek()[0] <= temperatures[i]){
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek()[1]-i;
            stack.push(new int[]{temperatures[i], i});
        }
        System.out.println(Arrays.toString(res));
        return res;
    }


    public static int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2*length-1; i >=0 ; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i%length]){
                stack.pop();
            }
            res[i%length] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % length]);
        }
        System.out.println(Arrays.toString(res));
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 5, 7,8, 8, 9};
//        int search = search(nums, 8);
//        System.out.println(search);
//        shipWithinDays(new int[]{1,2,3,1,1},4);

//        advantageCount(new int[]{12,24,8,32}, new int[]{13,25,32,11});
//        nextGreaterElement(new int[]{2,1,2,4,3});
        nextGreaterElement(new int[]{2,1,2,4,3});
        System.out.println();

    }

}
