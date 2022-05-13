package dbPointer;

import java.util.List;

public class Main {
    public void twoSumTest() {
        Solution solution = new Solution();
        int[] numbers = {0};
        int target = 8;
        int[] ints = solution.twoSumDbPt(numbers, target);

        for (int num:ints)
         System.out.println(num);
    }

    public void threeNumTest(){
        Solution solution = new Solution();
        int[] nums = {0,0,0};
        List<List<Integer>> lists = solution.threeSum(nums);
        System.out.println(lists);
    }

    public void checkInclusionTest() {
        Solution solution = new Solution();
        //没通过的案例1 "adc" "dcda"  <= n-m
        //没通过案例2 "abcdxabcde"  "abcdeabcdx" 字符数不一定符合长度
        String s1 = "abcdxabcde";
        String s2 = "abcdeabcdx";
        boolean b = solution.checkInclusion(s1, s2);
        System.out.println(b);
    }

    public void validPalindrome() {
        Solution solution = new Solution();
        String s = "aca";
        boolean b = solution.validPalindrome(s);
        System.out.println(b);
    }

    public void remoteDuplicateTest() {
        Solution solution = new Solution();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int k = solution.removeDuplicates(nums);
        System.out.println(k);
    }

    public void removeElementTest() {
        Solution solution = new Solution();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int k = solution.removeElement(nums, 1);
        System.out.println(k);
    }

    public static void main(String[] args) {
        Main main = new Main();
//        main.twoSumTest();
//        main.threeNumTest();
//        main.checkInclusionTest();
//        main.validPalindrome();
//        main.remoteDuplicateTest();
        main.removeElementTest();
    }
}
