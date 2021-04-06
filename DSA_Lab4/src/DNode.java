
public class DNode {

	private Object item;
	private DNode next;
	private DNode back;

	  public DNode(Object newItem) 
	  {
	    item = newItem;
	    next = this;
	    setBack(this);
	  } 

	  public DNode(Object newItem, DNode nextNode, DNode back) 
	  {
	    item = newItem;
	    next = nextNode;
	    this.back=back;
	  } 

	  public void setItem(Object newItem) 
	  {
	    item = newItem;
	  } 

	  public Object getItem() 
	  {
	    return item;
	  } 

	  public void setNext(DNode nextNode) 
	  {
	    next = nextNode;
	  } 

	  public DNode getNext() 
	  {
	    return next;
	  }

	public DNode getBack() {
		return back;
	}

	public void setBack(DNode back) {
		this.back = back;
	}
} // end class Node

