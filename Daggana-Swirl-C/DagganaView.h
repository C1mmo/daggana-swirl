/* 
 * File:   DagganaView.h
 * Author: Miitri
 *
 * Created on April 8, 2011, 5:22 PM
 */

#ifndef DAGGANAVIEW_H
#define	DAGGANAVIEW_H

#include "Daggana.h"

class DagganaView
{
public:
	DagganaView(Daggana::Type type);
	DagganaView(const DagganaView& orig);
	virtual ~DagganaView();
	void setType(const Daggana::Type);
	Daggana::Type getType();
private:
	Daggana::Type type;
	void switchType(const Daggana::Type);
};

#endif	/* DAGGANAVIEW_H */

