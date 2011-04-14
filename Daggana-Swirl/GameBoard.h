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
#include "Coordinate.h"
#define index(x,y,c) (y*c + x)      //1D taulukon indeksoimiseksi kaksiulotteisesti, x = x-koordinaatti,
                                        //y = y=koordinaatti, c = sarakkeiden määrä

using namespace std;

class GameBoard
{

    class Selection
    {
    public:
        enum ActionType {LEFT, RIGHT, MIRROR_HORIZONTALLY, MIRROR_VERTICALLY, MIRROR_BOTH}; //Tähän lisää näitä
        Selection() {}
        Selection(int items);
        Selection(int *selection);
        ~Selection();
        void addToSelection(int index);
        int* getSelection();
        //void addToSelection(Daggana &);
        //vector< vector<Daggana*> >getSelection();
    private:
        //vector <vector <Daggana*> > selection;
        int *selection, size, currentIndex;
        void doAction(ActionType type);
    };
public:

    enum Size
    {
        SMALL = 10, MEDIUM_SIZE = 20, LARGE = 30
    };

    enum GameType
    {
        LIMITEDTIME, LIMITEDMOVES, RELAXED
    };

    enum Difficulty
    {
        EASY, MEDIUM_DIFFICULTY, HARD
    };
    enum DagganaType {SQUARE = 0, TRIANGLE = 1, CIRCLE = 2, PENTAGON = 3, HEXAGON = 4, DIAMOND = 5};
    GameBoard();
    GameBoard(Size, GameType, Difficulty);
    GameBoard(const GameBoard& orig);
    ~GameBoard();
    //vector<vector<Daggana*> > getBoard();
    //Daggana* getDaggana(Coordinate);
private:
    Size size;
    GameType gameType;
    Difficulty difficulty;
    //vector< vector<Daggana *> > board;
    ScoreCounter *counter;
    Timer *timer;
    int *board;
    Selection *selection;
    
    void updateBoard();

    //void mergeSelection(const vector <vector<Daggana*> >);
};

#endif	/* GAMEBOARD_H */

