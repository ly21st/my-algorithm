# 学习笔记
----

>> ## 二叉树的层次遍历

每一层里面的所有元素放进一个list，最后结果是List<List<Intger>>

这里涉及到什么时候把一层的元素放进一个list，至少有两个时刻，一个是把父节点的所有子节点插入队列时，同时输出一层的结果。

另一个可能是同一层的元素出队列时，输出一层的结果。

怎么表示同一层的所有元素？可以把同一层的所有元素放进一个队列，多个层次就有多个队列。输出多层树时就会产生两个循环，
最外层循环是while(!deque.isEmpty()),里面一层循环是一层的元素非空。这种方法占用内存稍多。

另一种方法是，构造一个新的数据结构，包含两个数据元素,分别为TreeNode与level，每次插入一个TreeNode都标志是第一层，这种方式使用一个
循环就可以了，也不用每层用一个单独的list。


```

	class Solution {
	    int L = 0;
	    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
	        Set<String> visited = new HashSet<String>();
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
	        return helper(beginWord, endWord, visited, allMap);
	    }
	
	    public int helper(String beginWord, String endWord, Set<String> visited, 
	            Map<String, List<String>> allMap) {
	        LinkedList<Pair<String, Integer>> deque = new LinkedList<Pair<String, Integer>>();
	        deque.addLast(new Pair<String, Integer>(beginWord, 1));
	        while (!deque.isEmpty()) {
	            Pair<String, Integer> p = deque.removeFirst();
	            String curWord = p.getKey();
	            Integer level = p.getValue();
	            for (int j = 0; j < L; j++) {
	                String s = curWord.substring(0, j) + "*" + curWord.substring(j + 1, L);
	                List<String> list = allMap.getOrDefault(s, new ArrayList<String>());
	                for (String word : list) {
	                    if (word.equals(endWord)) return level + 1;
	                    if (!visited.contains(word)) {
	                        deque.add(new Pair<String, Integer>(word, level + 1));
	                        visited.add(word);
	                    }
	                }
	            }
	        }    
	        return 0;
	    }
	}

```

