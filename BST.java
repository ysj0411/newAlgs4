
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
public void deleteMin(){
		root=deleteMin(root);//创建根结点以便遍历，也许吧
	}
	private Node deleteMin(Node x){
		if(x.left==null) return x.right;//如果查找到对应的键，也就是把左子树全部遍历完了，左结点为空了，就返回右结点，这样每次调用或操作时就直接访问右结点忽略可当前结点，Java就会自动回收，相当于完成了删除操作。
	    x.left=deleteMin(x.left);//接着遍历左结点
	    x.N=size(x.left)+size(x.right)+1;//计数器调整
	    return x;//不知道为啥要返回自身,难道是为了平衡上面的Node，毕竟除了void其他都要返回语句
	}
	public void delete(Key key){
		root=delete(root,key);
		
	}
	private Node delete(Node x,Key key){
		if(x==null) return null;
		int cmp=key.compareTo(x.key);
		if(cmp<0) return delete(x.left,key);//如果要删除的键小于当前的键，则遍历左子树
	    if(cmp>0) return delete(x.right,key);//如果大于，则遍历右边的，直到相等
	    else{
	    	if(x.left==null) return x.right;//如果左边为空连接，则返回右链接，这样就会使当前键回收，因为一直用不上
	    	if(x.right==null) return x.left;// 同理，返回左链接
	    	Node t=x;//如果左右都有链接，则将指向即将被删除的结点的结点保存为t，以便接下来的操作。
	        x=min(t.right);//找出右子树最小的键最为后继结点，只是就完成了身份的替换,t相当于一个备份只是用来操作。
	        x.right=deleteMin(t.right);//相当于把后继结点删了吗，其实是直接返回了后继结点的右结点，这样就正好把后继结点的父节点和子结点相连，修正了父节点。
	        x.left=t.left;
	    }
	    x.N=size(x.left)+size(x.right)+1;
	    return x;
	}
	
}
