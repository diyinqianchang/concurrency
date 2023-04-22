package algo;

import java.util.Arrays;

/**
 * @Author Administrator
 * @Date 2022/2/19 18:59
 * @Version 1.0
 */
public class BubbleSort {

    private static void bubbleSort(int[] nums){
        boolean hasChange = true;
        for (int i = 0,n=nums.length; i < n-1 && hasChange; ++i) {
            hasChange = false;
            for (int j = 0; j < n-i-1; ++j) {
                if (nums[j] > nums[j+1]){
                    swap(nums,j,j+1);
                    hasChange = true;
                }
            }
        }
    }

    private static void bubbleSort1(int[] nums){
        int n = nums.length;
        for (int i = 0; i < n-1; ++i) {
            for (int j = 0; j < n-i-1; ++j) {
                if (nums[j] > nums[j+1]){
                    swap(nums,j,j+1);
                }
            }
        }
    }

    private static void swap(int[] nums,int i,int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 9, 5, 8};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
