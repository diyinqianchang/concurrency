package com.abc.algo.array;

import java.util.Arrays;

/**
 * @Author Administrator
 * @Date 2025/9/10 21:19
 * @Version 1.0
 */
public class Difference {

    private int[] diff;
    public Difference(int[] nums){
        assert nums.length > 0;
        diff = new int[nums.length];
        diff[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            diff[i] = nums[i] - nums[i-1];
        }
    }

    public void increment(int i, int j, int val){
        diff[i] += val;
        if(j + 1 < diff.length){
            diff[j+1] -= val;
        }
    }

    public int[] result(){
        int[] res = new int[diff.length];
        res[0] = diff[0];
        for(int i = 1; i < diff.length; i++){
            res[i] = res[i-1] + diff[i];
        }
        return res;
    }

    public int[] result2(){
        return diff;
    }



    public int[] corpFlightBookings(int[][] bookings, int n) {

        int[] res = new int[n];
        for (int[] booking : bookings) {
            int i = booking[0];
            int j = booking[1];
            int k = booking[2];
            res[i-1] += k;
            if(j < n){
                res[j] -= k;
            }
        }
        System.out.println(Arrays.toString(res));

        for(int i = 1; i < res.length; i++){
            res[i] += res[i-1];
        }

//        int[] res1 = new int[res.length];
//        res1[0] = res[0];
//        for(int i = 1; i < res.length; i++){
//            res1[i] = res1[i-1] + res[i];
//        }
        return res;
    }

    public boolean carPooling(int[][] trips, int capacity) {

        int[] res = new int[10];
        for (int[] trip : trips) {
            int i = trip[1];
            int j = trip[2];
            int k = trip[0];
            res[i] += k;
            res[j] -= k;
//            if(j < 10){
//                res[j] -= k;
//            }
        }
        if (res[0] > capacity){
            return false;
        }
        for(int i = 1; i < res.length; i++){
            res[i] += res[i-1];
            if (res[i] > capacity){
                return false;
            }
        }
        System.out.println(Arrays.toString(res));
        return true;
    }


    public static void main(String[] args) {
        Difference difference = new Difference(new int[]{1,2,3,4,5});
        System.out.println(Arrays.toString(difference.result2()));
        difference.increment(1, 3, 2);
        System.out.println(Arrays.toString(difference.result2()));
//        System.out.println(Arrays.toString(difference.result()));
//
        System.out.println(Arrays.toString(difference.corpFlightBookings(new int[][]{{1,2,10},{2,3,20},{2,5,25}}, 5)));
//        System.out.println(difference.carPooling(new int[][]{{2,1,5},{3,3,7}}, 4));
//        System.out.println(difference.carPooling(new int[][]{{2,1,5},{3,3,7}}, 5));
//        System.out.println(difference.carPooling(new int[][]{{9,0,1},{3,3,7}}, 4));
    }

}
