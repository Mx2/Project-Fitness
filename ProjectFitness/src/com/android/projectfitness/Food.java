package com.android.projectfitness;

public class Food {
	
	public String[] Food;
	public int calories;
	public String dining_hall;
	public String time;
	public String meal;

	
	public String toString() {
		return meal + " " + calories;
		//return Food.toString();
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String Meal) {
		meal = Meal;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int Calories) {
		calories = Calories;
	}

	public String getDining_Hall() {
		return dining_hall;
	}

	public void setDining_Hall(String dininghall) {
		dining_hall = dininghall;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String Time) {
		time = Time;
	}

}
