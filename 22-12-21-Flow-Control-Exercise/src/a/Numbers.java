package a;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Numbers {

	public static void main(String[] args) {
		// 1. create two arrays
		int[] nums1 = new int[25];
		int[] nums2 = new int[25];

		// 2. populate arrays and print
		for (int i = 0; i < nums1.length; i++) {
			nums1[i] = (int) (Math.random() * 10);
		}

		System.out.print("num1: ");
		
		for (int i = 0; i < nums1.length; i++) {
			System.out.print(nums1[i]);
		}
		
		/* for each loop
		System.out.println();
		for(int i : nums1) {
			System.out.print(i);
		} */
		
		System.out.println();
		
		System.out.print("num2: ");
		for (int i = 0; i < nums2.length; i++) {
			nums2[i] = (int) (Math.random() * 10);
		}

		for (int i = 0; i < nums2.length; i++) {
			System.out.print(nums2[i]);
		}
		
		System.out.println();
		System.out.println("================================");

		// 3. find and print highest number consisting of identical elements from arrays
				
		int c0 = 0;
		int c1 = 0;
		int c2 = 0;
		int c3 = 0;
		int c4 = 0;
		int c5 = 0;
		int c6 = 0;
		int c7 = 0;
		int c8 = 0;
		int c9 = 0;
		
		for(int i = 0; i<nums1.length; i++) {
			if(nums1[i]==0) {
				c0++;
			}else if(nums1[i]==1){
				c1++;
			}else if(nums1[i]==2){
				c2++;
			}else if(nums1[i]==3) {
				c3++;
			}else if(nums1[i]==4) {
				c4++;
			}else if(nums1[i]==5) {
				c5++;
			}else if(nums1[i]==6) {
				c6++;
			}else if(nums1[i]==7) {
				c7++;
			}else if(nums1[i]==8) {
				c8++;
			}else if(nums1[i]==9) {
				c9++;
			}
		}
		System.out.print(c0);
		System.out.print(c1);
		System.out.print(c2);
		System.out.print(c3);
		System.out.print(c4);
		System.out.print(c5);
		System.out.print(c6);
		System.out.print(c7);
		System.out.print(c8);
		System.out.print(c9);
		
		System.out.println();
		
		int[] big = new int[9];
		big[0]=c0;
		big[1]=c1;
		big[2]=c2;
		big[3]=c3;
		big[4]=c4;
		big[5]=c5;
		big[6]=c6;
		big[7]=c7;
		big[8]=c8;
	
		int max = 0;
		for (int i = 0; i < big.length; i++) {
			if (big[i] > max) {
				max = big[i];
			}
		}
		System.out.println(max);
		int num = 0;
		for (int i = num; i < big.length; i++) {
			if (big[i] == max) {
				System.out.println(i);
				num = i;
			}
		}
		
		for (int i = 1; i<=max; i++) {
			System.out.print(num);
		}
		System.out.println();
		System.out.println("================================");
		
		// 7. create number from all even elements (no doubles) from array nums1 
		int[] areven = new int[5];
				
		lbl: for(int i = 1; i<nums1.length; i++) {
			if (nums1[i]%2==0) {
				for(int j = 0; j<areven.length; j++){
					if(nums1[i]!=areven[j]) {
						if(areven[j]==0) {
							areven[j]=nums1[i];
							continue lbl;
						}
					}
				}
			}
		}
		System.out.println(Arrays.toString(areven));
		
	}

}
