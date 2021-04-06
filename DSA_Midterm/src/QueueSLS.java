
public class QueueSLS<T> implements ExtendedQueueInterface{
	private Node<T> head;
	private Node<T> tail;
	protected int numitems;
	
	public QueueSLS() {
		head=null;
		tail=null;
		numitems =0;
	}

	@Override
	public boolean isEmpty() {
		boolean empty= true;
		if(numitems>0) {
			empty=false;
		}
		return empty;
	}

	@Override
	public void enqueue(Object newItem) throws QueueException {
		if (isEmpty()) {
			Node<T> n = new Node(newItem);
			head= n;
			tail=n;
		}
		else {
			Node<T> n = new Node(newItem);
			tail.setNext(n);
			tail= tail.getNext();
		}
		numitems++;
		
	}

	@Override
	public Object dequeue() throws QueueException {
		if (isEmpty()) {
			throw new QueueException("no array");
		}
		Object result = head.getItem();
		head=head.getNext();
		numitems--;
		return result;
	}

	@Override
	public void dequeueAll() {
		head=null;
		tail=null;
		numitems=0;
		
	}

	@Override
	public Object peek() throws QueueException {
		Object result = head.getItem();
		return result;
	}

	@Override
	public void enqueueFirst(Object newItem) throws ExtendedQueueException {
		head = new Node(newItem, head);
		numitems++;
	}

	@Override
	public Object dequeueLast() throws ExtendedQueueException {
		if (isEmpty()) {
			throw new ExtendedQueueException("empty Queue");
		}
		Object result = tail.getItem();
		Node<T> n = head;
		while(!(n.getNext()==tail)) {
			n=n.getNext();
		}
		tail=n;
		n.setNext(null);
		numitems--;
		return result;
	}

	@Override
	public Object peekLast() throws ExtendedQueueException {
		Object result= tail.getItem();
		return result;
	}
	public String toString() {
		String s= "";
		if (isEmpty()) {
			s="no queue";
		}
		Node<T> n = head;
		for (int i = 0; i<numitems; i++) {
			s+=n.getItem()+", ";
			n=n.getNext();
		}
		return s;
	}
}
