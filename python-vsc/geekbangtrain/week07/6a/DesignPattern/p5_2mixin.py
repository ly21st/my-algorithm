# 《Python GUI Programming with Tkinter》
# Mixin类无法单独使用，必须和其他类混合使用，来加强其他类

class Displayer():
    def display(self, message):
        print('in Displayer.display')
        print('in Displayer.self', self)
        print(message)

class LoggerMixin():
    def log(self, message, filename='logfile.txt'):
        print('in LoggerMixin.log')
        print('in LoggerMixin.self', self)
        with open(filename, 'a') as fh:
            fh.write(message)

    def display(self, message):
        print('in LoggerMixin.display')
        print('in LoggerMixin.self', self)
        super(LoggerMixin, self).display(message)
        self.log(message)

class MySubClass(LoggerMixin, Displayer):
    def log(self, message):
        print('in MySubClass.log')
        print('in MySubClass.self', self)
        super().log(message, filename='subclasslog.txt')

subclass = MySubClass()
subclass.display("This string will be shown and logged in subclasslog.txt")
print(MySubClass.mro())
print(hex(id(subclass)))