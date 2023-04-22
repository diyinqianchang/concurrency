package algo;

import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author Administrator
 * @Date 2022/2/27 12:45
 * @Version 1.0
 */
public class LongestSub {

    private static int lengthOfLongestSubstring(String s) {
        int res = 0;
        Map<Character, Integer> chars = new HashMap<>();
        for (int i = 0, j = 0; j < s.length(); ++j) {
            char c = s.charAt(j);
            if (chars.containsKey(c)) {
                i = Math.max(i, chars.get(c) + 1);
            }
            chars.put(c, j);
            res = Math.max(res, j - i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
//        int abc = lengthOfLongestSubstring("tmmzuxt");
//        System.out.println(abc);
//        List<Integer> ll = new ArrayList<>();
//        Collections.
        String s1 = new StringBuilder("go").append("od").toString();
        System.out.println(s1.intern() == s1);
    }
}
