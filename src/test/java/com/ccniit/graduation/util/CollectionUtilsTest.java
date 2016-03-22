package com.ccniit.graduation.util;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class CollectionUtilsTest {

	@Test
	public void testPartition() {
		String[] tags = { "Ck", "Wr", "Sk", "Op", "Uc", "Qw" };
		List<String> tagsArray = CollectionUtils.partition(Arrays.asList(tags), 2, 3);
		System.out.println(Arrays.toString(tagsArray.toArray()));
	}

}
