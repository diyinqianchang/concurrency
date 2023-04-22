package algo;

import java.util.Arrays;

/**
 * @Author Administrator
 * @Date 2022/2/27 11:57
 * @Version 1.0
 */
public class ProductExceptSelf {


    private static int[] productExceptSelf(int[] nums){

        int n = nums.length;
        int[] outPut = new int[n];
        for (int i = 0,left = 1; i < n; i++) {
            outPut[i] = left;
            left *= nums[i];
        }
        System.out.println(Arrays.toString(outPut));
        for (int i = n-1,right = 1; i>=0; --i) {
            outPut[i] *= right;
            right *= nums[i];
        }
        return outPut;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] pro = productExceptSelf(nums);
        System.out.println(Arrays.toString(pro));
    }

}
