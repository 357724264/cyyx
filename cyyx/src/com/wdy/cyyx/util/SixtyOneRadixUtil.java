package com.wdy.cyyx.util;

import java.util.Stack;

/**
 * 六十一进制，用来生成主键 包含了英文的大小写，数字【除了z】,其中“-”符号用z代替
 * 
 * @author 日锐
 * 
 */
public class SixtyOneRadixUtil {

	private static char[] charSet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxy"
			.toCharArray();

	/**
	 * 将"xxxx-xxxx"装换成61进制
	 * 
	 * @param number用
	 *            “-”分割两个10进制数字
	 * @return
	 */
	public static String change(String number) {
		String[] nums = number.split("-");
		int length = nums.length;
		String ret = "";
		for (int i = 0; i < length; i++) {
			ret = ret + "z" + _10_to_61(Long.parseLong(nums[i]));
		}
		return ret.replaceFirst("z", "");

	}

	public static void main(String[] args) {
		System.err.println(change("3-1"));
	}

	/**
	 * 将10进制转化为62进制
	 * 
	 * @param number
	 * @param length
	 *            转化成的62进制长度，不足length长度的话高位补0，否则不改变什么
	 * @return
	 */
	public static String _10_to_61(long number) {
		Long rest = number;
		Stack<Character> stack = new Stack<Character>();
		StringBuilder result = new StringBuilder(0);
		while (rest != 0) {
			stack.add(charSet[new Long((rest - (rest / 62) * 62)).intValue()]);
			rest = rest / 62;
		}
		for (; !stack.isEmpty();) {
			result.append(stack.pop());
		}
		return result.toString();

	}

	/**
	 * 将62进制转换成10进制数
	 * 
	 * @param ident62
	 * @return
	 */
	public static String convertBase61ToDecimal(String ident61) {
		int decimal = 0;
		int base = 61;
		int keisu = 0;
		int cnt = 0;
		byte ident[] = ident61.getBytes();
		for (int i = ident.length - 1; i >= 0; i--) {
			int num = 0;
			if (ident[i] > 47 && ident[i] <= 56) {
				num = ident[i] - 48;
			} else if (ident[i] >= 65 && ident[i] <= 90) {
				num = ident[i] - 65 + 10;
			} else if (ident[i] >= 97 && ident[i] <= 122) {
				num = ident[i] - 97 + 10 + 26;
			}
			keisu = (int) java.lang.Math.pow((double) base, (double) cnt);
			decimal += num * keisu;
			cnt++;
		}
		return String.format("%08d", decimal);
	}

}
