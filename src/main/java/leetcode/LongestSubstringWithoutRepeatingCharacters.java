package leetcode;

/**
 * 반복되지 않는 최대 문자열의 길이 구하기
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        return solution1(s);
    }

    private int solution1(String s) {
        String str = "";
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {

            if(str.contains(s.charAt(i)+"")){
                maxLength = Math.max(str.length(), maxLength);
                str =  str.substring(str.indexOf(s.charAt(i))+1) + s.charAt(i);
            }else{
                str += s.charAt(i);
            }
        }
        return Math.max(str.length(), maxLength);
    }


}
