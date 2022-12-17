package leetcode;

public class SumOfTwoIntegers {

    private final String ONE = "1";
    private final String ZERO = "0";

    public int getSum(int a, int b) {

        String binaryA = getBinaryReverse(a);
        String binaryB = getBinaryReverse(b);

        String longer = getLonger(binaryA, binaryB);
        String shorter = getShorter(binaryA, binaryB);
        String sum = "";

        int index = 0;
        String carry = ZERO;

        while (true) {

            if (carry.equals(ZERO) && index >= longer.length()) {
                break;
            }

            String longerDigit = getDigit(longer, index);
            String shorterDigit = getDigit(shorter, index);

            sum += calculateDigit(longerDigit, shorterDigit, carry);
            carry = calculateCarry(longerDigit, shorterDigit, carry);

            index++;
        }

        String sumReversed = reverseString(sum);
        return Integer.parseInt(sumReversed, 2);
    }

    private String calculateCarry(String a, String b, String c) {
        if (a.equals(ONE) && b.equals(ONE)) {
            return ONE;
        }
        if ((a.equals(ONE) || b.equals(ONE)) && c.equals(ONE)) {
            return ONE;
        }
        return ZERO;
    }

    private String calculateDigit(String longerDigit, String shorterDigit, String carry) {
        return calculateBinaryDigit(calculateBinaryDigit(longerDigit, shorterDigit), carry);

    }

    private String calculateBinaryDigit(String a, String b) {
        if (a.equals(ZERO) && b.equals(ZERO)) {
            return ZERO;
        }
        if (a.equals(ONE) && b.equals(ONE)) {
            return ZERO;
        }
        return ONE;
    }

    private String getDigit(String binary, int index) {
        if (index >= binary.length()) {
            return ZERO;
        }
        return String.valueOf(binary.charAt(index));
    }

    private String getLonger(String binaryA, String binaryB) {
        if (binaryA.length() > binaryB.length()) {
            return binaryA;
        }
        return binaryB;
    }

    private String getShorter(String binaryA, String binaryB) {
        if (binaryA.length() <= binaryB.length()) {
            return binaryA;
        }
        return binaryB;
    }

    private static String getBinaryReverse(int a) {
        String s = Integer.toBinaryString(a);
        return reverseString(s);
    }

    private static String reverseString(String s) {
        StringBuffer sb = new StringBuffer(s);
        return sb.reverse().toString();
    }

}
