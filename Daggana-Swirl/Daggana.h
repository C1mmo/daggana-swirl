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
    
public:
    enum Type {SQUARE = 0, TRIANGLE = 1, CIRCLE = 2, PENTAGON = 3, HEXAGON = 4, DIAMOND = 5};
    Daggana();
	Daggana(int);
    Daggana(Type);
    Daggana(const Daggana& orig);
    virtual ~Daggana();
    Type getType();
    void setType(Type type);	
private:
    Type type;
};

#endif	/* DAGGANA_H */

