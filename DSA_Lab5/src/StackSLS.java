
public class StackSLS<T> implements StackInterface<T>{


	private Node<T> top;
	
	public StackSLS() {
		top = null;
	}
	public boolean isEmpty() {
		boolean empty=false;
		if (top==null){
			empty = true;
		}
		return empty;
	}
	public void popAll() {
		top=null;
	}
	public void push(T item) throws StackException {
		top = new Node(item, top);
	}
	public T pop() throws StackException {
		Object oldtop =  top.getItem();
		top=top.getNext();
		return (T) oldtop;
	}
	public T peek() throws StackException {
		return top.getItem();
	}
	public String toString() {
		String s="";
		if (!(top==null)) {
			s+=(String) top.getItem();
			Node<T> n = top.getNext();
			while(!(n==null)) {
				s+=", "+n.getItem();
				n=n.getNext();
			}
		}
		return s;
	}
}
