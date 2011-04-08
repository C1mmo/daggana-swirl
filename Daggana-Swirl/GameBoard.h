/* 
 * File:   GameBoard.h
 * Author: KJay
 *
 * Created on April 8, 2011, 8:57 AM
 */

#ifndef GAMEBOARD_H
#define	GAMEBOARD_H
#include "Daggana.h"
#include "ScoreCounter.h"
#include "Timer.h"
#include <vector>

using namespace std;

class GameBoard
{
    vector<vector<Daggana> > *board;
    vector<Daggana> *testi;
    Daggana *rows, *columns;

    ScoreCounter *counter;
    Timer *timer;
    

public:
    enum Size {SMALL = 10, MEDIUM_SIZE = 20, LARGE = 30};
    enum GameType {LIMITEDTIME, LIMITEDMOVES, RELAXED};
    enum Difficulty {EASY, MEDIUM_DIFFICULTY, HARD};
    GameBoard();
    GameBoard(Size, GameType, Difficulty);
    GameBoard(const GameBoard& orig);
    ~GameBoard();
    //vector<vector<Daggana> > getBoard();
private:
    Size size;
    GameType gameType;
    Difficulty difficulty;
};

#endif	/* GAMEBOARD_H */

