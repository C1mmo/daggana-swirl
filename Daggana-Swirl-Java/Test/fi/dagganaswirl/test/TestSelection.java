package fi.dagganaswirl.test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import fi.dagganaswirl.model.Selection;
import fi.dagganaswirl.model.Selection.ActionType;
import fi.dagganaswirl.model.Selection.Direction;

public class TestSelection {
	ArrayList<Integer> sl;
	List<Integer> exp;
	
	private ArrayList<Integer> generateList(int size) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < size; i++) {
			list.add(i + 1);
		}

		return list;
	}
	
	private void checkList(List<Integer> expected, Selection actual) {
		
		assertEquals(expected.size(), actual.size());
		
		for (int i = 0; i < actual.size(); i++) {
			assertEquals((int)expected.get(i), (int)actual.get(i));
		}
	}

	@Test
	public void testRowSizeCountEmptySelection() {
		sl = new ArrayList<Integer>();
		Selection s = new Selection(sl);

		assertEquals(0, s.getRowSize());
	}

	@Test
	public void testRowSizeCount3x3() {
		sl = generateList(9);		
		Selection s = new Selection(sl);	
		
		assertEquals(3, s.getRowSize());
	}
	
	@Test
	public void testRowSizeCount4x4() {
		sl = generateList(16);
		Selection s = new Selection(sl);
		
		assertEquals(4, s.getRowSize());
	}
	
	@Test
	public void testRowSizeCount10x10() {
		sl = generateList(100);
		Selection s = new Selection(sl);
		
		assertEquals(10, s.getRowSize());
		
	}
	
	@Test
	public void testHorizMirroring3x3() {
		sl = generateList(9);		
		Selection s = new Selection(sl);
		
		exp = Arrays.asList(3,2,1,6,5,4,9,8,7);
		
		checkList(exp, s.doAction(ActionType.MIRROR_HORIZONTALLY));
		
	}
	
	@Test
	public void testHorizMirroring4x4() {
		sl = generateList(16);
		Selection s = new Selection(sl);
		
		exp = Arrays.asList(4,3,2,1,8,7,6,5,12,11,10,9,16,15,14,13);
		
		checkList(exp, s.doAction(ActionType.MIRROR_HORIZONTALLY));
		
	}
	
	@Test
	public void testVertMirroring3x3() {
		sl = generateList(9);		
		Selection s = new Selection(sl);
		
		exp = Arrays.asList(7,8,9,4,5,6,1,2,3);
		
		checkList(exp, s.doAction(ActionType.MIRROR_VERTICALLY));
		
	}
	
	@Test
	public void testVertMirroring4x4() {
		sl = generateList(16);
		Selection s = new Selection(sl);
		
		exp = Arrays.asList(13,14,15,16,9,10,11,12,5,6,7,8,1,2,3,4);
		
		checkList(exp, s.doAction(ActionType.MIRROR_VERTICALLY));
		
	}
	
	@Test
	public void testVertMirroring10x10() {
		sl = generateList(100);
		Selection s = new Selection(sl);
		
		exp = Arrays.asList(91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 
				81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 
				71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 
				61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 
				51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 
				41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 
				31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 
				21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 
				11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		checkList(exp, s.doAction(ActionType.MIRROR_VERTICALLY));
		
	}
	
	@Test
	public void testMoveChainRight() {
		sl = generateList(9);
		Selection s = new Selection(sl);
		
		exp = Arrays.asList(9,1,2,3,4,5,6,7,8);
		
		checkList(exp, new Selection(s.moveChain(sl, Direction.RIGHT)));		
	}
	
	@Test
	public void testMoveChainLeft() {
		sl = generateList(9);
		Selection s = new Selection(sl);
		
		exp = Arrays.asList(2,3,4,5,6,7,8,9,1);
		
		checkList(exp, new Selection(s.moveChain(sl, Direction.LEFT)));		
	}
	
	@Test
	public void TestPeelingLayer0() {
		sl = generateList(16);
		Selection s = new Selection(sl);
		
		exp = Arrays.asList(1,2,3,4,4,8,12,16,13,14,15,16,1,5,9,13);
		
		checkList(exp, new Selection(s.peel(sl, 0)));		
	}
	
	@Test
	public void TestPeelingLayer1() {
		sl = generateList(16);
		Selection s = new Selection(sl);
		
		exp = Arrays.asList(7,8,8,12,12,11,11,7);
		
		checkList(exp, new Selection(s.peel(sl, 1)));		
	}
}
