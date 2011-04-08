/* 
 * File:   GameController.cpp
 * Author: KJay
 * 
 * Created on April 8, 2011, 10:11 AM
 */

#include "GameController.h"

GameController::GameController() { }

GameController::GameController(const GameController& orig) { }

GameController::~GameController()
{
    delete game;
}

void GameController::newGame()
{
    game = new GameBoard();
}

int main()
{
    GameController controller;

    return 0;

}

