package com.abc.algo.tu;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Author Administrator
 * @Date 2026/5/9 9:40
 * @Version 1.0
 */
public class OpenLock {

    public static void main(String[] args) {
        System.out.println(openLock(new String[]{"0201","0101","0102","1212","2002"},"0202"));

    }

    static int openLock(String[] deadends, String target) {

        Set<String> deads = new HashSet();
        for (String deadend : deadends) {
            deads.add(deadend);
        }
        Set<String> visited = new HashSet();
        Queue<String> q = new LinkedList();
        int step = 0;
        q.offer("0000");
        visited.add("0000");
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (deads.contains(cur)){
                    continue;
                }
                if (cur.equals(target)){
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur,j);
                    if (!visited.contains(up)){
                        q.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur,j);
                    if (!visited.contains(down)){
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;

    }

    /**
     * 模拟加一
     * @param cur
     * @param j
     * @return
     */
    private static String plusOne(String cur, int j) {
        char[] chars = cur.toCharArray();
        if (chars[j] == '9'){
            chars[j] = '0';
        } else {
            chars[j]++;
        }
        return new String(chars);
    }

    /**
     * 模拟减一
     * @param cur
     * @param j
     * @return
     */
    private static String minusOne(String cur, int j) {
        char[] chars = cur.toCharArray();
        if (chars[j] == '0'){
            chars[j] = '9';
        } else {
            chars[j]--;
        }
        return new String(chars);
    }


}
