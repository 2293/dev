# Java编程高手速成
Cody Luo @2019 summer

[TOC]

## 基础
### JDK的安装与切换
JDK(Java Development Kit)，Java开发包是Java平台的标准实现，包括标准版(Standard Edition),企业版(Enterprise Edition)还有微型版(Micro Edition)，现在由2009年4月收购SUN公司的Oracle公司负责升级与发布。Java是跨平台的编程语言，适用的操作系统包括Solaris, Linux, macOS, Windows等等。

安装JDK有两种选择：
- Oracle JDK, https://www.oracle.com/technetwork/java/javase/downloads/index.html , 目前的版本是12
- OpenJDK, https://jdk.java.net/ , 开源，目前的版本是12

两种JDK各分有64位和32位的安装包，建议选择64位的，Oracle JDK和OpenJDK都安装，使用时只需简单修改系统环境变量JAVA_HOME的值即可完成两种JDK的切换。
在Windows开发环境下，
> 可以把 jdk-12.0.1_windows-x64_bin.exe 安装到 D:\Java\jdk
接着把 openjdk-12.0.1_windows-x64_bin.zip 解压到 D:\Java\openjdk
现在设置环境变量，以管理员身份运行cmd，运行
```
    set JAVA_HOME=D:\Java\openjdk
    set PATH=%JAVA_HOME%\bin;%PATH% 
```
也可右键我的电脑（或者在控制面板中点击系统）->属性->高级->环境变量，在系统变量中新建变量名JAVA_HOME，变量值为JDK的安装路径。例：JAVA_HOME=D:\Java\openjdk
在PATH中添加一条%JAVA_HOME%\bin
建议不要设置CLASSPATH这样的一个环境变量，因为一般情况下不需要指定类路径，需要时完全可以在java运行命令行中用-cp参数指定

现在，JDK安装完成了，另起一个CMD或者PowerShell窗口,
```
C:\Users\ljl>java -version
openjdk version "12.0.1" 2019-04-16
OpenJDK Runtime Environment (build 12.0.1+12)
OpenJDK 64-Bit Server VM (build 12.0.1+12, mixed mode, sharing)

C:\Users\ljl>java Hi.java  # 新的Java 11特性: 直接运行单个.java源程序
Hello, World！你好，世界！

C:\Users\ljl>javac Hi.java

C:\Users\ljl>java Hi
Hello, World！你好，世界！

```

其中Hi.java 的内容如下，可用快速的编辑器进行编辑，如Notepad，Editplus，Visual Studio Code…… 为了防止中文出现乱码，注意在Windows CMD、PowerShell中运行时，Hi.java的编码应为ANSI；而在IDE及云平台中运行的.java源码一般应为UTF-8编码格式！
```
public class Hi {
    public static void main(String[] args) {
        // Prints some string to the terminal window.
        System.out.println("Hello, World！你好，世界！");
    }
}
```

当需要使用Oracle JDK时，只需切换环境变量 `set JAVA_HOME=D:\Java\jdk` ，再重启命令行窗口，
```
C:\Users\ljl>java -version
java version "12.0.1" 2019-04-16
Java(TM) SE Runtime Environment (build 12.0.1+12)
Java HotSpot(TM) 64-Bit Server VM (build 12.0.1+12, mixed mode, sharing)
```
而在IDE中，完全可以指定使用哪个路径下的JDK进行编译和开发

### 数据类型

### 流程控制

### 运算符优先级

### 类修饰词的作用域

## 数学与BigInteger

## Swing

## 网络