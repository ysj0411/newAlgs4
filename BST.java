
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
 public Key min(){
		 return min(root).key;//返回根结点的键
	 }
	private Node min(Node x){
		if(x.left==null) return x;//如果左子结点不存在，则说明当前数就是最小值了，所以返回当前键
		return min(x.left);//否则递归查询
	}
	public Key max(){//与上面相反
		return max(root).key;
	}
	private Node max(Node x){
		if(x.right==null) return x;
		return max(x.right);
	}
	public Key floor(Key key){//向上取整
		Node x=floor(root,key);
		if(x==null) return null;
		return x.key;
	}
	private Node floor(Node x,Key key){
		if(x==null) return null;//如果根结点不存在则返回null，因为下面是向上取整，只要root存在就返回不了null
		int cmp=key.compareTo(x.key);//当前键与查找键比较
		if(cmp==0) return x;//如果等于，则不用向上取整。直接输出
		if(cmp<0) return floor(x.left,key);//如果小于，则查找左子结点数
		Node t=floor(x.right,key);//定义结点t为递归的右结点查找
		if(t!=null) return t;//如果右结点存在，则继续递归
		else return x;//右子结点树不存在这样的键，则返回小于等于key的最大键就是父节点。
		
		
	}
	public Key ceiling(Key key){// 向下取整
		Node x=floor(root,key);
		if(x==null) return null;
		return x.key;
	}
	private Node ceiling(Node x,Key key){
		if(x==null) return null;//如果根结点不存在则返回null，因为下面是向下取整，只要root存在就返回不了null
		int cmp=key.compareTo(x.key);//当前键与查找键比较
		if(cmp==0) return x;//如果等于，则不用向下取整。直接输出
		if(cmp>0) return floor(x.right,key);//如果大于，则查找右子结点数
		Node t=floor(x.left,key);//定义结点t为递归的左结点查找
		if(t!=null) return t;//如果左结点存在，则继续递归
		else return x;//左子结点树不存在这样的键，则返回大于等于key的最大键就是父节点。
		
		
	}
	
}
