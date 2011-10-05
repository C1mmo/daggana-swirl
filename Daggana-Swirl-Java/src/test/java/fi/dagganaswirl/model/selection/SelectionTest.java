package fi.dagganaswirl.model.selection;

import static org.junit.Assert.assertEquals;
import fi.dagganaswirl.model.Selection;

public class SelectionTest {
	public int[][] generateList(int rowSize) {
		int[][] list = new int[rowSize][rowSize];

		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < rowSize; j++) {
				list[i][j] = j + (i * rowSize) + 1;
			}
		}

		return list;
	}
	
	public void checkList(int[][] expected, Selection actual) {
		
		assertEquals(expected[0].length, actual.size());
		
		for (int i = 0; i < expected.length; i++) {
			for (int j = 0; j < expected[0].length; j++) {
				assertEquals(expected[i][j], actual.get(i, j));		
			}
		}
	}
}
