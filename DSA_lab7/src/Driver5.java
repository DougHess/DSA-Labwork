/*
 * formulaic Pascal non-reduced (no falling factorials)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver5 {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	
	public static void main(String args[]) throws IOException {
		String s= "";
		while((s = in.readLine())!=null) {
		String d = in.readLine().trim();
		int n = Integer.parseInt(s);
		int k = Integer.parseInt(d);
		System.out.println(formulaicpascal(n,k));
		}
	}

	public static int rfac(int n) {
		int result = 1;
		if (n==0) {
			result = 1;
		}
		else {
			result = n * rfac(n-1);
		}
		return result;
	}
	public static int formulaicpascal(int n, int k) {
		int result=1;
		int nf = rfac(n);
		int kf = rfac(k);
		int nkf = rfac(n-k);
		result = nf / (kf * nkf);
		return result;
	}
}
