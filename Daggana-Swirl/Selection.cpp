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
    size = sizeof (selection);
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
        case SHUFFLE:
        {
            srand(time(NULL));
            for (int i = 0; i < size -1; i++)
            {
                int random = rand() % (size - i);
                int temp = selection[i];
                selection[i] = selection[random];
                selection[random] = temp;
            }
            break;
        }
        case RANDOMIZE:
        {
            break;
        }
    }
}

int*
GameBoard::Selection::getSelection()
{
    return this->selection;
}

GameBoard::Selection::~Selection()
{
    delete [] selection;
}
