package algo;

import java.util.Arrays;

/**
 * @Author Administrator
 * @Date 2022/2/19 20:35
 * @Version 1.0
 */
public class MergeSort {
    private static void merge(int[] nums,int low,int mid,int high, int[] temp){
         int i = low,j=mid+1,k=low;
         while (k<=high){
             if (i>mid){
                 temp[k++] = nums[j++];
             }else if(j>high){
                 temp[k++] = nums[i++];
             }else if (nums[i]<=nums[j]){
                 temp[k++] = nums[i++];
             }else {
                 temp[k++] = nums[j++];
             }
         }
         System.arraycopy(temp,low,nums,low,high-low+1);
    }
    private static void mergeSort(int[] nums,int low,int high,int[] temp){
        if (low >= high){
            return;
        }
        int mid = (low+high) >>> 1;
        System.out.println("mid-->"+mid);
        mergeSort(nums,low,mid,temp);
        System.out.println("low-->"+low + " mid-->"+mid);
        mergeSort(nums,mid+1,high,temp);
        merge(nums,low,mid,high,temp);
    }
    private static void mergeSort(int[] nums){
        int n = nums.length;
        int[] temp = new int[n];
        mergeSort(nums,0,n-1,temp);
    }
    public static void main(String[] args) {
//        int[] nums = {1, 2, 7, 4, 5, 3,8};
//        mergeSort(nums);
//        System.out.println(Arrays.toString(nums));


        int[] nums = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums,3,nums2,nums2.length);
        System.out.println(Arrays.toString(nums));
    }



    private static void merge(int[] nums1,int m,int[] nums2,int n){
        int i = m-1, j = n-1;
        int k = m+n-1;
        while (j>=0){
            if (i>=0 && nums1[i]>=nums2[j]){
                nums1[k--] = nums1[i--];
            }else{
                nums1[k--] = nums2[j--];
            }
            System.out.println(Arrays.toString(nums1));
        }
    }

}
