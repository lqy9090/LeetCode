package BitWise;

import java.util.*;

import static javax.swing.UIManager.put;

public class Solution {

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int total = 0;
            System.out.println("i: " + i);
            for (int num : nums) {
                int iBinary = ((num >> i) & 1);
                total += iBinary;
                System.out.println("ibinary: " + iBinary + " total: " + iBinary);

            }
            if (total % 3 != 0) {
                ans |= (1 << i);
                System.out.println("ans: " + ans);
            }
        }
        return ans;
    }

    /**
     * 时间复杂度 超 n^2
     *
     * @param words
     * @return
     */
    public int maxProduct(String[] words) {
        int n = words.length;
        int maxProduct = 0;
        for (int i = 0; i < n; i++) {
            String wordBase = words[i];
            for (int j = i + 1; j < n; j++) {
                String otherWord = words[j];
                int m = Math.min(wordBase.length(), otherWord.length());
                int flag = 0;
                for (int k = 0; k < m; k++) {
                    String c = wordBase.length() < otherWord.length() ? String.valueOf(wordBase.charAt(k)) : String.valueOf(otherWord.charAt(k));
                    String word = wordBase.length() < otherWord.length() ? otherWord : wordBase;
                    if (word.contains(c)) {
                        flag = 1;
                        break;
                    }
                }

                if (flag == 0) maxProduct = Math.max(maxProduct, wordBase.length() * otherWord.length());
//                System.out.println(" i: "+i+" j: "+j+ " maxProduct: "+maxProduct);
            }
        }

        return maxProduct;
    }

    public int maxProductNew(String[] words) {
        int n = words.length;
        int[] masks = new int[n];
        for (int i = 0; i < n; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                masks[i] |= 1 << (word.charAt(j) - 'a');
//                System.out.println((word.charAt(j) - 'a') + " masks: " + masks[i]);
            }
        }

        int maxProduct = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((masks[i] & masks[j]) == 0)
                    maxProduct = Math.max(maxProduct, words[i].length() * words[j].length());
            }
        }

        return maxProduct;
    }

    public int[] singleNumber2(int[] nums) {

        return null;
    }

    public List<String> findRepeatedDnaSequences(String s) {
        System.out.println("length of s " + s.length());
//        if (s.length() == 10) return new ArrayList<>(){{add(s);}};
        if (s.length() < 10) return new ArrayList<>();
        HashSet<String> set = new HashSet<>() {
        };

        String window = s.substring(0, 10);
        set.add(window);
        Set<String> list = new HashSet<>();
        int i = 1;
        while (i < s.length() - 9) {
            System.out.println("i: " + i + " i+9 " + (i + 9));
            window = s.substring(i, i + 10);
            System.out.println(window);
            if (set.contains(window)) list.add(window);
            set.add(window);
            i++;
        }
        System.out.println("set: " + Arrays.toString(set.toArray()));
        return list.stream().toList();
    }

    static final int L = 10;
   Map<Character, Integer> map =  new HashMap<Character, Integer> () {{
       put('A', 0);
       put('C', 1);
       put('G', 2);
       put('T', 3);}
   };

    public List<String> findRepeatedDnaSequencesBitWise(String s) {
        List<String> ans = new ArrayList<>();
        int n = s.length();
        if (n < L) {
            return ans;
        }

        int x = 0;
        //x代表当前滑动窗口对应的整数第一个滑动窗口
        for (int i = 0; i < L - 1; i++) {
            x = (x << 2) | map.get(s.charAt(i));
//            System.out.println(" x: " + x + " binary: " + Integer.toBinaryString(x));
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n - L; i++) {
            x = ((x << 2) | map.get(s.charAt(i + L -1))) & ((1 << (L * 2)) -1);
            System.out.println(" x: " + x + " binary: " + Integer.toBinaryString(x));
            if(set.contains(x)) ans.add(s.substring(i, i + L));
            set.add(x);
        }

        return ans;
    }

    public int maxProduct318(String[] words) {
        int n = words.length;
        int[] mask = new int[n];

        for (int i = 0; i < n; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                System.out.println(word.charAt(j));
                mask[i] |= 1 << (word.charAt(j) - 'a');
                System.out.println("i: " + i + " j: " + j + " int: " + mask[i] + " binary: " + Integer.toBinaryString(mask[i]));
            }
        }

        int maxProduct = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++)
                    if ((mask[i] & mask[j]) == 0)
                        maxProduct = Math.max(maxProduct, words[i].length() * words[j].length());

        }

        return maxProduct;
    }

}
