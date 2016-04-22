package com.ccniit.graduation.validator;

import com.ccniit.graduation.exception.IException;

public interface BaseVaildator<S> {

	boolean chech(S source) throws IException;

}
