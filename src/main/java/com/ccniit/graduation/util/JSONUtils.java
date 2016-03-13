package com.ccniit.graduation.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class JSONUtils {

	private JSONUtils() {

	}

	public static String toJSON(Object object) {
		SerializerFeature[] serializerFeatures = { SerializerFeature.WriteNullStringAsEmpty };
		return JSON.toJSONString(object, serializerFeatures);
	}

}
