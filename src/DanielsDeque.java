/**
 * This program provides an implementation of the Deque interface
 * and demonstrates it.
 * 
 * @author (your name), Acuna
 * @version (version)
 */
import java.util.NoSuchElementException;
    
//TODO: implement.
public class DanielsDeque<Item> implements Deque<Item> {

	private int count;
	private LinearNode<Item> head, tail;
	
	public DanielsDeque()
	{
		count =0;
		head = null;
		tail = null;
	}
	
	
	public void	enqueueFront(Item element)
	{
		LinearNode<Item> front = new LinearNode<Item> (element);
		if(head == null)
			tail = front;
		
		else
		{
			front.setNext(head);
			head.setPrevious(front);
			front.setPrevious(null);
			
			
		}
		
			
			head = front;
		
		
		count++;
	}
	
	public void enqueueBack(Item element)
	{
		LinearNode<Item> back = new LinearNode<Item> (element);
		if(tail == null)
		head = back;
			
		else
		{
			tail.setNext(back);
			back.setPrevious(tail);
			back.setNext(null);
		}
		
			tail = back;
		
		count++;
	}
	
	/**  
     * Removes and returns the element at the front of this deque.
     * Throws an exception if the deque is empty.
     * @return the element at the front of this deque
     * @throws NoSuchElementException if the deque is empty
     */
	public Item dequeueFront()throws NoSuchElementException
	{
		Item dqFront = null;
		if(head == null)
			throw new NoSuchElementException ("deque");
		
		if(count > 1) 
		{
		dqFront = head.getElement();
		head = head.getNext();
		head.setPrevious(null);
		if(head == null)
			tail = null;
		}
		else {
			head = head.getNext();
			tail = tail.getPrevious();
			head = null;
			tail = null;
			dqFront =null;
		}
		count--;
		return dqFront;
		
	
	
	}
	
	/**  
     * Removes and returns the element at the back of this deque.
     * Throw an exception if the deque is empty.
     * @return the element at the back of the deque. 
     * @throws NoSuchElementException if the deque is empty
     * */
	public Item dequeueBack()throws NoSuchElementException
	{
		Item dqBack = null;
		//LinearNode<Item> back = new LinearNode<Item> (element);
		if(isEmpty())
			throw new NoSuchElementException ("deque");
		
		if(count > 1) 
		{
		dqBack = tail.getElement();
		tail = tail.getPrevious();
		tail.setNext(null);
		if(head == null)
		{
		tail = null;
		}
		}
		else
		{
			head = head.getNext();
			tail = tail.getPrevious();
			head =null;
			tail =null;
			dqBack = null;
		}
		count --;
		return dqBack;
	}
	
	public Item first() throws NoSuchElementException
	{
		if(isEmpty())
			throw new NoSuchElementException ("deque");
		return head.getElement();
	}
	
	public Item last()throws NoSuchElementException
	{
		if(isEmpty())
			throw new NoSuchElementException ("deque");
		return tail.getElement();
	}
	
	
	 /**  
     * Returns true if a given element exists inside the deque, false
     * otherwise.
     * @return if element exists in list
     */
	public boolean contains(Item element)
	{
	LinearNode<Item> tmp = head;
	
	boolean test = false;
	while(tmp != null)
	{
		if (tmp.getElement() == element)
			test = true;
		
			tmp = tmp.getNext();
	}
	return test;
	}
	
	  /**  
     * Returns true if this deque is empty and false otherwise.
     * @return if deque empty
     */
	public boolean isEmpty()
	{
		LinearNode<Item> tmp = head;
		
		boolean test = true;
		while(tmp != null)
		{
			if (tmp.getElement() != null)
				test = false;
			
				tmp = tmp.getNext();
		}
		return test;
	}
	
  
	public int size()
	{
		return count;
	}

	
	public String toString()
	{
	LinearNode<Item> tmp = head;
		String toString = "";
		
		while(tmp != null)
		{
			toString += (tmp.getElement()) + " ";
			
				tmp = tmp.getNext();
		}
		return toString;
	}


	/**
     * Program entry point for deque. 
     * @param args command line arguments
     */    
    public static void main(String[] args) {
        DanielsDeque<Integer> deque = new DanielsDeque<>();

        //standard queue behavior
        deque.enqueueBack(3);
        deque.enqueueBack(7);
        deque.enqueueBack(4);
        deque.dequeueFront();        
        deque.enqueueBack(9);
        deque.enqueueBack(8);
        deque.dequeueFront();
        System.out.println("size: " + deque.size());
        System.out.println("contents:\n" + deque.toString() +"\n");   

        //deque features
        System.out.println(deque.dequeueFront());        
        deque.enqueueFront(1);
        deque.enqueueFront(11);                         
        deque.enqueueFront(3);                 
        deque.enqueueFront(5);         
        System.out.println(deque.dequeueBack());
        System.out.println(deque.dequeueBack());        
        System.out.println(deque.last());                
        deque.dequeueFront();
        deque.dequeueFront();        
        System.out.println(deque.first());        
        System.out.println("size: " + deque.size());
        System.out.println("contents:\n" + deque.toString() +"\n");            
    
        DanielsDeque<Integer> deque2 = new DanielsDeque<>();
        deque2.enqueueFront(1);
        System.out.println(deque2.dequeueBack());
        System.out.println("size: " + deque2.size());
        System.out.println("contents:\n" + deque2.toString() +"\n");
   
        DanielsDeque<Integer> deque3 = new DanielsDeque<>();
        deque3.enqueueFront(1);
        deque3.enqueueFront(42);
        System.out.println(deque3.dequeueFront());
        System.out.println("size: " + deque3.size());
        System.out.println("contents:\n" + deque3.toString() +"\n");
        
        DanielsDeque<String> deque4 = new DanielsDeque<>();
        deque4.enqueueFront("Abba");
        deque4.enqueueFront("the Hut");
        deque4.enqueueFront("Jabba");
        System.out.println(deque4.dequeueBack());
        System.out.println("size: " + deque4.size());
        System.out.println("contents:\n" + deque4.toString()  +"\n");
        
        
      
    
    
    }
} 