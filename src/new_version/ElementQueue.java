package new_version;

import java.util.Comparator;
import java.util.PriorityQueue;
import new_version.Triple;


public class ElementQueue {
	//PriorityQueue does not have pointer to back so we must keep track of max.
	public Triple max;
	PriorityQueue<Triple> q;
	
	public ElementQueue() {
		// want smallest one first. 
		Comparator<Triple> c = new Comparator<Triple>() {
			public int compare(Triple a, Triple b) {
				if (a.round == b.round) {
					if (a.elem < b.elem) {
						return -1;
					} else if (a.elem > b.elem) {
						return 1;
					} else {
						return 0;
					}
				} else if (a.round < b.round) {
					return -1;
				} else {
					return 1;
				}
			}
			
		};
		
		q = new PriorityQueue<Triple>(10, c);
		max = null;
	}
	
	public void add(Triple a) {
		q.add(a);
		if (max == null || (a.round == max.round && a.elem > max.elem)) {
			max = a;
		}
	}
	
	public Triple dequeue() {
		Triple res = q.poll();
		if (q.isEmpty()) {
			max = null;
		}
		return res;
	}
	
	public Triple peek() {
		return q.peek();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Triple p : q) {
			sb.append(" (" + p.round + ", " + p.elem + ", " + p.index + ")");
		}
		return sb.toString();
	}
}