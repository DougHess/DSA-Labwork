/*
 * Iterative Pascal triangle
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver3 {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int[] row1;
	static int[] row2;
	
	public static void main(String args[]) throws IOException {
		String s= "";
		while((s = in.readLine())!=null) {
		int n = Integer.parseInt(s);
		row1 = new int[n+1];
		row2 = new int[n+1];
		ipascal(n);
		}
		
	}
	public static void ipascal(int n) {
		row2[0]=1;
		for(int i=2;i<n+3;i++) {
			row1=row2;
			row2= new int[i+2];
			row2[0]=1;
			row2[i+1]=1;
			System.out.println();
			System.out.print("1 ");
			for (int j=1; j<i-1;j++) {
				row2[j]=row1[j-1]+row1[j];
				System.out.print(row2[j]+" ");
			}
		}
	}
}

