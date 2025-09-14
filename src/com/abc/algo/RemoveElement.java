package com.abc.algo;

import java.util.Arrays;

/**
 * @Author Administrator
 * @Date 2022/2/20 11:13
 * @Version 1.0
 */
public class RemoveElement {

    private static int removeElement(int[] nums,int val){
        int cnt=0,n=nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i]==val){
                ++cnt;
            }else {
                nums[i-cnt] = nums[i];
            }
            System.out.println(cnt);
        }
        return n-cnt;
    }

    private static int removeElement2(int[] nums,int val){
        if (nums.length==0){
            return 0;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length){
            if (nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;

    }

    public void reverseString(char[] s) {
        if (s.length==0){
            return;
        }
        int left = 0, right = s.length-1;
        while (left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }


    public static boolean validPalindrome(String s) {
        int left = 0, right = s.length()-1;
        int delete = 0;
        while (left < right){
            System.out.println(s.charAt(left)+"-->"+s.charAt(right));
            if (s.charAt(left) != s.charAt(right)){
                if (delete == 1){
                    left--;
                    right--;
                    delete++;
                    continue;
                }else if (delete == 2){
                    return false;
                }else{
                    delete++;
                    left++;
                    continue;
                }
            }
            left++;
            right--;

        }
        return true;
    }

    public static boolean isPalindrome2(String s) {
        int left = 0, right = s.length()-1;
        while (left < right){
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (!Character.isLetterOrDigit(leftChar)){
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(rightChar)){
                right--;
                continue;
            }
            if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public String longestPalindrome(String s) {

        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = palindrome(s,i,i);
            String s2 = palindrome(s,i,i+1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    private String palindrome(String s,int left,int right){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }

    public static void main(String[] args) {
//        int[] nums = {2,0,1,2,2,3,0,4,2};
//        int search = removeElement2(nums,2);
////        System.out.println(search);
//        System.out.println(Arrays.toString(nums));
        System.out.println(isPalindrome2("A man, a plan, a canal: Panama"));

    }

}
