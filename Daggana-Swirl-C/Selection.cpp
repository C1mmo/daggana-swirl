#include "GameBoard.h"

GameBoard::Selection::Selection(int size)
{
	this->size = size;
	origSelection = new int[size];
	currentIndex = 0;
}

GameBoard::Selection::Selection(int *selection)
{
	this->origSelection = selection;
	size = sizeof (selection) / sizeof (int);
}

void
GameBoard::Selection::addToSelection(int index)
{
	origSelection[currentIndex] = index;
	currentIndex++;
}

void
GameBoard::Selection::doAction(ActionType type)
{
	changedSelection = new int[size];

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
			for (int i = 0; i < size - 1; i++)
			{
				int random = rand() % (size - i);
				int temp = origSelection[i];
				changedSelection[i] = origSelection[random];
				changedSelection[random] = temp;
			}
			break;
		}
		case RANDOMIZE:
		{
			break;
		}
	}

	/*for (int i = 0; i < size; i++)
	{
		board[origSelection[i]] = board[changedSelection[i]];
	}*/
}

int*
GameBoard::Selection::getSelection()
{
	return this->changedSelection;
}

GameBoard::Selection::~Selection()
{
	delete [] origSelection;
	delete [] changedSelection;
}
