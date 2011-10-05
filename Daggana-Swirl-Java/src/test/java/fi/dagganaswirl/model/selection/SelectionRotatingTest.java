package fi.dagganaswirl.model.selection;

import org.junit.Test;

import fi.dagganaswirl.model.Selection;
import fi.dagganaswirl.model.Selection.ActionType;

public class SelectionRotatingTest extends SelectionTest {
		
	@Test
	public void testTurnClockwise3x3() {
		int[][] sl = generateList(3);
		
		int[][] exp = {
			{7,4,1},
			{8,5,2},
			{9,6,3}
		};
		
		Selection s = new Selection(sl);
		s = s.doAction(ActionType.CLOCKWISE);
		
		System.out.println(s.toString());
		
		checkList(exp, s);
	}
	
	@Test
	public void testTurnClockwise4x4() {
		int[][] sl = generateList(4);
		
		int[][] exp = {
			{13,9,5,1},
			{14,10,6,2},
			{15,11,7,3},
			{16,12,8,4}
		};
		
		Selection s = new Selection(sl);
		s = s.doAction(ActionType.CLOCKWISE);
		
		System.out.println(s.toString());
		
		checkList(exp, s);
	}

	@Test
	public void testTurnCClockWise3x3() {
		int[][] sl = generateList(3);
		
		int[][] exp = {
			{3,6,9},
			{2,5,8},
			{1,4,7}
		};
		
		Selection s = new Selection(sl);
		s = s.doAction(ActionType.CCLOCKWISE);
		
		System.out.println(s.toString());
		
		checkList(exp, s);
	}
	
	@Test
	public void testTurnCClockWise4x4() {
		int[][] sl = generateList(4);
		
		int[][] exp = {
			{4,8,12,16},
			{3,7,11,15},
			{2,6,10,14},
			{1,5,9,13}
		};
		
		Selection s = new Selection(sl);
		s = s.doAction(ActionType.CCLOCKWISE);
		
		System.out.println(s.toString());
		
		checkList(exp, s);
	}
}
