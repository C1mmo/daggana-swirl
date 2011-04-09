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
#include "Daggana.h"
#include "ScoreCounter.h"
#include "Timer.h"

using namespace std;

class GameBoard
{
	class Selection{
	public:
		Selection(int);
		void addToSelection(Daggana &);
		vector< vector<Daggana*> >getSelection();
	private:
		vector <vector <Daggana*> > selection;
		void doAction();
	};
public:
    enum Size {SMALL = 10, MEDIUM_SIZE = 20, LARGE = 30};
    enum GameType {LIMITEDTIME, LIMITEDMOVES, RELAXED};
    enum Difficulty {EASY, MEDIUM_DIFFICULTY, HARD};
    GameBoard();
    GameBoard(Size, GameType, Difficulty);
    GameBoard(const GameBoard& orig);
    ~GameBoard();
    vector<vector<Daggana*> > getBoard();
private:
    Size size;
    GameType gameType;
    Difficulty difficulty;
	vector< vector<Daggana *> > board;
	ScoreCounter *counter;
    Timer *timer;

	void mergeSelection(const vector <vector<Daggana*> >);
};

#endif	/* GAMEBOARD_H */

