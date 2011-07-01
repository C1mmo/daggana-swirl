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

void GameController::newGame(GameBoard::Size size, GameBoard::GameType gameType, GameBoard::Difficulty difficulty)
{
    game = new GameBoard(size, gameType, difficulty);
}

int main()
{
    GameController controller;
    controller.newGame(GameBoard::MEDIUM_SIZE, GameBoard::LIMITEDTIME, GameBoard::HARD);

    return 0;

}

