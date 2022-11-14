package array;

import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> keys = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(keys.containsKey(nums[i])){
                return new int[] {keys.get(nums[i]), i};
            }
            keys.put(target-nums[i], i);
        }
        return new int[]{};
    }
}
