public class SequentialSearchST<Key,Value>{
	private Node first;//链表首链接
	private class Node{//定义链表结点
		private Node next;//next域
		private Key key;//键
		private Value val;//值
		public Node(Key key,Value val,Node next){
			this.key=key;
			this.val=val;
			this.next=next;//局部变量接受参数
		}
		}
	public Value get(Key key){//获取值
		for(Node x=first;x!=null;x=x.next)
			if(key.equals(x.key))
				return x.val;//命中返回值
			return null;// 不存在相应的键，返回空null
	
	}
	public void put(Key key,Value val){//构造链表，放入值
		for(Node x=first;x!=null;x=x.next)
			if(key.equals(x.key)){
				x.val=val;return;//有相同键，更新值，跳出循环
			}
		first=new Node(key,val,first);//新建结点。
	}
}