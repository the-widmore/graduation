package com.ccniit.graduation.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class JSONUtils {

	public JSONUtils() {
	}

	public static String toJson(Object object) {
		SerializerFeature[] serializerFeatures = { SerializerFeature.WriteNullStringAsEmpty };
		return JSON.toJSONString(object, serializerFeatures);
	}

}
