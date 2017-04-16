Problems Recording
=====
#####I met up with some problems during my coding process.So I would record the problems and write down the steps to solving the problems.  
#####You can learn the Markdown editing from this webside <http://wowubuntu.com/markdown/>  
>2017.4.15  
* Problem  
>项目转移到Idea时产生的编码错误（注：Eclipse转Idea）  
Solution：  
Step1：  
从UTF-8转向GBK编码，并使用Reload重新加载文件，这样乱码就会变成正常文字  
Step2：  
这样是不够的，再将GBK编码转回UTF-8，并使用Convert转变文件编码  
参考：<http://www.cnblogs.com/heitan/p/5750456.html>  
* Problem  
>Idea导入java项目后无法找到运行按钮，原因在于没有Idea无法定位src源码文件夹  
Solution:  
重新设置项目结构，在File>Project Structure中的Source栏下选择src作为代码的Source Folders，
在Paths栏下选择Use module compile output path，并将Output path设置为eclipse目录下原有的
bin目录，这里我新建了一个testbin目录用于test文件输出  

_今天算解决了一个一直让我比较头疼的Eclipse项目导入Idea的问题，以后会把解决方案用在
Healthy项目上，从muEclipse转移到Idea中来。_   
 
>2017/4/16  








