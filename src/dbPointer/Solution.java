package dbPointer;

import java.util.*;

public class Solution {
    public static final HashSet<List<Integer>>  set = new HashSet<>();

    /**
     * 给定一个已按照 升序排列 的整数数组numbers ，请你从数组中找出两个数满足相加之和等于目标数target 。
     *
     * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 0开始计数 ，所以答案数组应当满足 0<= answer[0] < answer[1] <numbers.length。
     *
     * 假设数组中存在且只存在一对符合条件的数字，同时一个数字不能使用两次
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/kLl5u1
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int[] res = new int[2];
        for (int i=0; i<numbers.length; i++) {
            int num = numbers[i];
            int other = target - num;
            if (map.get(other) != null) {
                res[0] = map.get(other);
                res[1] = i;
                break;
            }

            map.put(num, i);
        }

        return res;
    }

    /**
     * 只有答案是唯一的才可以这样 ?
     */
    public int[] twoSumDbPt(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                res[0] = left;
                res[1] = right;
                break;
            }else if(sum < target)  {
                left ++;
            }else right --;
        }

        return res;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) return res;

        Arrays.sort(nums);

        HashSet<List<Integer>>  set =new HashSet<>() ;
        int n =  nums.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];

            int left = i+1;
            int right = n-1;
            while (left < right) {
                // 需要和上一次枚举的数不相同
                int sum = nums[left] + nums[right];

                if (sum == target){
                    set.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum < target) {
                    left ++;
                }else {
                    right --;
                }

            }
        }

        return res;
    }

    /**
     * 时间复杂度 n*m
     * 空间复杂度  n
     */
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        Map<Character, Integer> s1Map = getStringCount(s1);
        for (int i = 0; i <=m - n; i++) {
            String item = s2;
            if (m != n) {
               item = s2.substring(i, i + n);
            }

            System.out.println(item);
            Map<Character, Integer> itemMap = getStringCount(item);
            boolean flag = true;
            for (Character key : s1Map.keySet()) {
                if (!Objects.equals(s1Map.get(key), itemMap.get(key))) flag = false;
            }
            if (flag) return true;
        }

        return false;
    }

    public Map<Character, Integer> getStringCount(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char key = str.charAt(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        return map;
    }

    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() -1;
        for (; start < s.length() / 2; start++, end--) {
            if (s.charAt(start) != s.charAt(end)) break;
        }

        return start == s.length() / 2 || isPalindrome(s, start, end - 1) || isPalindrome(s, start + 1, end);
    }

    public boolean isPalindrome(String s, int start, int end) {

        while (start < end) {
            System.out.println("start: " + start + " end: " + end);
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        System.out.println("isPalindrome");

        return true;
    }

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (nums.length <=1) return nums.length;
        int pre = 0;
        int cur = pre + 1 ;
        int cnt = 0;
        while (cur < nums.length) {
            if (nums[pre] == nums[cur]) {
//                nums[cur] = nums[cur + 1];
                cur++;
                cnt++;
            }else {
                nums[cur - cnt] = nums[cur];
                pre = cur;
                cur ++;
            }
        }
        int k = n-cnt;
        nums = Arrays.copyOfRange(nums, 0, k);
        System.out.println(Arrays.toString(nums));
        return k;
    }

    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        if (nums.length <=1) return nums.length;
        int pre = 0;
        int cur = 0;
        int cnt = 0;
        while (cur < nums.length) {
            if (nums[cur] == val) {
                cur++;
                cnt++;
            }else {
                nums[cur - cnt] = nums[cur];
                cur ++;
            }
        }
        int k = n-cnt;
        nums = Arrays.copyOfRange(nums, 0, k);
        System.out.println(Arrays.toString(nums));
        return k;
    }

    /**
     * 超过时间限制
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int n = height.length - 1;
        for (int i = n; i > 0; i--) {
            int l = 0, r = i;
            while (r <= n) {
//                System.out.println("l: " + l + " r: " + r);
                int area = i * Math.min(height[l], height[r]);
                maxArea = Math.max(maxArea, area);
                l++;
                r++;
            }
        }

        return maxArea;
    }

    /**
     * i * （l,r)
     * 双指针
     * 开始在头尾
     * 移动数较小那边的指针 保证y比较大
     * @param height
     * @return
     */
    public int maxAreaNew(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int r = height.length - 1, l = 0;

        while (l <= r) {
            int len = r-l;
            int area = len * Math.min(height[l], height[r]);
            maxArea = Math.max(maxArea, area);

            if (height[l] < height[r]) l++;
            else r--;
        }


        return maxArea;
    }
}
