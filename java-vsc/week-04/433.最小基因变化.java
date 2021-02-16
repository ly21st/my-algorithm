import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=433 lang=java
 *
 * [433] 最小基因变化
 *
 * https://leetcode-cn.com/problems/minimum-genetic-mutation/description/
 *
 * algorithms
 * Medium (53.47%)
 * Likes:    67
 * Dislikes: 0
 * Total Accepted:    11.3K
 * Total Submissions: 21.1K
 * Testcase Example:  '"AACCGGTT"\n"AACCGGTA"\n["AACCGGTA"]'
 *
 * 一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
 * 
 * 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
 * 
 * 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
 * 
 * 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。
 * 
 * 现在给定3个参数 — start, end,
 * bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回
 * -1。
 * 
 * 注意：
 * 
 * 
 * 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
 * 如果一个起始基因序列需要多次变化，那么它每一次变化之后的基因序列都必须是合法的。
 * 假定起始基因序列与目标基因序列是不一样的。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * start: "AACCGGTT"
 * end:   "AACCGGTA"
 * bank: ["AACCGGTA"]
 * 
 * 返回值: 1
 * 
 * 
 * 示例 2：
 * 
 * 
 * start: "AACCGGTT"
 * end:   "AAACGGTA"
 * bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
 * 
 * 返回值: 2
 * 
 * 
 * 示例 3：
 * 
 * 
 * start: "AAAAACCC"
 * end:   "AACCCCCC"
 * bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
 * 
 * 返回值: 3
 * 
 * 
 */

// @lc code=start
class Solution {
    int minLevel = Integer.MAX_VALUE;
    int len = 0;

    public int minMutation(String start, String end, String[] bank) {
        char[] letter = new char[] { 'A', 'C', 'G', 'T' };
        len = start.length();
        Set<String> visited = new HashSet<>();
        visited.add(start);
        Set<String> bankSet = new HashSet<>();
        for (int i = 0; i < bank.length; i++) {
            bankSet.add(bank[i]);
        }
        LinkedList<String> queue = new LinkedList<>();
        queue.add(start);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int k = 0; k < size; k++) {
                String s = queue.poll();
                char[] sArr = s.toCharArray();
                for (int i = 0; i < len; i++) {
                    char c = sArr[i];
                    for (int j = 0; j < letter.length; j++) {
                        if (c == letter[j]) {
                            continue;
                        }
                        sArr[i] = letter[j];
                        String newStr = new String(sArr);
                        if (bankSet.contains(newStr) && !visited.contains(newStr)) {
                            if (newStr.equals(end)) {
                                return level;
                            }
                            visited.add(newStr);
                            queue.add(newStr);
                        }
                    }
                    sArr[i] = c;
                }
            }

        }
        return -1;
    }
}
// @lc code=end

// 深度优先算法求解
class Solution {
    int minLevel = Integer.MAX_VALUE;
    int len = 0;

    public int minMutation(String start, String end, String[] bank) {
        char[] letter = new char[] { 'A', 'C', 'G', 'T' };
        Set<String> visited = new HashSet<>();
        len = start.length();
        visited.add(start);
        Set<String> bankSet = new HashSet<>();
        for (int i = 0; i < bank.length; i++) {
            bankSet.add(bank[i]);
        }
        dfs(start, end, bankSet, letter, visited, 0);

        return minLevel == Integer.MAX_VALUE ? -1 : minLevel;
    }

    public void dfs(String start, String end, Set<String> bankSet, char[] letter, Set<String> visited, int level) {
        if (start.equals(end)) {
            if (level < minLevel) {
                minLevel = level;
            }
            return;
        }
        char[] startArr = start.toCharArray();
        for (int i = 0; i < len; i++) {
            char c = startArr[i];
            for (int j = 0; j < letter.length; j++) {
                if (c == letter[j]) {
                    continue;
                }
                startArr[i] = letter[j];
                String newStr = new String(startArr);
                if (!bankSet.contains(newStr)) {
                    continue;
                }
                if (visited.contains(newStr)) {
                    continue;
                }
                visited.add(newStr);
                dfs(newStr, end, bankSet, letter, visited, level + 1);
                visited.remove(newStr);
            }
            startArr[i] = c;
        }
    }
}