public class Coordinate {
	private int column;
	private int row;

	public Coordinate(int column, int row) {
		this.column = column;
		this.row = row;
	}

	public boolean equals(Coordinate c) {
		return (this.column == c.getColumn()) && (this.row == c.getRow());
	}

	public int getColumn() {
		return this.column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getRow() {
		return this.row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	@Override
	public String toString() {
		return "[column:" + column + ", row:" + row + "]";
	}
}