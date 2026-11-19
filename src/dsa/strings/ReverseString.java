package dsa.strings;

import java.util.Arrays;

public class ReverseString {

	public static void main(String[] args) {
		char[] s = { 'h', 'e', 'l', 'l', 'o' };
		char[] o = reverseStr(s);
		System.out.println(Arrays.toString(o));
		
		//2nd String str ="java";
		String str = "java";
		String reversed = reverseString(str);
		System.out.println("string rev:"+reversed);
		
	}
	private static String reverseString(String str) {
		char[] arr = str.toCharArray();
		int left = 0;
		int right = arr.length-1;
		while(left<right) {
			char temp = arr[left];
			arr[left]= arr[right];
			arr[right]= temp;
			left++;
			right--;
		}
		return new String(arr);
	}
	private static char[] reverseStr(char[] s) {

		int left = 0;
		int right = s.length - 1;
		while (left < right) {
			char temp = s[left];
			s[left] = s[right];
			s[right] = temp;
			left++;
			right--;
		}
		return s;
	}
}
/*
 * Time : O(n) Space : O(1)
 */