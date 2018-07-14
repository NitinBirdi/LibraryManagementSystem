package com.lms.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.lms.models.TrieNode;

public class SearchService {

	public void insert(TrieNode root, String word) {

		TrieNode node = root;

		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);

			Map<Character, TrieNode> child = node.getChildren();

			if (child.containsKey(ch)) {
				node = child.get(ch);
			} else {
				node = new TrieNode(ch);
				child.put(ch, node);
			}
		}

		node.setIsLeaf(true);

	}

	public List<String> search(TrieNode root, String searchStr) {

		Map<Character, TrieNode> children = root.getChildren();
		List<String> resultList = new ArrayList<String>();

		TrieNode node = root;
		StringBuilder prefix = new StringBuilder();
		int i = 0;
		for (; i < searchStr.length(); i++) {
			char ch = searchStr.charAt(i);

			if (children.containsKey(ch)) {
				prefix.append(ch);
				node = children.get(ch);
				children = node.getChildren();

			} else {
				break;
			}
		}

		if (i != searchStr.length()) {
			return resultList;
		}
		
		getWordsStartingWithPrefix(node, prefix.toString(), resultList);
		

		return resultList;
	}

	public void getWordsStartingWithPrefix(TrieNode root, String prefix, List<String> resultList) {

		if (root == null) {
			return;
		}
		if (root.getIsLeaf()) {
			resultList.add(prefix);
			//return;
		}

		Map<Character, TrieNode> children = root.getChildren();

		Set<Character> suffices = children.keySet();

		for (Character ch : suffices) {
			getWordsStartingWithPrefix(children.get(ch), prefix+ch, resultList);

		}
	}

}
