package com.projectK.utils.search;


public class MPPEqualPredicate extends MPPPredicate {

	public MPPEqualPredicate(String propertyName, String expectedValue) {
		super(propertyName, expectedValue);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean check(Object element) {
		String actualVal = getValue(element);

		if(actualVal.equals(expectedValue))
			return true;
		
		return false;
	}

}
