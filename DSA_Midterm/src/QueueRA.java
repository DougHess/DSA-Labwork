
public class QueueRA<T> implements QueueInterface {
	protected Object[] que;
	protected int front;
	protected int back;
	protected int numitems;
	
	public QueueRA() {
		que=(T[]) new Object[3];
		front=0;
		back=0;
		numitems=0;
	}

	@Override
	public boolean isEmpty() {
		boolean empty=true;
		if(numitems>0) {
			empty=false;
		}
		return empty;
	}
	
	protected void resize() {
		Object[] newque= (T[]) new Object[que.length*2];
		for(int i = 0; i<numitems; i++) {
			newque[i]=que[front];
			front=(front+1)%que.length;
		}
		front=0;
		back=numitems;
		que=newque;
	}

	@Override
	public void enqueue(Object newItem) throws QueueException {
		if (numitems==que.length) {
			resize();
		}
		que[back]=newItem;
		back=(back+1)%que.length;
		numitems++;
	}

	@Override
	public Object dequeue() throws QueueException {
		if(isEmpty()) {
			throw new QueueException("Empty Queue");
		}
		Object result = que[front];
		que[front]=null;
		front=(front+1)%que.length;
		numitems--;
		return result;
	}

	@Override
	public void dequeueAll() {
		que=(T[]) new Object[3];
		front=0;
		back=0;
		numitems= 0;
	}

	@Override
	public Object peek() throws QueueException {
		if(isEmpty()) {
			throw new QueueException("Empty Queue");
		}
		Object result=que[front];
		return result;
	}
	
	public String toString() {
		String s = "";
		int temp=front;
		if (isEmpty()) {
			s = "Empty Queue";
		}
		for (int i= 0; i<numitems;i++) {
			s+=que[temp]+", ";
			temp=(temp+1)%que.length;
		}
		
		return s;
	}

}
