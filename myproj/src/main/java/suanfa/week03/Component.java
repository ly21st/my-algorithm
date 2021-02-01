package suanfa.week03;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Component {
    public static void main(String[] args) {
        Component component = new Component();
        List<List<Integer>> res = component.combine(4, 2);
        log.info("res:{}", res);
    }

    public List<List<Integer>> combine(int n, int k) {
        ArrayList<Integer> output = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int []arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        log.info("arr:{}", JSON.toJSONString(arr));
        helper(arr, n, k, res, output, 0);
        return res;
    }
    public void helper(int []arr, int n, int k, List<List<Integer>> res, ArrayList<Integer>output, int i) {
        if (output.size() >= k) {
            ArrayList<Integer> list = new ArrayList<>(output);
            res.add(list);
            return;
        }
        if (i >= n) {
            return;
        }
        for (int j = i; j < n; j++) {
            output.add(arr[j]);
            helper(arr, n, k, res, output, j + 1);
            output.remove(output.size() - 1);
        }
    }
}
