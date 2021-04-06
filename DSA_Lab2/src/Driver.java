import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {
	
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] agrs) throws IOException {
		ListArrayBased myArray = new ArrayBasePlus();

		
		System.out.println("Select from the following menu\r\n" +
				"	0. Exit program.\r\n" + 
				"	1. Insert item to list.\r\n" + 
				"	2. Remove item from list.\r\n" + 
				"	3. Get item from list.\r\n" + 
				"	4. Clear list.\r\n" + 
				"	5. Print size and content of list.\r\n" + 
				"	6. Reverse list.");
		
		String s = in.readLine().trim();
		while(!s.equals("0")) {
			if (s.equals("1")) {
				System.out.println("Enter item");
				String a = in.readLine().trim();
				System.out.println("Enter index");
				String b = in.readLine().trim();
				int x =Integer.parseInt(b);
				myArray.add(x, a);
				System.out.println("Make selection now");
				s = in.readLine().trim();
			}
			if (s.equals("2")) {
				System.out.println("Enter index");
				String b = in.readLine().trim();
				int x =Integer.parseInt(b);
				myArray.remove(x);
				System.out.println("Make selection now");
				s = in.readLine().trim();
			}
			if (s.equals("3")) {
				System.out.println("Enter index");
				String b = in.readLine().trim();
				int x =Integer.parseInt(b);
				myArray.get(x);
				System.out.println("Make selection now");
				s = in.readLine().trim();
			}
			if (s.equals("4")) {
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
			if (s.equals("5")) {
				System.out.println("The Array has " + myArray.numItems+" :"+myArray.toString());
				System.out.println("Make selection now");
				s = in.readLine().trim();
				
			}
			if (s.equals("6")) {
				((ArrayBasePlus) myArray).reverse();
				System.out.println("Make selection now");
				s = in.readLine().trim();
			}
		}
	}
}
