package com.ccniit.graduation.builder;

/**
 * 对象构建接口
 * 
 * @param B构建的依据
 * @param T构建的目标
 */
public interface Builder<B, T> {

	/**
	 * @param B构建的依据
	 * @return 构建的对象
	 */
	T build(B by);

}
