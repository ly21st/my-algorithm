package suanfa.week04;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2021-02-15
 **/
@Slf4j
public class LadderLength {
    int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        LadderLength ladderLength = new LadderLength();
        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        int len = ladderLength.ladderLength("hit", "cog", wordList);
        System.out.printf("len:%d\n", len);
    }

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
