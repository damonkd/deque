
public class LinearNode<T> {

	//modified code from deque
	private LinearNode<T> next;
	private LinearNode<T> previous;
	private T element;
	
	public LinearNode()
	{
		next = null;
		element = null;
		previous = null;
	}
	
	public LinearNode(T elem)
	{
		next = null;
		element = elem;
		previous = null;
	}
	
	public void setNext(LinearNode<T> node)
	{
		next = node;
	}

	public void setPrevious(LinearNode<T> node)
	{
		//if(next==null)
		
		previous = node;
		
	}
	
	
	public LinearNode<T> getNext()
	{
		return next;
	}

	public LinearNode<T> getPrevious()
	{
		return previous;
	}
	
	
	public T getElement()
	{
		return element;
	}
	
	public void setElement(T elem)
	{
		element = elem;
	}
	
	
}
