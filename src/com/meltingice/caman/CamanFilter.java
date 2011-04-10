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

import java.util.LinkedList;

/**
 * Abstract class for all filters. Override only the methods you need, and the
 * others will automatically throw an InvalidArgument exception.
 * 
 * @author Ryan LeFevre
 * 
 */
public abstract class CamanFilter {
	protected LinkedList<Object> params;

	/**
	 * Default constructor for the filter. This will probably never need to be
	 * overrode unless you're doing something really fancy.
	 */
	public CamanFilter() {
		params = new LinkedList<Object>();
	}

	/**
	 * Set a param for this filter. Params are stored in the order that they're
	 * added.
	 * 
	 * @param param
	 *            The param to set
	 * @return This filter object for chainability reasons
	 */
	public CamanFilter set(Object param) {
		params.add(param);

		return this;
	}

	/**
	 * Set an array of params for easier readability/simplicity
	 * 
	 * @param paramArr
	 *            An array of values to set
	 * @return This filter object for chainability reasons
	 */
	public CamanFilter set(Object[] paramArr) {
		for (Object param : paramArr) {
			params.add(param);
		}

		return this;
	}

	/**
	 * Retrieves the specified param and forces it to be a double. This avoids
	 * confusing the user by making some filters requiring doubles with others
	 * requiring integers.
	 * 
	 * @param num
	 *            The index of the argument
	 * @return The specified argument as a double
	 */
	public double getParamDouble(int num) {
		try {
			return (Double) params.get(num);
		} catch (Exception e) {
			return ((Integer) params.get(num)).doubleValue();
		}
	}

	/**
	 * Retrieves the specified param and forces it to be an integer. This avoids
	 * confusing the user by making some filters requiring doubles with others
	 * requiring integers.
	 * 
	 * @param num
	 *            The index of the argument
	 * @return The specified argument as an int
	 */
	public int getParamInt(int num) {
		try {
			return (Integer) params.get(num);
		} catch (Exception e) {
			return ((Double) params.get(num)).intValue();
		}
	}

	/**
	 * Allows the filter to precompute any required values before
	 * {@link CamanFilter#process(int[])} is executed. This helps with speed so
	 * that arguments don't have to be recomputed for every pixel.
	 */
	public void precomputeParams() {
		// Do nothing by default
	}

	/**
	 * Processes the given pixel and returns the updated values.
	 * 
	 * @param rgb
	 *            The current pixel's color values
	 * 
	 *            rgb[0] => red, rgb[1] => green, rgb[2] => blue
	 * @return The updated RGB color values
	 */
	public abstract int[] process(int[] rgb);
}