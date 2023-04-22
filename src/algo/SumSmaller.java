package algo;

import java.util.Arrays;

/**
 * @Author Administrator
 * @Date 2022/2/27 11:03
 * @Version 1.0
 */
public class SumSmaller {

    private static int threeSumSmaller(int[] nums,int target){

        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            count += threeSumSmaller(nums,i+1,n-1,target-nums[i]);
        }
        return count;
    }

    private static int threeSumSmaller(int[] nums,int start,int end,int target){
        int count = 0;
        while (start < end){
            if (nums[start] + nums[end] < target){
                count += (end -start);
                ++start;
            }else {
                --end;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,1,3};
        int smaller = threeSumSmaller(nums, 2);
        System.out.println(smaller);
        System.out.println(Arrays.toString(nums));
    }

}

















