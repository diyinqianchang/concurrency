package algo;

import java.util.Arrays;

/**
 * @Author Administrator
 * @Date 2022/2/20 11:13
 * @Version 1.0
 */
public class RemoveElement {

    private static int removeElement(int[] nums,int val){
        int cnt=0,n=nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i]==val){
                ++cnt;
            }else {
                nums[i-cnt] = nums[i];
            }
        }
        return n-cnt;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int search = removeElement(nums,2);
        System.out.println(search);
        System.out.println(Arrays.toString(nums));
    }

}
