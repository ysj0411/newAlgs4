mport java.util.Iterator;
public class Bag <Item> implements Iterable<Item>{
	private Node first;//链表的首结点
	private int N;//链表大小
    private class Node{
    	Item item;
    	Node next;
    }
    public boolean isEmpty(){return N==0;}
    public int size(){return N;}
    public void add(Item item){
    	Node oldfirst =first;//保存原首结点
    	first= new Node();// 创建新指针
    	first.item=item;
    	first.next=first;//指向原首结点，构造新链接
    }
    
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();//保证了类必然会实现hashNext(),next()和remove()供用例的foreach语法使用、
	}
	private class ListIterator implements Iterator<Item>{//维护了一个实例变量currrent来记录链表当前的结点。hashNext()方法检测current是否为null，next()方法会保存当前元素的引用。将current变量指向链表的下个结点并返回所保存的引用
		private Node current =first;
		public boolean hasNext(){
			return current !=null;
		}
		public void remove(){}
		public Item next(){
			Item item=current.item;
			current = current.next;
			return item;
		}
	
	
	}
     
}
