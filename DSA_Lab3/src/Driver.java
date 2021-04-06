import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String args[]) throws IOException {
		MyListReferenceBased myArray = new MyListReferenceBased();
		
		System.out.println("Select from the following menu\r\n" +
				"	1. Insert item to list.\r\n" + 
				"	2. Remove item from list.\r\n" + 
				"	3. Get item from list.\r\n" + 
				"	4. Clear list.\r\n" + 
				"	5. Print size and content of list.\r\n" + 
				"	6. Delete largest item of list.\r\n" +
				"	7. Reverse list.\r\n" +				
				"	8. Exit.");
		
		String s = in.readLine().trim();
		while(!s.equals("8")) {
			if (s.equals("1")) {
				System.out.println("Enter item");
				String item = in.readLine().trim();
				System.out.println("Enter index");
				String b = in.readLine().trim();
				int index =Integer.parseInt(b);
				try {
				myArray.add(index, item);
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
				System.out.println("Make selection now");
				s = in.readLine().trim();
			}
			else if (s.equals("2")) {
				System.out.println("Enter index");
				String b = in.readLine().trim();
				int x =Integer.parseInt(b);
				myArray.remove(x);
				System.out.println("Make selection now");
				s = in.readLine().trim();
			}
			else if (s.equals("3")) {
				System.out.println("Enter index");
				String b = in.readLine().trim();
				int x =Integer.parseInt(b);
				myArray.get(x);
				System.out.println("Make selection now");
				s = in.readLine().trim();
			}
			else if (s.equals("4")) {
				System.out.println("Are you sure you want to delete entire list? Y/N");
				String b = in.readLine().trim();
				if (b.equals("Y")){
				myArray.removeAll();
				System.out.println("Make selection now");
				s = in.readLine().trim();
				}
				System.out.println("Make selection now");
				s = in.readLine().trim();
			}
			else if (s.equals("5")) {
				System.out.println("The Array has " + myArray.size()+" :"+myArray.toString());
				System.out.println("Make selection now");
				s = in.readLine().trim();	
			}
			else if (s.equals("6")) {
				myArray.deleteLL();
				System.out.println("the largest string deleted");
				s = in.readLine().trim();
			}
			else if (s.equals("7")) {
				myArray= reverse(myArray);
				System.out.print(myArray.toString());
				System.out.println("List order has been revesed");
				s = in.readLine().trim();
				break;
		}
	}
	System.out.println("You have left the program goodbye");
}
public static MyListReferenceBased oldreverse(MyListReferenceBased list) {
	MyListReferenceBased newlist = new MyListReferenceBased();
	int size = list.size();
	int index = size;
	for (int i= 0; i <size; i++) {
		newlist.add(i, list.find(index--));
	}
	list = newlist;
	return list;
}
public static MyListReferenceBased reverse(MyListReferenceBased list) {
	int size = list.size();
	Node last = list.find(size-1);
	if (size>1) {
		
		for (int i =size-1; i>0; i--) {
			last.setNext(list.find((size-1)-i));
		}
	
	Node n = list.find(size-1);
	n.setNext(null);
	}
	list.setHead(last);
	return list;
	}
public MyListReferenceBased deleteLL(MyListReferenceBased list) {
	//this method deletes the first longest occurrence
	Node n = list.find(0);
	int size = list.size();
	if (size==1) {
		n = null;
	}
	else if (size>1){
		int i;
	for (i=0; i<size;i++) {
		if (n.getItem().toString().compareTo(n.getNext().getItem().toString())<0) {
			n= n.getNext();
		}
	}
	Node prev = list.find(i-1);
	prev.setNext(n.getNext());
	n=null;
	}
	return list;
}
}

