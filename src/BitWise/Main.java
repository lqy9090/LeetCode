package BitWise;

import java.util.List;

public class Main {
    public void singleNumberTest(){
        Solution solution = new Solution();
        int[] nums = {2, 2, 3, 2};
        int i = solution.singleNumber(nums);
        System.out.println(i);
    }

    public void maxProductTest() {
        Solution solution = new Solution();
        String[] words = {"abcw","baz","foo","bar","fxyz","abcdef"};
        int maxProduct = solution.maxProductNew(words);
        System.out.println(maxProduct);
    }

    public void findRepeatedDnaSequencesTest() {
        Solution solution = new Solution();
        List<String> sequences = solution.findRepeatedDnaSequencesBitWise("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        System.out.println(sequences);
    }

    public void maxProduct318Test() {
        Solution solution = new Solution();
        String[] words = {"aa","abb","abc","d","cd","bcd","abcd"};
        int res = solution.maxProduct318(words);
        System.out.println(res);
    }

    public static void main(String[] args) {
//        System.out.println('a'^'a');
        Main main = new Main();
//        main.maxProductTest();
//        main.findRepeatedDnaSequencesTest();
        main.maxProduct318Test();
    }
}
