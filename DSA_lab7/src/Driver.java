/*
 * Towers of Hanoi Lab problem 2
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Driver {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int callnums=0;
	static int movenums=0;
	
	public static void main(String args[]) throws IOException {
		String s= "";
		while((s = in.readLine())!=null) {
		int i = Integer.parseInt(s);
		System.out.println(s);
		solve(i, "Start", "Finish", "Temp");
		System.out.println("Tower of "+i+" was moved "+ 
		movenums+ " times and method was called "+callnums);
		}
	}
	public static void solve(int i, String init, String dest, String temp) {
		callnums++;
		if(i>0) {
			solve(i-1, init, temp, dest);
			System.out.println("Moving disk "+i+" from "+init+" to "+dest);
			movenums++;
			solve(i-1, temp, dest, init);
		}
	}
}

