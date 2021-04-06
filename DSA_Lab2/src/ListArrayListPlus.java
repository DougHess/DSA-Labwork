import java.util.ArrayList;

public class ListArrayListPlus extends ListArrayListBased {
	protected ArrayList<Object> newArray;
	
	public void reverse() {
		int j=0;
	 for (int i=array.size(); i>=0;i--) {
		 newArray.add(j++, array.get(i));
	 }
	 array = newArray;
	}
	public String toString() {
		String s;
		if (array.isEmpty()) {
			s= "no array";
		}
		else {
			s=", ";
		for(Object item : array){
			s+=item.toString();
		}
		}
		return s;
	}
}
