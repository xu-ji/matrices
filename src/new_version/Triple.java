package new_version;

public class Triple {
	public int round;
	public int elem;
	public int index;
	public Triple(int round, int elem, int index) {
		this.round = round;
		this.elem = elem;
		this.index = index;
	}
	public Triple incRound() {
		round++;
		return this;
	}
}
