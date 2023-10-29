import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

import javax.lang.model.element.Element;

// import linked_List.MyLinkedList.Node;

//Task 1.1: Implements some basic methods in MyArrayList.java as follows:
public class MyArrayList<E> {
	public static final int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;

	public MyArrayList() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int capacity) {
		this.elements = (E[]) new Object[capacity];
	}

	public MyArrayList(E[] elements, int size) {
		this.elements = elements;
		this.size = size;
	}

	// creates an array of double-size if the array of elements is full

	public void growSize() {

		if (elements.length > size) {
			size = elements.length * 2;
		}
		E[] newElements = (E[]) new Object[size];
		System.arraycopy(elements, 0, newElements, 0, elements.length);
		elements = newElements;
	}

	// Returns the number of elements in this list.
	public int size() {
		return elements.length;
	}

	// Returns whether the list is empty.
	public boolean isEmpty() {

		return elements.length == 0;
	}

	// Returns (but does not remove) the element at index i.
	public E get(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= elements.length) {
			throw new IndexOutOfBoundsException("index is not valid");
		}

		return elements[i];

	}

	// Replaces the element at index i with e, and
	// returns the replaced element. ∗/
	public E set(int i, E e) throws IndexOutOfBoundsException {
		E temp = elements[i];
		elements[i] = e;
		return temp;
	}

	// It is used to append the specified element at the end of a list.

	public boolean add(E e) {

		E[] newElements = (E[]) new Object[elements.length + 1];
		System.arraycopy(elements, 0, newElements, 0, elements.length);
		elements = newElements;
		elements[elements.length - 1] = e;
		return true;
	}

	// Inserts element e to be at index i, shifting all subsequent elements later.
	public void add(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i >= elements.length) {
			throw new IndexOutOfBoundsException("index is not valid");
		}
		int pivot = elements.length - i;
		E[] tmp1 = (E[]) new Object[elements.length - pivot];
		E[] tmp2 = (E[]) new Object[pivot];
		E[] newElements = (E[]) new Object[elements.length + 1];

		System.arraycopy(elements, 0, tmp1, 0, tmp1.length);

		System.arraycopy(elements, i, tmp2, 0, tmp2.length);

		System.arraycopy(tmp1, 0, newElements, 0, tmp1.length);
		newElements[i] = e;
		System.arraycopy(tmp2, 0, newElements, i + 1, tmp2.length);

		elements = newElements;

	}

	// Removes and returns the element at index i, shifting subsequent elements
	// earlier.
	public E remove(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= elements.length) {
			throw new IndexOutOfBoundsException("index is not valid");
		}
		int pivot = elements.length - i - 1;
		E[] tmp1 = (E[]) new Object[elements.length - pivot - 1];
		E[] tmp2 = (E[]) new Object[pivot];
		E[] newElements = (E[]) new Object[elements.length - 1];

		System.arraycopy(elements, 0, tmp1, 0, tmp1.length);

		System.arraycopy(elements, i + 1, tmp2, 0, tmp2.length);

		System.arraycopy(tmp1, 0, newElements, 0, tmp1.length);
		System.arraycopy(tmp2, 0, newElements, i, tmp2.length);

		elements = newElements;

		return elements[i];
	}

	// Then implements other methods as in Java Collection Framework -
	// ArrayList.java
	// It is used to clear all elements in the list.
	public void clear() {
		E[] newElements = (E[]) new Object[0];
		elements = newElements;

	}

	// It is used to return the index in this list of the
	// last occurrence of the specified element, or -1 if the
	// list does not contain this element.

	public int lastIndexOf(Object o) {
		for (int i = elements.length - 1; i >= 0; i--) {
			if (elements[i] == (E) o) { // can't compare with E's data is String
				return i;
			}
		}
		return -1;
	}
	// It is used to return an array containing all of the
	// elements in this list in the correct order.

	public E[] toArray() {
		E[] newArray = (E[]) new Object[elements.length];
		System.arraycopy(elements, 0, newArray, 0, elements.length);
		return newArray;
	}

	// It is used to return a shallow copy of an ArrayList.
	public MyArrayList<E> clone() {
		E[] newArray = (E[]) new Object[elements.length];
		System.arraycopy(elements, 0, newArray, 0, elements.length);
		MyArrayList<E> newMyArrayList = new MyArrayList<>(newArray, size());

		return newMyArrayList;
	}

	// It returns true if the list contains the specified element
	public boolean contains(E o) {
		for (E e : elements) {

			if (e == o) { // can't compare with E's data is String
				return true;
			}
		}
		return false;
	}

	// It is used to return the index in this list of the
	// first occurrence of the specified element, or -1 if the
	// List does not contain this element.
	public int indexOf(E o) {

		for (int i = 0; i < elements.length; i++) {

			if (elements[i] == (o)) { // can't compare with E's data is String
				return i;
			}
		}
		return -1;
	}

	// It is used to remove the first occurrence of the specified element.
	public boolean remove2(E e) {

		return false;
	}

	// It is used to sort the elements of the list on the basis of specified
	// comparator.
	public void sort(Comparator<E> c) {
		if (elements.length < 2) {
			return;
		}
		for (int i = 0; i < elements.length - 1; i++) {
			for (int j = i + 1; j < elements.length; j++) {
				if (c.compare(elements[i], elements[j]) > 0) {
					E temp = elements[i];
					elements[i] = elements[j];
					elements[j] = temp;
				}
			}
		}

	}

	public void print() {
		if (isEmpty()) {
			System.out.println("List is empty");
			return;
		}
		for (int i = 0; i < elements.length; i++) {
			System.out.print(elements[i] + " ");
		}
	}

}