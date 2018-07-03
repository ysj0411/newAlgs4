import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
        private Node first;//指向最早添加的结点的链接
        private Node last;//指向最近添加的结点的链接
        private int N;//队列中元素数量
        private class Node
        {
        	Item item;
        	Node next;
        }
        public boolean isEmpty(){
        	return first==null;
        }
        public int size(){return N;}
	    public void enqueue(Item item){//表尾添加一个元素，相当于进
		Node oldlast=last;//保存指向尾结点的链接，相当于原本的表头换了个名字，其他不变，而原本的则变为空了
		last=new Node();// 新结点赋予last
		last.item=item;//item域设为item就是输入的那个值，Item是占位符代表所有的数据类型
		last.next=null;//next域为空
		if(isEmpty()) first=last;//如果队列为空，就认为只有头，直接创建头，而使尾为空。
		else         oldlast.next=last;//不然从尾部添加
		N++;// 链表大小加一
		
		
	}
	    public  Item dequeue(){//从表头删除元素。这样就完成了先进先出，因为后进的添加在了尾部
	    	Item item=first.item;//因为要提取表头元素，所以要保存item域
	    	first=first.next;//让first成为一个孤儿，这样就会被回收，first.next则指向下一个item域
	    	if(isEmpty()) last=null;//如果不存在队列就把last设为null
	    	N--;//每次改变统计数
	    	return item;//返回值
	    	
	    }
		@Override
		public Iterator<Item> iterator() {
			// TODO Auto-generated method stub
			return null;
		}


}