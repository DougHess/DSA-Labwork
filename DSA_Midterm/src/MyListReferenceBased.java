import java.util.Iterator;

public class MyListReferenceBased implements ListInterface {
	private DNode tail;
	private int numitems;
	
	public MyListReferenceBased() {
		tail = null;
		numitems=0;
	}
	public MyListReferenceBased(DNode tail, int numitems) {
		this.tail=tail;
		this.numitems=numitems;
	}
	public boolean isEmpty() {
		return tail==null;
	}
	public int size() {
		return numitems;
	}
	public int oldsize() {
		int size =0;
		if (tail==null) {
			size =0;
		}
		else if (!(tail==null)){
			size=1;
			DNode n =tail.getNext();
			while(!(n==tail)) {
				size++;
				n=n.getNext();
			}
		}
		return size;
	}
	protected DNode oldfind(int index) {//Inefficient
		DNode current = tail;
		for (int i =0; i<index;i++) {
			current=current.getNext();
		}
		return current;
	}
	protected DNode find(int index) {
		DNode current = tail.getNext();
		if (index==size()) {
			current=tail.getNext();
		}
		else if (index <=size()/2) {
			for (int i =0; i<index;i++) {
				current=current.getNext();
			}
		}
		else {
			int moddedindex = size() % index;
			for (int i =0; i<moddedindex;i++) {
				current=current.getBack();
			}
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
			DNode current =find(index);
			return current.getItem();
		}
		throw new ListIndexOutOfBoundsException("out of bounds");
	}
	public void oldadd(int index, Object item) throws ListIndexOutOfBoundsException {//broken
		if (isValid(index)) {
			if(index==0) {
				DNode newNode = new DNode(item);
				tail= newNode;
			}
			else {
				DNode prev = find(index-1);
		        DNode newNode = new DNode(item, prev.getNext(), prev);
		        prev.setNext(newNode);
			}
			numitems+=1;
		}
		else {
		throw new ListIndexOutOfBoundsException("cannot add to this index");
		}
	}
	public void add(int index, Object item) throws ListIndexOutOfBoundsException {
		if (isValid(index)) {
			if (numitems==0) {
				tail= new DNode(item);
			}
			else {
				DNode prev= find(index-1);
				DNode newnode = new DNode(item, prev.getNext(), prev);
				prev.setNext(newnode);
				newnode.getNext().setBack(newnode);
			}
			numitems++;
		}
		else {
			throw new ListIndexOutOfBoundsException("cannot add to this index");
		}
	}
	public void oldremove(int index) throws ListIndexOutOfBoundsException{//broken
		if(isValid(index)) {
			if(index==0) {
				tail=tail.getNext();
			}
			find(index-1).setNext(find(index+1));
			numitems-=1;
		}
		throw new ListIndexOutOfBoundsException("cannot remove from index");
	}
	public void remove(int index) throws ListIndexOutOfBoundsException{
		if(isValid(index)) {
			if (numitems==1) {
				tail=null;
			}
			else if(numitems==2) {
				DNode prev = find(index-1);
				prev.setNext(prev);
			}
			else {
				DNode prev= find(index-1);
				DNode n= prev.getNext().getNext();
				prev.setNext(n);
				n.setBack(prev);
			}
			numitems--;
		}
		else {
			throw new ListIndexOutOfBoundsException("cannot remove from index");
		}
	}
	public void removeAll() {
		tail = null;
		numitems=0;
	}
	public String oldtoString() {
		int size = size();
		System.out.println(size);
		String s = "no array";
		if (size ==1) {
			s=tail.getItem().toString();
		}
		else if(size > 1) {
			DNode n = tail.getNext();
			String a = n.getItem().toString()+", ";
			s=a;
			while (!(n.getNext()==n)) {
				a +=n.getNext().getItem().toString()+", ";
				s = a;
				n=n.getNext();
				}
		}
		return s;
	}
	public String toString()
	{
		String array="";
		if (numitems == 0) {
		 array = "no array";
		}
		else {
			DNode n = tail;
			for (int i=0; i<numitems; i++) {
				array += n.getItem().toString()+", ";
				n = n.getNext();
			}
		}
		return array;
	}
	public void oldreverse() {//broken
		int size = size();
		DNode last = find(size-1);
		if (size>1) {
			
			for (int i =size-1; i>0; i--) {
				last.setNext(find((size-1)-i));
			}
		
		DNode n = find(size-1);
		n.setNext(null);
		}
		tail = last;
		System.out.println(size);
	}
	public String reverse() {
		
			String array="";
			if (numitems == 0) {
			 array = "no array";
			}
			else {
				DNode n = tail;
				for (int i=0; i<numitems; i++) {
					array += n.getItem().toString()+", ";
					n = n.getBack();
				}
			}
			return array;
		}
	
	public void deleteLL() {
		//this method deletes the first longest occurrence
		DNode n = tail;
		int size = size();
		if (size==1) {
			tail = null;
		}
		else if (size>1){
			int i;
		for (i=0; i<size;i++) {
			if (n.getItem().toString().compareTo(n.getNext().getItem().toString())<0) {
				n= n.getNext();
			}
		}
		DNode prev = find(i-1);
		prev.setNext(n.getNext());
		n=null;
		}
	}
	public int getNumitems() {
		return numitems;
	}
	public class LRBIterator implements Iterator<DNode>{

		public boolean hasNext() {
			if (tail.getNext()==null) {
				return false;
			}
			return true;
		}

		public DNode next() {
			return tail.getNext();
		}
		
	}
}