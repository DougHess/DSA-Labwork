import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Driver {

	private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int swap = 0;
	static int count = 0;
	
	public static void main(String[] args) throws IOException {

		System.out.println("Enter number of ranks:");
		String s = in.readLine().trim();
		int i = Integer.parseInt(s);
		int array[] = new int[i];
		int arrCopy[] = new int[i];
		

		if (i != 0) {
			for (int j = 0; j < i; j++) {
				System.out.print("Please enter rank: ");
				String a = in.readLine().trim();
				int k = Integer.parseInt(a);
				System.out.println(k);
				array[j] = k;
			}
		}
		System.out.println("\n");
		arrCopy=Arrays.copyOf(array, i);
		System.out.println("Merge sorting recursively following array\n"+Arrays.toString(array)+"\n");
		mergeSortR(array);
		System.out.println("key comparisons = "+count+"\n"+Arrays.toString(array)+"\n");
		array = Arrays.copyOf(arrCopy, i);
		count=0;
		System.out.println("\n");
		System.out.println("Quick sorting recursively following array\n"+Arrays.toString(array)+"\n");
		quickSort(array, 0, array.length);
		System.out.println("key comparisons = "+count+" swaps = "+swap+"\n"+Arrays.toString(array)+"\n");
	}
	
	public static void mergeSortR(int[] ahri) {//recursive merge sort
		if (ahri.length>1) {
			int mid = ahri.length/2;
			int[] lux = new int[mid];
			for (int i = 0 ; i<mid ; i++) {
					lux[i]=ahri[i];
			}
			int[] morg = new int[ahri.length-mid];
			for (int i = mid ; i<ahri.length ; i++) {
				morg[i-mid]=ahri[i];
			}
			mergeSortR(lux);
			mergeSortR(morg);
			int i=0;
			int j=0;
			int k=0;
			while ( i < lux.length && j < morg.length) {
				count++;
				if (lux[i]<morg[j]) {
					ahri[k++]=lux[i++];
				}
				else {
					ahri[k++]=morg[j++];
				}
			}
			while (i<lux.length) {
				ahri[k++] = lux[i++];
			}
			while (j<morg.length) {
				ahri[k++]=morg[j++];
			}
		}
	}
	public static void quickSort(int[] ahri, int low, int high) {
		int j = low+1;
		int k= low+1;
		if (low<high&&ahri.length>1) {

			int pivot = ahri[(low+high)/2];//pivot is random middle index chosen
			ahri[(low+high)/2] = ahri[low];
			ahri[low] = pivot;
			for (int i =low+1 ; i< high ;i++) {
				count++;
				if (ahri[i] > pivot) {
					swap++;
					int temp = ahri[j];
					ahri[j] = ahri[i];
					ahri[i] = temp;
					j++;
				}
				else if (ahri[i]<pivot) {
					swap++;
					int temp = ahri[k];
					ahri[k]=ahri[i];
					ahri[i]=temp;
					k++;
					j++;
				}
			}
			int temp = ahri[low];
			ahri[low]=ahri[k-1];
			ahri[k-1]=temp;
			swap++;
			quickSort(ahri, low+1, k);
			quickSort(ahri, k, j);
		}
		
	}
}
