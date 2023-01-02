package leetcode;

/*피보나치  수열*/
public class ClimbingStairs {

    public int climbStairs(int n) {
       if(n<=1) {
           return 1;
       }
       return climbStairs(n-2) + climbStairs(n-1);
    }

}
