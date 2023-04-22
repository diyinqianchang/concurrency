package algo;

import java.util.Arrays;

/**
 * @Author Administrator
 * @Date 2022/2/19 19:25
 * @Version 1.0
 */
public class InsertSort {

    private static void insertionSort(int[] nums){
        for (int i = 1,j,n= nums.length; i < n; ++i) {
            int num = nums[i];
            System.out.print(num +"===>");
            for (j = i-1; j>=0 && nums[j]>num; --j) {
                nums[j+1] = nums[j];
            }
            System.out.print(j +"===>");
            nums[j+1] = num;
            System.out.println(Arrays.toString(nums));
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 9, 5, 8};
        insertionSort(nums);
//        System.out.println(Arrays.toString(nums));
    }

}
