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

class GameBoard
{
    Daggana *board;
    ScoreCounter *counter;
    Timer *timer;
    Size size;
    GameType gameType;
    Difficulty difficulty;

public:
    enum Size {SMALL = 10, MEDIUM = 20, LARGE = 30};
    enum GameType {LIMITEDTIME, LIMITEDMOVES, RELAXED};
    enum Difficulty {EASY, MEDIUM, HARD};
    GameBoard();
    GameBoard(Size, GameType, Difficulty);
    GameBoard(const GameBoard& orig);
    ~GameBoard();
    Daggana getBoard();
private:

};

#endif	/* GAMEBOARD_H */

