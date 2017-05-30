package dominio;

import java.awt.DisplayMode;

/* Class linkedList */
public class ListaDuplamenteCircular {
	public Node start;
	public Node end;

	public Node getStart() {
		return start;
	}

	public void setStart(Node start) {
		this.start = start;
	}

	public Node getEnd() {
		return end;
	}

	public void setEnd(Node end) {
		this.end = end;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int size;

	/* Constructor */
	public ListaDuplamenteCircular() {
		start = null;
		end = null;
		size = 0;
	}

	/* Function to check if list is empty */
	public boolean isEmpty() {
		return start == null;
	}

	/* Function to get size of list */
	public int getSize() {
		return size;
	}

	/* Function to insert element at begining */
	public void insertAtStart(Object val) {
		Node nptr = new Node(val, null, null);
		if (start == null) {
			nptr.setLinkNext(nptr);
			nptr.setLinkPrev(nptr);
			start = nptr;
			end = start;
		} else {
			nptr.setLinkPrev(end);
			end.setLinkNext(nptr);
			start.setLinkPrev(nptr);
			nptr.setLinkNext(start);
			start = nptr;
		}
		size++;
	}

	/* Function to insert element at end */
	public void insertAtEnd(Object val) {
		Node nptr = new Node(val, null, null);
		if (start == null) {
			nptr.setLinkNext(nptr);
			nptr.setLinkPrev(nptr);
			start = nptr;
			end = start;
		} else {
			nptr.setLinkPrev(end);
			end.setLinkNext(nptr);
			start.setLinkPrev(nptr);
			nptr.setLinkNext(start);
			end = nptr;
		}
		size++;
	}

	/* Function to insert element at position */
	public void insertAtPos(Object val, int pos) {
		Node nptr = new Node(val, null, null);
		if (pos == 1) {
			insertAtStart(val);
			return;
		}
		Node ptr = start;
		for (int i = 2; i <= size; i++) {
			if (i == pos) {
				Node tmp = ptr.getLinkNext();
				ptr.setLinkNext(nptr);
				nptr.setLinkPrev(ptr);
				nptr.setLinkNext(tmp);
				tmp.setLinkPrev(nptr);
			}
			ptr = ptr.getLinkNext();
		}
		size++;
	}

	/* Function to delete node at position */
	public void deleteAtPos(int pos) {
		if (pos == 1) {
			if (size == 1) {
				start = null;
				end = null;
				size = 0;
				return;
			}
			start = start.getLinkNext();
			start.setLinkPrev(end);
			end.setLinkNext(start);
			size--;
			return;
		}
		if (pos == size) {
			end = end.getLinkPrev();
			end.setLinkNext(start);
			start.setLinkPrev(end);
			size--;
		}
		Node ptr = start.getLinkNext();
		for (int i = 2; i <= size; i++) {
			if (i == pos) {
				Node p = ptr.getLinkPrev();
				Node n = ptr.getLinkNext();

				p.setLinkNext(n);
				n.setLinkPrev(p);
				size--;
				return;
			}
			ptr = ptr.getLinkNext();
		}
	}

	/* Function to display status of list */
	public void display() {
		Node ptr = start;
		if (size == 0) {
			System.out.print("empty\n");
			return;
		}
		if (start.getLinkNext() == start) {
			System.out.print(start.getData() + " - " + ptr.getData() + "\n");
			return;
		}
		System.out.print(start.getData() + " -");
		ptr = start.getLinkNext();
		while (ptr.getLinkNext() != start) {
			System.out.print(ptr.getData() + " - ");
			ptr = ptr.getLinkNext();
		}
		System.out.print(ptr.getData() + " -");
		ptr = ptr.getLinkNext();
//		System.out.print(ptr.getData() + "\n"); //imprime o primeiro
		System.out.println();
	}

	public class Node {

		protected Object data;
		protected Node next, prev;

		/* Constructor */
		public Node() {
			next = null;
			prev = null;
			data = 0;
		}

		/* Constructor */
		public Node(Object d, Node n, Node p) {
			data = d;
			next = n;
			prev = p;
		}

		/* Function to set link to next node */
		public void setLinkNext(Node n) {
			next = n;
		}

		/* Function to set link to previous node */
		public void setLinkPrev(Node p) {
			prev = p;
		}

		/* Funtion to get link to next node */
		public Node getLinkNext() {
			return next;
		}

		/* Function to get link to previous node */
		public Node getLinkPrev() {
			return prev;
		}

		/* Function to set data to node */
		public void setData(Object d) {
			data = d;
		}

		/* Function to get data from node */
		public Object getData() {
			return data;
		}
	}

	public void imprimeLista() {
		Node ptr = start;
		for(ptr = start; ptr.getLinkNext() != start  ;ptr = ptr.getLinkNext()){
			System.out.print(ptr.getData() + " - ");
		}
		System.out.println();
	}

	public int buscarElemento(Object data) {
		Node temp = start;
//		System.out.println("Start:" + start.data);
		for (int i = 1; i <= size; i++) {
			if (temp.data == data) {
//				System.out.println(temp.data + " é igual a "+ data);
				return i;
			}
			temp = temp.getLinkNext();
		}
		return -1;
	}

}
