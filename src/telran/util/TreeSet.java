package telran.util;

import java.util.Comparator;
import java.util.Iterator;
@SuppressWarnings("unchecked")
public class TreeSet<T> implements SortedSet<T> {
private static class Node<T> {
	T obj;
	Node<T> parent;
	Node<T> left;
	Node<T> right;
	Node(T obj) {
		this.obj = obj;
	}
}
	Node<T> root;
	int size;
	Comparator<T> comp;
	private Node<T> getParentOrNode(T key) {
		Node<T> current = root;
		Node<T> parent = null;
		int compRes;
		while(current != null && (compRes = comp.compare(key, current.obj)) != 0) {
			parent = current;
			current = compRes < 0 ? current.left : current.right;
		}
		return current == null ? parent : current;
	}
	private Node<T> getParent(T key) {
		//returns null in the case the object matching key exists
		Node<T> node = getParentOrNode(key);
		Node<T> parent = null;
		if (comp.compare(key, node.obj) != 0) {
			parent = node;
		}
		return parent;
	}
	private Node<T> getNode(T key) {
		//returns null in the case the object matching key doesn't exist
				Node<T> node = getParentOrNode(key);
				Node<T> res = null;
				if (node != null && comp.compare(key, node.obj) == 0) {
					res = node;
				}
				return res;
			}
	public TreeSet(Comparator<T> comp) {
		this.comp = comp;
	}
	
	public TreeSet() {
		this((Comparator<T>)Comparator.naturalOrder());
	}
	@Override
	public T get(Object pattern) {
		Node<T> node = getNode((T)pattern);
		T res = null;
		if (node != null) {
			res = node.obj;
		
		}
		return res;
	}

	@Override
	public boolean add(T obj) {
		Node<T> node = new Node<T>(obj);
		boolean res = false;
		if(root == null) {
			res = true;
			root = node;
		} else {
			Node<T> parent = getParent(obj);
			if(parent != null) {
				res = true;
				node.parent = parent;
				int compRes = comp.compare(obj, parent.obj);
				if(compRes > 0) {
					parent.right = node;
				} else {
					parent.left = node;
				}
			}
		}
		if(res) {
			size++;
		}
		return res;
	}

	@Override
	public boolean remove(Object pattern) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object pattern) {
		
		return getNode((T) pattern) != null;
	}

	@Override
	public int size() {
		
		return size;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T first() {
		T res = null;
		if (root != null) {
			res = getLeastFrom(root).obj;
		}
		
		return res;
	}

	private Node<T> getLeastFrom(Node<T> node) {
		while(node.left != null) {
			node = node.left;
		}
		return node;
	}
	@Override
	public T last() {
		T res = null;
		if (root != null) {
			res = getGreatestFrom(root).obj;
		}
		
		return res;
	}

	private Node<T> getGreatestFrom(Node<T> node) {
		while(node.right != null) {
			node = node.right;
		}
		return node;
	}
	@Override
	public T ceiling(T key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T floor(T key) {
		// TODO Auto-generated method stub
		return null;
	}

}
