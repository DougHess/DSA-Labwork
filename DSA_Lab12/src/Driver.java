import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Driver {
	
	private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
	
		HashTable<String , Integer> ahri = new HashTable();
		ahri.tableInsert("ATE", 7);
		ahri.tableInsert("EAT", -5);
		ahri.tableInsert("TEA", 1000);
		ahri.tableInsert("GRADE", 100);
		ahri.tableInsert("DSA", 10);
		ahri.tableInsert("CAT", 67);
		ahri.tableInsert("DOGGY", 25);
		ahri.tableInsert("CHAIRS", -45);
		ahri.tableInsert("LETTER", 6);
		ahri.tableInsert("PASS", 88);
		
		System.out.println("Make your selection from the menu.\n"
				+ "0. Exit.\n"
				+ "1. Insert.\n"
				+ "2. Delete.\n"
				+ "3. Retrieve.\n"
				+ "4. Display a HashCode.\n"
				+ "5. Display all data.\n");
		String s=in.readLine().trim();
		
		while (!s.equals("0")) {
			switch(s) {
			case "1" :
				System.out.println("Enter key");
				s=in.readLine().trim().toUpperCase();
				System.out.println("Enter value");
				int x = Integer.parseInt(in.readLine().trim());
				boolean insert = ahri.tableInsert(s, x);
				if (insert==true) {
					System.out.println("insert successful");
				}
				else {System.out.println("insert fail");}
				s = read();
				break;
			case "2" :
				System.out.println("Enter key");
				s=in.readLine().trim().toUpperCase();
				boolean delete = ahri.tableDelete(s);
				if (delete==true) {
					System.out.println("delete successful");
				}
				else {System.out.println("delete fail");}
				s = read();
				break;
			case "3" :
				System.out.println("Enter key");
				s=in.readLine().trim().toUpperCase();
				int retrieve=0;
				try {
					 retrieve = ahri.tableRetrieve(s);
				}
				catch (Exception e) {
					e.getMessage();
				}
				if (retrieve==0) {
					System.out.println("No key = "+s+" found");
				}
				else {
					System.out.println("retrieve key = "+s+" value = "+retrieve);
				}
				s = read();
				break;
			case "4" :
				System.out.println("Enter key");
				s=in.readLine().trim().toUpperCase();
				int hashCode = ahri.hashCode(s);
				System.out.println(s+ " is hashed into array index "+hashCode);
				s = read();
				break;
			case "5" :
				System.out.println(ahri.tableLength()+ " = total\n" + ahri.toString());
				s = read();
				break;
			}
		}
		System.out.println("Goodbye");
	}
	
	
	public static String read() {
		System.out.println("Make selection now");
		String s = null;
		try {
			s = in.readLine().trim();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("You have selected: " + s);
		return s;
	}
}