package algo;

import java.util.Arrays;

/**
 * @Author Administrator
 * @Date 2022/2/20 11:37
 * @Version 1.0
 */
public class MoveZeros {

    private static void moveZeros(int[] nums){

        int n;
        if (nums == null || (n=nums.length) < 1){
            return;
        }
        int zeroCount = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0){
                zeroCount++;
            }else {
                nums[i-zeroCount] = nums[i];
            }
        }
        while (zeroCount>0){
            nums[n-zeroCount--] = 0;
        }

    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12,14};
        moveZeros(nums);
        System.out.println(Arrays.toString(nums));
    }

}
