package data_structures;

import java.util.Comparator;
import java.util.PriorityQueue;
import data_structures.Pair;


public class ElementQueue {
	//PriorityQueue does not have pointer to back so we must keep track of max.
	public Pair max;
	PriorityQueue<Pair> q;
	
	public ElementQueue() {
		// want smallest one first. 
		Comparator<Pair> c = new Comparator<Pair>() {
			public int compare(Pair a, Pair b) {
				if (a.elem == b.elem) {
					return 0;
				} else if (a.elem < b.elem) {
					return -1;
				} else {
					return 1;
				}
			}
			
		};
		
		q = new PriorityQueue<Pair>(10, c);
		max = null;
	}
	
	public void add(Pair a) {
		q.add(a);
		if (max == null || a.elem > max.elem) {
			max = a;
		}
	}
	
	public Pair dequeue() {
		Pair res = q.poll();
		if (q.isEmpty()) {
			max = null;
		}
		return res;
	}
	
	public Pair peek() {
		return q.peek();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Pair p : q) {
			sb.append(" (" + p.elem + ", " + p.index + ")");
		}
		return sb.toString();
	}
}