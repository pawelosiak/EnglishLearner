package extend.testModule;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

/**
 * @author pawel Test rating module maded with simple fuzzylogic CoG inference
 *         method.
 * 
 *
 */
public class FuzzyLogic {

	// zmienne do budowy tablic
	static float value;
	static float step;

	// termy zmiennych lingwistycznych
	static String[][] difficultEasy = new String[22][3];
	static String[][] difficultMedium = new String[21][3];
	static String[][] difficultHard = new String[22][3];

	static String[][] examResbad = new String[31][3];
	static String[][] examResMid = new String[31][3];
	static String[][] examResGood = new String[48][3];

	static float[][] finalResBad = new float[101][3];
	static float[][] finalResMid = new float[101][3];
	static float[][] finalResGood = new float[101][3];
	static float[][] finalResExcellent = new float[101][3];

	// zmienne wej�ciowe u�ytkownika
	// float failPoints;
	float usersPoints;
	float wordCount;

	// zmienne do oblicze� fuzzy
	private String difficult;
	private static String examResult;
	String collectionDiff;
	String collectionRes;

	static float diffValueEasy;
	static float diffValueMedium;
	static float diffValueHard;
	static float resValueBad;
	static float resValueMid;
	static float resValueGood;
	static float fuzzyValue;
	DecimalFormat form = new DecimalFormat("0.0");
	DecimalFormat form1 = new DecimalFormat("0");

	/**
	 * @param level
	 * 
	 */
	public FuzzyLogic(String level, int wordsAll, int wordsGood) {
		this.difficult = level;
		this.wordCount = (float) wordsAll;
		// this.failPoints = wordsBad;
		this.usersPoints = (float) wordsGood;

		fillTermsDifficult();
		fillTermsExamRes();
		fuzzifyTerms();
		System.out.println("Values difficult: "+diffValueEasy+" "+diffValueMedium+" "+diffValueHard+", values result: "+resValueBad+" "+resValueMid+" "+resValueGood);
		System.out.println("Collection difficult: "+collectionDiff+" collection result: "+collectionRes);
		defuzzify(diffValueEasy, diffValueMedium, diffValueHard, resValueBad, resValueMid, resValueGood, collectionDiff, collectionRes );

		genReport();
		// float val = Float.parseFloat(difficultMedium[0][1].replaceAll(",", "."));

	}

	// funkcje buduj�ce termy
	private void fillTermsExamRes() {

		value = 0;
		step = 0;
		// Terms of exam result.
		for (int i = 0; i < examResbad.length; i++) {
			for (int j = 0; j < 2; j++) {

				if (j == 0) {
					examResbad[i][j] = form1.format(value);
					value += 1;

				} else if (j == 1) {
					examResbad[i][j] = form.format(step);

					if (value >= 0 && value <= 19) {
						step = 1.0f;
						

					}
					if (value > 19 && value <= 29) {
						step -= 0.1f;
						if (step == 0.79999995f) {
							step += 0.01f;

						}
					}
					if (step < 0.0) {
						step = 0.0f;
					}
					if (step > 1.0) {
						step = 1.0f;
					}
				}
				// System.out.println(examResbad[i][j] + " --Tabela rezultat testu Bad.");

			}
		}
		value = 19;
		step = 0;
		System.out.println("");
		System.out.println("--------------------");
		System.out.println("");
		for (int i = 0; i < examResMid.length; i++) {
			for (int j = 0; j < 2; j++) {

				if (j == 0) {
					examResMid[i][j] = form1.format(value);
					value += 1;

				} else if (j == 1) {
					examResMid[i][j] = form.format(step);

					if (value >= 19 && value <= 29) {
						step += 0.1f;
						if (step == 0.79999995f) {
							step += 0.01f;

						}

					}
					if (value > 29 && value < 45) {
						step = 1.0f;
					}
					if (value > 45) {
						step -= 0.1f;
						if (step == 0.79999995f) {
							step += 0.01f;

						}
					}
					if (step < 0.0) {
						step = 0.0f;
					}
					if (step > 1.0) {
						step = 1.0f;
					}
				}
				// System.out.println(examResMid[i][j] + " --Tabela rezultat testu Mid.");

			}
		}
		value = 45;
		step = 0;
		System.out.println("");
		System.out.println("--------------------");
		System.out.println("");
		for (int i = 0; i < examResGood.length; i++) {
			for (int j = 0; j < 2; j++) {

				if (j == 0) {
					examResGood[i][j] = form1.format(value);
					value += 1;

				} else if (j == 1) {
					examResGood[i][j] = form.format(step);

					if (value > 55) {
						step = 1.0f;

					}
					if (value > 45 && value <= 55) {
						step += 0.1f;
						if (step == 0.79999995f) {
							step += 0.01f;

						}
					}
					if (step < 0.0) {
						step = 0.0f;
					}
					if (step > 1.0) {
						step = 1.0f;
					}
				}
				// System.out.println(examResGood[i][j] + " --Tabela rezultat testu Good.");

			}
		}

	}

	private void fillTermsDifficult() {

		value = 0;
		step = 0;
		// Terms of difficulty level.
		for (int i = 0; i < difficultEasy.length; i++) {

			for (int j = 0; j < 2; j++) {
				if (j == 0) {
					difficultEasy[i][j] = form1.format(value);
					value += 1;

				} else if (j == 1) {
					difficultEasy[i][j] = form.format(step);

					if (value >= 0 && value <= 10) {
						step = 1.0f;

					}
					if (value > 10 && value <= 20) {
						step -= 0.1f;
						if (step == 0.79999995f) {
							step += 0.01f;

						}
					}
					if (step < 0.0) {
						step = 0.0f;
					}
					if (step > 1.0) {
						step = 1.0f;
					}
				}
				// System.out.println(difficultEasy[i][j] + " --Tabela poziomu trudności
				// Easy.");

			}

		}
		value = 10;
		step = 0;
		System.out.println("");
		System.out.println("--------------------");
		System.out.println("");
		for (int i = 0; i < difficultMedium.length; i++) {
			for (int j = 0; j < 2; j++) {

				if (j == 0) {
					difficultMedium[i][j] = form1.format(value);
					value += 1;

				} else if (j == 1) {
					difficultMedium[i][j] = form.format(step);
					if (value == 29.0) {
						step = 1.0f;

					}
					if (value >= 10 && value <= 20) {
						step += 0.1f;
						if (step == 0.79999995f) {
							step += 0.01f;

						}

					}
					if (value > 20 && value <= 45) {
						step =1.0f;
						
						
					}
					if(value > 45 && value <=55) {
						step -=0.1f;
						if (step == 0.79999995f) {
							step += 0.01f;

						}
					}
					if (step < 0.0) {
						step = 0.0f;
					}
					if (step > 1.0) {
						step = 1.0f;
					}
				}
				// System.out.println(difficultMedium[i][j] + " --Tabela poziomu trudności
				// Medium.");

			}
		}
		value = 45;
		step = 0;
		System.out.println("");
		System.out.println("--------------------");
		System.out.println("");
		for (int i = 0; i < difficultHard.length; i++) {
			for (int j = 0; j < 2; j++) {

				if (j == 0) {
					difficultHard[i][j] = form1.format(value);
					value += 1;

				} else if (j == 1) {
					difficultHard[i][j] = form.format(step);

					if (value >= 45 && value <=55) {
						step += 0.1f;
						if (step == 0.79999995f) {
							step += 0.01f;

						}

					}
					if (value > 55) {
						step = 1.0f;
						
					}
					if (step < 0.0) {
						step = 0.0f;
					}
					if (step > 1.0) {
						step = 1.0f;
					}
				}
				// System.out.println(difficultHard[i][j] + " --Tabela poziomu trudności
				// Hard.");

			}
		}
		value = 0;
		step = 0;
		System.out.println("");
		System.out.println("--------------------");
		System.out.println("");

	}

	private void fuzzifyTerms() {

		cutDifficult(difficult, wordCount);
		cutResult(calcResult(wordCount, usersPoints));
	}

	private void cutResult(float result) {
		float valueFirst = 0;
		float valueSecond = 0;
		float valueThird = 0;
		float maxRes;

		System.out.println("Result value: " + result);
		if (result == 0) {
			resValueBad = Float.parseFloat(examResbad[0][0].replaceAll(",", "."));
			valueFirst = Float.parseFloat(examResbad[0][1].replaceAll(",", "."));
		}
		if (result > 100) {
			resValueGood = 100;
			valueThird = 1.0f;
		}
		if (result != 0) {
			if (result > 0 && result < 29) {
				for (int i = 0; i < examResbad.length; i++) {
					for (int j = 0; j < examResbad.length; j++) {
						if (j == 0) {
							float x1 = Float.parseFloat(examResbad[i][j].replaceAll(",", "."));
							if (x1 == result) {
								valueFirst = Float.parseFloat(examResbad[i][j + 1].replaceAll(",", "."));
							}
						}
					}
				}
			}
			if (result > 19 && result < 55) {
				for (int i = 0; i < examResMid.length; i++) {
					for (int j = 0; j < examResMid.length; j++) {
						if (j == 0) {
							float x1 = Float.parseFloat(examResMid[i][j].replaceAll(",", "."));
							if (x1 == result) {
								valueSecond = Float.parseFloat(examResMid[i][j + 1].replaceAll(",", "."));
							}
						}
					}
				}
			}
			if (result > 45 && result <= 100) {
				for (int i = 0; i < examResGood.length; i++) {
					for (int j = 0; j < examResGood.length; j++) {
						if (j == 0) {
							float x1 = Float.parseFloat(examResGood[i][j].replaceAll(",", "."));
							if (x1 == result) {
								valueThird = Float.parseFloat(examResGood[i][j + 1].replaceAll(",", "."));
							}
						}
					}
				}
			}
		}
		if (valueFirst != 0 && valueSecond != 0) {
			maxRes = Math.max(valueFirst, valueSecond);
			if (valueFirst > valueSecond) {
				for (int i = 0; i < examResbad.length; i++) {
					for (int j = 0; j < examResbad.length; j++) {
						if (j == 1) {
							if (maxRes < Float.parseFloat(examResbad[i][j].replaceAll(",", "."))) {
								examResbad[i][j] = form.format(maxRes);
							}
						}
					}
				}
			}

			if (valueFirst < valueSecond) {
				for (int i = 0; i < examResMid.length; i++) {
					for (int j = 0; j < examResMid.length; j++) {
						if (j == 1) {
							if (maxRes < Float.parseFloat(examResMid[i][j].replaceAll(",", "."))) {
								examResMid[i][j] = form.format(maxRes);
							}
						}
					}
				}
			}

		}

		if (valueThird != 0 && valueSecond != 0) {
			maxRes = Math.max(valueThird, valueSecond);
			if (valueSecond > valueThird) {
				for (int i = 0; i < examResMid.length; i++) {
					for (int j = 0; j < examResMid.length; j++) {
						if (j == 1) {
							if (maxRes < Float.parseFloat(examResMid[i][j].replaceAll(",", "."))) {
								examResMid[i][j] = form.format(maxRes);
							}
						}
					}
				}
			}

			if (valueSecond < valueThird) {
				for (int i = 0; i < examResGood.length; i++) {
					for (int j = 0; j < examResGood.length; j++) {
						if (j == 1) {
							if (maxRes < Float.parseFloat(examResGood[i][j].replaceAll(",", "."))) {
								examResGood[i][j] = form.format(maxRes);
							}
						}
					}
				}
			}

		}
		float temp1 = Math.max(valueFirst, valueSecond);
		float temp2 = Math.max(valueSecond, valueThird);
		maxRes = Math.max(temp1, temp2);
		if (valueFirst > valueSecond) {
			collectionRes = new String("bad");
		} else if (valueSecond > valueThird) {
			collectionRes = new String("medium");
		} else if (valueSecond < valueThird) {
			collectionRes = new String("good");
		}
		resValueBad = valueFirst;
		resValueMid = valueSecond;
		resValueGood = valueThird;
	}

	private void cutDifficult(String difficult, float wordsAll) {

		float valueFirst = 0;
		float valueSecond = 0;
		float valueThird = 0;
		float maxDiff;

		float bonus = 0;

		if (difficult.equals("begginer")) {
			bonus = 0.0f;
		}
		if (difficult.equals("intermediate")) {
			bonus = 0.1f;
		}
		if (difficult.equals("expert")) {
			bonus = 0.2f;
		}

		if (wordsAll == 0) {
			diffValueEasy = Float.parseFloat(difficultEasy[0][0].replaceAll(",", "."));
			valueFirst = Float.parseFloat(difficultEasy[0][1].replaceAll(",", "."));
		}
		if (wordsAll > 55 && wordsAll <=100) {
			diffValueHard = 56;
			valueThird = 1.0f;
		}
		if (wordsAll != 0) {
			if (wordsAll > 0 && wordsAll < 20) {
				for (int i = 0; i < difficultEasy.length; i++) {
					for (int j = 0; j < difficultEasy.length; j++) {
						if (j == 0) {
							float x1 = Float.parseFloat(difficultEasy[i][j].replaceAll(",", "."));
							if (x1 == wordsAll) {
								valueFirst = Float.parseFloat(difficultEasy[i][j + 1].replaceAll(",", "."));
							}
						}
					}
				}
			}
			if (wordsAll > 10 && wordsAll < 55) {
				for (int i = 0; i < difficultMedium.length; i++) {
					for (int j = 0; j < difficultMedium.length; j++) {
						if (j == 0) {
							float x1 = Float.parseFloat(difficultMedium[i][j].replaceAll(",", "."));
							if (x1 == wordsAll) {
								valueSecond = Float.parseFloat(difficultMedium[i][j + 1].replaceAll(",", "."));
							}
						}
					}
				}
			}
			if (wordsAll > 45 && wordsAll < 100) {
				for (int i = 0; i < difficultHard.length; i++) {
					for (int j = 0; j < difficultHard.length; j++) {
						if (j == 0) {
							float x1 = Float.parseFloat(difficultHard[i][j].replaceAll(",", "."));
							if (x1 == wordsAll) {
								valueThird = Float.parseFloat(difficultHard[i][j + 1].replaceAll(",", "."));
							}
						}
					}
				}
			}
		}
		if (valueFirst != 0 && valueSecond != 0) {
			maxDiff = Math.max(valueFirst, valueSecond);
			if (valueFirst > valueSecond) {
				for (int i = 0; i < difficultEasy.length; i++) {
					for (int j = 0; j < difficultEasy.length; j++) {
						if (j == 1) {
							if (maxDiff < Float.parseFloat(difficultEasy[i][j].replaceAll(",", "."))) {
								difficultEasy[i][j] = form.format(maxDiff);
							}
						}
					}
				}
			}

			if (valueFirst < valueSecond) {
				for (int i = 0; i < difficultMedium.length; i++) {
					for (int j = 0; j < difficultMedium.length; j++) {
						if (j == 1) {
							if (maxDiff < Float.parseFloat(difficultMedium[i][j].replaceAll(",", "."))) {
								difficultMedium[i][j] = form.format(maxDiff);
							}
						}
					}
				}
			}

		}

		if (valueThird != 0 && valueSecond != 0) {
			maxDiff = Math.max(valueThird, valueSecond);
			if (valueSecond > valueThird) {
				for (int i = 0; i < difficultMedium.length; i++) {
					for (int j = 0; j < difficultMedium.length; j++) {
						if (j == 1) {
							if (maxDiff < Float.parseFloat(difficultEasy[i][j].replaceAll(",", "."))) {
								difficultMedium[i][j] = form.format(maxDiff);
							}
						}
					}
				}
			}

			if (valueSecond < valueThird) {
				for (int i = 0; i < difficultHard.length; i++) {
					for (int j = 0; j < difficultHard.length; j++) {
						if (j == 1) {
							if (maxDiff < Float.parseFloat(difficultMedium[i][j].replaceAll(",", "."))) {
								difficultHard[i][j] = form.format(maxDiff);
							}
						}
					}
				}
			}

		}
		float temp1 = Math.max(valueFirst, valueSecond);
		float temp2 = Math.max(valueSecond, valueThird);
		maxDiff = Math.max(temp1, temp2);
		if (valueFirst > valueSecond) {
			collectionDiff = new String("easy");
		} else if (valueSecond > valueThird) {
			collectionDiff = new String("medium");
		} else if (valueSecond < valueThird) {
			collectionDiff = new String("hard");
		}
		diffValueEasy = valueFirst;
		diffValueMedium = valueSecond ;
		diffValueHard = valueThird ;
		
	}

	private float calcResult(float wordsAll, float wordsGood) {

		float result = (wordsGood / wordsAll) * 100.0f;
		String temporaryRes = form1.format(result);
		return Float.parseFloat(temporaryRes);
	}

	private float defuzzify(float x1, float x2, float x3, float x4, float x5, float x6, String difficult, String collectionRes) {

		/*
		 * x1, x2, x3 - difficult values; x4, x5, x6 - result values;
		 * 
		 * Defuzzify rules for terms difficult, exam result and final result as out.
		 * Rule1: IF bad AND easy THEN Vbad 
		 * Rule2: IF bad AND medium THEN bad 
		 * Rule3: IF bad AND hard THEN Lmid
		 * 
		 * Rule4: IF medium AND easy Then Lmid 
		 * Rule5: IF medium AND medium THEN mid 
		 * Rule6: IF medium AND hard THEN Lgood
		 * 
		 * Rule7: IF good AND easy THEN mid 
		 * Rule8: IF good AND medium THEN good 
		 * Rule9: IF good AND hard THEN excellent
		 * 
		 */

		float diffValueFirst = 0;
		float diffValueSecond = 0;
		float diffValueThird = 0;

		float resValueFirst = 0;
		float resValueSecond = 0;
		float resValueThird = 0;
		float y = 0;

		if (difficult.equals("easy") && collectionRes.equals("bad")) {

			diffValueFirst = x1;
			diffValueSecond = x2;
			diffValueThird = x3;
			resValueFirst = x4;
			resValueSecond = x5;
			resValueThird = x6;

			float h1 = Math.min(diffValueFirst, resValueFirst);// Vbad
			float h2 = Math.min(diffValueFirst, resValueSecond);// Lbad
			float h3 = Math.min(diffValueFirst, resValueThird);// mid

			

			y = (10*h1+30*h2+40*0+50*h3+70*0+90*0+100*0) / (h1+h2+0+h3+0+0);

		}
		if (difficult.equals("medium") && collectionRes.equals("bad")) {

			diffValueFirst = x1;
			diffValueSecond = x2;
			diffValueThird = x3;
			resValueFirst = x4;
			resValueSecond = x5;
			resValueThird = x6;

			float h1 = Math.min(diffValueSecond, resValueFirst);// bad
			float h2 = Math.min(diffValueSecond, resValueSecond);// mid
			float h3 = Math.min(diffValueSecond, resValueThird);// Lgood

			

			y = (10*0+30*h1+40*0+50*h2+70*h3+90*0+100*0) / (0+h1+0+h2+h3+0+0);

		}
		if (difficult.equals("hard") && collectionRes.equals("bad")) {

			diffValueFirst = x1;
			diffValueSecond = x2;
			diffValueThird = x3;
			resValueFirst = x4;
			resValueSecond = x5;
			resValueThird = x6;

			float h1 = Math.min(diffValueThird, resValueFirst);// Lmid
			float h2 = Math.min(diffValueThird, resValueSecond);// Lgood
			float h3 = Math.min(diffValueThird, resValueThird);// good

			

			y = (10*0+30*0+40*h1+50*0+70*h2+90*h3+100*0) / (h1+h2+0+h3+0+0);

		}
		if (difficult.equals("easy") && collectionRes.equals("medium")) {

			diffValueFirst = x1;
			diffValueSecond = x2;
			diffValueThird = x3;
			resValueFirst = x4;
			resValueSecond = x5;
			resValueThird = x6;

			float h1 = Math.min(diffValueFirst, resValueSecond);//Lbad
			float h2 = Math.min(diffValueFirst, resValueFirst);// Vbad
			float h3 = Math.min(diffValueFirst, resValueThird);// mid

			

			y = (10*h2+30*h1+40*0+50*h3+70*0+90*0+100*0) / (h1+h2+0+h3+0+0);

		}
		if (difficult.equals("medium") && collectionRes.equals("medium")) {

			diffValueFirst = x1;
			diffValueSecond = x2;
			diffValueThird = x3;
			resValueFirst = x4;
			resValueSecond = x5;
			resValueThird = x6;

			float h1 = Math.min(diffValueSecond, resValueSecond);// mid
			float h2 = Math.min(diffValueSecond, resValueFirst);// mid
			float h3 = Math.min(diffValueSecond, resValueThird);// Lgood

			float h = Math.max(h2, h1);

			y = (10*0+30*0+40*0+50*h+70*h3+90*0+100*0) / (h+0+0+h3+0+0);

		}
		if (difficult.equals("hard") && collectionRes.equals("medium")) {

			diffValueFirst = x1;
			diffValueSecond = x2;
			diffValueThird = x3;
			resValueFirst = x4;
			resValueSecond = x5;
			resValueThird = x6;

			float h1 = Math.min(diffValueThird, resValueSecond);// Lgood
			float h2 = Math.min(diffValueThird, resValueFirst);// Lmid
			float h3 = Math.min(diffValueThird, resValueThird);// good

			

			y = (10*0+30*0+40*h2+50*0+70*h1+90*h3+100*0) / (h1+h2+0+0+h3+0+0);

		}
		if (difficult.equals("easy") && collectionRes.equals("good")) {

			diffValueFirst = x1;
			diffValueSecond = x2;
			diffValueThird = x3;
			resValueFirst = x4;
			resValueSecond = x5;
			resValueThird = x6;

			float h1 = Math.min(diffValueFirst, resValueThird);// mid
			float h2 = Math.min(diffValueFirst, resValueSecond);// Lbad
			float h3 = Math.min(diffValueFirst, resValueFirst);// Vbad

			

			y = (10*h3+30*h2+40*0+50*h1+70*0+90*0+100*0) / (h1+h2+0+h3+0+0);

		}
		if (difficult.equals("medium") && collectionRes.equals("good")) {

			diffValueFirst = x1;
			diffValueSecond = x2;
			diffValueThird = x3;
			resValueFirst = x4;
			resValueSecond = x5;
			resValueThird = x6;

			float h1 = Math.min(diffValueSecond, resValueThird);// Lgood
			float h2 = Math.min(diffValueSecond, resValueSecond);// mid
			float h3 = Math.min(diffValueSecond, resValueFirst);//bad

			

			y = (10*h3+30*0+40*0+50*h2+70*h1+90*0+100*0) / (h1+0+h2+0+h3+0+0);

		}
		if (difficult.equals("hard") && collectionRes.equals("good")) {

			diffValueFirst = x1;
			diffValueSecond = x2;
			diffValueThird = x3;
			resValueFirst = x4;
			resValueSecond = x5;
			resValueThird = x6;

			float h1 = Math.min(diffValueThird, resValueThird);// good
			float h2 = Math.min(diffValueThird, resValueFirst);// mid
			float h3 = Math.min(diffValueThird, resValueSecond);// Lmid

			

			y = (10*0+30*0+40*h3+50*h2+70*0+90*0+100*h1) / (0+0+h3+h2+0+0+h1);

		}
		System.out.println("Fuzzy value is: "+y);
		fuzzyValue = y;
		
		return fuzzyValue;
	}

	private void genReport() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(System.currentTimeMillis());
		int i=1;
		String fail;
		
		try {
		
				Path reports = Files.createFile(Paths.get("EnglishLearner/"+Tester.u+"/TestsResults/TestReport"+i+formatter.format(date)+".txt"));
				File report = new File(reports.toString());
				System.out.println(report);
				PrintWriter pw  = new PrintWriter(report);
				
				pw.println("Plik użyty do testu: "+Tester.filePath);
				pw.println("Wynik : "+usersPoints+"/"+wordCount);
				pw.println("Poziom trudności: "+difficult);
				pw.println("Wartość modułu oceniającego :"+fuzzyValue);
				pw.println("Wartości liczbowe z modułu oceniającego oznaczają odpowiednio:");
				pw.println("10 - bardzo zły wynik, musisz jeszcze dużo pracować nad słownictwem");
				pw.println("30 - zły wynik, nadal bardzo słabo pracuj dalej");
				pw.println("40 - średnio, powinieneś nadal dużo pracować");
				pw.println("50 - robisz postępy, popracuj jeszcze trochę aby było lepiej");
				pw.println("70 - całkiem nieźle, idzie Ci coraz lepiej");
				pw.println("90 - bardzo dobrze, ciężką pracą osiągasz sukces");
				pw.println("100 – rewelacja, opanowałeś ten plik testowy do perfekcji");
				pw.close();
			
			
		} catch (IOException e) {
			
			if(e.getMessage()!=null) {
				
				Path reports;
				try {
					i+=1;
					reports = Files.createFile(Paths.get("EnglishLearner/"+Tester.u+"/TestsResults/TestReport"+i+formatter.format(date)+".txt"));
					File report = new File(reports.toString());
					System.out.println(report);
					PrintWriter pw  = new PrintWriter(report);
					
					pw.println("Plik użyty do testu: "+Tester.filePath);
					pw.println("Wynik : "+usersPoints+"/"+wordCount);
					pw.println("Poziom trudności: "+difficult);
					pw.println("Wartość modułu oceniającego :"+fuzzyValue);
					pw.println("Wartości liczbowe z modułu oceniającego oznaczają odpowiednio:");
					pw.println("10 - bardzo zły wynik, musisz jeszcze dużo pracować nad słownictwem");
					pw.println("30 - zły wynik, nadal bardzo słabo pracuj dalej");
					pw.println("40 - średnio, powinieneś nadal dużo pracować");
					pw.println("50 - robisz postępy, popracuj jeszcze trochę aby było lepiej");
					pw.println("70 - całkiem nieźle, idzie Ci coraz lepiej");
					pw.println("90 - bardzo dobrze, ciężką pracą osiągasz sukces");
					pw.println("100 – rewelacja, opanowałeś ten plik testowy do perfekcji");
					pw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		}
	}
}
