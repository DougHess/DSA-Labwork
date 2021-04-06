/*
 * Recursive call for binomial coefficient
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Driver2 {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	
	public static void main(String args[]) throws IOException {
		String s= "";
		while((s = in.readLine())!=null) {
		String d = in.readLine().trim();
		int n = Integer.parseInt(s);
		int k = Integer.parseInt(d);
		//System.out.println(s+" "+d);
		System.out.println(rpascal(n,k));
		 }
		
	}
	public static int rpascal(int n, int k) {
		int result = 1;
		if(k==0||n==k) {
			result=1;
		}
		else {
			result = rpascal(n-1,k-1)+rpascal(n-1,k);
		}
		return result;
	}
}


