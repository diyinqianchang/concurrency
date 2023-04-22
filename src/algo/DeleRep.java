package algo;

import java.util.Arrays;

/**
 * @Author Administrator
 * @Date 2022/2/20 10:24
 * @Version 1.0
 */
public class DeleRep {
    /**
     * 给定数组 nums = [1,1,2],
     * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     * 你不需要考虑数组中超出新长度后面的元素
     * @param nums
     * @return
     */
    private static int removeDuplicates(int[] nums){
        int cnt = 0, n = nums.length;
        for (int i = 1; i < n; ++i) {
            if (nums[i]==nums[i-1]){
                ++cnt;
            }else{
                nums[i-cnt] = nums[i];
                System.out.println("i-->"+i+" cnt--->"+cnt);
            }

        }
        return n-cnt;
    }

    private static int removeDuplicates2(int[] nums){
        int n = nums.length;
        int last = 1;
        for (int i = 1; i < n; ++i) {
            if (nums[i]==nums[i-1]){

            }else{
                nums[last++] = nums[i];
            }
        }
        return last;
    }

    /**
     * 给定 nums = [0,0,1,1,1,1,2,3,3],
     * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
     * 你不需要考虑数组中超出新长度后面的元素。
     * @param nums
     * @return
     */
    private static int removeDuplicates3(int[] nums){
        int n = nums.length;
        int last = 1,cnt = 0;
        for (int i = 1; i < n; ++i) {
            if (nums[i]==nums[i-1]){
                ++cnt;
            }else{
               cnt = 0;
            }
            if (cnt<2){
                nums[last++] = nums[i];
            }
        }
        return last;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int search = removeDuplicates2(nums);
        System.out.println(search);
        System.out.println(Arrays.toString(nums));
    }


}
