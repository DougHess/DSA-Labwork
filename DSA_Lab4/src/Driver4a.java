import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver4a {

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
			switch(s) {
			case "1" :
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
					break;
			case"2": 
					System.out.println("Enter index");
					String b1 = in.readLine().trim();
					int x =Integer.parseInt(b1);
					myArray.remove(x);
					System.out.println("Make selection now");
					s = in.readLine().trim();
					break;
			case "3":
					System.out.println("Enter index");
					String b11 = in.readLine().trim();
					int x1 =Integer.parseInt(b11);
					myArray.get(x1);
					System.out.println("Make selection now");
					s = in.readLine().trim();
					break;
			case "4":
					System.out.println("List has been removed");
					myArray.removeAll();
					System.out.println("Make selection now");
					s = in.readLine().trim();
					break;
			case "5":
					System.out.println("The Array has " + myArray.size()+" :"+myArray.toString());
					System.out.println("Make selection now");
					s = in.readLine().trim();	
					break;
			case "6":
					myArray=reverse(myArray);
					System.out.print(myArray.toString());
					System.out.println("List order has been revesed");
					s = in.readLine().trim();
					break;
			}
		}
		System.out.println("You have left the program goodbye");
	}
	public static MyListReferenceBased reverse(MyListReferenceBased list) {
		MyListReferenceBased newlist = new MyListReferenceBased();
		int size = list.size();
		int index = size;
		if (size>1) {
		for (int i= 0; i <size; i++) {
			
			newlist.add(0, list.get(index--));
		}
		return newlist;
		}
		else {return list;}
	}
	
}
