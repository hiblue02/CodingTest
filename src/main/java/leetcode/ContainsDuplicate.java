package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 배열 요소에 중복이 있으면 true, 없으면 false
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> bowl = new HashSet<>();

        for (int num : nums) {
            if(!bowl.add(num)){
                return true;
            }
        }
        return false;
    }
}
