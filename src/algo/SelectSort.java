package algo;

import java.util.Arrays;

/**
 * @Author Administrator
 * @Date 2022/2/19 19:57
 * @Version 1.0
 */
public class SelectSort {

    private static void selectionSort(int[] nums){
        for (int i = 0,n=nums.length; i <n-1 ; i++) {
            int minIndex = i;
            for (int j = i; j < n; j++) {
                if (nums[j]<nums[minIndex]){
                    minIndex = j;
                }
            }
            Swap.swap(nums,minIndex,i);
            System.out.println(i+"===>"+Arrays.toString(nums));
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 9, 5, 8};
        selectionSort(nums);
//        System.out.println(Arrays.toString(nums));
    }
}
