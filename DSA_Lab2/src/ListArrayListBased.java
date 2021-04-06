import java.util.ArrayList;

public class ListArrayListBased implements ListInterface{
	protected ArrayList<Object> array; 
	protected int numItems;
	public  ListArrayListBased() {
		array = new ArrayList<Object>();
		numItems=0;
	}
	public int size() {
		return numItems;
	}
	public void add(int index, Object item) throws ListIndexOutOfBoundsException {
		array.add(index, item);
		numItems++;
	}
	public Object get(int index) throws ListIndexOutOfBoundsException {
		return array.get(index);
	}
	public void remove(int index) throws ListIndexOutOfBoundsException {
		array.remove(index);
		numItems--;
	}
	public void removeAll() {
		array=null;
	}
	public boolean isEmpty() {
		return (numItems == 0);
	}
}
