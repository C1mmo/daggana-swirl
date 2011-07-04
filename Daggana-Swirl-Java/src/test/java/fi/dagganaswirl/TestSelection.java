package fi.dagganaswirl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import fi.dagganaswirl.model.Selection;
import fi.dagganaswirl.model.Selection.ActionType;
import fi.dagganaswirl.model.Selection.Direction;

public class TestSelection {	
	
	private List<Integer> generateList(int size) {
		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < size; i++) {
			list.add(i + 1);
		}

		return list;
	}
	
	private void checkList(List<Integer> expected, Selection actual) {
		
		assertEquals(expected.size(), actual.size());
		
		for (int i = 0; i < expected.size(); i++) {
			assertEquals((int)expected.get(i), (int)actual.get(i));
		}
	}
	
	@Test
	public void testRowSizeCountEmptySelection() {
		List<Integer> sl = new ArrayList<Integer>();
		Selection s = new Selection(sl);

		assertEquals(0, s.getRowSize());
	}

	@Test
	public void testRowSizeCount3x3() {
		List<Integer> sl = generateList(3*3);		
		Selection s = new Selection(sl);	
		
		assertEquals(3, s.getRowSize());
	}
	
	@Test
	public void testRowSizeCount4x4() {
		List<Integer> sl = generateList(4*4);
		Selection s = new Selection(sl);
		
		assertEquals(4, s.getRowSize());
	}
	
	@Test
	public void testRowSizeCount10x10() {
		List<Integer> sl = generateList(10*10);
		Selection s = new Selection(sl);
		
		assertEquals(10, s.getRowSize());		
	}
	
	@Test
	public void testHorizMirroring3x3() {
		List<Integer> sl = generateList(3*3);		
		Selection s = new Selection(sl);
		
		List<Integer> exp = Arrays.asList(3,2,1,6,5,4,9,8,7);
		
		checkList(exp, s.doAction(ActionType.MIRROR_HORIZONTALLY));
		
	}
	
	@Test
	public void testHorizMirroring4x4() {
		List<Integer> sl = generateList(4*4);
		Selection s = new Selection(sl);
		
		List<Integer> exp = Arrays.asList(4,3,2,1,8,7,6,5,12,11,10,9,16,15,14,13);
		
		checkList(exp, s.doAction(ActionType.MIRROR_HORIZONTALLY));
		
	}
	
	@Test
	public void testVertMirroring3x3() {
		List<Integer> sl = generateList(3*3);		
		Selection s = new Selection(sl);
		
		List<Integer> exp = Arrays.asList(7,8,9,4,5,6,1,2,3);
		
		checkList(exp, s.doAction(ActionType.MIRROR_VERTICALLY));
		
	}
	
	@Test
	public void testVertMirroring4x4() {
		List<Integer> sl = generateList(4*4);
		Selection s = new Selection(sl);
		
		List<Integer> exp = Arrays.asList(13,14,15,16,9,10,11,12,5,6,7,8,1,2,3,4);
		
		checkList(exp, s.doAction(ActionType.MIRROR_VERTICALLY));
		
	}
	
	@Test
	public void testVertMirroring10x10() {
		List<Integer> sl = generateList(10*10);
		Selection s = new Selection(sl);
		
		List<Integer> exp = Arrays.asList(91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 
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
	public void testMirrorBoth() {
		List<Integer> sl = generateList(4*4);
		Selection s = new Selection(sl);
		
		System.out.println("---- Test Mirror both --------");
		
		List<Integer> exp = Arrays.asList(16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1);
		s = s.doAction(ActionType.MIRROR_BOTH);
		
		for(int i=0;i<s.size(); i++) {
			System.out.print(s.get(i) + " ");
		}
		
		checkList(exp, s);
	}
	
	@Test
	public void testMoveChainRight() {
		List<Integer> sl = generateList(3*3);
		Selection s = new Selection(sl);
		
		List<Integer> exp = Arrays.asList(9,1,2,3,4,5,6,7,8);
		
		checkList(exp, new Selection(s.moveChain(sl, Direction.RIGHT)));		
	}
	
	@Test
	public void testMoveChainLeft() {
		List<Integer> sl = generateList(3*3);
		Selection s = new Selection(sl);
		
		List<Integer> exp = Arrays.asList(2,3,4,5,6,7,8,9,1);
		
		System.out.println("---- Test Move chain L--------");
		
		checkList(exp, new Selection(s.moveChain(sl, Direction.LEFT)));	
	}
	
	@Test
	public void testPeelingLayer1() {
		List<Integer> sl = generateList(4*4);
		Selection s = new Selection(sl);
		
		List<Integer> expTop = Arrays.asList(1,2,3,4);
		List<Integer> expRight = Arrays.asList(4,8,12,16);
		List<Integer> expBottom = Arrays.asList(16,15,14,13);
		List<Integer> expLeft = Arrays.asList(1,5,9,13);		
		
		System.out.println("------ Test peeling l1-------");
		List<List<Integer>> sides =s.peel(sl, 0);
		
		checkList(expTop, new Selection(sides.get(0)));
		checkList(expRight, new Selection(sides.get(1)));
		checkList(expBottom, new Selection(sides.get(2)));
		checkList(expLeft, new Selection(sides.get(3)));
	}
	
	@Test
	public void testPeelingLayer2() {
		List<Integer> sl = generateList(4*4);
		Selection s = new Selection(sl);
		
		List<Integer> expTop = Arrays.asList(6,7);
		List<Integer> expRight = Arrays.asList(7,11);
		List<Integer> expBottom = Arrays.asList(11,10);
		List<Integer> expLeft = Arrays.asList(6,10);		
		
		System.out.println("------ Test peeling l2-------");
		List<List<Integer>> sides =s.peel(sl, 1);
		
		checkList(expTop, new Selection(sides.get(0)));
		checkList(expRight, new Selection(sides.get(1)));
		checkList(expBottom, new Selection(sides.get(2)));
		checkList(expLeft, new Selection(sides.get(3)));	
	}
	
	@Test
	public void testPeelingLayer3() {
		List<Integer> sl = generateList(10*10);
		Selection s = new Selection(sl);
		
		List<Integer> expTop = Arrays.asList(23,24,25,26,27,28);
		List<Integer> expRight = Arrays.asList(28,38,48,58,68,78);
		List<Integer> expBottom = Arrays.asList(78,77,76,75,74,73);
		List<Integer> expLeft = Arrays.asList(23,33,43,53,63,73);		
		
		System.out.println("------ Test peeling l3-------");
		List<List<Integer>> sides =s.peel(sl, 2);
		
		checkList(expTop, new Selection(sides.get(0)));
		checkList(expRight, new Selection(sides.get(1)));
		checkList(expBottom, new Selection(sides.get(2)));
		checkList(expLeft, new Selection(sides.get(3)));		
	}
	
	@Test
	public void testPeelingLayer4() {
		List<Integer> sl = generateList(10*10);
		Selection s = new Selection(sl);
		
		List<Integer> expTop = Arrays.asList(34,35,36,37);
		List<Integer> expRight = Arrays.asList(37,47,57,67);
		List<Integer> expBottom = Arrays.asList(67,66,65,64);
		List<Integer> expLeft = Arrays.asList(34,44,54,64);
		
		System.out.println("------ Test peeling l4-------");
		List<List<Integer>> sides =s.peel(sl, 3);
		
		checkList(expTop, new Selection(sides.get(0)));
		checkList(expRight, new Selection(sides.get(1)));
		checkList(expBottom, new Selection(sides.get(2)));
		checkList(expLeft, new Selection(sides.get(3)));
	}
	
	@Test
	public void testRandom() {
		List<Integer> sl = generateList(10*10);
		Selection s = new Selection(sl);	
		
		s.shuffle();
		
	}
	
}
