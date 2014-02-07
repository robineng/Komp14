package komp14.parser;

import java.util.ArrayList;



public class ParseTree<T> {
	private Node<T> root;
	
	public ParseTree(T root){
		this.root = new Node<T>(root);
	}
	
	public Node<T> getRoot(){
		return this.root;
	}
	
	

	public class Node<E>{
		private E data;
		private Node<E> parent;
		private ArrayList<Node<E>> children;
		
		private Node(){
			children = new ArrayList<Node<E>>();
		}
		
		private Node(E data){
			children = new ArrayList<Node<E>>();
			this.data = data;
		}
		
		public E getData(){
			return this.data;
		}
		public void setData(E data){
			this.data = data;
		}
		
		public Node<E> getParent(){
			return this.parent;
		}
		
		public void setParent(Node<E> parent){
			this.parent = parent;
		}
		
		public ArrayList<Node<E>> getChildren(){
			return this.children;
		}
		
		public void addChildren(Node<E> child){
			this.children.add(child);
		}
		
		
	}
}
