package com.liyi.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class OverAll {
	/**
	 * JsonNode 和 ObjectNode的区别
	 * 1. JsonNode 是 ObjectNode的父类
	 */
	public void objectNodeToJsonNode(){
		ObjectMapper om = new ObjectMapper();
		ObjectNode on = om.createObjectNode();
	}
}
