#include "GameBoard.h"

GameBoard::Selection::Selection(int size)
{
    this->size = size;
    selection = new int[size];
    currentIndex = 0;
}

GameBoard::Selection::Selection(int *selection)
{
    this->selection = selection;
}

void
GameBoard::Selection::addToSelection(int index)
{
    selection[currentIndex] = index;
    currentIndex++;
}

void
GameBoard::Selection::doAction(ActionType type)
{
    switch (type)
    {

        case LEFT:
        {
            break;
        }

        case RIGHT:
        {
            break;
        }

        case MIRROR_HORIZONTALLY:
        {
            break;
        }

        case MIRROR_VERTICALLY:
        {
            break;
        }

        case MIRROR_BOTH:
        {
            break;
        }
    }
}

int* GameBoard::Selection::getSelection()
{
    return this->selection;
}

GameBoard::Selection::~Selection()
{
    delete [] selection;
}
