import java.util.Scanner;


public class CellList
{
	//
	// INNER CLASS
	//
	public class CellNode
	{
		private CellPhone cellphone;
		private CellNode next;
		
		
		 public CellNode() 
		 {
			 this.cellphone = null;
			 this.next = null;
	     }
		 
		 public CellNode(CellPhone cellphone, CellNode next) 
		 {
			 this.cellphone = cellphone;
			 this.next = next;
		 }
		 
		 //copy constructor
		 public CellNode(CellNode cellnode, long serialNum) 
		 {
		     this.cellphone = cellnode.cellphone.clone(serialNum);
		     this.next = cellnode.next;
	     }
		 
	     public CellNode clone(long serialNum) 
	     {
	    	 return new CellNode(this, serialNum);
	     }

		public CellPhone getCellphone()
		{
			return cellphone;
		}

		public void setCellphone(CellPhone cellphone)
		{
			this.cellphone = cellphone;
		}

		public CellNode getNext()
		{
			return next;
		}

		public void setNext(CellNode next)
		{
			this.next = next;
		}
	          
	}
	//
	//OUTER CLASS
	//
	private CellNode head;
	private int size = 0;
	Scanner scanner = new Scanner(System.in);
	
	public CellList()
	{
		this.head = null;
		this.size = 0;
	}
	
	public CellList(CellList list)
	{
		System.out.println("\nCopying list");
		long serialNum;
		
		if(list.head == null)
		{
			this.head = null;
			System.out.println("list is empty");
		}
		else
		{
			this.head = null;	
			CellNode t1, t2, t3;	// create 3 temporary pointers
			
			t1 = list.head;
			t2 = t3 = null;
			while(t1 != null)	
			{
				if (this.head == null)	// this happens only once
				{
					System.out.println("Enter serial number to new copied node: ");
					serialNum = scanner.nextLong();
					t2 = new CellNode(t1, serialNum);	
					this.head = t2;
				}
				else 
				{
					System.out.println("Enter serial number to new copied node: ");
					serialNum = scanner.nextLong();
					t3 = new CellNode(t1, serialNum);	
					t2.next = t3;
					t2 = t3;												
				}
				t1 = t1.next;
			}
			
			t2 = t3 = null; 	// t1 is already null by now
			this.size = list.size;		
		}
			
	}
	
	
	/**
	 * this method adds a cell to the start
	 * @param (Cellphone cell)
	 */
	public void addToStart(CellPhone cell)
	{
		CellNode node = new CellNode(cell, head);	     
		this.head = node; 						
		node = null;
		size++;
		if(size == 1)
			System.out.println();
		System.out.println("size of your list is " + size);
	}

	public void insertAtIndex(CellPhone cell, int index)
	{
		try
		{
			if(index > this.size || index < 0)
				throw new NoSuchElementException("Not a valid index");
		}
		catch(NoSuchElementException e)
		{
			String s = e.getMessage();
			System.out.println(s);
			System.exit(0);
		}
		
		if(this.head == null)
		{
			System.out.println("List is empty");
			return; //use return to exit from a method
		}
		
		if (index == 0)
		{
			addToStart(cell);
			return;
		}
		
		else
		{
			int i = 0;
			CellNode temp1 = this.head;

			while(i != index-1) //index-1 cuz we want to make it the one before to apply next
			{
				temp1 = temp1.next;
				i++;
			} 

			CellNode temp2 = temp1.next;
		
			temp1.next = new CellNode(cell,temp2);
			
		}
		size++;
		System.out.println("You have successfully added element at index " + index + ", size of your list is " + size);
	}
	
	public void deleteFromIndex(int index)
	{
		try
		{
			if(index > this.size || index < 0)
				throw new NoSuchElementException("Not a valid index");
		}
		catch(NoSuchElementException e)
		{
			String s = e.getMessage();
			System.out.println(s);
			System.exit(0);
		}
		
		if(this.head == null)
		{
			System.out.println("List is empty");
			return;
		}
		
		if(index == 0)
		{
			CellNode temp1 = this.head;
			this.head = temp1.next;
			temp1 = null;
		}
		
		else
		{
			int i = 0;
			CellNode temp1 = this.head;

			while(i != index-1) //index-1 cuz we want to make it the one before to apply next
			{
				temp1 = temp1.next;
				i++;
			} 
			
			CellNode temp2 = temp1.next;
			temp1.next = temp1.next.next;
			temp2 = null;
		}
		size--;
		System.out.println("size of your list is " + size + " after deleting element from index " + index);
	}
	
	public void deleteFromStart()
	{
		if(head ==null)
		{
			System.out.println("list is empty");
		}
		else
		{
			CellNode temp1 = this.head;
			this.head = temp1.next;
			temp1 = null;
			size--;
			System.out.println("the size of your list is" + size + " after deleting the first element of your list");
		}
	}
	
	
	public void replaceAtIndex(CellPhone c,int index)
	{
		if(index > this.size-1 || index < 0)
		{
			System.out.println("index does not exist");
			return;
		}
		else
		{
			if(index == 0 )
			{
				deleteFromStart();
				addToStart(c);
			}	
			else
			{
				deleteFromIndex(index);
				insertAtIndex(c,index);
				
			}	
		}
	}
	
	public CellNode find(long serialNum)
	{
		CellNode temp = this.head;
		
		while(temp != null)
		{
			if (temp.cellphone.getSerialNum() == serialNum)
				return temp;		//can result in privacy leak
			temp = temp.next;
		}
		return null;			// value was not found in the list
	}
	
	public boolean contains(long serialNum)
	{
		if(find(serialNum) != null)
			return true;
		else 
			return false;
	}
	
	public void showContents()
	{
		CellNode temp = this.head;
		if (temp == null)
			System.out.println("There is nothing to display; list is empty." );
		else
		{
			System.out.println("The current size of the list is " + size + ". Here are the contents of the list\n=======================================================================");
			int count = 1;
			while(temp != null)
			{
				System.out.println("Cellphone" + count + " " + temp.cellphone +  " ---> ");
				temp = temp.next;
				count++;
			}
		}
	}
	
	public boolean equals(CellList cellList)
	{
		CellNode temp1 = this.head;
		CellNode temp2 = cellList.head;
		
		if (temp1==null || temp2==null || this.size != cellList.size)
			return false;
		
		else 
		{
			int count = 0;
			while(this.size != count)
			{
				if(temp1.cellphone.equals(temp2.cellphone))
				{
					temp1 = temp1.next;
					temp2 = temp2.next;
					count++;
				}
				else
					return false;
			}
			return true;
		}
	}

	
	//Getters and Setters

	public CellNode getHead()
	{
		return head;
	}

	public void setHead(CellNode head)
	{
		this.head = head;
	}

	public int getSize()
	{
		return size;
	}

	public void setSize(int size)
	{
		this.size = size;
	}
	
	
}
