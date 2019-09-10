package com.mohdfai.process.factory;

import com.mohdfai.common.RetailConstants;
import com.mohdfai.process.discount.AmountBasedDiscountProcess;
import com.mohdfai.process.discount.DiscountProcess;
import com.mohdfai.process.discount.PercentageBasedDiscountProcess;

public class DiscountFactory {
	private DiscountFactory() {}
	public static DiscountProcess getInstance(String discountType, double value) {
		if(discountType.equals(RetailConstants.PERCENT_BASED)) {
			return  new PercentageBasedDiscountProcess(value);
		}else {
			return new AmountBasedDiscountProcess(value);
			
		}
	}

}
