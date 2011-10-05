package fi.dagganaswirl.model.selection;

import org.junit.Test;

import fi.dagganaswirl.model.Selection;
import fi.dagganaswirl.model.Selection.ActionType;

public class SelectionMirroringTest extends SelectionTest {	
		
	@Test
	public void testHorizontalMirroring3x3() {
		int[][] sl = generateList(3);		
		Selection s = new Selection(sl);		
		
		int[][] exp = {
			{3,2,1}, 
			{6,5,4},
			{9,8,7}
		};
		
		checkList(exp, s.doAction(ActionType.MIRROR_HORIZONTALLY));
		
		System.out.println("HORIZ3x3:\n" + s.toString());
	}
	
	@Test
	public void testHorizontalMirroring4x4() {
		int[][] sl = generateList(4);		
		Selection s = new Selection(sl);		
		
		int[][] exp = {
			{4,3,2,1}, 
			{8,7,6,5},
			{12,11,10,9}
		};
		
		checkList(exp, s.doAction(ActionType.MIRROR_HORIZONTALLY));
		
		System.out.println("HORIZ4x4:\n" + s.toString());
	}
	
	@Test
	public void testVertMirroring3x3() {
		int[][] sl = generateList(3);		
		Selection s = new Selection(sl);		
		
		int[][] exp = {
			{7,8,9}, 
			{4,5,6},
			{1,2,3}
		};
		
		checkList(exp, s.doAction(ActionType.MIRROR_VERTICALLY));
		
		System.out.println("VERT3x3:\n" + s.toString());		
	}
	
	@Test
	public void testVertMirroring4x4() {
		int[][] sl = generateList(4);
		Selection s = new Selection(sl);
		
		int[][] exp = {
			{13,14,15,16},
			{9,10,11,12},
			{5,6,7,8},
			{1,2,3,4}
		};
		
		checkList(exp, s.doAction(ActionType.MIRROR_VERTICALLY));
		
		System.out.println("VERT4x4:\n" + s.toString());		
	}
	
	@Test
	public void testMirrorBoth3x3() {
		int[][] sl = generateList(3);
		Selection s = new Selection(sl);	
		
		int[][] exp = {			
			{9,8,7},
			{6,5,4},
			{3,2,1}
		};	
		
		checkList(exp, s.doAction(ActionType.MIRROR_BOTH));
		
		System.out.println("BOTH3x3:\n" + s.toString());
	}
	
	
	@Test
	public void testMirrorBoth4x4() {
		int[][] sl = generateList(4);
		Selection s = new Selection(sl);	
		
		int[][] exp = {
			{16,15,14,13},
			{12,11,10,9},
			{8,7,6,5,4},
			{4,3,2,1}
		};	
		
		checkList(exp, s.doAction(ActionType.MIRROR_BOTH));
		
		System.out.println("BOTH4x4:\n" + s.toString());
	}
}
