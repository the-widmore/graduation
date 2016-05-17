package com.ccniit.graduation.builder;

import com.ccniit.graduation.exception.IException;

/**
 * 对象构建接口
 * 
 * @param B构建的依据 
 * @param T构建的目标
 */
public interface Builder<B, T> {

	/**
	 * @param B
	 *            构建的依据
	 * @param T
	 *            返回对象的类型
	 * @return 构建的对象
	 */
	T build(B by) throws IException;

}
