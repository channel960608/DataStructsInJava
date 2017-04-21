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
Healthy项目上，从myEclipse转移到Idea中来。_   
 
>2017/4/17    
* Problem
>测试application.linear.Expense类时 ，Main类入口函数中   
<code>   
Calendar cal=Calendar.getInstance();  
Expense exp=new Expense(Expense.getCalendar("1996/6/8"),100,"赌博");  
System.out.print(exp.toString());   
</code>  
返回的结果  
1996/00/08	100.00	赌博
Process finished with exit code 0  
中间的月份无法正确显示，debug之后发现问题出在SimpleDateFormat类的format()方法中   
Solution:
<code>  
 public static final SimpleDateFormat sdf=new SimpleDateFormat("yyyy/mm/dd");  
</code>  
应该改为  
<code>  
 public static final SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");  
 </code>  
 没有想到SimpleDateFormat的这个方法在限定格式时区分大小写，而且yyyy/MM/dd通过大小限
 限定了返回的Calendar中的具体内容  
 另外，发现了Calendar这个日期类中，月份Month是从0开始计算的，同时，一周的第一天是从
 周日开始的。
 
>2017.4.21  
* Problem  
>Huffman类编写过程中Queue类无法正确声明  
<code>  
Queue<BinaryTree<Float>> leaves;  
</code>  
Solution:
原因是当初我对Queue是这样定义的  
<code>  
public class Queue<T extends Comparable<T>>   
</code>  
这里BinaryTree类不属于可比较的Comparable<T>类型
结果看了一下书上，确实没有对其进行extends Comparable<T>的定义  











