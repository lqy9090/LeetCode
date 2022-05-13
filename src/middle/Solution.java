package middle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    //统计各位数字都不同的数字个数
    //解法一：超出时间限制，n>8时
    public int countNumbersWithUniqueDigits(int n) {

        int end = 1;
        for (int i = 0; i < n; i++) {
            end *= 10;
        }
        System.out.println("end: " + end);

        int res = 0;
        for (int i = 0; i < end; i++) {
            if (ifUniqueDigits(i)) {
                System.out.println(i);
                res++;
            }
        }

        return res;
    }

    public boolean ifUniqueDigits(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        while (n > 0) {
            int num = n % 10;
            if (list.contains(num)) return true;
            list.add(num);
            n = n / 10;
        }

        return false;
    }

    /*解法二： 排列组合
     *第一位可以从1~9里面选，后面几位是选择0~9里并且排除已选第一位的排列 即 A(9,n-1)，结果是当前n位数与小于n位数的和
     *边界条件：当n=0时，结果为1，n=10时，结果为10，个位数的各个位数都不相同
     */
    public int countNumbersWithUniqueDigists2(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;

        int res = 10, cur = 9;
        for (int i = 0; i < n - 1; i++) {
            cur *= 9 - i;
            System.out.println(cur);
            res += cur;
        }
        return res;
    }

    public int uniqueMorseRepresentations(String[] words) {
        //字典
        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

//		HashMap<Character, String> map = new HashMap<>();
//        for(int i=0; i<26; i++) {
//        	map.put((char) ('a'+i), morse[i]);
//        }

        //翻译
        HashSet<String> set = new HashSet<>();
        for (String word : words) {

            String translateString = "";
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int index = (ch - 'a') % 26;
                String dict = morse[index];
//        		String string = map.get(ch);
                translateString += dict;
            }
            System.out.println("morse: " + translateString);
            set.add(translateString);
        }

//        for(String str:set) {
//        	System.out.println(str);
//        }


        return set.size();
    }

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return null;

        Queue<Node> queue = new LinkedList();
        queue.add(root);
        List<List<Integer>> resList = new ArrayList<>();
        while (!queue.isEmpty()) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            System.out.println("queue size: " + queue.size());
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node node = queue.poll();
                arrayList.add(node.val);

                List<Node> children = node.children;
                if (children == null) continue;
                for (Node nodeTemp : children) {
                    queue.add(nodeTemp);
                }
            }
            System.out.println(arrayList.toString());
            resList.add(arrayList);
        }

        return resList;
    }

    public NestedInteger deserialize(String s) {
        if (s.matches("[0-9]+")) {
            int value = Integer.parseInt(s);
            NestedIntegerImpl nestedInteger = new NestedIntegerImpl(value);
            return nestedInteger;
        }

//        int firstEnd = s.indexOf(']');
//        int interval = 1;
//        for (int i = firstEnd; i >= 0; i -= interval) {
//
//        }


        int n = s.length();
        int interval = 1;
        for (int i=0; i<n; i+=1){
            if (s.charAt(i) == '[') {
                NestedIntegerImpl nestedInteger = new NestedIntegerImpl();
            }
        }

        return null;
    }

}
