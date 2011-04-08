/* 
 * File:   GameController.h
 * Author: KJay
 *
 * Created on April 8, 2011, 10:11 AM
 */

#ifndef GAMECONTROLLER_H
#define	GAMECONTROLLER_H
#include "GameBoard.h"

class GameController
{
    GameBoard *game;

public:
    GameController();
    GameController(const GameController& orig);
    virtual ~GameController();
    void newGame();
    int main();
private:

};

#endif	/* GAMECONTROLLER_H */

