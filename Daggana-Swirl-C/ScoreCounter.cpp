/* 
 * File:   ScoreCounter.cpp
 * Author: KJay
 * 
 * Created on April 8, 2011, 9:39 AM
 */

#include "ScoreCounter.h"

ScoreCounter::ScoreCounter()
{
	this->score = 0;
}

ScoreCounter::ScoreCounter(const ScoreCounter& orig)
{
}

ScoreCounter::~ScoreCounter()
{
}

void ScoreCounter::addScore(int score)
{
	this->score += score;
}

int ScoreCounter::getScore()
{
	return this->score;
}

