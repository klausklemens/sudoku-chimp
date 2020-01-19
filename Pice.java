public class Pice {
	private int number;
	private boolean marked = false;

	public Pice(int number) {
		this.number = number;
	}

	public Pice(int number, boolean marked) {
		this.number = number;
		this.marked = marked;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean isMarked() {
		return this.marked;
	}

	public void setMarked(boolean marked) {
		this.marked = marked;
	}

	public boolean equals(Pice p) {
		return this.number == p.getNumber();
	}

	@Override
	public String toString() {
		String s;
		if (this.number == 0) {
			s = " ";
		} else {
			s = "" + (char) ('0' + this.number);
		}

		if (this.marked) {
			return "\u001B[31m" + s + "\u001B[0m"; //red
		} else {
			return s;
		}
	}
}