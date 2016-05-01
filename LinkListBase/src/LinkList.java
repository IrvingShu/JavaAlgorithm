
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
	
	private Node header; //头结点
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
	
	//得到链表长度
	public int length()
	{
		return size;
	}
	
	//返回指定位置index的节点的数据
	public T get(int index)
	{
		return getNodeByIndex(index).data;
	}
	
	private Node getNodeByIndex(int index)
	{
		if(index < 0 || index > size - 1)
		{
			throw new IndexOutOfBoundsException("线性表索引越界");
		}
		
		if(this.size == 1) return null;
		
		Node current = this.header;
		for(int i=0; i< index; i++)
		{
			current = current.next;
		}
		return current;
	}
	
	//返回element在链表的位置, -1表示不存在
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
	
	//在index位置插入节点element
	public void insert(T element, int index)
	{
		if(index < 0 || index > this.size)
			throw new IndexOutOfBoundsException("线性索引越界");
	
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
	
	// 采用尾插法为链表添加新节点
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
    
  //采用头插法为链表添加新节点  
  private void addAtHeader(T element){  
      header=new Node(element,header);  
      if(tail==null){  
          tail=header;  
      }  
      size++;  
  }  
    
  //删除index位置的节点  
  public T delete(int index){  
      if(index<0||index>size-1){  
          throw new IndexOutOfBoundsException("线性表索引越界");  
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
    
  //从链表后面删除一个节点  
  public T remove(){  
      return delete(size-1);  
  }  
    
  //是否为空  
  public boolean empty(){  
      return size==0;  
  }  
  //清空链表  
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
      System.out.println("ccc在链表中的位置："+list.locate("ccc"));  
      System.out.println("链表中索引2处的元素："+list.get(2));  
 
  }  

}  