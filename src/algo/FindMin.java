package algo;

/**
 * @Author Administrator
 * @Date 2022/2/27 11:39
 * @Version 1.0
 */
public class FindMin {

    private static int findMin(int[] nums){
        int l = 0,r = nums.length - 1;
        while (l<r){
            int m = (l+r) >>> 1;
            if (nums[m]>nums[r]){
                l = m+1;
            }else if(nums[m] < nums[r]) {
                r= m;
            }else {
                --r;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,7,0,0,1,2};
        int min = findMin(nums);
        System.out.println(min);

//        System.out.println((0+11)>>>1);
    }

}
