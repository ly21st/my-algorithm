#! -*- coding:utf-8 -*-

class Node(object):
    def __init__(self, value=-1):
        self.pre = None
        self.next = None
        self.value = value

class MyCircularDeque(object):
    def __init__(self, k):
        self._size = 0
        self._max_size = k
        self._node = Node()
        self._front = self._node
        self._last = self._node
        self._node.pre = self._node
        self._node.next = self._node

    def insert(self, position, value):
        node = Node(value)
        node.next = position
        position.pre.next = node
        node.pre = position.pre
        position.pre = node
        return node

    def insertFront(self, value):
        if self._size >= self._max_size:
            return False
        self.insert(self._front, value)
        self._front = self._last.next
        self._size += 1
        return True

    def insertLast(self, value):
        if self._size >= self._max_size:
            return False
        self.insert(self._last, value)
        self._front = self._last.next
        self._size += 1
        return True

    def deleteFront(self):
        if self._size < 1:
            return False
        self._last.next = self._front.next
        self._front.next.pre = self._last
        self._front = self._front.next
        self._size -= 1
        return True

    def deleteLast(self):
        if self._size < 1:
            return False
        last = self._last.pre
        last.pre.next = self._last
        self._last.pre = last.pre
        self._front = self._last.next
        self._size -= 1
        return True

    def getFront(self):
        if self._size < 1:
            return -1
        return self._front.value

    def getRear(self):
        if self._size < 1:
            return -1
        return self._last.pre.value

    def isEmpty(self):
        return self._size == 0

    def isFull(self):
        return self._size == self._max_size

if __name__ == '__main__':
    # Your MyCircularDeque object will be instantiated and called as such:
    obj = MyCircularDeque(3)
    param_1 = obj.insertFront(1)
    param_2 = obj.insertLast(2)
    param_3 = obj.deleteFront()
    param_4 = obj.deleteLast()
    param_5 = obj.getFront()
    param_6 = obj.getRear()
    param_7 = obj.isEmpty()
    param_8 = obj.isFull()