package tcc.tcc1;

import java.util.ArrayList;

import android.util.Log;

public abstract class ManagerTest {
	
	static String APP_NAME = "colorBlind";
	
	private static int current = 0;
	
	private static ArrayList<Image> images = new ArrayList<Image>();
	private static ArrayList<String> answers = new ArrayList<String>();
	
	public static void startTest (ArrayList<Image> imgs) {
		ManagerTest.images = imgs;
		ManagerTest.answers = new ArrayList<String>();
		ManagerTest.current = 0;
		
		next();		
	}
	
	public static void setAnswer (String answer){
		answers.add(current - 1, answer);
	}
	
	public static void setImages (ArrayList<Image> images) {
		ManagerTest.images = images;
	}
	
	public static Boolean hasNext () {
		
		if (current < images.size()){
			return true;
		} else {
			return false;
		}
	}
	
	public static Image next () {
//		if (current == -1) {
//			current = 0;
//		}
//		setAnswer(answer);
		Image img = images.get(current++);
		
		Log.i(ManagerTest.APP_NAME, "NEXT - current: " + current);
		return img;
	}
	
	
	public static int getResultPercent () {
		int correct = 0;
		
		for (int i = 0; i < images.size(); i++) {
			
			if (images.get(i).getvalue().equals(answers.get(i)) ) {
				Log.i(ManagerTest.APP_NAME, "CORRETO");
				correct += 1;
			}
		}
		
		float percent = (correct * 100.0f) / images.size();		
		
		return (int)percent;
	}
}
