
class Node
{
	public  int data;
	public Node next;
		
	public Node()
	{
		this.data = 0;
		this.next = null;
	}
		
	public Node(int data)
	{
		this.data = data;
		this.next = null;
	}
}
	

	
public class LinkListAdd {
	public static void printList(Node p)
	{
		Node tail = p.next;
		while(tail != null)
		{
			System.out.print(tail.data);
			tail = tail.next;
		}
	}
	
	public static Node Add(Node header1, Node header2)
	{
		Node sum = new Node();
		Node tail = sum;
		Node p1 = header1.next;
		Node p2 = header2.next;
		int carry = 0;
		int value = 0;
		
		while(p1 != null && p2 != null)
		{
			value = p1.data + p2.data + carry;
			carry = value / 10;
			value %= 10;
			Node currentNode = new Node(value);
			tail.next = currentNode;
			tail = currentNode;
			p1 = p1.next;
			p2 = p2.next;
		}
		//处理较长的链
		Node longP = new Node();
		if(p1 != null) longP = p1;
		if(p2 != null) longP = p2;
		while(longP != null)
		{
			value = longP.data + carry;
			carry = value / 10;
			value %= 10;
			Node currentNode = new Node(value);
			tail.next = currentNode;
			tail = currentNode;
			longP = longP.next;
		}
		if(carry !=0 )
		{
			tail.next = new Node(carry);
		}
		
		
		return sum;
	}
	
	public static void main(String[] args) {
		Node header1 = new Node();
		for(int i=0; i<6; i++)
		{
			Node node = new Node((int) (Math.random() * 10 % 10));
			node.next = header1.next;
			header1.next = node;
			
		}
	
		Node header2 = new Node();
		for(int i=0; i<9; i++)
		{
			Node node = new Node((int) (Math.random() * 10 % 10));
			node.next = header2.next;
			header2.next = node;
		}
		System.out.println("Start");
		printList(header1);
		System.out.println("");
		printList(header2);
		System.out.println("");
		Node sum = Add(header1, header2);
		printList(sum);
		
	}
	
}
