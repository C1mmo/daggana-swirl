/* 
 * File:   Daggana.h
 * Author: miitri
 *
 * Created on April 7, 2011, 6:46 PM
 */

#ifndef DAGGANA_H
#define	DAGGANA_H

class Daggana
{
    Type type;

public:
    enum Type {SQUARE, TRIANGLE, CIRCLE, DICK, ASS};
    Daggana();
    Daggana(Type);
    Daggana(const Daggana& orig);
    virtual ~Daggana();
    Type getType();
private:

};

#endif	/* DAGGANA_H */

