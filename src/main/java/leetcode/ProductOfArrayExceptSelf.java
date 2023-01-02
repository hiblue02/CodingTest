package leetcode;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 * 배열에서 자신을 제외한 나머지를 모두 곱한 값을 새로운 배열로 출력, 나누기 사용 금지s
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {

        int[] answers = new int[nums.length];
        int[] prefixes = new int[nums.length];
        int[] suffixes = new int[nums.length];

        prefixes[0] = 1;
        suffixes[nums.length-1] = 1;

        for (int i = 0; i < nums.length-1; i++) {
            prefixes[i+1] = prefixes[i]*nums[i];
        }
        for (int i = nums.length-1; i > 0 ; i--) {
            suffixes[i-1] = suffixes[i]*nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            answers[i] = prefixes[i]*suffixes[i];
        }

        return answers;
    }
}
