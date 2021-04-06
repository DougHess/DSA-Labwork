/*
 * Lab 8 problems 1 and 2 searching unordered lists.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Driver1 {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] agrs) throws IOException {
		System.out.println("Make your selection from the menu.\n"
				+ "1. Insert item into the list.\n"
				+ "2. Remove item from the list.\n"
				+ "3. Get item from the list.\n"
				+ "4. Search for an item in the list.\n"
				+ "5. Clear the list.\n"
				+ "6. Print size and content of the list.\n"
				+ "7. Exit the program.");
		String s=in.readLine().trim();
		System.out.println("You have selected: " + s);
		ArrayBasePlus list = new ArrayBasePlus();
		while (!s.equals("7")) {
			switch(s) {
			case "1" :
				System.out.println("Enter item to be inserted");
				String a=in.readLine().trim();
				System.out.println("You have entered: " + a);
				System.out.println("Enter index to insert at");
				String b = in.readLine().trim();
				int i =Integer.parseInt(b);
				System.out.println("You have entered: " + i);
				list.add(i, a);
				System.out.println("You have added "+list.get(i)+" to index "+i);
				System.out.println("Make selection now");
				s=in.readLine().trim();
				System.out.println("You have selected: " + s);
				break;
			case "2" :
				System.out.println("Enter index to remove at");
				String r = in.readLine().trim();
				int j =Integer.parseInt(r);
				System.out.println("You have entered: " + j);
				System.out.println("Removing "+list.get(j));
				list.remove(j);
				System.out.println("Make selection now");
				s=in.readLine().trim();
				System.out.println("You have selected: " + s);
				break;
			case "3" :
				System.out.println("Enter index to get item");
				s = in.readLine().trim();
				int x =Integer.parseInt(s);
				System.out.println("You have "+list.get(x));
				System.out.println("Make selection now");
				s=in.readLine().trim();
				System.out.println("You have selected: " + s);
				break;
			case "4" :
				System.out.println("Enter item to be searched for");
				s=in.readLine().trim();
				System.out.println("Searching for: " + s);
				int k = search(s, list);
				if (k<0) {
					System.out.println("you have not found any matches");
				}
				else if (k==list.size()) {
					System.out.println("you have found "+ list.get(0)+" at index 0");
				}
				else {
					System.out.println("you have found "+ list.get(k)+" at index "+k);
				}
				System.out.println("Make selection now");
				s=in.readLine().trim();
				System.out.println("You have selected: " + s);
				break;
			case "6" :
				int size = 0;
				System.out.println("Prining list: ");
				for (int l =0; l <list.size(); l++) {
					System.out.println(list.get(l)+" "+size+++" ");
				}
				System.out.println("Make selection now");
				s=in.readLine().trim();
				System.out.println("You have selected: " + s);
				break;
			}
		}
		System.out.println("Goodbye");
	}
	public static int search(String s, ArrayBasePlus o) {
		int found = -1;
		int result = 0;
		for (int i =0; i<o.size()&&found==-1; i++) {
			if (o.get(i).equals(s)) {
				result = i;
				found = 1;
			}
		}
		if(result == 0) {
			result = o.size();
		}
		result = result * found;
		return result;
	}
}
