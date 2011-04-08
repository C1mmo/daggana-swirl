/* 
 * File:   GameBoard.cpp
 * Author: KJay
 * 
 * Created on April 8, 2011, 8:57 AM
 */

#include "GameBoard.h"

GameBoard::GameBoard() { }

GameBoard::GameBoard(Size size, GameType gameType, Difficulty difficulty)
{
    this->size = size;
    this->gameType = gameType;
    this->difficulty = difficulty;

    board = new Daggana[this->size][this->size];
    counter = new ScoreCounter();
    timer = new Timer();
}

GameBoard::GameBoard(const GameBoard& orig) { }

GameBoard::~GameBoard()
{
    delete [][] board;
    delete counter;
    delete timer;
}

Daggana GameBoard::getBoard()
{
    return board;
}

