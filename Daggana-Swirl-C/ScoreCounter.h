/* 
 * File:   ScoreCounter.h
 * Author: KJay
 *
 * Created on April 8, 2011, 9:39 AM
 */

#ifndef SCORECOUNTER_H
#define	SCORECOUNTER_H

class ScoreCounter
{
public:
    ScoreCounter();
    ScoreCounter(const ScoreCounter& orig);
    virtual ~ScoreCounter();
	void addScore(int);
	int getScore();
private:
	int score;
};

#endif	/* SCORECOUNTER_H */

