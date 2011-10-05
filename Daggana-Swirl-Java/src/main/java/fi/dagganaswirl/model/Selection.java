package fi.dagganaswirl.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Selection {
	public static enum ActionType {
		LEFT, RIGHT, MIRROR_HORIZONTALLY, MIRROR_VERTICALLY, MIRROR_BOTH, SHUFFLE
	}

	public static enum Direction {
		LEFT, RIGHT;
	}

	private List<Integer> container;
	private int rowSize;

	public Selection(List<Integer> selection) {
		this.container = selection;
		this.rowSize = calculateRowSize();
	}

	/**
	 * Get the size of one row or column
	 * 
	 * @return the rowSize
	 */
	public int getRowSize() {
		return rowSize;
	}

	public int size() {
		return this.container.size();
	}

	public int get(int index) {
		return this.container.get(index);
	}

	/**
	 * 
	 * @param enum
	 *            action type to be done to selection
	 * @return List<Integer> Selection New selection
	 */
	public Selection doAction(ActionType type) {

		switch (type) {
		case LEFT:			
			break;
		case RIGHT:
			this.turnRight();
			return this;
		case MIRROR_HORIZONTALLY:
			this.mirrorHorizontally();
			return this;
		case MIRROR_VERTICALLY:
			this.mirrorVertically();
			return this;
		case MIRROR_BOTH:
			this.container = this.mirrorGroup(this.container);			
			return this;
		case SHUFFLE:
			this.shuffle();
			return this;		
		default:
			throw new IllegalArgumentException("Invalid action type!");
		}

		return null;
	}

	private void turnRight() {		
		int target = 0;
		int i = 1;		
		
		while (i < this.rowSize - 1) {			
			target = (i > 0) ? (i + 1) * (this.rowSize - 1) : this.rowSize - 1;		 
			System.out.println(target);
			this.container = this.switchPlaces(i, target + i, this.container);
			System.out.println(this.toString());
			i++;
		}
		
		System.out.println();
		
		i = 1;
		
		while (i < this.rowSize - 1) {
			target = (this.size() - 1) - i;
			System.out.println(target);
			this.container = this.switchPlaces(i, target, this.container);
			System.out.println(this.toString());
			i++;
		}
		
		i = 1;
		
		System.out.println();
		
		while (i < rowSize - 1) {
			target = (this.size()) - (i + 1) * this.rowSize;
			System.out.println("---->" + target);
			this.container = this.switchPlaces(i, target, this.container);
			System.out.println(this.toString());
			i++;
		}
		
		this.container = this.switchCorners(this.container);
		
		System.out.println();
		
		System.out.println(this.toString());
	}
	
	private List<Integer> switchCorners(List<Integer> arr) {
		int temp = arr.get(0);
			
		arr.set(0, arr.get(arr.size() - this.rowSize));
		arr.set(arr.size() - this.rowSize, arr.get(arr.size() - 1));
		arr.set(arr.size() -1, arr.get(this.rowSize - 1));
		arr.set(this.rowSize - 1, temp);
		
		return arr;
	}

	public void shuffle() {
		Random rand = new Random();
		List<Integer> used = new ArrayList<Integer>();
		
		int from = -1;
		int to = -1;		
		
		while (used.size() < this.size()) {		
			do {
				from = rand.nextInt(this.size());
			} while (used.contains(from));
			
			do {
				to = rand.nextInt(this.size());
			} while (used.contains(to));
			
			this.container = this.switchPlaces(from, to, this.container);
			
			used.add(from);
			used.add(to);			
		}
		
		System.out.println(this.toString());
	}

	/**
	 * 
	 * @return List<Integer> Mirrored selection
	 */
	private List<Integer> mirrorHorizontally() {
		List<Integer> newSelection = new ArrayList<Integer>();

		int i = 0;

		while ((i + this.rowSize) <= this.size()) {
			List<Integer> row = this.mirrorGroup(this.container.subList(i, i
					+ this.rowSize));

			newSelection = this.merge(newSelection, row);

			i += this.rowSize;
		}

		this.container = new ArrayList<Integer>(newSelection);

		return newSelection;
	}
	
	private List<Integer> mirrorVertically() {
		List<Integer> newSelection = new ArrayList<Integer>(this.container);
		int rowFromBottom = -1;
		int movementAmount = 0;
		int i = 0;

		while (this.rowSize - rowFromBottom > 0) {

			if (i % this.rowSize == 0) {
				rowFromBottom += 2;
			}

			movementAmount = (this.rowSize - rowFromBottom) * this.rowSize;

			if (movementAmount < 0) {
				break;
			}

			int moveTo = i + movementAmount;

			this.switchPlaces(i, moveTo, newSelection);

			i++;
		}

		this.container = newSelection;
		System.out.println(this.toString());

		return newSelection;
	}
	
	private List<Integer> mirrorGroup(List<Integer> subList) {

		if (subList.size() < 2) {
			return subList;
		}

		int half = (int) Math.floor(subList.size() / 2) - 1;

		for (int i = 0; i <= half; i++) {
			subList = this.switchPlaces(i, subList.size() - (i + 1), subList);
		}

		return subList;
	}

	private List<Integer> switchPlaces(int from, int to, List<Integer> subject) {
		int temp = subject.get(to);

		subject.set(to, subject.get(from));
		subject.set(from, temp);

		return subject;
	}
	
	private List<Integer> merge(List<Integer> mergeTo, List<Integer> mergeFrom) {
		
		for (Iterator<Integer> it = mergeFrom.iterator(); it.hasNext();) {
			mergeTo.add(it.next());
		}
	
		return mergeTo;
	}
	
	public String toString() {
		String str = "";

		for (int i = 0; i < this.container.size(); i++) {
			if (i > 0 && i % this.rowSize == 0) {
				str = str.concat("\n");
			}
			str = str.concat(this.container.get(i).toString()).concat(" ");
		}

		return str;
	}
	
	/**
	 * Calculates the row size
	 * 
	 * @return length row size
	 */

	private int calculateRowSize() {
		int length = this.container.size();
		int i = 0;

		while (i < length / 2) {
			if ((i * i) == length) {
				return i;
			}
			i++;
		}

		return 0;
	}
	/*public List<List<Integer>> peel(List<Integer> subject, int layer) {
	List<List<Integer>> sides = new ArrayList<List<Integer>>();
	int lastindex = this.container.size() - 1;
	
	System.out.println("peeling layer " + layer);
	
	for (int i = 0; i < 4; i++) {
		ArrayList<Integer> side = new ArrayList<Integer>();
		sides.add(side);
	}

	for (int rowStart = layer + (this.rowSize * layer); rowStart < this.rowSize
			+ (this.rowSize * layer) - layer; rowStart++) {
		
		sides.get(0).add(subject.get(rowStart));
		sides.get(2).add(subject.get(lastindex - rowStart));
	}

	for (int i = layer * this.rowSize; i < this.rowSize * (this.rowSize - layer); i += this.rowSize) {
		sides.get(1).add(subject.get(i + this.rowSize - 1 - layer));
		sides.get(3).add(subject.get(i) + layer);
	}

	System.out.println("top:" + sides.get(0).toString());
	System.out.println("right:" + sides.get(1).toString());
	System.out.println("bottom:" + sides.get(2).toString());
	System.out.println("left:" + sides.get(3).toString());
	
	subject.clear();	
	
	return sides;
	}
	
	public List<Integer> moveChain(List<Integer> subject, Direction dir) {
		LinkedList<Integer> chain = new LinkedList<Integer>();
		Integer t = null;
		chain.addAll(subject);
	
		if (dir == Direction.RIGHT) {
			t = chain.removeLast();
			chain.addFirst(t);
		} else {
			t = chain.removeFirst();
			chain.addLast(t);
		}
		return chain;
	}	
	*/
	
	
	/*private List<Integer> unpeel(List<List<Integer>> outcome) {
	List<Integer> temp = new ArrayList<Integer>();
	int layer = (int) Math.floor(outcome.size() / 2);
	
	for (int rowStart = layer + (this.rowSize * layer); rowStart < this.rowSize
	+ (this.rowSize * layer) - layer; rowStart++) {			
		sides.get(0).add(subject.get(rowStart));
		sides.get(2).add(subject.get(lastindex - rowStart));
	}
	
	for (int i = layer * this.rowSize; i < this.rowSize * (this.rowSize - layer); i += this.rowSize) {
		sides.get(1).add(subject.get(i + this.rowSize - 1 - layer));
		sides.get(3).add(subject.get(i) + layer);
	}
	
	return temp;
}*/
/*
private List<Integer> mergeSides(List<List<Integer>> sides) {
	List<Integer> merged = new ArrayList<Integer>();		
	int i = 0;
	int side = 0;
	
	while (side < 4) {
		while (i < this.rowSize -1) {
			merged.add(sides.get(side).get(i));
			i++;
		}
		i = 0;
		side++;
	}
	
	return merged;
}

public List<List<Integer>> rotateSides(List<List<Integer>> sides, Direction dir) {		
	List<List<Integer>> newSides = new ArrayList<List<Integer>>();
	
	if (dir == Direction.RIGHT) {
		newSides.add(this.mirrorGroup(sides.get(3)));
		newSides.add(sides.get(0));
		newSides.add(sides.get(1));
		newSides.add(sides.get(2));
	} else if (dir == Direction.LEFT) {
		newSides.add(this.mirrorGroup(sides.get(3)));
		newSides.add(sides.get(0));
		newSides.add(sides.get(1));
		newSides.add(sides.get(2));
	}
	System.out.println("Printing sides:");
	System.out.println(newSides.get(0).toString());
	System.out.println(newSides.get(1).toString());
	System.out.println(newSides.get(2).toString());
	System.out.println(newSides.get(3).toString());
	
	return newSides;
}
 */
}
