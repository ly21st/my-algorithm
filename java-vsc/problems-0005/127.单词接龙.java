import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javafx.util.Pair;

/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 *
 * https://leetcode-cn.com/problems/word-ladder/description/
 *
 * algorithms
 * Medium (41.03%)
 * Likes:    302
 * Dislikes: 0
 * Total Accepted:    37.6K
 * Total Submissions: 90.6K
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
// 双向队列，官方版本仿写
class Solution {
    int L = 0;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        Map<String, List<String>> allMap = new HashMap<String, List<String>>();
        L = beginWord.length();
        for (String word : wordList) {
            for (int i = 0; i < L; i++) {
                String s = word.substring(0, i) + "*" + word.substring(i + 1, L);
                List<String> list = allMap.getOrDefault(s, new ArrayList<String>());
                list.add(word);
                allMap.put(s, list);
            }
        }
        return helper(beginWord, endWord, allMap);
    }

    public int helper(String beginWord, String endWord, 
            Map<String, List<String>> allMap) {
        LinkedList<Pair<String, Integer>> deque1 = new LinkedList<Pair<String, Integer>>();
        deque1.addLast(new Pair<String, Integer>(beginWord, 1));
        Map<String, Integer> visited = new HashMap<String, Integer>();
        visited.put(beginWord, 1);
        LinkedList<Pair<String, Integer>> deque2 = new LinkedList<Pair<String, Integer>>();
        deque2.addLast(new Pair<String, Integer>(endWord, 1));
        Map<String, Integer> otherVisited = new HashMap<String, Integer>();
        otherVisited.put(endWord, 1);

        while (!deque1.isEmpty() && !deque2.isEmpty()) {
            int level;
            level = visitedInQeque(deque1, visited, otherVisited, allMap);
            if (level > 0) return level;
            level =  visitedInQeque(deque2, otherVisited, visited, allMap);
            if (level > 0) return level;
        }    
        return 0;
    }

    public int visitedInQeque(LinkedList<Pair<String, Integer>> deque, 
                            Map<String, Integer> visited, Map<String, Integer> otherVisited,
                            Map<String, List<String>> allMap) {
        Pair<String, Integer> p = deque.removeFirst();
        String key = p.getKey();
        int level = p.getValue();
        for (int j = 0; j < L; j++) {
            String s = key.substring(0, j) + "*" + key.substring(j + 1, L);
            List<String> list = allMap.getOrDefault(s, new ArrayList<String>());
            for (String word : list) {
                if (otherVisited.containsKey(word)) {
                    return level + (int)otherVisited.get(word);
                }
                if (!visited.containsKey(word)) {
                    deque.addLast(new Pair<String, Integer>(word, level + 1));
                    visited.put(word, level + 1);
                }
            }
        } 
        return -1;
    }
}
// @lc code=end


// 广度优先算法，方法1，获取相邻字符串时不进行过滤
// class Solution {
//     int L = 0;
//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//         Set<String> words = new HashSet<String>(wordList);
//         Set<String> visited = new HashSet<String>();
//         return helper(beginWord, endWord, words, visited, 0);
//     }

//     public int helper(String curWord, String endWord, Set<String> words, Set<String> visited, int level) {
//         if (!words.contains(endWord)) return 0;
//         LinkedList<String> deque = new LinkedList<String>();
//         deque.addLast(curWord);
//         while (!deque.isEmpty()) {
//             int size = deque.size();
//             level++;
//             Set<String> subVisited = new HashSet<String>();
//             for (int i = 0; i < size; i++) {
//                 curWord = deque.removeFirst();
//                 List<String> nextWords = getNextWords(curWord, words);
//                 for (String s : nextWords) {
//                     if (s.equals(endWord)) return level + 1;
//                     if (!visited.contains(s)) {
//                         deque.addLast(s);
//                         subVisited.add(s);
//                     }
//                 }
//             }
//             visited.addAll(subVisited);
//         }
//         return 0;
//     }

//     public List<String> getNextWords(String curWord, Set<String> words) {
//         L = curWord.length();
//         char[] arr = curWord.toCharArray();
//         List<String> list = new ArrayList<String>();
//         for (int i = 0; i < L; i++) {
//             char tmp = arr[i];
//             for (char c = 'a'; c <= 'z'; c++) {
//                 if (tmp == c) continue;
//                 arr[i] = c;
//                 String s = String.valueOf(arr);
//                 if (words.contains(s)) {
//                     list.add(s);
//                 }
//                 arr[i] = tmp;
//             }
//         }
//         return list;
//     }
// }



// 广度优先算法，方法2， 获取相邻字符串时也进行过滤
// class Solution {
//     int L = 0;
//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//         Set<String> words = new HashSet<String>(wordList);
//         Set<String> visited = new HashSet<String>();
//         return helper(beginWord, endWord, words, visited, 0);
//     }

//     public int helper(String curWord, String endWord, Set<String> words, Set<String> visited, int level) {
//         if (!words.contains(endWord)) return 0;
//         LinkedList<String> deque = new LinkedList<String>();
//         deque.addLast(curWord);
//         while (!deque.isEmpty()) {
//             int size = deque.size();
//             level++;
//             Set<String> subVisited = new HashSet<String>();
//             for (int i = 0; i < size; i++) {
//                 curWord = deque.removeFirst();
//                 List<String> nextWords = getNextWords(curWord, words, visited);
//                 for (String s : nextWords) {
//                     if (s.equals(endWord)) return level + 1;
//                     deque.addLast(s);
//                     subVisited.add(s);
//                 }
//             }
//             visited.addAll(subVisited);
//         }
//         return 0;
//     }

//     public List<String> getNextWords(String curWord, Set<String> words, Set<String> visited) {
//         L = curWord.length();
//         char[] arr = curWord.toCharArray();
//         List<String> list = new ArrayList<String>();
//         for (int i = 0; i < L; i++) {
//             char tmp = arr[i];
//             for (char c = 'a'; c <= 'z'; c++) {
//                 if (tmp == c) continue;
//                 arr[i] = c;
//                 String s = String.valueOf(arr);
//                 if (!visited.contains(s) && words.contains(s)) {
//                     list.add(s);
//                 }
//                 arr[i] = tmp;
//             }
//         }
//         return list;
//     }
// }



// 方法3，使用通用字符串，里面每轮循环都记录层次
// class Solution {
//     int L = 0;
//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//         Set<String> visited = new HashSet<String>();
//         Map<String, List<String>> allMap = new HashMap<String, List<String>>();
//         L = beginWord.length();
//         for (String word : wordList) {
//             for (int i = 0; i < L; i++) {
//                 String s = word.substring(0, i) + "*" + word.substring(i + 1, L);
//                 List<String> list = allMap.getOrDefault(s, new ArrayList<String>());
//                 list.add(word);
//                 allMap.put(s, list);
//             }
//         }
//         return helper(beginWord, endWord, visited, 0, allMap);
//     }

//     public int helper(String beginWord, String endWord, Set<String> visited, int level, 
//             Map<String, List<String>> allMap) {
//         LinkedList<String> deque = new LinkedList<String>();
//         deque.addLast(beginWord);
//         while (!deque.isEmpty()) {
//             int size = deque.size();
//             level++;
//             Set<String> subVisited = new HashSet<String>();
//             for (int i = 0; i < size; i++) {
//                 String curWord = deque.removeFirst();
//                 for (int j = 0; j < L; j++) {
//                     String s = curWord.substring(0, j) + "*" + curWord.substring(j + 1, L);
//                     List<String> list = allMap.getOrDefault(s, new ArrayList<String>());
//                     for (String word : list) {
//                         if (word.equals(endWord)) return level + 1;
//                         if (!visited.contains(word)) {
//                             deque.add(word);
//                             subVisited.add(word);
//                         }
//                     }
//                 }
//             }
//             visited.addAll(subVisited);
//         }
//         return 0;
//     }
// }


// 默写官方解法
// class Solution {
//     int L = 0;
//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//         Set<String> visited = new HashSet<String>();
//         Map<String, List<String>> allMap = new HashMap<String, List<String>>();
//         L = beginWord.length();
//         for (String word : wordList) {
//             for (int i = 0; i < L; i++) {
//                 String s = word.substring(0, i) + "*" + word.substring(i + 1, L);
//                 List<String> list = allMap.getOrDefault(s, new ArrayList<String>());
//                 list.add(word);
//                 allMap.put(s, list);
//             }
//         }
//         return helper(beginWord, endWord, visited, allMap);
//     }

//     public int helper(String beginWord, String endWord, Set<String> visited, 
//             Map<String, List<String>> allMap) {
//         LinkedList<Pair<String, Integer>> deque = new LinkedList<Pair<String, Integer>>();
//         deque.addLast(new Pair<String, Integer>(beginWord, 1));
//         while (!deque.isEmpty()) {
//             Pair<String, Integer> p = deque.removeFirst();
//             String curWord = p.getKey();
//             Integer level = p.getValue();
//             for (int j = 0; j < L; j++) {
//                 String s = curWord.substring(0, j) + "*" + curWord.substring(j + 1, L);
//                 List<String> list = allMap.getOrDefault(s, new ArrayList<String>());
//                 for (String word : list) {
//                     if (word.equals(endWord)) return level + 1;
//                     if (!visited.contains(word)) {
//                         deque.add(new Pair<String, Integer>(word, level + 1));
//                         visited.add(word);
//                     }
//                 }
//             }
//         }    
//         return 0;
//     }
// }



// 双向队列，方法1，出队列时判断
// class Solution {
//     int L = 0;
//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//         if (!wordList.contains(endWord)) return 0;
//         Map<String, List<String>> allMap = new HashMap<String, List<String>>();
//         L = beginWord.length();
//         for (String word : wordList) {
//             for (int i = 0; i < L; i++) {
//                 String s = word.substring(0, i) + "*" + word.substring(i + 1, L);
//                 List<String> list = allMap.getOrDefault(s, new ArrayList<String>());
//                 list.add(word);
//                 allMap.put(s, list);
//             }
//         }
//         return helper(beginWord, endWord, allMap);
//     }

//     public int helper(String beginWord, String endWord, 
//             Map<String, List<String>> allMap) {
//         LinkedList<Pair<String, Integer>> deque1 = new LinkedList<Pair<String, Integer>>();
//         deque1.addLast(new Pair<String, Integer>(beginWord, 1));
//         Map<String, Integer> visited = new HashMap<String, Integer>();
//         visited.put(beginWord, 1);
//         LinkedList<Pair<String, Integer>> deque2 = new LinkedList<Pair<String, Integer>>();
//         deque2.addLast(new Pair<String, Integer>(endWord, 1));
//         Map<String, Integer> otherVisited = new HashMap<String, Integer>();
//         otherVisited.put(endWord, 1);

//         while (!deque1.isEmpty() && !deque2.isEmpty()) {
//             int level;
//             if (deque1.size() <= deque2.size()) {
//                 level = visitedInQeque(deque1, visited, otherVisited, allMap);
//             } else {
//                 level =  visitedInQeque(deque2, otherVisited, visited, allMap);
//             }
//             if (level > 0) return level;
//         }    
//         return 0;
//     }

//     public int visitedInQeque(LinkedList<Pair<String, Integer>> deque, 
//                             Map<String, Integer> visited, Map<String, Integer> otherVisited,
//                             Map<String, List<String>> allMap) {
//         int size = deque.size();
//         for (int i = 0; i < size; i++) {
//             Pair<String, Integer> p = deque.removeFirst();
//             String key = p.getKey();
//             int level = p.getValue();

//             if (otherVisited.containsKey(key)) {
//                 return level + (int)otherVisited.get(key) - 1;
//             }

//             for (int j = 0; j < L; j++) {
//                 String s = key.substring(0, j) + "*" + key.substring(j + 1, L);
//                 List<String> list = allMap.getOrDefault(s, new ArrayList<String>());
//                 for (String word : list) {
                    
//                     if (!visited.containsKey(word)) {
//                         deque.addLast(new Pair<String, Integer>(word, level + 1));
//                         visited.put(word, level + 1);
//                     }
//                 }
//             }
//         }
//         return -1;
//     }
// }





// 双向队列，入队列前判断，减少一轮循环
// class Solution {
//     int L = 0;
//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//         if (!wordList.contains(endWord)) return 0;
//         Map<String, List<String>> allMap = new HashMap<String, List<String>>();
//         L = beginWord.length();
//         for (String word : wordList) {
//             for (int i = 0; i < L; i++) {
//                 String s = word.substring(0, i) + "*" + word.substring(i + 1, L);
//                 List<String> list = allMap.getOrDefault(s, new ArrayList<String>());
//                 list.add(word);
//                 allMap.put(s, list);
//             }
//         }
//         return helper(beginWord, endWord, allMap);
//     }

//     public int helper(String beginWord, String endWord, 
//             Map<String, List<String>> allMap) {
//         LinkedList<Pair<String, Integer>> deque1 = new LinkedList<Pair<String, Integer>>();
//         deque1.addLast(new Pair<String, Integer>(beginWord, 1));
//         Map<String, Integer> visited = new HashMap<String, Integer>();
//         visited.put(beginWord, 1);
//         LinkedList<Pair<String, Integer>> deque2 = new LinkedList<Pair<String, Integer>>();
//         deque2.addLast(new Pair<String, Integer>(endWord, 1));
//         Map<String, Integer> otherVisited = new HashMap<String, Integer>();
//         otherVisited.put(endWord, 1);

//         while (!deque1.isEmpty() && !deque2.isEmpty()) {
//             int level;
//             if (deque1.size() <= deque2.size()) {
//                 level = visitedInQeque(deque1, visited, otherVisited, allMap);
//             } else {
//                 level =  visitedInQeque(deque2, otherVisited, visited, allMap);
//             }
//             if (level > 0) return level;
//         }    
//         return 0;
//     }

//     public int visitedInQeque(LinkedList<Pair<String, Integer>> deque, 
//                             Map<String, Integer> visited, Map<String, Integer> otherVisited,
//                             Map<String, List<String>> allMap) {
//         int size = deque.size();
//         for (int i = 0; i < size; i++) {
//             Pair<String, Integer> p = deque.removeFirst();
//             String key = p.getKey();
//             int level = p.getValue();

//             for (int j = 0; j < L; j++) {
//                 String s = key.substring(0, j) + "*" + key.substring(j + 1, L);
//                 List<String> list = allMap.getOrDefault(s, new ArrayList<String>());
//                 for (String word : list) {
//                     if (otherVisited.containsKey(word)) {
//                         return level + (int)otherVisited.get(word);
//                     }
//                     if (!visited.containsKey(word)) {
//                         deque.addLast(new Pair<String, Integer>(word, level + 1));
//                         visited.put(word, level + 1);
//                     }
//                 }
//             }
//         }
//         return -1;
//     }
// }