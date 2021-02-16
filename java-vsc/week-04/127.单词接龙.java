import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 *
 * https://leetcode-cn.com/problems/word-ladder/description/
 *
 * algorithms
 * Medium (41.06%)
 * Likes:    304
 * Dislikes: 0
 * Total Accepted:    38.5K
 * Total Submissions: 92.5K
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord
 * 的最短转换序列的长度。转换需遵循如下规则：
 * 
 * 
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 
 * 
 * 说明:
 * 
 * 
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * 输出: 5
 * 
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * ⁠    返回它的长度 5。
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * 输出: 0
 * 
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 * 
 */

// @lc code=start
class Solution {
    int len = 0;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.length() != endWord.length()) {
            return 0;
        }
        len = beginWord.length();
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int []letter = new int[26];
        for (int i = 0; i < 26; i++) {
            letter[i] = 'a' + i;
        }
        return bfs(beginWord, endWord, wordSet, visited, letter);
    }

    public int bfs(String beginWord, String endWord, Set<String> wordSet, 
        Set<String> visited, int[] letter) {
        
        LinkedList<String> queue = new LinkedList<>();
        int level = 1;
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                String curStr = queue.poll();
                char []sArr = curStr.toCharArray();
                for (int j = 0; j < len; j++) {
                    char c = sArr[j];
                    for (int k = 0; k < letter.length; k++) {
                        if (c == (char)letter[k]) {
                            continue;
                        }
                        sArr[j] = (char)letter[k];
                        String newStr = new String(sArr);
                        if (wordSet.contains(newStr) && !visited.contains(newStr)) {
                            if (endWord.equals(newStr)) {
                                return level;
                            } 
                            visited.add(newStr);
                            queue.add(newStr);
                        }
                    }
                    sArr[j] = c;
                }
            }
        }
        return 0;
    }

}
// @lc code=end


// 部分测试例子超时
class Solution {
    int min = Integer.MAX_VALUE;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.length() != endWord.length()) {
            return 0;
        }
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        dfs(beginWord, endWord, wordSet, 1, visited);
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public void dfs(String beginWord, String endWord, Set<String> wordSet, 
        int level, Set<String> visited) {
        if (beginWord.equals(endWord)) {
            if (level < min) {
                min = level;
            }
            return;
        }
        if (level >= min) {
            return;
        }
        for (String newBeginWord : convertList(beginWord, wordSet)) {
            if (visited.contains(newBeginWord)) {
                continue;
            }
            visited.add(newBeginWord);
            dfs(newBeginWord, endWord, wordSet, level + 1, visited);
            visited.remove(newBeginWord);
        }

    }

    List<String> convertList(String startWord, Set<String> wordSet) {
        List<String> res = new ArrayList<>();
        for (String word : wordSet) {
            if (oneCharDiff(startWord, word)) {
                res.add(word);
            }
        }
        return res;
    }

    public boolean oneCharDiff(String srcWord, String destWord) {
        if (srcWord.length() != destWord.length()) {
            return false;
        }
        char []srcArr = srcWord.toCharArray();
        char []destArr = destWord.toCharArray();
        int diffCnt = 0;
        for (int i = 0; i < srcArr.length; i++) {
            if (srcArr[i] != destArr[i]) {
                diffCnt++;
            }
            if (diffCnt > 1) {
                return false;
            }
        }
        return true;
    }

}


// 深度优先算法求解2，批量测试会超时
class Solution {
    int min = Integer.MAX_VALUE;
    int len = 0;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.length() != endWord.length()) {
            return 0;
        }
        len = beginWord.length();
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int []letter = new int[26];
        for (int i = 0; i < 26; i++) {
            letter[i] = 'a' + i;
        }
        dfs(beginWord, endWord, wordSet, 1, visited, letter);
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public void dfs(String beginWord, String endWord, Set<String> wordSet, 
        int level, Set<String> visited, int[] letter) {
        if (beginWord.equals(endWord)) {
            if (level < min) {
                min = level;
            }
            return;
        }
        if (level >= min) {
            return;
        }

        char []sArr = beginWord.toCharArray();
        for (int i = 0; i < len; i++) {
            char c = sArr[i];
            for (int j = 0; j < letter.length; j++) {
                if ((char)letter[j] == c) {
                    continue;
                }
                sArr[i] = (char)letter[j];
                String newStr = new String(sArr);
                if (wordSet.contains(newStr) && !visited.contains(newStr)) {
                    visited.add(newStr);
                    dfs(newStr, endWord, wordSet, level + 1, visited, letter);
                    visited.remove(newStr);
                }
            }
            sArr[i] = c;
        }
    }

}