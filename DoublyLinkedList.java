package linkedList;

class Node1<T>
{
	T data;
	Node1<T> next;
	Node1<T> prev;
	public Node1(T data)
	{
		this.data=data;
	}
}
class Double<T>
{
	private Node1<T> head;
	private Node1<T> tail;
	private int size;
	
	public Double()
	{
		this.size=0;
	}
	public int size()
	{
		return this.size;
	}
	public boolean isEmpty()
	{
		return this.size==0;
	}
	public void addFirst(T value)
	{
		size++;
		Node1<T> n=new Node1<T>(value);
		if(head==null)
		{
			head=n;
			tail=n;
			return;
		}
		n.next=head;
		head.prev=n;
		head=n;
		size++;
		
	}
	public void addLast(T value)
	{
		if(size==0)
		{
			addFirst(value);
			return;
		}
		Node1<T> n=new Node1<>(value);
		tail.next=n;
		n.prev=tail;
		tail=n;
		size++;
	}
	public Node1<T> get(int index)
	{
		Node1<T> temp=head;
		for(int i=1;i<index;i++)
		{
			temp=temp.next;
		}
		return temp;
	}
	public void add(T value,int index)
	{
		if(index==0)
		{
			addFirst(value);
			return;
		}
		if(index==size-1)
		{
			addLast(value);
			return;
		}
		Node1<T> temp=get(index);
		Node1<T> n=new Node1<>(value);
		n.prev=temp;
		n.next=temp.next;
		temp.next=n;
		size++;
	}
	public void deleteFirst()
	{
		if(size==0)
			return;
		head=head.next;
		size--;
	}
	public void deleteLast()
	{
		if(size==1)
		{
			deleteFirst();
			return;
		}
		tail=tail.prev;
		tail.next=null;
		size--;
	}
	public void delete(int index)
	{
		if(index==0)
		{
			deleteFirst();
			return;
		}
		if(index==size-1)
		{
			deleteLast();
			return;
		}
		Node1<T> temp=get(index);
		temp.next=temp.next.next;
		size--;
	}
	public void print()
	{
		Node1<T> temp=head;
		while(temp.next!=null)
		{
			System.out.print(temp.data+"->");
			temp=temp.next;
		}
		System.out.println(temp.data);
	}
}
public class DoublyLinkedList {

	public static void main(String[] args) {
		Double<Integer> a=new Double<Integer>();
		a.addFirst(5);
		a.addFirst(4);
		a.addFirst(3);
		a.addFirst(2);
		a.addFirst(1);
		a.addLast(6);
		a.add(9, 3);
		a.deleteFirst();
		a.deleteLast();
		a.delete(2);
		a.print();
	}

}
