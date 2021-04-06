import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Driver {

	private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

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
		System.out.println("Running Bubble Sort I:");
		System.out.println(Arrays.toString(array));
		arrCopy = Arrays.copyOf(array, i);
		array = bubbleSort(array);
		System.out.println(Arrays.toString(array));
		System.out.println("\n");
		array = Arrays.copyOf(arrCopy, i);
		
		System.out.println("Running Bubble Sort II:");
		System.out.println(Arrays.toString(array));
		arrCopy = Arrays.copyOf(array, i);
		System.out.println(Arrays.toString(bubbleSortII(array)));
		System.out.println("\n");
		array = Arrays.copyOf(arrCopy, i);
		
		System.out.println("Running Selection Sort:");
		System.out.println(Arrays.toString(array));
		arrCopy = Arrays.copyOf(array, i);
		System.out.println(Arrays.toString(selectionSort(array)));
		System.out.println("\n");
		array = Arrays.copyOf(arrCopy, i);
		
		System.out.println("Running Insertion Sort:");
		System.out.println(Arrays.toString(array));
		arrCopy = Arrays.copyOf(array, i);
		System.out.println(Arrays.toString(insertionSort(array)));
		System.out.println("\n");
		array = Arrays.copyOf(arrCopy, i);
	}

	public static int[] selectionSort(int[] ahri) {
		int i = 0;
		int k = ahri.length - 1;
		int[] temp = new int[k + 1];
		int comparison = 0;
		int swap = 0;
		for (i = 0; i <= k; i++) {
			while (k > i) {
				if (ahri[i] > ahri[k]) {
					temp[0] = ahri[k];
					ahri[k] = ahri[i];
					ahri[i] = temp[0];
					++swap;
				}
				++comparison;
				k--;
			}
			k = ahri.length - 1;
		}
		System.out.println("swaps = " + swap + " comparisons = " + comparison);
		return ahri;
	}

	public static int[] bubbleSortII(int[] ahri) {
		int i = 0;
		int k = ahri.length - 1;
		int[] temp = new int[k + 1];
		int comparison = 0;
		int swap = 0;
		int newSwaps = 0;
		for (i = 0; i <= k; i++) {
			while (k > i) {
				if (ahri[i] > ahri[k]) {
					temp[0] = ahri[k];
					ahri[k] = ahri[i];
					ahri[i] = temp[0];
					++swap;
				}
				++comparison;
				k--;
			}
			if (swap==newSwaps) {
				break;
			}
			else {newSwaps=swap;}
			k = ahri.length - 1;
		}
		System.out.println("swaps = " + swap + " comparisons = " + comparison);
		return ahri;
	}
	
	public static int[] insertionSort(int[] ahri) {
		int k = ahri.length-1;
		int i = 0;
		int largestIndex = 0;
		int swap =0;
		int count =0;
		for ( ; k>=0;k--) {
			largestIndex=0;
			for (i =0; i<=k;i++) {
				count++;
				if (ahri[i]>ahri[largestIndex]) {
					largestIndex = i;
					swap++;
				}
				
			}
			int temp = ahri[k];
			ahri[k]=ahri[largestIndex];
			ahri[largestIndex]=temp;
			
		}
		System.out.println("shifts = "+swap+" comparisons = "+count);
		return ahri;
	}
	public static int[] bubbleSort(int[] ahri) {
		int i =0;
		int swap=0;
		int count=0;
		for (i = 1; i<ahri.length; i++) {
		
			for (int k = i; k>0;k--) {
				count++;
				if (ahri[k-1]>ahri[k]) {
					int temp = ahri[k-1];
					ahri[k-1]=ahri[k];
					ahri[k]= temp;
					swap++;
					}
			}
		}
		System.out.println("swaps = "+swap+" comparisons = "+count);
		return ahri;
	}
}

