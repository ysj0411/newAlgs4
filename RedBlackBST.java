
public class RedBlackBST<Key extends Comparable<Key>,Value> {
	private static final boolean RED=true;
	private static final boolean BLACK=false;
	private Node root;
	private class Node{//定义黑红色结点要用的属性，键，值，左结点，右结点，大小，颜色（链接指向的颜色）
		Key key;
		Value val;
		Node left,right;
		int N;
		boolean color;
	
   Node(Key key,Value val,int N,boolean color){
	   this.val=val;
	   this.key=key;
	   this.color=color;
	   this.N=N;
   }
}
	private boolean isRed(Node x){//判断是否为红连接
		if(x==null) return false;
		return x.color=RED;
		
	}
	public  int size(){//大小，其实是由公式N=size(x.left)+size(x.right)+1得到，递归
		return size(root);
	}
	private int size(Node x){
		if(x==null) return 0;
		else return x.N;
		
	}
	private Node rotateLeft(Node h){
		Node x=h.right;//定义结点x，为父节点的左结点，把x的左结点放到父节点的右结点上，h放到x的右结点上
		h.right=x.left;
		x.left=h;
		x.color=h.color;//x的颜色等于原本h的颜色
		h.color=RED;//h的颜色为红
		x.N=h.N;//调整N
		h.N=size(h.left)+size(h.right)+1;
		return x;
	}
	private Node rotateRight(Node h){
		Node x=h.left;
		h.left=x.right;
		x.right=h;
		x.color=h.color;
		h.color=RED;
		x.N=h.N;
		h.N=size(h.left)+size(h.right)+1;
		return x;
	}
	private void flipColors(Node h){//翻转颜色
		h.color=RED;
		h.left.color=BLACK;
		h.right.color=BLACK;
		
		
	}
	public void put(Key key,Value val){
		root=put(root,key,val);
		root.color=BLACK;
	}
	private Node put(Node h,Key key ,Value val){
		if(h==null) return new Node(key,val,1,RED);//如果结点不存在则创建，大小为1，颜色为红色
		int cmp=key.compareTo(h.key);//比较大小，查找键和当前键比较
		if(cmp<0) return put(h.left,key,val);//如果小于，放左边
		else if(cmp>0) return put(h.right,key,val);//如果大于，放右边
		else h.val=val;//如果存在则更新值
		
		if(isRed(h.right)&&!isRed(h.left)) h=rotateLeft(h);//如果左链接是黑的，右链接是红的，则左翻转
		if(isRed(h.left)&&isRed(h.left.left)) h=rotateRight(h);//如果左链接是红的，左左链接也是红的，又翻转
		if(isRed(h.left)&&isRed(h.right)) flipColors(h);//如果左右链接都是红的，则改变颜色，即父节点变红其他变黑
		
		h.N=size(h.left)+size(h.right)+1;
		return h;
		
	}
}