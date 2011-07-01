/* 
 * File:   GameBoard.h
 * Author: KJay & Miitri
 *
 * Created on April 8, 2011, 8:57 AM
 */

#ifndef GAMEBOARD_H
#define	GAMEBOARD_H
#include <vector>
#include <time.h>
#include <stdlib.h>
#include "ScoreCounter.h"
#include "Timer.h"
#include "Coordinate.h"  

using namespace std;

class GameBoard
{

	class Selection
	{
	public:

		enum ActionType
		{
			LEFT, RIGHT, MIRROR_HORIZONTALLY, MIRROR_VERTICALLY, MIRROR_BOTH,
			SHUFFLE, RANDOMIZE
		}; //Tähän lisää näitä

		Selection() { }
		Selection(int items);
		Selection(int *selection);
		~Selection();
		void addToSelection(int index);
		int* getSelection();
		//void addToSelection(Daggana &);
		//vector< vector<Daggana*> >getSelection();
	private:
		//vector <vector <Daggana*> > selection;
		int *origSelection, *changedSelection, size, currentIndex;
		void doAction(ActionType type);

	};
public:
	
	friend class Selection;

	enum Size
	{
		SMALL = 10, MEDIUM_SIZE = 20, LARGE = 30
	};

	enum GameType
	{
		LIMITEDTIME, LIMITEDMOVES, RELAXED
	};

	enum Difficulty
	{
		EASY, MEDIUM_DIFFICULTY, HARD
	};

	enum Daggana
	{
		SQUARE = 0, TRIANGLE = 1, CIRCLE = 2, PENTAGON = 3, HEXAGON = 4, DIAMOND = 5
	};
	GameBoard();
	GameBoard(Size, GameType, Difficulty);
	GameBoard(const GameBoard& orig);
	~GameBoard();
private:
	Size size;
	GameType gameType;
	Difficulty difficulty;
	ScoreCounter *counter;
	Timer *timer;
	Daggana *board;
	Selection *selection;

	inline int index(int x, int y, int cols)
	{
		return y * cols + x;
	}//1D taulukon indeksoimiseksi kaksiulotteisesti, x = x-koordinaatti
	//y = y=koordinaatti, c = sarakkeiden määrä
	//void mergeSelection(const vector <vector<Daggana*> >);
};

#endif	/* GAMEBOARD_H */

