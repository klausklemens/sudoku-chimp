public enum SudokuIterType {
	ROW {
		public Coordinate next(Coordinate origin, int i) {
			return new Coordinate(i, origin.getRow());
		}
	},

	COLUMN {
		public Coordinate next(Coordinate origin, int i) {
			return new Coordinate(origin.getColumn(), i);
		}
	},

	PATCH {
		public Coordinate next(Coordinate origin, int i) {
			int newColumn = ((origin.getColumn() / 3) * 3) + (i % 3);
			int newRow = ((origin.getRow() / 3) * 3) + (i / 3);
			return new Coordinate(newColumn, newRow);
		}
	};

	public abstract Coordinate next(Coordinate origin, int i);
}
