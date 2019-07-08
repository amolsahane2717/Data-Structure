package com.bootstart.main;

import java.util.LinkedList;
import java.util.Queue;

public class TreeDemo {

	public static void main(String[] args) {
	
		Node node1 = new Node(5);
		Node node2 = new Node(4);
		Node node3 = new Node(10);
		Node node4 = new Node(15);
		Node node5 = new Node(1);
		Node node7 = new Node(3);
		Node node6 = new Node(12);
		
		Tree tree = new Tree();
		tree.insertData(tree.getRootNode(),node1);
		tree.insertData(tree.getRootNode(),node7);
		tree.insertData(tree.getRootNode(),node2);
		tree.insertData(tree.getRootNode(),node3);
		tree.insertData(tree.getRootNode(),node4);
		tree.insertData(tree.getRootNode(),node5);
		tree.insertData(tree.getRootNode(),node6);
		
		System.out.println("In Order: ");
		tree.readInOrder(tree.getRootNode());
		System.out.println();
		
		System.out.println("Pre Order: ");
		tree.readPreOrder(tree.getRootNode());
		System.out.println();
		
		System.out.println("Post Order: ");
		tree.readPostOrder(tree.getRootNode());
		System.out.println();
		
		System.out.println("Height:" + tree.height(tree.getRootNode()));
		
		System.out.println("Level Traversal : ");
		tree.getLevelTraversal(tree.getRootNode());
	}

}


class Node{
	
	Node left, right;
	int data;
	
	Node(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

class Tree{
	private Node root;
	
	public Node getRootNode() {
		return this.root;
	}
	void insertData(Node root, Node node) {
		if(this.root==null) {
			this.root = node;
			return;
		}else if(root.data > node.data) {
			//insert left
			if(root.left == null) {
				root.left = node;
			}else {
				insertData(root.left,node);
			}
		}else if(root.data < node.data) {
			//insert right
			if(root.right==null) {
				root.right=node;
			}else {
				insertData(root.right,node);
			}
		}
	}
	
	void readInOrder(Node root){
		if(root.left != null) {
			readInOrder(root.left);
		}
		System.out.print(root.data);
		if(root.right != null) {
			readInOrder(root.right);
		}
	}
	
	void readPostOrder(Node root) {
		if(root.left != null) {
			readPostOrder(root.left);
		}
		if(root.right != null) {
			readPostOrder(root.right);
		}
		System.out.print(root.data);
	}
	
	void readPreOrder(Node root) {
		System.out.print(root.data);
		if(root.left != null) {
			readPreOrder(root.left);
		}
		if(root.right != null) {
			readPreOrder(root.right);
		}
	}
	
	int height(Node root) {

	    int leftHeight = 0;
	    int rightHeight = 0;

	    if (root.left != null) {
	        leftHeight = 1 + height(root.left);
	    }

	    if (root.right != null) {
	        rightHeight = 1 + height(root.right);
	    }

	    return leftHeight > rightHeight ? leftHeight : rightHeight;
	}
	
	void getLevelTraversal(Node root) {
		Queue<Node> nodesToVisit = new LinkedList<Node>();
		nodesToVisit.add(root);
		while (!nodesToVisit.isEmpty()) {
			Node node = nodesToVisit.poll();
			System.out.println(node.data);
			if(node.left!=null)
				nodesToVisit.add(node.left);
			if(node.right!=null)
				nodesToVisit.add(node.right);
		}
		
	}
	

}