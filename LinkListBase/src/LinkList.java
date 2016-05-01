
public class LinkList<T> {
	public class Node
	{
		private T data;
		private Node next;
		public Node()
		{
			
		}
		
		public Node(T data, Node next)
		{
			this.data = data;
			this.next = next;
		}
	}
	
	private Node header; //ͷ���
	private Node tail;
	private int size;
	
	public LinkList()
	{
		this.header = null;
		this.tail = null;
	}
	
	public LinkList(T element)
	{
		header = new Node(element, null);
		this.tail = header;
		this.size++;
	}
	
	//�õ�������
	public int length()
	{
		return size;
	}
	
	//����ָ��λ��index�Ľڵ������
	public T get(int index)
	{
		return getNodeByIndex(index).data;
	}
	
	private Node getNodeByIndex(int index)
	{
		if(index < 0 || index > size - 1)
		{
			throw new IndexOutOfBoundsException("���Ա�����Խ��");
		}
		
		if(this.size == 1) return null;
		
		Node current = this.header;
		for(int i=0; i< index; i++)
		{
			current = current.next;
		}
		return current;
	}
	
	//����element�������λ��, -1��ʾ������
	public int locate(T element)
	{
		Node current = this.header;
		for(int i=0; i<size; i++)
		{
			if(current.data == element)
			{
				return i;
			}
			current = current.next;
		}
		return -1;
	}
	
	//��indexλ�ò���ڵ�element
	public void insert(T element, int index)
	{
		if(index < 0 || index > this.size)
			throw new IndexOutOfBoundsException("��������Խ��");
	
		if(this.header == null)
			add(element);
		else
		{
			if(index == 0)
			{
				addAtHeader(element);
			}
			else
			{
				Node prev = getNodeByIndex(index - 1);
				prev.next = new Node(element, prev.next);
				this.size ++;
			}	
		}
	}
	
	// ����β�巨Ϊ��������½ڵ�
	private void add(T element)
	{
		if(this.header == null)
		{
			this.header = new Node(element, null);
			this.tail = this.header;
		}
		else
		{
			Node  newNode = new Node(element, null);
			tail.next = newNode;
			tail = newNode;
		}
		 size++;  
	}
    
  //����ͷ�巨Ϊ��������½ڵ�  
  private void addAtHeader(T element){  
      header=new Node(element,header);  
      if(tail==null){  
          tail=header;  
      }  
      size++;  
  }  
    
  //ɾ��indexλ�õĽڵ�  
  public T delete(int index){  
      if(index<0||index>size-1){  
          throw new IndexOutOfBoundsException("���Ա�����Խ��");  
      }  
      Node del=null;  
      if(index==0){  
          del=header;  
          header=header.next;  
      }else{  
          Node prev=getNodeByIndex(index-1);  
          del=prev.next;  
          prev.next=del.next;  
          del.next=null;  
      }  
      size--;  
      return del.data;  
  }  
    
  //���������ɾ��һ���ڵ�  
  public T remove(){  
      return delete(size-1);  
  }  
    
  //�Ƿ�Ϊ��  
  public boolean empty(){  
      return size==0;  
  }  
  //�������  
  public void clear(){  
      header=null;  
      tail=null;  
      size=0;  
  }  
    
  public String toString(){  
      if(empty()){  
          return "[]";  
      }else{  
          StringBuilder sb=new StringBuilder("[");  
          for(Node current=header;current!=null;current=current.next){  
              sb.append(current.data.toString()+", ");  
          }  
          int len=sb.length();  
          return sb.delete(len-2, len).append("]").toString();  
      }  
  }  
  
  public static void main(String[] args) {  
      LinkList<String> list=new LinkList<String>();  
      list.insert("aaa", 0);  
      list.add("bbb");  
      list.add("ccc");  
      
      System.out.println(list.toString());  
 
      list.insert("ddd", 1);  
      System.out.println(list.toString());  
      list.delete(2);  
      System.out.println(list.toString());  
      System.out.println("ccc�������е�λ�ã�"+list.locate("ccc"));  
      System.out.println("����������2����Ԫ�أ�"+list.get(2));  
 
  }  

}  