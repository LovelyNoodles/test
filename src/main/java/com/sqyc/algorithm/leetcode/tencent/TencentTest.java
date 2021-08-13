package com.sqyc.algorithm.leetcode.tencent;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TencentTest {

    /**
     * 两数之和
     * <p>
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * <p>
     * 你可以按任意顺序返回答案。
     * <p>
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/tencent/xxqfy5/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    @Test
    public void test1() {
//        int[] nums = {2, 7, 11, 15};
//        int target = 9;
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] ints1 = twoSum1(nums, target);
        int[] ints2 = twoSum2(nums, target);
        System.out.println(Arrays.toString(ints1));
        System.out.println(Arrays.toString(ints2));
    }

    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int b = target - a;
            int indexB = ArrayUtils.indexOf(nums, b);
            if (indexB != i && indexB >= 0) {
                return new int[]{i, indexB};
            }
        }
        return new int[]{-1, -1};
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (m.get(target - nums[i]) != null) {
                return new int[]{m.get(target - nums[i]), i};
            }
            m.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }


    /**
     * 寻找两个正序数组的中位数
     * <p>
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
     * <p>
     * 示例 1：
     * 输入：nums1 = [1,3], nums2 = [2]
     * 输出：2.00000
     * 解释：合并数组 = [1,2,3] ，中位数 2
     * <p>
     * 示例 2：
     * 输入：nums1 = [1,2], nums2 = [3,4]
     * 输出：2.50000
     * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     * <p>
     * 示例 3：
     * 输入：nums1 = [0,0], nums2 = [0,0]
     * 输出：0.00000
     * <p>
     * 示例 4：
     * 输入：nums1 = [], nums2 = [1]
     * 输出：1.00000
     * <p>
     * 示例 5：
     * 输入：nums1 = [2], nums2 = []
     * 输出：2.00000
     * <p>
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/tencent/xx6c46/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    @Test
    public void test2() {
        int[] nums1 = {3};
        int[] nums2 = {};
//        int[] nums1 = {1, 2, 4};
//        int[] nums2 = {3};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    private double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        if (length1 == 0 && length2 == 0) {
            return 0.0;
        }
        int length = length1 + length2;

        int temp = length / 2 + 1;
        Integer tl = null, th = null;
        int i = 0, j = 0, k = 0;
        while (k < temp) {
            tl = th;
            if (i == nums1.length) {
                th = nums2[j++];
            } else if (j == nums2.length) {
                th = nums1[i++];
            } else {
                int ni = nums1[i];
                int nj = nums2[j];
                if (ni < nj) {
                    th = ni;
                    i++;
                } else {
                    th = nj;
                    j++;
                }
            }
            k++;
        }

        return (length & 1) == 1 ? th : (tl + th) / 2.0;
    }


    /**
     * 最长回文子串
     * <p>
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * <p>
     * 示例 1：
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     * <p>
     * 示例 2：
     * 输入：s = "cbbd"
     * 输出："bb"
     * <p>
     * 示例 3：
     * 输入：s = "a"
     * 输出："a"
     * <p>
     * 示例 4：
     * 输入：s = "ac"
     * 输出："a"
     * <p>
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/tencent/xxk4s2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    @Test
    public void test3() {
        System.out.println(longestPalindrome1("babad"));
        System.out.println(longestPalindrome2("babad"));
        System.out.println(longestPalindrome3("babad"));
        System.out.println(longestPalindrome4("babad"));
    }

    /**
     * 动态规划算法：一种算法思想，可系统学习
     */
    private String longestPalindrome4(String s) {
        if (s == null || s.length() < 2)
            return s;

        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        int maxLen = 1;
        String longest = null;
        for (int pl = 0; pl < len; pl++) {
            for (int i = 0; i < len - pl; i++) {
                int j = i + pl;
                if (s.charAt(i) == s.charAt(j) && (pl <= 2 || dp[i + 1][j - 1])) {// 头尾相等且(子串长度<=3[头尾相等且长度<=3的一定是回文子串] 或 子串内部的子子串也是回文子串)
                    dp[i][j] = true;

                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        longest = s.substring(i, j + 1);
                    }
                }
            }
        }
        System.out.println(JSON.toJSONString(dp));

        return longest;
    }

    /**
     *Manacher 算法（“马拉车”算法）：它专门用于解决“最长回文子串”问题，时间复杂度为O(N)。
     */
    private boolean longestPalindrome3(String babad) {
        return false;
    }

    /**
     * 中心扩散法：按规则判断内容是否符合，扩散到直到所有都符合为止
     * <p>
     * 时间复杂度：O(N^2)
     * <p>
     * 空间复杂度：O(1)
     */
    private String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        String res = s.substring(0, 1);
        // 中心位置枚举到 len - 2 即可
        for (int i = 0; i < len - 1; i++) {
            String oddStr = centerSpread(s, i, i);
            String evenStr = centerSpread(s, i, i + 1);
            String maxLenStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
            if (maxLenStr.length() > maxLen) {
                maxLen = maxLenStr.length();
                res = maxLenStr;
            }
        }
        return res;
    }

    private String centerSpread(String s, int left, int right) {
        // left = right 的时候，此时回文中心是一个字符，回文串的长度是奇数
        // right = left + 1 的时候，此时回文中心是一个空隙，回文串的长度是偶数
        int len = s.length();
        int i = left;
        int j = right;
        while (i >= 0 && j < len) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        // 这里要小心，跳出 while 循环时，恰好满足 s.charAt(i) != s.charAt(j)，因此不能取 i，不能取 j
        return s.substring(i + 1, j);
    }

    /**
     * 暴力匹配：循环找出目标值，判断是否符合规则
     * <p>
     * 时间复杂度：O(N^3)
     * <p>
     * 空间复杂度：O(1)
     */
    private String longestPalindrome1(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        String res = s.substring(0, 1);

        // 枚举所有长度大于等于 2 的子串
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLen && valid(s, i, j)) {
                    maxLen = j - i + 1;
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    private boolean valid(String s, int left, int right) {
        // 验证子串 s[left, right] 是否为回文串
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
