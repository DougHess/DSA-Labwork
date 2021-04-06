	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;

	public class Lab5Driver2 {

		static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		static int numbagitems=0;
		static int bagweight=0;
		
		public static <T> void main(String args[]) throws IOException {
			StackInterface<Package> bag = new StackSLS<Package>();
			StackInterface<Item> sample = new StackRA<Item>();
			
			
			System.out.println("Select from the following menu\r\n" +
			        "   0. Exit.\r\n" +
					"	1. Pick up an order.\r\n" + 
					"	2. Drop off an order.\r\n" + 
					"	3. Display number of packages and weight of bag.\r\n" + 
					"	4. Display number of items in sample bag.\r\n" + 
					"	5. enjoy an item form the samples.\r\n" +
					"   6. empty sample bag.");
			
			String s = in.readLine().trim();
			while(!s.equals("0")) {
				switch(s) {
				case "1" :
						System.out.println("Enter item");
						String item = in.readLine().trim();
						System.out.println(item);
						System.out.println("Enter item weight");
						String weight = in.readLine().trim();
						System.out.println("weight");
						System.out.println("Enter numer of items");
						String num = in.readLine().trim();
						System.out.println("num");
						System.out.println("Enter name of sender");
						String send = in.readLine().trim();
						System.out.println(send);
						System.out.println("Enter name of recipient");
						String rec = in.readLine().trim();
						Package<T> i = new Package<T>((T)item, (T)weight, (T)num, (T)send, (T)rec);
						try {
						bag.push(i);
						numbagitems++;
						}
						catch(Exception e) {
							System.out.println(e.getMessage());
						}
						System.out.println("Make selection now");
						s = in.readLine().trim();
						break;
				case"2": 
						System.out.println("May I keep a sample?");
						String keep = in.readLine().trim();
						try {
							if (keep.equals('Y')) {
						sample.push(bag.pop());
						numbagitems--;
						
						}
							else {
								bag.pop();
								numbagitems--;
							}
						}
						catch(Exception e) {
							System.out.println(e.getMessage());
						}
						System.out.println("Make selection now");
						s = in.readLine().trim();
						break;
				case "3":
						System.out.println("The Array has : "+numbagitems+" and a weight of" +bagweight(bag));
						System.out.println("Make selection now");
						s = in.readLine().trim();
						
						break;
				case "4":
						System.out.println("The Array has :"+sample.toString());
						System.out.println("The Array weighs :");
						System.out.println("Make selection now");
						s = in.readLine().trim();	
						break;
				case "5":
						System.out.println("List has been removed");
						try {
						sample.pop();
						}
						catch(Exception e) {
							System.out.println(e.getMessage());
						}
						System.out.println("Make selection now");
						s = in.readLine().trim();
						break;
				case"6":
						System.out.println("List has been removed");
						sample.popAll();
						numbagitems=0;
						System.out.println("Make selection now");
						s = in.readLine().trim();
						break;
				}
			}
			System.out.println("You have left the program goodbye");
		}
		public String toString(StackInterface list, int numitems) {
			StackInterface<Package> newlist = new StackRA<Package>();
			newlist=list;
			Object[] item=new Object[numitems];
			for(int i=0; i<numitems;i++) {
				item[i]= newlist.pop().getName();
			}
			return item.toString();
		}
		public static int bagweight(StackInterface list) {
			StackInterface<Package> newlist = new StackRA<Package>();
			newlist=list;
			Object[] item=new Object[numbagitems];
			for(int i=0; i<numbagitems;i++) {
				item[i]= newlist.pop().getweight();
				bagweight+=(int)item[i];
			}
			return bagweight;
		}
}

