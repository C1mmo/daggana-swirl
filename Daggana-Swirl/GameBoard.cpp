/* 
 * File:   GameBoard.cpp
 * Author: KJay
 * 
 * Created on April 8, 2011, 8:57 AM
 */

#include "GameBoard.h"
#include <time.h>

GameBoard::GameBoard() { }

GameBoard::GameBoard(Size size, GameType gameType, Difficulty difficulty)
{
    this->size = size;
    this->gameType = gameType;
    this->difficulty = difficulty;


    this->board = new vector<vector <Daggana> > (size, vector<Daggana>(size));
    //this->testi = new vector<Daggana> (size, new Daggana());
    //this->rows = new Daggana[size];
    //for (int i = 0; i < size; i++)
      //  rows[i] = new Daggana[size];
    //srand(time(NULL));
    /*for (int i=0; i < board.size(); i++)
    {
        for (int j=0; j < board[i].size(); j++)
        {}
            //board[i][j] = new Daggana((rand % 4) + difficulty);
    }*/
    counter = new ScoreCounter();
    timer = new Timer();
}

GameBoard::GameBoard(const GameBoard& orig) { }

GameBoard::~GameBoard()
{
    delete board;
    delete counter;
    delete timer;
}

/*vector<vector<Daggana> > GameBoard::getBoard()
{
    return board;
}*/

