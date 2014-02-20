package new_version;

import java.util.Arrays;
import new_version.ElementQueue;
import new_version.Triple;

public class MatrixMul {

	public static int[][] matrixMul(int[][] fst, int[][] snd) {
		// 2 square matrices of same dimensions
		assert(fst.length == snd.length && fst[0].length == snd[0].length && fst.length == fst[0].length);
		int dim = fst.length;
		
		int[][] res = new int[dim][dim];
		
		// queues comprised of the rows of b
		ElementQueue[] rq = new ElementQueue[dim];
		for (int r = 0; r < dim; r++) {
			rq[r] = new ElementQueue();
			for (int c = 0; c < dim; c++) {
				rq[r].add(new Triple(0, snd[r][c], c)); // insert pair of element and its column in snd
			}
		}
		
		for (int row = 0; row < dim; row++) {
			for (int col = 0; col < dim; col++) {
				
				int mulRes = 0;
				
				// iterate from 0 to largest element in snd[row]
				for (int mul = 0; (rq[col].max != null && mul <= rq[col].max.elem); mul++) {
					if (mul == rq[col].peek().elem) {
						Triple reached = rq[col].dequeue();
						res[row][reached.index] += mulRes;
						rq[col].add(reached.incRound());
					}
					
					mulRes+=fst[row][col];
				}
			}
		}
		
		return res;
	}
	
	
	public static void main(String[] args) {
		int[][] a = {{1, 3, 2},
				{4, 5, 6},
				{9, 8, 9}};
		int[][] b = {{50, 11, 12},
				{13, 14, 15},
				{16, 17, 18}};
		System.out.println("Multiplying: ");
		System.out.println(Arrays.deepToString(a));
		System.out.println("by: ");
		System.out.println(Arrays.deepToString(b));
		System.out.println("...");
		
		int[][] res = matrixMul(a, b);
		System.out.println("Got: ");
		System.out.println(Arrays.deepToString(res));
	}
	
}
