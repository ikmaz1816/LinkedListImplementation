package linkedList;

class Node<T>
{
	T data;
	Node<T> next;
	public Node(T data)
	{
		this.data=data;
	}
}
class Single<T>
{
	private Node<T> head;
	private Node<T> tail;
	private int size;
	
	public Single()
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
	public void add(T value)
	{
		Node<T> n=new Node<>(value);
		if(head==null)
		{
			head=n;
			tail=n;
		}
		else
		{
			tail.next=n;
			tail=n;
		}
		size++;
	}
	public void addFirst(T value)
	{
		size++;
		Node<T> n=new Node<>(value);
		if(head==null)
		{
			head=n;
			tail=n;
			return;
		}
		n.next=head;
		head=n;
		
		
	}
	public void addLast(T value)
	{
		size++;
		Node<T> n=new Node<>(value);
		if(head==null)
		{
			head=n;
			tail=n;
			return;
		}
		tail.next=n;
		tail=n;
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
		Node<T> temp=get(index);
		Node<T> n=new Node<>(value);
		n.next=temp.next;
		temp.next=n;
		size++;
		
	}
	public void deleteFirst()
	{
		if(head!=null)
		{
			head=head.next;
			size--;
		}
	}
	public void delete(T value)
	{
		Node<T> temp=get(value);
		if(temp==null)
			return;
		if(temp.next!=null)
		{
			temp.next=temp.next.next;
			size--;
		}
	}
	public void delete(int index)
	{
		Node<T> temp=get(index);
		if(temp==null)
			return;
		if(temp.next!=null)
		{
		temp.next=temp.next.next;
		size--;
		}
	}
	public Node<T> get(T value)
	{
		Node<T> temp=head;
		while(!(temp.next.data.equals(value)))
		{
			temp=temp.next;
		}
		return temp;
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
	public void deleteLast()
	{
		Node<T> temp=get(size-2);
		if(size<1)
			return;
		temp.next=null;
		tail=temp;
		size--;
	}
	public void print()
	{
		Node<T> temp=head;
		while(temp.next!=null)
		{
			System.out.print(temp.data+"->");
			temp=temp.next;
		}
		System.out.println(temp.data);
	}
}
public class SinglyLinkedList {
	
	public static void main(String[] args) {
		Single<String> s=new Single<>();
		s.add("Imran");
		s.add("Khan");
		s.add("Mohammed");
		s.add("Abrar");
		s.print();
		s.addFirst("Ruksana");
		s.addLast("Zaid");
		s.add("Moin", 4);
		s.print();
		s.deleteFirst();
		s.print();
		s.deleteLast();
		s.print();
		s.delete("Moin");
		s.print();
		s.delete(1);
		s.print();
	}

}
