package com.lms.models;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

	char val;
	Map<Character, TrieNode> map;
	Boolean isLeaf;

	public TrieNode(char ch) {
		val = ch;
		map = new HashMap<Character, TrieNode>();
		isLeaf = false;
	}

	public char getValue() {
		return val;
	}
	
	public Map<Character, TrieNode> getChildren() {
		return map;
	}
	
	public void setIsLeaf(Boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public Boolean getIsLeaf() {
		return isLeaf;
	}
}
