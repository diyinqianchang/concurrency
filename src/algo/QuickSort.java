package algo;

import java.util.Arrays;

/**
 * @Author Administrator
 * @Date 2022/2/19 21:32
 * @Version 1.0
 */
public class QuickSort {

    private static void quickSort(int[] nums){
        quickSort(nums,0,nums.length-1);
    }
    private static void quickSort(int[] nums,int low,int high){
        if (low >= high){
            return;
        }
        int[] p = partition(nums,low,high);
        System.out.println(Arrays.toString(p));
        quickSort(nums,low,p[0]-1);
        quickSort(nums,p[0]+1,high);
    }
    private static int[] partition(int[] nums,int low,int high){
        int less = low-1,more = high;
        while (low<more){
            if (nums[low] < nums[high]){
                Swap.swap(nums,++less,low++);
            }else if(nums[low] > nums[high]){
                Swap.swap(nums,--more,low);
            }else {
                ++low;
            }
        }
        Swap.swap(nums,more,high);
        return new int[]{less+1,more};
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 4, 5, 3};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
