package algo;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author Administrator
 * @Date 2022/3/1 0:11
 * @Version 1.0
 */
public class BackTrack {

    List<List<Integer>> res = new LinkedList<>();

    List<List<Integer>> permute(int[] nums){
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums,track);
        return res;
    }

    void backtrack(int[] nums,LinkedList<Integer> track){

        if (track.size() == nums.length){
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])){
                continue;
            }
            track.add(nums[i]);
            backtrack(nums,track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        BackTrack backTrack = new BackTrack();
        List<List<Integer>> permute = backTrack.permute(nums);
        System.out.println(permute);

    }
}
