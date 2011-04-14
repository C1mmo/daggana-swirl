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
        int random = rand() % (4 + difficulty);
        switch(random)
        {
            case 0 : board[i] = SQUARE;
            break;
            case 1 : board[i] = TRIANGLE;
            break;
            case 2 : board[i] = CIRCLE;
            break;
            case 3 : board[i] = PENTAGON;
            break;
            case 4 : board[i] = HEXAGON;
            break;
            case 5 : board[i] = DIAMOND;
            break;
        }
    }

    /*for (int row = 0; row < this->size; row++)
    {
            vector<Daggana *> newRow;
            for (int col = 0; col < this->size; col++)
            {
                    newRow.push_back(new Daggana(rand() % 4 + difficulty));
            }
            board.push_back(newRow);
    }

    //this->board = new vector<vector <Daggana> > (size, vector<Daggana>(size));
    //this->rows = new Daggana[size];
    //for (int i = 0; i < size; i++)
    //  rows[i] = new Daggana[size];*/

    counter = new ScoreCounter();
    timer = new Timer();
}

GameBoard::GameBoard(const GameBoard& orig) { }

GameBoard::~GameBoard()
{
    // iteroi vector ja poista dakkanat, sit delete board;
    delete [] board;
    delete counter;
    delete timer;
}

/*vector <vector<Daggana*> > GameBoard::getBoard()
{
        return board;
}*/

/*Daggana* GameBoard::getDaggana(Coordinate coords)
{
        if ( coords.y >= board.size()||coords.x >= board.at(0).size()){
                return NULL;
        }

        return board.at(coords.y).at(coords.x);
}*/