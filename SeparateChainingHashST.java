
public class SeparateChainingHashST<Key,Value> {
     private int N;//局部变量。键值对的总数
     private int M;//散列表的大小，取素数
     private SequentialSearchST<Key,Value> [] st;//存放链表对象的数组，类似于String[] args[].不过调用了顺序查找算法（基于无序链表）
     public SeparateChainingHashST(){
    	 this(997);}//默认，即不传入参数，就使用997条链表
    	 

	public SeparateChainingHashST(int M) {
		this.M=M;//局部变量值为参数
		st=(SequentialSearchST<Key,Value> []) new SequentialSearchST[M];//数组大小为M
		for(int i=0;i<M;i++)
			st[i]=new SequentialSearchST();//构造数组
		
	}
	private int hash(Key key){
		return (key.hashCode()&0x7fffffff)%M;//将hashCode()返回值转换成一个数组索引，hashCode会得出一个32位的整数，系统内置，前面的操作将其转换成了31位的非负整数再除以数组长度或者说是链表数，因为一个索引放一条链表
		
	}
	private Value get(Key key){//获取键的值，详情查看，顺序查询（sequentialSearchST）
		return (Value) st[hash(key)].get(key);//hash(key)得到相关的索引，通过上面构造的数组通过顺序查询就可获取对应的值
		
	}
	public void get(Key key,Value val){
	 st[hash(key)].put(key, val);//存放对应的键值
	}
	
}