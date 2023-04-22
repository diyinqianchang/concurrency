package algo;

/**
 * @Author Administrator
 * @Date 2022/2/19 19:59
 * @Version 1.0
 */
public class Swap {

    public static void swap(int[] nums,int i,int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
