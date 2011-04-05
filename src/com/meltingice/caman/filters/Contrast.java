package com.meltingice.caman.filters;

import com.meltingice.caman.CamanFilter;
import com.meltingice.caman.CamanUtil;
import com.meltingice.caman.exceptions.InvalidArgument;

public class Contrast extends CamanFilter {

	@Override
	public int[] process(int[] rgb, double arg) throws InvalidArgument {
		arg = (arg + 100) / 100;
		arg = Math.pow(arg, 2);
		
		double[] drgb = CamanUtil.toDouble(rgb);
		
		for (int i = 0; i < 3; i++) {
			drgb[i] /= 255;
			drgb[i] -= 0.5;
			drgb[i] *= arg;
			drgb[i] += 0.5;
			drgb[i] *= 255;
		}
		
		return CamanUtil.clampRGB(drgb);
	}
}
