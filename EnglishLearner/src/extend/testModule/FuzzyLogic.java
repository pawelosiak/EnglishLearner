package extend.testModule;

import java.text.DecimalFormat;

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
	//float failPoints;
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
		this.difficult=level;
		this.wordCount =(float) wordsAll;
		//this.failPoints = wordsBad;
		this.usersPoints = (float)wordsGood;
		
		fillTermsDifficult();
		fillTermsExamRes();
		fuzzifyTerms();

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

					if (value >= 0 && value <= 20) {
						step = 1.0f;

					}
					if (value > 20 && value <= 30.0) {
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
		value = 25;
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

					if (value >= 25 && value <= 35) {
						step += 0.1f;

					}
					if (value > 35 && value < 45) {
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
		value = 53;
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

					if (value > 63) {
						step = 1.0f;

					}
					if (value > 53 && value <= 63) {
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

					if (value >= 1 && value < 11) {
						step += 0.1;

					}
					if (value > 11 && value <= 21.0) {
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
		value = 19;
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
					if (value > 29.0 && value <= 39.0) {
						step -= 0.1f;

					}
					if (value > 19 && value <= 29.0) {
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
				// System.out.println(difficultMedium[i][j] + " --Tabela poziomu trudności
				// Medium.");

			}
		}
		value = 35;
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

					if (value > 45) {
						step = 1.0f;

					}
					if (value >= 35 && value <= 45) {
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

		System.out.println("Result value: "+result);
		if (result == 0) {
			resValueBad = Float.parseFloat(examResbad[0][0].replaceAll(",", "."));
			valueFirst = Float.parseFloat(examResbad[0][1].replaceAll(",", "."));
		}
		if (result > 100) {
			resValueGood = 100;
			valueThird = 1.0f;
		}
		if (result != 0) {
			if (wordsAll > 0 && wordsAll < 21) {
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
			if (wordsAll > 19 && wordsAll < 39) {
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
			if (wordsAll > 35 && wordsAll < 59) {
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
	}

	private void cutDifficult(String difficult, float wordsAll) {

		float valueFirst = 0;
		float valueSecond = 0;
		float valueThird = 0;
		float maxDiff;

		float bonus = 0;

		if (difficult.equals("easy")) {
			bonus = 0.0f;
		}
		if (difficult.equals("medium")) {
			bonus = 0.1f;
		}
		if (difficult.equals("hard")) {
			bonus = 0.2f;
		}

		if (wordsAll == 0) {
			diffValueEasy = Float.parseFloat(difficultEasy[0][0].replaceAll(",", "."));
			valueFirst = Float.parseFloat(difficultEasy[0][1].replaceAll(",", "."));
		}
		if (wordsAll > 56) {
			diffValueHard = 56;
			valueThird = 1.0f;
		}
		if (wordsAll != 0) {
			if (wordsAll > 0 && wordsAll < 21) {
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
			if (wordsAll > 19 && wordsAll < 39) {
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
			if (wordsAll > 35 && wordsAll < 59) {
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
		diffValueMedium = valueSecond + bonus;
		diffValueHard = valueThird + bonus;
	}

	private float calcResult(float wordsAll, float wordsGood) {

		float result = (wordsGood / wordsAll)*100.0f;
		return result;
	}
}
