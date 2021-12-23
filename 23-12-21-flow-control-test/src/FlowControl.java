import java.util.Arrays;
import java.util.LinkedHashSet;

public class FlowControl {

	public static void main(String[] args) {
		
		// 1. create two arrays
		int[] nums1 = new int[15];
		int[] nums2 = new int[15];
		
		for (int i = 0; i < nums1.length; i++) {
			nums1[i] = (int) (Math.random() * 10);
		}
		
		for (int i = 0; i < nums2.length; i++) {
			nums2[i] = (int) (Math.random() * 10);
		}

		
		// 2. print arrays
		System.out.print("num1: ");
		for (int i = 0; i < nums1.length; i++) {
			System.out.print(nums1[i]);
		}
		System.out.println();
		
		System.out.print("num2: ");
		for (int i = 0; i < nums2.length; i++) {
			System.out.print(nums2[i]);
		}
		System.out.println();
		System.out.println("================================");
		
		// 3. print the highest 3 digit number from consecutive elements from array nums1
		
		int max = 0;
		int ind = 0;
		int cons = 0;
		int cons2 = 0;
		for (int i = 0; i < nums1.length; i++) {
			if (nums1[i] > max) {
				max = nums1[i];
				ind = i;
			}
		}
		
		// check left to right
		for (int i = ind; i < ind+3; i++) {
			if(ind == 14 || ind == 13) { // impossible consecutive 3 elements
			}else {
				cons = (cons*10)+nums1[i];				
			}
		}
		// check right to left
		for (int i = ind; i > ind-3; i--) {
			if (ind == 0 || ind == 1) { // impossible consecutive 3 elements
			}else {
				cons2 = (cons2*10)+nums1[i];				
			}
		}
		// check which one is bigger		
		if(cons>=cons2) {
			System.out.println(cons);
		}else {
			System.out.println(cons2);			
		}
		System.out.println("================================");		
		
		// 4. create 3rd array from numbers that are unique to nums1/nums2, without doubles
		Integer [] distinct = new Integer [10];
		Integer [] nums3 = new Integer [nums1.length]; // store unique numbers nums1 
		Integer [] nums4 = new Integer [nums2.length]; // store unique numbers nums2
		for (int i = 0; i < distinct.length; i++) {
			distinct[i] = (-1);
		}
		
		for (int i = 0; i < nums3.length; i++) {
			nums3[i] = (-1);
		}
		for (int i = 0; i < nums4.length; i++) {
			nums4[i] = (-1);
		}
		
		// find unique numbers numbs1
		lbl1: for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				if (nums1[i]==nums2[j]) {
					continue lbl1;
				}
				
			}
			for(int j = 0; j < nums3.length; j++) {
				if(nums3[j]==-1) {
					nums3[j]=nums1[i];	
					continue lbl1;					
				}
			}
			
		}
		System.out.println(Arrays.toString(nums3));
		System.out.println();
		
		// find unique numbers numbs2
		lbl2: for (int i = 0; i < nums2.length; i++) {
			for (int j = 0; j < nums1.length; j++) {
				if (nums2[i]==nums1[j]) {
					continue lbl2;
				}
				
			}
			for(int j = 0; j < nums4.length; j++) {
				if(nums4[j]==-1) {
					nums4[j]=nums2[i];	
					continue lbl2;					
				}
			}
			
		}
		System.out.println(Arrays.toString(nums4));
		System.out.println();
		
		// remove duplicates nums3
		LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>(Arrays.asList(nums3));
		Integer[] noDuplicates1 = linkedHashSet.toArray(new Integer[] {});
		System.out.println(Arrays.toString(noDuplicates1));
		System.out.println("================================");	
		
		// remove duplicates nums4
 /*
		LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>(Arrays.asList(nums4));
		Integer[] noDuplicates2 = linkedHashSet.toArray(new Integer[] {});
		System.out.println(Arrays.toString(noDuplicates2));
		System.out.println("================================");	
*/		
		// populate unique numbers without duplicates in distinct
		for (int i = 0; i < noDuplicates1.length; i++) {
			distinct[i] = noDuplicates1[i];
		}

		// 5. print 3rd array
		System.out.print("distinct: ");
		System.out.println(Arrays.toString(distinct));
		System.out.println("================================");	
		
		// 6. create and print the number consisting from elements from the 3rd array
		
		int number = 0;
		for (int i = 0; i < distinct.length; i++) {
			if(distinct[i]!=(-1)) {
				number = (number*10)+distinct[i]; // left to right
			}
		}
		System.out.println();
		System.out.println(number);
	}

}
