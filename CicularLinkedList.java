package linkedList;
class Circular<T>
{
	private Node<T> head;
	private Node<T> tail;
	private int size;
	public Circular()
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
		Node<T> n=new Node<>(value);
		if(head==null)
		{
			head=n;
			tail=n;
			tail.next=head;
			size++;
			return;
		}
		tail.next=n;
		n.next=head;
		head=n;
		size++;
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
		Node<T> n=new Node<>(value);
		Node<T> temp=get(index);
		n.next=temp.next;
		temp.next=n;
		size++;
	}
	public Node<T> get(int index)
	{
		Node<T> temp=head;
		for(int i=1;i<index;i++)
		{
			temp=temp.next;
		}
		return temp;
	}
	public void addLast(T value)
	{
		if(size==0)
		{
			addFirst(value);
			return;
		}
		Node<T> n=new Node<>(value);
		tail.next=n;
		tail=n;
		tail.next=head;
		size++;
	}
	public void deleteFirst()
	{
		if(size==0)
			return;
		head=head.next;
		tail.next=head;
		size--;
	}
	public void deleteLast()
	{
		if(size==1)
		{
			deleteFirst();
			return;
		}
		Node<T> temp=get(size-1);
		temp.next=null;
		tail=temp;
		size--;
	}
	public void delete(int index)
	{
		if(index==1)
		{
			deleteFirst();
			return;
		}
		if(index==size-1)
		{
			deleteLast();
			return;
		}
		Node<T> temp=get(index);
		if(temp.next!=null)
			temp.next=temp.next.next;
		size--;
	}
	public void print()
	{
		Node<T> temp=head;
		while(temp!=tail)
		{
			System.out.print(temp.data+"->");
			temp=temp.next;
		}
		System.out.println(temp.data);
	}
}
public class CicularLinkedList {

	public static void main(String[] args) {
		Circular<Integer> a=new Circular<Integer>();
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
