/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 *
 * https://leetcode-cn.com/problems/min-stack/description/
 *
 * algorithms
 * Easy (55.32%)
 * Likes:    680
 * Dislikes: 0
 * Total Accepted:    165.2K
 * Total Submissions: 298.4K
 * Testcase Example:  '["MinStack","push","push","push","getMin","pop","top","getMin"]\n' +
  '[[],[-2],[0],[-3],[],[],[],[]]'
 *
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * 
 * 
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 * 
 * 
 * 
 * 
 * 示例:
 * 
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * 
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * 
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 * 
 * 
 */

// @lc code=start
class MinStack {
    class Node {
        int value;
        Node pre;
        Node next;

        public Node(int i) {
            value = i;
            pre = null;
            next = null;
        }
    };

    Node header = null;
    Node tail = null;


    /** initialize your data structure here. */
    public MinStack() {
        header = tail = new Node(Integer.MAX_VALUE);
    }
    
    public void push(int x) {
        Node node = new Node(x);
        tail.next = node;
        node.pre = tail;
        tail = node;
    }
    
    public void pop() {
        if (header == tail) {
            return;
        }
        tail = tail.pre;
        tail.next = null;
    }
    
    public int top() {
        if (header == tail) {
            return -1;
        }
        return tail.value;
    }
    
    public int getMin() {
        Node p = header.next;
        int min;
        if (p != null) {
            min = p.value;
        } else {
            return -1;
        }
        while (p != null) {
            if (min > p.value) {
                min = p.value;
            }
            p = p.next;
        }
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

