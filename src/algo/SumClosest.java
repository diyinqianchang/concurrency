package algo;

import java.util.Arrays;

/**
 * @Author Administrator
 * @Date 2022/2/27 11:12
 * @Version 1.0
 */
public class SumClosest {

    private static int threeSumClosest(int[] nums,int taget){
        Arrays.sort(nums);
        int res = 0;
        int n = nums.length;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; ++i) {
            int t = twoSumClosest(nums,i+1,n-1,taget-nums[i]);
            if (Math.abs(nums[i]+t-taget)<diff){
                res = nums[i]+t;
                diff = Math.abs(nums[i]+t-taget);
            }
        }
        return res;
    }

    private static int twoSumClosest(int[] nums,int start,int end,int target){
        int res = 0;
        int diff = Integer.MAX_VALUE;
        while (start<end){
            int val = nums[start] + nums[end];
            if (val == target){
                return val;
            }
            if (Math.abs(val-target)<diff){
                res = val;
                diff = Math.abs(val-target);
            }
            if (val < target){
                ++start;
            }else {
                --end;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int i = threeSumClosest(nums, 1);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));
    }



}
