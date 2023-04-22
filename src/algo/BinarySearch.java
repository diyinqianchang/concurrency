package algo;

/**
 * @Author Administrator
 * @Date 2022/2/19 23:11
 * @Version 1.0
 */
public class BinarySearch {

    private static int search(int[] nums,int low,int high,int val){

        while (low<=high){
            int mid = (low+high)>>>1;
            if (nums[mid]==val){
                return mid;
            }else if (nums[mid]<val){
                low = mid+1;
            }else {
                high=mid-1;
            }
        }
        return -1;
    }

    // 查找第一个值等于给定值的元素
    private static int search1(int[] nums,int low,int high,int val){

        while (low<=high){
            int mid = (low+high)>>>1;
            if (nums[mid] > val){
                high=mid-1;
            }else if (nums[mid]<val){
                low = mid+1;
            }else {
                if (mid==0 || nums[mid-1]!=val){
                    return mid;
                }
               high = mid-1;
            }
        }
        return -1;
    }


    private static int search(int[] nums,int val){
        return search1(nums,0,nums.length-1,val);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 7,8, 8, 9};
        int search = search(nums, 8);
        System.out.println(search);
    }

}
