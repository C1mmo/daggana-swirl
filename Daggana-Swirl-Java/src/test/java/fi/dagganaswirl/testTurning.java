package fi.dagganaswirl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import fi.dagganaswirl.model.Selection;
import fi.dagganaswirl.model.Selection.ActionType;

public class testTurning {
	
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
	public void testTurnRight4x4() {
		List<Integer> sl = generateList(4 * 4);
		List<Integer> exp = Arrays.asList(13,9,5,1,14,6,7,2,15,10,11,3,16,12,8,4);
		Selection s = new Selection(sl);
		
		System.out.println("------ 4x4 -------");
		
		checkList(exp, s.doAction(ActionType.RIGHT));
	}
	
	@Test
	public void testTurnRight5x5() {
		List<Integer> sl = generateList(5 * 5);
		List<Integer> exp = Arrays.asList(21,16,11,6,1,22,17,12,7,2,23,18,13,8,3,24,19,14,9,4,25,20,15,10,5);
		Selection s = new Selection(sl);
		
		System.out.println("------ 5x5 -------");
		
		checkList(exp, s.doAction(ActionType.RIGHT));
	}
}
