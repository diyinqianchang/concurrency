package algo;

import java.util.Arrays;

/**
 * @Author Administrator
 * @Date 2022/2/20 11:54
 * @Version 1.0
 */
public class Rotate {

    private static void rotate(int[] nums,int k){
        int n;
        if (nums == null || (n=nums.length) < 1){
            return;
        }
        k %= n;
        if (n<2 || k==0){
            return;
        }
        for (int i = 0; i < k; i++) {
            int curr = nums[n-1];
            for (int j = 1; j <n; j++) {
                nums[n-j] = nums[n-1-j];
            }
            nums[0] = curr;
        }
//        rotate(nums, 0, n - 1);
//        rotate(nums, 0, k - 1);
//        rotate(nums, k, n - 1);

    }

    private static void rotate(int[] nums, int i, int j) {
        while (i < j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            ++i;
            --j;
        }
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,6,7,8,9};
        rotate(nums,4);
        System.out.println(Arrays.toString(nums));

    }

}
