package problems_0010;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution {
    int L;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<String>(wordList);
        Set<String> visited = new HashSet<String>();
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        if (beginWord.equals(endWord)) {
            return 1;
        }
        L = beginWord.length();
        return bfs(beginWord, endWord, wordSet, visited);
    }

    public int bfs(String begString, String endString, Set<String> wordsSet, Set<String> visited) {
        Deque<String> deque = new LinkedList<String>();
        int level = 0;
        deque.addLast(begString);
        while(!deque.isEmpty()) {
            int size = deque.size();
            level++;
            for (int i = 0; i < size; i++) {
                String top = deque.removeFirst();
                char []arr = top.toCharArray();
                for (int j = 0; j < L; j++) {
                    char tmp = arr[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (tmp == k) {
                            continue;
                        }
                        arr[j] = k;
                        String target = new String(arr);
                        if (target.equals(endString)) {
                            return level + 1;
                        }
                        if (!wordsSet.contains(target)) {
                            continue;
                        }
                        if (visited.contains(target)) {
                            continue;
                        } 
                        visited.add(target);
                        deque.addLast(target);
                    }
                    arr[j] = tmp;
                }
            }
        }
        return 0;
    }
}