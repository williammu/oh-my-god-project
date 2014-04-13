package com.projectK.utils.search;

public class MPPNotContainsPredicate extends MPPPredicate {

	public MPPNotContainsPredicate(String propertyName, String expectedValue) {
		super(propertyName, expectedValue);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean check(Object element) {
		String value = getValue(element);
		
		if(!value.contains(expectedValue.replaceAll("%", "")))
			return true;
		
		return false;
	}

}
