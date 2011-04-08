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
    enum Type {SQUARE, TRIANGLE, CIRCLE, PENTAGON, HEXAGON, KEKSIVIELAYKSITAHAN};
    Daggana();
    Daggana(Type);
    Daggana(const Daggana& orig);
    virtual ~Daggana();
    Type getType();
    void setType(Type type);
private:
    Type type;
};

#endif	/* DAGGANA_H */

