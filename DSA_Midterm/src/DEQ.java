
public class DEQ<T> extends QueueRA<T> implements ExtendedQueueInterface{

	@Override
	public void enqueueFirst(Object newItem) throws ExtendedQueueException {
		if(numitems==que.length) {
			resize();
		}
		front=(front+que.length-1)%que.length;
		que[front]=newItem;
		numitems++;
	}

	@Override
	public Object dequeueLast() throws ExtendedQueueException {
		if(isEmpty()) {
			throw new ExtendedQueueException("Queue empty");
		}
		back=(back+que.length-1)%que.length;
		Object result=que[back];
		que[back]=null;
		return result;
	}

	@Override
	public Object peekLast() throws ExtendedQueueException {
		int temp=(back+que.length-1)%que.length;
		Object result=que[temp];
		return result;
	}

	
}
