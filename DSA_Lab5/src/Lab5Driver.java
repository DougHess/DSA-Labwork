	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;

	public class Lab5Driver {

		static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		public static <T> void main(String args[]) throws IOException {
			StackInterface<String> myArray = new StackSLS<String>();
			
			System.out.println("Select from the following menu\r\n" +
					"	1. Push item to stack.\r\n" + 
					"	2. Pop item from stack.\r\n" + 
					"	3. Display top item.\r\n" + 
					"	4. Display items in stack.\r\n" + 
					"	5. Clear stack.\r\n" +
					"   6. Exit.");
			
			String s = in.readLine().trim();
			while(!s.equals("6")) {
				switch(s) {
				case "1" :
						System.out.println("Enter item");
						String item = in.readLine().trim();
						try {
						myArray.push(item);
						}
						catch(Exception e) {
							System.out.println(e.getMessage());
						}
						System.out.println("Make selection now");
						s = in.readLine().trim();
						break;
				case"2": 
						try {
						myArray.pop();
						}
						catch(Exception e) {
							System.out.println(e.getMessage());
						}
						System.out.println("Make selection now");
						s = in.readLine().trim();
						break;
				case "3":
						try {
						System.out.println(myArray.peek());
						}
						catch(Exception e) {
							System.out.println(e.getMessage());
						}
						System.out.println("Make selection now");
						s = in.readLine().trim();
						break;
				case "4":
						System.out.println("List has been removed");
						myArray.popAll();
						System.out.println("Make selection now");
						s = in.readLine().trim();
						break;
				case "5":
						System.out.println("The Array has :"+myArray.toString());
						System.out.println("Make selection now");
						s = in.readLine().trim();	
						break;
				}
			}
			System.out.println("You have left the program goodbye");
		}
}
