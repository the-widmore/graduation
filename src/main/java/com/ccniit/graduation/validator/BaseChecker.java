package com.ccniit.graduation.validator;

import com.ccniit.graduation.exception.IException;

public interface BaseChecker<S, C> {

	boolean check(S source, C checker) throws IException;

}
