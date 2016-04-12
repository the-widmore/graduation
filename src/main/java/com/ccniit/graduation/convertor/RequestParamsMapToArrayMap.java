package com.ccniit.graduation.convertor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("requestParamsMapToArrayMap")
public class RequestParamsMapToArrayMap implements Converter<Map<String, String[]>, Map<String, List<String>>> {

	@Override
	public Map<String, List<String>> convert(Map<String, String[]> source) {

		Map<String, List<String>> resultMap = new HashMap<>(source.size());
		for (Map.Entry<String, String[]> param : source.entrySet()) {
			resultMap.put(param.getKey(), Arrays.asList(param.getValue()));
		}
		return resultMap;
	}

}
