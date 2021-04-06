import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	public static <T> void main(String args[]) throws IOException {
		System.out.println("how many booths are available?");
	    String s = in.readLine().trim();
	    System.out.println(s);
	    int x = Integer.parseInt(s);
		StackInterface<String> boothstack = new StackSLS<String>();
		 for (int i =0;i<x;i++){
			 System.out.println("Enter color for key number "+ (i+1));
			 s = in.readLine().trim();
			 System.out.println(s);
			 boothstack.push(s);
		 }
		 
		 QueueInterface<Item> waiting = new QueueRA<Item>();
		 QueueInterface<String> boothinuse = new QueueRA<String>();
		 int voters =0;
		System.out.println("Select from the following menu\r\n" +
				"	0. Exit.\r\n"+
				"	1. insert .\r\n" + 
				"	2. drop .\r\n" + 
				"	3. display .\r\n" + 
				"	4. display .\r\n" + 
				"	5. enjoy .\r\n"+
				"	6. clear .\r\n"+
				"	7. pick \r\n");
		
		s = in.readLine().trim();
		
		
		while(!s.equals("0")) {
			switch(s) {
			case "1" :
					System.out.println("Enter your name");
					s = in.readLine().trim();
					System.out.println("Enter your perfered color");
					String color = in.readLine().trim();
					Item person= new Item(color, s);
					
					try {
						waiting.enqueue(person);
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
					System.out.println("Make selection now");
					s = in.readLine().trim();
					System.out.println(s);
					break;
			case"2": 
				
					if(waiting.isEmpty()) {
						System.out.println("no voters");
					}
					else if (!(waiting.isEmpty())){
						try {
							Item wait = waiting.dequeue();
							if (wait.getcolor().equals(boothstack.peek()) {
								System.out.println(wait.getName()+ " is using "+ boothstack.peek());
								String booth = boothstack.pop();
								boothinuse.enqueue(booth);
							}
						
							else if(!(((String) wait.getcolor()).contains(boothstack.peek()))){
							System.out.println("Would you like a different color?");
							s = in.readLine().trim();
							System.out.println(s);
								if(s.equals("Y")) {
									System.out.println(wait.getName()+ " is using "+ boothstack.peek());
									String booth = boothstack.pop();
									boothinuse.enqueue(booth);
								}
							}
						
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
					System.out.println("Make selection now");
					s = in.readLine().trim();
					System.out.println(s);
					break;
			case "3":
					
					
					try {
					if(!(boothinuse.isEmpty())) {
						boothstack.push(boothinuse.dequeue());
						voters++;
						System.out.println(boothstack.peek()+ " is now free");
					}
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
					System.out.println("Make selection now");
					s = in.readLine().trim();
					System.out.println(s);
					break;
			case "4":
					
					try {
						System.out.println(waiting.toString());
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
					System.out.println("Make selection now");
					s = in.readLine().trim();
					System.out.println(s);
					break;
			case "5":
					try {
						System.out.println(boothinuse.toString());
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
					System.out.println("Make selection now");
					s = in.readLine().trim();
					System.out.println(s);
					break;
			case "6":
					try {
						System.out.println(boothstack.toString());
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
					System.out.println("Make selection now");
					s = in.readLine().trim();
					System.out.println(s);
					break;
			case "7":

				System.out.println(voters+ "have voted and left");
					System.out.println("Make selection now");
					s = in.readLine().trim();
					System.out.println(s);
					break;

			}
		}
		System.out.println("You have left the program goodbye");
	}
}