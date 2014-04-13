package com.projectK.utils;

import java.lang.reflect.Field;

import com.projectK.common.DomainObject;

public interface HashFieldSelector {
	public boolean shouldIncludeField(DomainObject obj, Field f);
}
