import java.util.Iterator;

public class MyListReferenceBased implements ListInterface {
	private Node head;
	
	public MyListReferenceBased() {
		head = null;
	}
	public void setHead(Node n) {
		head = n;
	}
	public boolean isEmpty() {
		return head==null;
	}
	public int size() {
		int size =0;
		if (head==null) {
			size =0;
		}
		else if (!(head==null)){
			size=1;
			Node n =head;
			while(!(n.getNext()==null)) {
				size++;
				n=n.getNext();
			}
		}
		return size;
	}
	protected Node find(int index) {
		Node current = head;
		for (int i =0; i<index;i++) {
			current=current.getNext();
		}
		return current;
	}
	protected boolean isValid(int index) {
		if (index>=0&&index<size()+1) {
			return true;
		}
		return false;
	}
	public Object get(int index) throws ListIndexOutOfBoundsException {
		if(isValid(index)) {
			Node current =find(index);
			return current.getItem();
		}
		throw new ListIndexOutOfBoundsException("out of bounds");
	}
	public void add(int index, Object item) throws ListIndexOutOfBoundsException {
		if (isValid(index)) {
			if(index==0) {
				Node newNode = new Node(item, head);
				head= newNode;
			}
			else {
				Node prev = find(index-1);
		        Node newNode = new Node(item, prev.getNext());
		        prev.setNext(newNode);
			}
		}
		else {
		throw new ListIndexOutOfBoundsException("cannot add to this index");
		}
	}
	public void remove(int index) throws ListIndexOutOfBoundsException{
		if(isValid(index)) {
			if(index==0) {
				head=head.getNext();
			}
			find(index-1).setNext(find(index+1));
		}
		throw new ListIndexOutOfBoundsException("cannot remove from index");
	}
	public void removeAll() {
		head = null;
	}
	public String toString() {
		int size = size();
		String s = "no array";
		if (size ==1) {
			s=head.getItem().toString();
		}
		else if(size > 1) {
			Node n = head;
			String a = n.getItem().toString()+", ";
			while (!(n.getNext()==null)) {
				a +=n.getNext().getItem().toString()+", ";
				s = a;
				n=n.getNext();
				}
		}
		return s;
	}
	
	public void deleteLL() {
		//this method deletes the first longest occurrence
		Node n = head;
		int size = size();
		if (size==1) {
			head = null;
		}
		else if (size>1){
			int i;
		for (i=0; i<size;i++) {
			if (n.getItem().toString().compareTo(n.getNext().getItem().toString())<0) {
				n= n.getNext();
			}
		}
		Node prev = find(i-1);
		prev.setNext(n.getNext());
		n=null;
		}
	}
	public class LRBIterator implements Iterator<Node>{

		public boolean hasNext() {
			if (head.getNext()==null) {
				return false;
			}
			return true;
		}

		public Node next() {
			return head.getNext();
		}
		
	}
}
