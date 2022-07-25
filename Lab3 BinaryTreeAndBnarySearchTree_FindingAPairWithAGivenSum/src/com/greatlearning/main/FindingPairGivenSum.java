package com.greatlearning.main;

import java.util.HashSet;

public class FindingPairGivenSum {
	static class Node {
		int nodeData;
		Node leftNode, rightNode;
	};

	static Node NewNode(int nodedata) {
		Node temp = new Node();
		temp.nodeData = nodedata;
		temp.leftNode = null;
		temp.rightNode = null;
		return temp;
	}

	public Node insert(Node root, int key) {
		if (root == null)
			return NewNode(key);
		if (key < root.nodeData)
			root.leftNode = insert(root.leftNode, key);
		else
			root.rightNode = insert(root.rightNode, key);
		return root;
	}

	public boolean findpairUtil(Node root, int sum, HashSet<Integer> set) {
		if (root == null)
			return false;

		if (findpairUtil(root.leftNode, sum, set))
			return true;

		if (set.contains(sum - root.nodeData)) {
			System.out.println("Pair is found {" + (sum - root.nodeData) + ", " + root.nodeData + "}");
			return true;
		} else
			set.add(root.nodeData);
		return findpairUtil(root.rightNode, sum, set);
	}

	public void findPairWithGivenSum(Node root, int sum) {
		HashSet<Integer> set = new HashSet<Integer>();
		if (!findpairUtil(root, sum, set))
			System.out.println("Pairs do not exist");
	}

	public static void main(String args[]) {
		Node root = null;
		FindingPairGivenSum findPGS = new FindingPairGivenSum();
		root = findPGS.insert(root, 40);
		root = findPGS.insert(root, 20);
		root = findPGS.insert(root, 60);
		root = findPGS.insert(root, 10);
		root = findPGS.insert(root, 30);
		root = findPGS.insert(root, 50);
		root = findPGS.insert(root, 70);

		int sum = 130;
		findPGS.findPairWithGivenSum(root, sum);
	}
}
