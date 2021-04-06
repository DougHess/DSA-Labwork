/*
 * Lab 8 problems 3 searching ordered lists. using the Binary II method search.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Driver4 {

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
				int i = search(a, list);
				if (i<=0) {
					if (list.size()==0) {
					System.out.println("adding "+a+" into index 0");
					list.add(0, a);
					}
					else {
						System.out.println("adding "+a+" into index "+(i*-1));
						list.add((i*-1), a);
					}
				}
				else if (i>=0) {
					System.out.println("duplicate item at index "+i+" not added");
				}
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
					System.out.println(size+++": "+list.get(l));
				}
				System.out.println("Make selection now");
				s=in.readLine().trim();
				System.out.println("You have selected: " + s);
				break;
			}
		}
		System.out.println("Goodbye");
	}
	
	public static int search(String j, ArrayBasePlus o) {
		int bottom = 0;
		int top = o.size();
		int mid = 0;
		int found= -1;
		int pos = 0;
		while (top>bottom){
			mid = (top+bottom)/2;
			if (((String) o.get(mid)).compareTo(j)<1) {//current >= search key
				pos = mid+1;
				bottom = mid +1;
			}
			else {
				top = mid;
				
			}
			//System.out.println(o.get(mid)+" "+j);
		}
		if  (o.size()!=0&&((String)o.get(mid)).equals(j)) {
			found = 1;
			System.out.println("hi");
			return mid;
		}
		if (pos>mid) {
			return pos*found;
		}
		//System.out.println(o.get(mid)+" "+j);
		else {
		mid=mid*found;
		return mid;}
	}
	
}
