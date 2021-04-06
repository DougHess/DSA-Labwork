import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Stream;



public class Driver {
	
	 
	 static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		public static void main(String[] args) throws IOException {
			  
			ArrayList<Calendar> mycal = new ArrayList<Calendar>();
			//menu
			System.out.println("0. Exit the program.\r\n" + 
				"\r\n" + 
				"1. Add an event.\r\n" + 
				"\r\n" + 
				"2. Delete an event.\r\n" + 
				"\r\n" + 
				"3. Delete all events on a specified day.\r\n" + 
				"\r\n" + 
				"4. Display content of Calendar.\r\n" + 
				"\r\n" + 
				"5. Search for an event.");
		
			String s = in.readLine().trim();
			
				while(!s.equals("0")) {
					//exit on 0
					if (s.equals("1")){
						//add a calendar prompt
						System.out.println("You are now adding a new event to your Calendar.");
						System.out.println("Enter the name of the event: ");
						String a = in.readLine().trim();
						System.out.println("Enter the day of the event: ");
						String b = in.readLine().trim();
						System.out.println("Enter the month of the event: ");
						String c = in.readLine().trim();
						System.out.println("Enter the year of the event: ");
						String d = in.readLine().trim();
						//add to mycal
						mycal.add(new Calendar(a, b, c, d));
						System.out.println("Event "+a+" has been registered for "+b+" "+c+" "+d);
						System.out.println("Make your menu selection now: ");
						s = in.readLine().trim();
					}
					if (s.equals("2")){
						//delete a calendar by event
						//prompt for empty array
						if (mycal.isEmpty()) {
							System.out.println("There are no events to delete in the Calendar. ");
							System.out.println("Make your menu selection now: ");
							s=in.readLine().trim();
						}
						System.out.println("You are now deleting an event from your Calendar. ");
						System.out.println("Name of event to delete: ");
						s = in.readLine().trim();
						for(Calendar p : mycal) {
							if (p.getEvent().equalsIgnoreCase(s)) {
								mycal.remove(p);
							}
						}
						System.out.println("Make your menu selection now: ");
						s = in.readLine();
						//
						//attempts to use lambdas syntax errors
						//mycal.stream().forEach(e->e.e.remove(e.getEvent().toString().equals(a)));
						//mycal.forEach(e->e.stream().getEvent());
						//mycal.remove(e ->e.stream().filter(e.getEvent().equals(s));
					}
					if (s.equals("3")){
						//delete all events on a spec day
						System.out.println("You are now deleting all events for a specified day ");
						System.out.println("Enter day: ");
						String a=in.readLine().trim();
						System.out.println("Enter month: ");
						String b=in.readLine().trim();
						System.out.println("Enter year: ");
						String c=in.readLine().trim();
						System.out.println("Should any yearly event be deleted also enter Y or N : ");
						String d=in.readLine().trim();
						//Remove all matching events
						if (d=="Y") {
							for (Calendar p : mycal) {
								if (p.getDate().equals(a)&&p.getMonth().contains(b)) {
									mycal.remove(p);
								}
							}
						}
						for (Calendar p : mycal) {
							if (p.getDate().equals(a)&&p.getMonth().contains(b)&&p.getYear().equals(c)) {
								mycal.remove(p);
							}
						}
					}
					if(s.equals("4")) {
						//disp Calendar
						//System.out.println(mycal.forEach(e->e.toString()));
						for(Calendar p : mycal) {
							System.out.println(p.toString());
						}
						s = in.readLine().trim();
					}
					if (s.contentEquals("5")) {
						//search for event
						System.out.println("You are now seerching for an event.");
						System.out.println("Enter the name of your event");
						s=in.readLine().trim();
						for (Calendar p: mycal) {
							if (p.getEvent().contains(s)) {
								System.out.println(p.toString());
							}
						}
					}
				}
				System.out.println("Now you are exiting the program goodbye");
		}
}
	
		
		
	
	
