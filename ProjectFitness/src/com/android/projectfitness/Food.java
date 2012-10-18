package com.android.projectfitness;

public class Food {
	
	public String[] Food;
	public int Calories;
	public String Dining_Hall;
	public String Time;
	public String Meal;

	
	public String toString() {
		return Food + " " + Calories;
		//return Food.toString();
	}

	public String getMeal() {
		return Meal;
	}

	public void setMeal(String meal) {
		Meal = meal;
	}

	public int getCalories() {
		return Calories;
	}

	public void setCalories(int calories) {
		Calories = calories;
	}

	public String getDining_Hall() {
		return Dining_Hall;
	}

	public void setDining_Hall(String dininghall) {
		Dining_Hall = dininghall;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

}
