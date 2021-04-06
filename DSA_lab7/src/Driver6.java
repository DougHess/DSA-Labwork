/*
 * pascal/binomial co reduced formulaic approach
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver6 {

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

	public static int fallingfac(int n, int k) {
		int result = 1;
		if(0<k) {
			if (n==0) {
				result = 1;
			}
			else {
				result = n * fallingfac(n-1,k-1);
			}
		}
		return result;
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
		int nf = 1;
		int kf = 1;;
		if (k>=(n-k)) {
			nf = fallingfac(n, n-k);
			kf = rfac(n-k);
			result = nf / kf;
		}
		else {
			nf = fallingfac(n, k);
			kf = rfac(k);
			result = nf / kf;
		}
		return result;
	}
}
