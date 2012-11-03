package com.android.projectfitness;

public class Diary {
		
		public String[] Diary;
		public int calories;
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



	
}
