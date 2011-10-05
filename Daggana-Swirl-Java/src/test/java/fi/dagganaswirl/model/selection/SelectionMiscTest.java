package fi.dagganaswirl.model.selection;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fi.dagganaswirl.model.Selection;

public class SelectionMiscTest extends SelectionTest {
	
	@Test
	public void testRowSizeCountEmptySelection() {
		int[][] sl = new int[0][0];
		Selection s = new Selection(sl);

		assertEquals(0, s.rowSize());	
	}
	
	@Test
	public void testRowSizeCount3x3() {
		int[][] sl = generateList(3);	
		Selection s = new Selection(sl);	
		
		assertEquals(3, s.rowSize());		
	}
	
	@Test
	public void testRowSizeCount10x10() {
		int[][] sl = generateList(10);	
		Selection s = new Selection(sl);	
		
		assertEquals(10, s.rowSize());
	}
}
