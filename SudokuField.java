import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;


public class SudokuField {
	private Pice[][] field;
	private Scanner input;

	public SudokuField() {
		this.input = new Scanner(System.in);
		this.field = new Pice[9][9];

		Random rng = new Random();
		for (int row = 0; row < this.field.length; row++) {
			for (int column = 0; column < this.field.length; column++) {
				this.field[column][row] = new Pice(rng.nextInt(9) + 1, false);
			}
		}

		this.tmpMarker();
	}

	private void tmpMarker() {
		for (int row = 0; row < this.field.length; row++) {
			for (int column = 0; column < this.field.length; column++) {
				Coordinate originCoord = new Coordinate(column, row);
				Pice originPice = this.getPice(originCoord);

				for (SudokuIterType iterationType : SudokuIterType.values()) {
					if (originPice.isMarked()) {
						break;
					}

					Iterator pices = this.getIterator(iterationType, originCoord);
					int c = 0;
					while (pices.hasNext()) {
						Pice pNow = (Pice) pices.next();
						if (originPice.equals(pNow)) {
							c += 1;
						}
					}

					if (c >= 2) {
						originPice.setMarked(true);
					}
				}
			}
		}
	}

	public void readInput() {
		String s = this.input.nextLine().toUpperCase();

		String[] coordString = s.split(":")[0].split(",");

		int[] coord = {Integer.parseInt(coordString[0]), Integer.parseInt(coordString[1])};

		this.field[coord[0]][coord[1]].setNumber(Integer.parseInt(s.split(":")[1]));

		for (int row = 0; row < this.field.length; row++) {
			for (int column = 0; column < this.field.length; column++) {
				this.field[column][row].setMarked(false);
			}
		}
		this.tmpMarker();
	}

	public Pice getPice(Coordinate c) {
		return field[c.getColumn()][c.getRow()];
	}

	@Override
	public String toString() {
		String divider = "+---+---+---+\n";

		String s = divider;
		for (int row = 0; row < this.field.length; row++) {
			for (int column = 0; column < this.field.length; column++) {
				if (column % 3 == 0) {
					s += "|";
				}
				s += this.field[column][row];
			}
			s += "|\n";
			if (row % 3 == 2) {
				s += divider;
			}
		}

		return s;
	}

	public Iterator getIterator(SudokuIterType iteratorType, Coordinate origin) {
		return new SudokuFieldIterator(iteratorType, origin);
	}

	private class SudokuFieldIterator implements Iterator {
		private int iterator = 0;
		private SudokuIterType iteratorType;
		private Coordinate origin;

		public SudokuFieldIterator(SudokuIterType iteratorType, Coordinate origin) {
			this.iteratorType = iteratorType;
			this.origin = origin;
		}

		public boolean hasNext() {
			return this.iterator < 9;
		}

		public Pice next() {
			Coordinate c = this.iteratorType.next(this.origin, this.iterator);
			this.iterator += 1;
			return getPice(c);
		}
	}
}
