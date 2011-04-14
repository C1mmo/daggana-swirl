/* 
 * File:   Daggana.cpp
 * Author: miitri
 * 
 * Created on April 7, 2011, 6:46 PM
 */

#include "Daggana.h"

Daggana::Daggana() { }

Daggana::Daggana(Type type)
{
    this->type = type;
}

Daggana::Daggana(int type)
{
    switch (type)
    {
        case 0:
            this->type = Daggana::SQUARE;
            break;
        case 1:
            this->type = Daggana::TRIANGLE;
            break;
        case 2:
            this->type = Daggana::CIRCLE;
            break;
        case 3:
            this->type = Daggana::PENTAGON;
            break;
        case 4:
            this->type = Daggana::HEXAGON;
            break;
        default:
            this->type = Daggana::DIAMOND;
    }

}

Daggana::Daggana(const Daggana& orig) { }

Daggana::~Daggana() { }

void
Daggana::setType(Type type)
{
    this->type = type;
}

Daggana::Type
Daggana::getType()
{
    return this->type;
}

