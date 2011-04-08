/* 
 * File:   DagganaView.cpp
 * Author: miitri
 * 
 * Created on April 8, 2011, 5:22 PM
 */

#include "DagganaView.h"

DagganaView::DagganaView(Daggana::Type type)
{
	switchType(type);
}

DagganaView::DagganaView(const DagganaView& orig)
{
}

DagganaView::~DagganaView()
{
}

Daggana::Type DagganaView::getType()
{
	return this->type;
}

DagganaView::setType(Daggana::Type type)
{
	this->switchType(type);	
}

DagganaView::switchType(Daggana::Type newType)
{
	// Change image according to type
	switch (newType)
	{
		case Daggana::SQUARE:
			break;
		case Daggana::TRIANGLE:
			break;
		case Daggana::CIRCLE:
			break;
		case Daggana::PENTAGON:
			break;
		case Daggana::HEXAGON:
			break;
	}
	this->type = newType;
}