import java.util.Arrays;

public class gameboard {
	private int w, h;
	private int[][] mat;
	private int[][] matCopy;
	
	public gameboard() {
		this.w = 12;
		this.h = 12;
		mat = new int[w][h];
	}
	
	
	public gameboard(int w, int h) {
		this.w = w;
		this.h = h;
		mat = new int[w][h];
	}
	
	public void init() {
		// basic init model
		mat[2][2] = 1;
		mat[2][3] = 1;
		mat[2][4] = 1;
		mat[1][3] = 1;
	}
	
	public void play() {
		matCopy = copy();
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				int nearCellOutput = nearCell(i, j);
				if (matCopy[i][j] == 1) {
					if (nearCellOutput == 2 || nearCellOutput == 3) 
						continue;
					else 
						mat[i][j] = 0;
				} else {
					if (nearCellOutput == 3)
						mat[i][j] = 1;
				}
			}
		}
		print();
	}
	
	public void print() {
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				System.out.printf(mat[i][j] + " ");
			}
			System.out.printf("%n");
		}
		System.out.println("---------------");
	}
	
	private int[][] copy() {
		int[][] copy = new int[w][h];
		for (int i = 0; i < w; i++) {
			copy[i] = Arrays.copyOf(mat[i], h);
		}
		return copy;
	}
	
	private int nearCell(int x, int y) {
		int counter = 0;
		
		int min_x, min_y;
	    int max_x, max_y;

	    if ((x - 1) < 0)
	        min_x = 0;
	    else
	        min_x = x - 1;
	    if ((x + 1) > w - 1)
	        max_x = w - 1;
	    else
	        max_x = x + 1;
	    if ((y - 1) < 0)
	        min_y = 0;
	    else
	        min_y = y - 1;
	    if ((y + 1) > h - 1)
	        max_y = h - 1;
	    else
	        max_y = y + 1;

	    for (int i = min_x; i <= max_x; i++) {
	        for (int j = min_y; j <= max_y; j++) {
	            if (i == x && j == y) {
	                continue;
	            }
	            if (matCopy[i][j] == 1) {
	                counter++;
	            }
	        }
	    }
		return counter;
	}
}
