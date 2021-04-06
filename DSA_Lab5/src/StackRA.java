
public class StackRA<T> implements StackInterface<T>{
	
	private T[] list;
	protected int top;

	public StackRA() {
		list =(T[]) new Object[3];
		top=-1;
	}
	public boolean isEmpty() {
		boolean isempty=false;
		if(top ==-1) {
			isempty=true;
		}
		return isempty;
	}
	public void popAll() {
		list = (T[]) new Object[3];
		top=-1;
	}
	protected void resize() {
		Object[] newlist = new Object[(list.length)*2];
		for (int i=0;i<=top;i++) {
		newlist[i] = list[i];
		}
		list = (T[]) newlist;
	}
	public void push(T item) throws StackException {
		if (top==list.length) {
			resize();
		}
		list[++top]=item;
	}
	public T pop() throws StackException {
		Object o=list[top];
		list[top--]=null;
		return (T) o;
	}
	public T peek() throws StackException {
		T result = (T) list[top];
		return result;
	}
	public String toString() {
		String s="";
		if (top==-1) {
			s="no array";
		}
		else if(top==0) {
			s=list[0].toString();
		}
		else if(top>0) {
			for(int i=top;i>=0;i--) {
				s+=list[i]+", ";		
				}
		}
		return s;
	}
}
