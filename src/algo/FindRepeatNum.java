package algo;

import java.util.Arrays;

/**
 * @Author Administrator
 * @Date 2022/2/20 11:47
 * @Version 1.0
 */
public class FindRepeatNum {

    private static int findRepeatNum(int[] nums){
        int n;
        if (nums == null || (n=nums.length) < 1){
            return -1;
        }
        for (int i = 0; i < n; i++) {
            while (nums[i]!=i){
                if (nums[i]==nums[nums[i]])return nums[i];
                Swap.swap(nums,i,nums[i]);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,0,2,5,3};
        int repeatNum = findRepeatNum(nums);
        System.out.println(repeatNum);
        System.out.println(Arrays.toString(nums));
    }
}
