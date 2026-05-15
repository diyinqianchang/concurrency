package com.abc.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author Administrator
 * @Date 2026/5/10 20:06
 * @Version 1.0
 */
public class Greedy {


    class Item{
        int w;
        int v;
        public Item(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }


    /**
     * 找零问题
     * @param coins  排好序的硬币 从小到大
     * @param amount
     * @return
     */
    static int coinChangeGreedy(int[] coins, int amount) {
        int i = coins.length - 1;
        int count = 0;
        while (amount > 0){
            while (i>0 && coins[i] > amount){
                i--;
            }
            amount -= coins[i];
            count++;
        }
        return amount == 0 ? count : -1;
    }


    double fractionalKnapsack(int[] wgt,int[] val, int capacity){
        double res = 0;
        Item[] items = new Item[wgt.length];
        for (int i = 0; i < wgt.length; i++) {
            items[i] = new Item(wgt[i],val[i]);
        }
        Arrays.sort(items, Comparator.comparingDouble(o ->(double)o.v/o.w));
        for (int i = 0; i < items.length; i++) {
            if (capacity >= items[i].w){
                res += items[i].v;
                capacity -= items[i].w;
            }else {
                res += items[i].v * ((double) capacity / items[i].w);
                break;
            }
        }

        return res;
    }

    int maxCapacity(int[] ht){
        int i = 0,j = ht.length - 1;
        int res = 0;
        while (i < j){
            int cap = Math.min(ht[i],ht[j]) * (j-i);
            res = Math.max(res,cap);
            if (ht[i] < ht[j]){
                i++;
            }else {
                j--;
            }
        }
        return res;
    }


    public static void main(String[] args) {

//        int[] coins = {1,2,5};
//        System.out.println(coinChangeGreedy(coins,11));

        int[] wgt = {20,40,10,30,50};
        int[] val = {120,210,50,150,240};
        Greedy greedy = new Greedy();
        double v = greedy.fractionalKnapsack(wgt, val, 50);
        System.out.println(v);


    }

}
