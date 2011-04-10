/**
 * CamanJ - Java Image Manipulation
 * Ported from the CamanJS Javascript library
 *
 * Copyright 2011, Ryan LeFevre
 * Licensed under the new BSD License
 * See LICENSE for more info.
 * 
 * Project Home: http://github.com/meltingice/CamanJ
 */
package com.meltingice.caman;

/**
 * Utility class of static methods
 * 
 * @author Ryan LeFevre
 * @version 1.0
 */
public class CamanUtil {
	/**
	 * Clamps an integer value between 0 and 255
	 * 
	 * @param val
	 *            The value to clamp
	 * @return The clamped integer
	 */
	public static int clampRGB(int val) {
		if (val < 0) {
			return 0;
		} else if (val > 255) {
			return 255;
		}

		return val;
	}

	/**
	 * Clamps an array of integers between 0 and 255. Useful when returning an
	 * integer array from {@link CamanFilter#process(int[])}
	 * 
	 * @param rgb
	 *            The array of integers to clamp
	 * @return The array of clamped integers
	 */
	public static int[] clampRGB(int[] rgb) {
		rgb[0] = clampRGB(rgb[0]);
		rgb[1] = clampRGB(rgb[1]);
		rgb[2] = clampRGB(rgb[2]);
		rgb[3] = clampRGB(rgb[3]);

		return rgb;
	}

	/**
	 * Clamps an array of doubles and returns an array of integers. The reason
	 * it doesn't return an array of doubles is because this is designed to be
	 * returned from {@link CamanFilter#process(int[])}, and the return must be
	 * an int array. Doubles are converted to ints by simple casting, so the
	 * decimal portion of the double is dropped without rounding.
	 * 
	 * @param drgb
	 *            The array of doubles to clamp
	 * @return The array of clamped integers
	 */
	public static int[] clampRGB(double[] drgb) {
		int[] rgb = new int[4];
		rgb[0] = clampRGB((int) drgb[0]);
		rgb[1] = clampRGB((int) drgb[1]);
		rgb[2] = clampRGB((int) drgb[2]);
		rgb[3] = clampRGB((int) drgb[3]);

		return rgb;
	}

	/**
	 * Converts an integer array to a double array.
	 * 
	 * @param rgb
	 *            The integer array to convert
	 * @return The array of doubles
	 */
	public static double[] toDouble(int[] rgb) {
		return new double[] { (double) rgb[0], (double) rgb[1],
				(double) rgb[2], (double) rgb[3] };
	}

	/**
	 * Given an input string, format it to produce the class name for a filter.
	 * All it does is capitolize the first letter of the name.
	 * 
	 * @param input
	 *            The filter name
	 * @return The formatted filter name
	 */
	public static String getFilterName(String input) {
		if (input.length() == 0) {
			return input;
		}

		return Character.toUpperCase(input.charAt(0)) + input.substring(1);
	}
	
	public static double randomRange(double min, double max) {
		return min + (Math.random() * ((max - min) + 1));
	}
	
	public static int randomRange(int min, int max) {
		return min + (int)(Math.random() * ((max - min) + 1));
	}
}
