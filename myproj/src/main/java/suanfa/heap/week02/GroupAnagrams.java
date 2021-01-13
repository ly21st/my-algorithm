package suanfa.heap.week02;

import java.util.*;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2021-01-13
 **/
public class GroupAnagrams {
    public static void main(String argc) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();

    }

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> res = new ArrayList<>();
        if (strs.length == 0) {
            return res;
        }
        Map<char[], List<String>> group = new HashMap<>();
        for (String str : strs) {
            char []arr = str.toCharArray();
            Arrays.sort(arr);
            List<String> list = group.getOrDefault(arr, new ArrayList<String>());
            list.add(str);
            group.put(arr, list);
        }

        System.out.println(group);
        for (Map.Entry<char[], List<String>> entry : group.entrySet()) {
            res.add(entry.getValue());
        }

        return res;
    }
}
