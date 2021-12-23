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
		
		// 4/5. create third array (length=5) with highest numbers from nums1, nums2
		
		int cc0 = 0;
		int cc1 = 0;
		int cc2 = 0;
		int cc3 = 0;
		int cc4 = 0;
		int cc5 = 0;
		int cc6 = 0;
		int cc7 = 0;
		int cc8 = 0;
		int cc9 = 0;
		
		for(int i = 0; i<nums1.length; i++) {
			if(nums1[i]==0) {
				cc0++;
			}else if(nums1[i]==1){
				cc1++;
			}else if(nums1[i]==2){
				cc2++;
			}else if(nums1[i]==3) {
				cc3++;
			}else if(nums1[i]==4) {
				cc4++;
			}else if(nums1[i]==5) {
				cc5++;
			}else if(nums1[i]==6) {
				cc6++;
			}else if(nums1[i]==7) {
				cc7++;
			}else if(nums1[i]==8) {
				cc8++;
			}else if(nums1[i]==9) {
				cc9++;
			}
		}
				
		int[] big2 = new int[9];
		big2[0]=cc0;
		big2[1]=cc1;
		big2[2]=cc2;
		big2[3]=cc3;
		big2[4]=cc4;
		big2[5]=cc5;
		big2[6]=cc6;
		big2[7]=cc7;
		big2[8]=cc8;
	
		int max2 = 0;
		for (int i = 0; i < big2.length; i++) {
			if (big2[i] > max2) {
				max2 = big2[i];
			}
		}
				
		int num2 = 0;
		for (int i = num2; i < big2.length; i++) {
			if (big2[i] == max2) {
				num2 = i;
			}
		}
		int num3 = 0;
		for (int i = 1; i<=max2; i++) {
			num3=(num3*10)+num2;
		}
		System.out.println(num3);
		System.out.println("================================");
		
		max2 = 0;
		for (int i = 0; i < big2.length; i++) {
			if (big2[i] > max2 && num2!=i) {
				max2 = big2[i];
				System.out.println(max2);
			}
		}
				
		int num4 = 0;
		for (int i = num4; i < big2.length; i++) {
			if (big2[i] == max2) {
				num4 = i;
			}
		}
		int num5 = 0;
		for (int i = 1; i<=max2; i++) {
			num5=(num5*10)+num4;
		}
		System.out.print(num5);
		
		System.out.println();
		System.out.println("================================");
		
		// 6. print the highest 3 digit number from all digits in array nums1, nums2, nums3
		
		// 7. create number from all even elements (no doubles) from array nums1 
		int[] areven = new int[5];
				
		lbl: for(int i = 1; i<nums1.length; i++) {
			if (nums1[i]%2==0) {
				for(int j = 0; j<areven.length; j++){
					if(nums1[i]!=areven[j]) {
						if(areven[j]==0) {
							areven[j]=nums1[i];
							System.out.print(areven[j]);
							continue lbl;
						}
					}else {
						continue lbl;
					}
				}
			}
		}
		System.out.println();
		System.out.println(Arrays.toString(areven));
		System.out.println("================================");
		
		// 8. create number from all odd elements (no doubles) from array nums2 
		int[] arodd = new int[5];
		
		lbl: for(int i = 1; i<nums2.length; i++) {
			if (nums2[i]%2!=0) {
				for(int j = 0; j<arodd.length; j++){
					if(nums2[i]!=arodd[j]) {
						if(arodd[j]==0) {
							arodd[j]=nums2[i];
							System.out.print(arodd[j]);
							continue lbl;
						}
					}else {
						continue lbl;
					}
				}
			}
		}
		System.out.println();
		System.out.println(Arrays.toString(arodd));
	}

}
