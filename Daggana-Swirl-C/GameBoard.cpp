/* 
 * File:   GameBoard.cpp
 * Author: KJay
 * 
 * Created on April 8, 2011, 8:57 AM
 */

#include "GameBoard.h"
#include <iostream>


GameBoard::GameBoard() { }

GameBoard::GameBoard(Size size, GameType gameType, Difficulty difficulty)
{
    this->size = size;
    this->gameType = gameType;
    this->difficulty = difficulty;

    srand(time(NULL));

    board = new Daggana[size * size];

    for (int i=0; i < size * size; i++)
    {
		board[i] = (Daggana) (rand() % (4 + difficulty));
    }

    counter = new ScoreCounter();
    timer = new Timer();
}

GameBoard::GameBoard(const GameBoard& orig) { }

GameBoard::~GameBoard()
{
    delete [] board;
    delete counter;
    delete timer;
}