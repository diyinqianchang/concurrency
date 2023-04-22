package algo;

/**
 * @Author Administrator
 * @Date 2022/2/27 13:09
 * @Version 1.0
 */
public class Construct {

    private static boolean canConstruct(String ransomNote,String magazine){

        int[] chars = new int[26];
        for (int i = 0, n = magazine.length(); i < n; ++i) {
            int idx = magazine.charAt(i) - 'a';
            ++chars[idx];
        }
        for (int i = 0, n = ransomNote.length(); i < n; ++i) {
            int idx = ransomNote.charAt(i) - 'a';
            if (chars[idx] == 0)return false;
            --chars[idx];
        }
        return true;
    }

    public static void main(String[] args) {
        boolean b = canConstruct("aac", "aabc");
        System.out.println(b);
    }
}
