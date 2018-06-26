import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;//调用算法4中的库

public class FrequencyCounter {//频率统计
  public static void main(String[] args){
	  int minlen=Integer.parseInt(args[0]);//integer.parsein指的是将字符串转换成一个整数，args[0]指的是第一个参数。指的是输入一个指定的值然后作为最小键长。
	 ST<String,Integer> st=new ST<String,Integer>();//API，创建一张有序的符号表。其中包括，put(放键值),get(获取键值，空为则删除),delete(删除)等等。
	while(!StdIn.isEmpty()){//判断是否为输入空		
	String word = StdIn.readString();//接收数据,readString()是一个个读取，即返回下一个值。
	if(word.length()<minlen) continue;//如果小于最小键长开始下轮循环。
	if(!st.contains(word)) st.put(word,1);//如果不存在（contain判断是否存在表中），则把键值都放入表中，否则更新值，即统计数加一，利用了不能存在相同键，否则更新值的原理。
	else st.put(word, st.get(word)+1);
	}
	String max=" ";
	st.put(max, 0);//插入一个值为0，键为“ ”的键值对。
	for(String word:st.keys()){//word遍历表中键的集合。
		if(st.get(word)>st.get(max))
			max=word;//用max键值对与其他键值对相比较，如果值比较大则max获得那个键名。
		   StdOut.println(max+" "+ st.get(max));//输出出现频率最大的键的名字和值。
	}
  }
}