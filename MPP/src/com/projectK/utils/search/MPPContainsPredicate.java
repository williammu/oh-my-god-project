package com.projectK.utils.search;


public class MPPContainsPredicate extends MPPPredicate {

	public MPPContainsPredicate(String propertyName, String expectedValue) {
		super(propertyName, expectedValue);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean check(Object element) {
		String actualVal = getValue(element);

		if(actualVal.contains(expectedValue.replaceAll("%", "")))
			return true;
		
		return false;
	}

}
