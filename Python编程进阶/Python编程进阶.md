# Python编程进阶
@ 2018冬季 Cody Luo (罗江林 cody@ ustc.edu)

### GUI: tkinter

```python
from tkinter import *
Label(text='Spam').pack()
mainloop()
```

https://docs.python.org/3/library/tkinter.html
### 使用*pickle*序列化对象
pickle提供了一种对象序列化的机制，一个对象可以被表示为一个字节序列。 将序列化对象写入文件之后，可以从文件中读取出来，并且对它进行反序列化

- pickle.dump(obj, file, protocol=None, *, fix_imports=True)
- pickle.dumps(obj, protocol=None, *, fix_imports=True)
- pickle.load(file, *, fix_imports=True, encoding="ASCII", errors="strict")
- pickle.loads(bytes_object, *, fix_imports=True, encoding="ASCII", errors="strict")



```python
import pickle

obj={'book':'python计算机视觉编程','author':'Jan Solem','url':'http://shop.oreilly.com/product/0636920022923.do'}
with  open('book.obj', 'bw') as file:
    pickle.dump(obj, file)    
```

```python
import pickle

with open('book.obj', 'rb') as f:
    data = pickle.load(f)
    print(data)
```

### urlopen

```python=
import urllib.request
with urllib.request.urlopen('http://qing.tk/webbud/') as f:
    print(f.read(300))
```

### ftplib
```
>>> from ftplib import FTP
>>> ftp = FTP('ftp.auckland.ac.nz')
>>> ftp.login()
'230 Login successful.'
>>> ftp.dir()
lrwxrwxrwx    1 0        0              18 Mar 05  2010 debian -> linux/dists/debian
drwxr-x---    3 30016    30016       20480 Aug 05  2010 ironport
drwxr-xr-x    3 0        0            4096 Mar 05  2006 linux
drwxr-xr-x    2 0        0           16384 Jan 11  2007 lost+found
dr-xr-xr-x   20 0        0            4096 Jun 13  2010 pub
>>> ftp.cwd('/pub/gnu/wget')
'250 Directory successfully changed.'
>>> ftp.retrbinary('RETR wget-1.19.tar.xz', open('wget-1.19.tar.xz', 'wb').write)
'226 File send OK.'
>>> ftp.quit()
'221 Goodbye.'
```



@ 2019暑假 Cody Luo (罗江林 cody@ ustc.edu)

## Python精湛代码

### 简单web服务器, 以当前目录开始
```
 # Python 2
python -m SimpleHTTPServer

 # Python 3
python -m http.server 80
```

### 心形字符图案
```
print('\n'.join([''.join([('EternalLove!'[(x-y)%8]if((x*0.05)**2+(y*0.1)**2-1)**3-(x*0.05)**2*(y*0.1)**3<=0 else' ')for x in range(-30,30)])for y in range(15,-15,-1)]))
```

<img src="images/heart1.png"> <img src="images/heart2.png">

### Mandelbrot集
```
print('\n'.join([''.join(['*'if abs((lambda a:lambda z,c,n:a(a,z,c,n))(lambda s,z,c,n:z if n==0else s(s,z*z+c,c,n-1))(0,0.02*x+0.05j*y,40))<2 else' 'for x in range(-80,20)])for y in range(-20,20)]))
```
<img src="images/Mandelbrot-set.png">

### 乘法表
```
  #命令行中打印9X9乘法表
py -c "print( '\n'.join([' '.join(['%s*%s=%-2s' % (y,x,x*y) for y in range(1,x+1)]) for x in range(1,10)]))"

  ##打印16进制乘法表
print( '\n'.join([' '.join(['%s*%s=%-2s' % (hex(y)[2:],hex(x)[2:],hex(x*y)[2:]) for y in range(1,x+1)]) for x in range(1,0x10)]))

```

### 质数序列
```
pl=[i for i in range(2, 1000) if all(tuple(i%j for j in range(2, int(i**.5)+1)))]
print(pl)
  # [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997]

  # 注意：如果range(2, int(i**.5)+1)换成range(2, int(i**.5)) ，那么质数的平方也会包含其中，但合数的平方不在其中
```

### 计算输入数字的阶乘
```
import functools
f=functools.reduce(lambda x,y:x*y,  range(1,int(input('输入整数n:'))+1))
print('n!=',f)
```

### random.choice
```
import random;print (random.choice([1,2,5,10]))
# 这两句代码也可写成这样：
print(__import__('random').choice([1, 2, 5, 10]))
```

### 打印八皇后问题的92个解
```
import sys,itertools;[sys.stdout.write('\n'.join('.' * i + 'Q' + '.' * (8-i-1) for i in vec) + "\n========\n") for vec in itertools.permutations(range(8)) if 8 == len(set(vec[i]+i for i in range(8))) == len(set(vec[i]-i for i in range(8)))]

```
<img src="images/8queens.png">

### 
`import this` 将打印Python之禅 (The Zen of Python, by Tim Peters)

`import antigravity` 将打开浏览器访问网址 https://xkcd.com/

在IDLE(Python 3.7 64bit)中运行，然后学习 antigravity.py 的源码：

```python
>>> import antigravity
>>> print(antigravity.__file__)
D:\Python37\lib\antigravity.py
```

```python
import webbrowser
import hashlib

webbrowser.open("https://xkcd.com/353/")

def geohash(latitude, longitude, datedow):
    '''Compute geohash() using the Munroe algorithm.

    >>> geohash(37.421542, -122.085589, b'2005-05-26-10458.68')
    37.857713 -122.544543

    '''
    # https://xkcd.com/426/
    h = hashlib.md5(datedow).hexdigest()
    p, q = [('%f' % float.fromhex('0.' + x)) for x in (h[:16], h[16:32])]
    print('%d%s %d%s' % (latitude, p[1:], longitude, q[1:]))
```
学习编程的最好办法就是阅读运行源码，引发创想与实验……
IDLE(Python 3.7 64bit) 菜单 `Help>Turtle Demo` 提供一个有趣的窗口程序样例，它的源码位于`D:\Python37\Lib\turtledemo\` turtledemo提供了一个编写Tkinter窗口应用的清晰框架，把它作为参考模板，我们完全可以轻松的编写自己的应用甚至游戏……

```python
from turtle import *
#speed('fast')
i=1000
while i>0:
    forward(200),left(75)
    i-=1
```
<img src="F:\cloud\github\dev\Python编程进阶\images\turtuledemo_left75.png" width="200">

https://docs.python.org/zh-cn/3/library/turtle.html#turtle.forward 详尽介绍了海龟绘图的各个函数与使用方法。这个页面示范了如何编写程序文档，它使用[Sphinx](http://sphinx.pocoo.org/)2.0.1 创建。

### 获取公网IP地址
```
import socket; sock=socket.create_connection(('ns1.dnspod.net',6666)); print (sock.recv(16)); sock.close()
```

### 打印字符型曲线
```
D:\Python37\Doc>python -c "import math as m;a,v=eval(input());[print('%03d'%x+' '*m.floor(0.5+x*m.tan(a)-x*x/(v*m.cos(a)))+'o') for x in range(102)]"
0.98,100
```
<img src="images/ascii-curve.png">

### 随机生成迷宫
```
import random
while 1:
    print(random.choice('╱ ╲'), end='')
```
### 实现老虎机功能，多个字符中随机选择3个
```
import random;p=lambda:random.choice('7♪♫♣♠♦♥◄☼☽');[print('|'.join([p(),p(),p()]),end='\r') for i in range(8**5)]

# 可以利用random.sample()函数把上述代码简写为
import random;[print('|'.join(random.sample('7♪♫♣♠♦♥◄☼☽',3)),end='\r')  for i in range(8**5)]
```

### 实现一个计算器 calc.py
```
while 1: print(eval(input('>')))
```

### 暴力破解zip压缩文件的密码
使用 zipfile 库来解压文件只需3行
```
import zipfile
zFile = zipfile.ZipFile("magic.zip")
zFile.extractall(pwd=b"secret")
```

很自然的，我们可以使用一个密码字典程序, 尝试暴力破解zip文件
```
import zipfile
zFile = zipfile.ZipFile("magic.zip")
passFile = open('dictionary.txt',encoding="utf-8")

for line in passFile.readlines():
        password = line.strip('\n')
        try:
                zFile.extractall(path="./magic",pwd=password.encode('utf-8'))
                print('Password : ', password)
                exit(0)
        except Exception as e:
                print (e)
```

注意: zipfile会对AES-256加密算法失效，即使密码串正确，解压时总是出现异常Bad password for file......对于ZipCrypto加密算法的.zip工作良好。

## Python简明代码样例

### 交换值 x,y=y,x

```python=
x,y=1,2
x,y=y,x
print(x,y)
// 输出 2 1
```

### 字符串
```
name = 'George'
name[::-1]  #返回 'egroeG'。反转字符串 reverse a str。
```
### split 与 join

- str.split(sep=None, maxsplit=-1)
- str.splitlines([keepends])
- str.join(iterable)

```python=
sentence1='My name is <b>Cody Luo</b>!'
s=sentence1.split(None,maxsplit=3)
 # ['My', 'name', 'is', '<b>Cody Luo</b>!']

'+'.join(s)
 # 'My+name+is+<b>Cody Luo</b>!'
```

### 关于列表
```
[0]*3  # [0,0,0]
[1,2,3]+[10]  # [1, 2, 3, 10]

print(list( map(lambda x:x*x, [1,2,3,4]) ))
 # [1, 4, 9, 16]

```

### 合并词典
```python=
x={'a':1,'b':2}
y={'b':'boat','c':3}
z={**x,**y}
print(z)
   # {'a': 1, 'b': 'boat', 'c': 3}
```
### itertools

## Python标准库

### Tk图形用户界面(GUI)

在命令行中运行 `python -m tkinter`，会弹出一个Tk界面的窗口，这表明 [`tkinter`](https://docs.python.org/zh-cn/3/library/tkinter.html#module-tkinter) 包已经正确安装。

```
>>> import tkinter as tk
>>> tk._test()
>>> tk.Tcl().eval('info patchlevel')
'8.6.9'
>>> 
```



### cmd -- 支持面向行的命令解释器
源代码: Lib/cmd.py
class cmd.Cmd(completekey='tab', stdin=None, stdout=None)

## 

Jupyter SageMath pygame TensorFlow NLTK face_recoganition

## 参考文档

1. https://docs.python.org/zh-cn/3/library/turtle.html  Python3中文文档, turtle --- 海龟绘图
2. https://docs.python.org/3/library/random.html   The Python Standard Library » Numeric and Mathematical Modules » random — Generate pseudo-random numbers
2. https://python3-cookbook.readthedocs.io/zh_CN/latest/c03/p11_pick_things_at_random.html python3-cookbook » 第三章：数字日期和时间 » 3.11 随机选择