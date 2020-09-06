class Human2(object):    
    def __getattribute__(self, item):
        """
        将不存在的属性设置为100并返回,模拟getattr行为
        """
        print('Human2:__getattribute__')
        try:
            return super().__getattribute__(item)
        except Exception as e:
            self.__dict__[item] = 100
            return 100
h1 = Human2()

print(h1.noattr)

# 思考：有更简洁的写法吗？


# liyuan编写代码并且测试, 得到错误结果
class Human3(object):    
    def __getattribute__(self, item):
        """
        将不存在的属性设置为100并返回,模拟getattr行为
        """
        print('Human2:__getattribute__')
        if hasattr(self, item):
            return super().__getattribute__(item)
        else:
            self.__dict__[item] = 100
            return 100
h3 = Human3()
