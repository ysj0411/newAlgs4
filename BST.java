
public class BST<Key extends Comparable<Key>, Value> {
	private Node root;//根结点
	private class Node{
		private Key key;//键
		private Value val;//值
		private Node left,right;//指向子树的链接
		private int N;//以该结点为根的子树中的结点数
		public Node(Key key,Value val,int N){
			this.key=key;this.val=val;this.N=N;
		}
	}
	public int  size(){
		return size(root);}
		private int size(Node x){
			if(x==null) return 0;//如果为空链接，返回0
			else return x.N;//否则返回Node.N即结点子树中的结点数
		}
	public Value get(Key key){
		return get(root,key);//调用下方的查找方法，且从根结点开始查询
	}
	private Value get(Node x,Key key){
		if(x==null) return null;
		int cmp=key.compareTo(x.key);//比较键的大小
		if(cmp<0) return get(x.left,key);//如果小于根结点则查询左子结点，递归（调用自身）
		else if(cmp>0) return get(x.right,key);//如果大于根结点则查询右子结点
		else return x.val;// 不然就是找到了，返回当前结点的值
		
	}
	 public void put(Key key,Value val){
		 root=put(root,key,val);
		 }
	 private Node put(Node x,Key key,Value val){
		 if(x==null ) return new Node(key,val,1);//如果 key不存在，这把键值插入到该子树中
		 int cmp=key.compareTo(x.key);//比较键的大小
		 if (cmp<0) x.left=put(x.left,key,val);//如果小于则遍历左子结点
		 else if(cmp>0) x.right=put(x.right,key,val);//如果大于则遍历右子结点
		 else x.val=val;//否则更新值，即这个键存在的话
		 x.N=size(x.left)+size(x.right)+1; //保证二叉树成立
		 return x;
		 
	 }
	
}
