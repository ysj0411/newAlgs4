import java.util.Iterator;



public class Stack<Item > implements Iterable<Item> {
     private Node first;
     private int N;
     private class Node{
    	 Item item;
    	 Node next;
     }
     public boolean isEmpty(){return first==null;}
     public int size(){return N;}
     public void push(Item item){
    	 Node oldfirst=first;
    	 first=new Node();
    	 first.item=item;
    	 first.next=oldfirst;
    	 N++;
     }
     public Item pop(){
    	 Item item=first.item;
    	 first=first.next;
    	 N--;
    	 return item;
    	 
     }
     public Iterator<Item> iterator() {
			
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