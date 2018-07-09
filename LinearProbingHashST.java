
public class LinearProbingHashST<Key,Value> {//基于线性探测的散列表
    private int N;//符号表中键值对的总数
    private int M=16;//初始表大小
    private Key[] keys;//键数组
    private Value[] vals;//值数组
    public LinearProbingHashST(int cap){
    	keys=(Key []) new Object[M];//创建大小为M的键数组
    	vals=(Value []) new Object[M];//创建大小为M的值数组
    	
    }

	private int hash(Key key){
    	return (key.hashCode()&0x7fffffff)%M;//计算索引值，为键对应的哈希函数与M的余数
    }
    private void put(Key key,Value val){
    	if(N>=M/2) resize(M*2);//如果键值对的数量大于表的一半，则表的大小翻倍。
    	int i;
    	for(i=hash(key);keys[i]!=null;i=(i+1)%M)//先算数索引，以此开始循环，碰到边界则返回开头（由最后代码可知）
    		if(keys[i].equals(key)){vals[i]=val;return;}//如果相等，更新值，跳出方法，即键值对不增加。不然索引加1
    	keys[i]=key;//放入键值
    	vals[i]=val;
    	N++;// 键值对加1
    }
    public Value get(Key key){
    	for(int i=hash(key);keys[i]!=null;i=(i+1)%M)//先算数索引，以此开始循环，碰到边界则返回开头（由最后代码可知）
    		if(keys[i].equals(key))//如果相等
    	          return vals[i];//获得对应值
    return null;//否则返回null即不存在
    }
    public void delete(Key key){
    	if(!contains(key)) return;//如果键不存在跳出循环
    	int i=hash(key);//得出键的索引
    	while(!key.equals(keys[i]))//如果不相等，接着下找
    		i=(i+1)%M;
    	keys[i]=null;//删除，且接着向下遍历
    	vals[i]=null;
    	i=(i+1)%M;
    	while(keys[i]!=null){//保存之后的值，重新插入表中
    		Key keyToRedo=keys[i];
    		Value valToRedo=vals[i];
    		keys[i]=null;
    		vals[i]=null;
    		N--;
    		put(keyToRedo,valToRedo);
    		i=(i+1)%M;
    		
    	}
    	N--;
    	if(N>0&&N==M/8) resize(M/2);//动态调整数组大小，使其使用率在1/8到1/2之间(使用率N/M)
    	
    }
	private boolean contains(Key key) {
		
		return get(key)!=null;
	}
	private void resize(int cap){
		LinearProbingHashST<Key,Value> t=new LinearProbingHashST<Key,Value>(cap);
		for (int i1=0;i1<M;i1++)//创建一张新表，将原来的键放入新表中。
			if(keys[i1]==null)
				t.put(keys[i1], vals[i1]);
		keys=t.keys;
		vals=t.vals;
		M=t.M;
	}
 }
