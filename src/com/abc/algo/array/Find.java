package com.abc.algo.array;

/**
 * @Author Administrator
 * @Date 2025/9/7 15:02
 * @Version 1.0
 */
public class Find {


    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        int left = 0, right = nums.length-1;
        while (left <= right){
            int num = nums[left];
            if (ans[0] == -1){
                if (num == target){
                    ans[0] = left;
                }else{
                    left++;
                }
            }

            num = nums[right];
            if (ans[1] == -1){
                if (num == target){
                    ans[1] = right;
                }else{
                    right--;
                }
            }
            if (ans[0] != -1 && ans[1] != -1){
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Find find = new Find();
        int[] nums = {1,2,3};
        int[] ans = find.searchRange(nums, 1);
        System.out.println(ans[0] + " " + ans[1]);
    }


}
