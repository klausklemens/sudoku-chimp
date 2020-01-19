public class Sudoku {
	private SudokuField field;

	public Sudoku() {
		this.field = new SudokuField();
		System.out.println(field);

		while (true) {
			field.readInput();

			System.out.println(field);
		}
	}

	@Override
	public String toString() {
		return this.field.toString();
	}
}
