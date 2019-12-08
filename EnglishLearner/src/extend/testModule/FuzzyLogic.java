package extend.testModule;



/**
 * @author pawel
 * Test rating module maded with simple fuzzylogic CoG inference method. 
 *	
 *
 */
public class FuzzyLogic {
	
	//zmienne do budowy tablic
	 static float a = 0;
	 static float b = 1;
	 static float c = 0;
	 
	
	  
	//termy zmiennych lingwistycznych
	static float[][] tempLow = new float [101][3];
	static float [][] tempMiddle = new float [101][3];
	static float [][] tempHigh = new float [101][3];
	
	static float [][] gasLow = new float [51][3];
	static float [][] gasHigh = new float [51][3];
	
	static float [][] CO2Low = new float [51][3];
	static float [][] CO2High = new float [51][3];
	
	static float [][] ClimaZero = new float [101][3];
	static float [][] ClimaLow = new float [101][3];
	static float [][] ClimaMiddle = new float [101][3];
	static float [][] ClimaHigh = new float [101][3];
	
		 //zmienne wej�ciowe u�ytkownika
		 public static  float temperature = Display.valT;
		 public static float gas = Display.valG;
		 public static  float CO2 = Main.co2;
		 public static String state = "gas";
		 
		 //zmienne do oblicze� fuzzy
		 private static String whatTemp = "tempLow";
		 private static String whatGas  = "gasLow";
		 private static String whatCO2 = "CO2Low";
		 
		 static float x1 ;
		 static float x2 ;
		 static float x3 ;
		 static float x4 ;
		 static float x5 ;
		 static float x6 ;
		 static float x7 ;
		 public static float y ;
		
		  
	public FuzzyLogic() {
		
		buildTerms();
		fuzzifyTerms();
		update();
		
		
		System.out.println(y);
		
		
		
	}
		
	//funkcje buduj�ce termy
	public static void fillLow(float a, float b) {
		
		for(int i=0; i<tempLow.length; i++) {
		
				for(int j=0; j<2; j++) {
					
					if(j==0) {
						
					tempLow[i][j] = a;
					a+=1;
					} else if(j ==1) {
					tempLow[i][j] =  b;
					
					if(a>9 && a<14) {
						b=b-0.25f;
						}
					if(b<=0.0){
						b = 0.0f;
					}
					
					}
					
					//System.out.printf("Term low [%d][%d] = %f \n", i, j ,tempLow [i][j]);
					
				}

		}
	}
	
	public static void fillMiddle(float a, float c) {
		
		for(int i=0; i<tempMiddle.length; i++) {
		
				for(int j=0; j<2; j++) {
					
					if(j==0) {
						
					tempMiddle[i][j] = a;
					a+=1;
					} else if(j ==1) {
					tempMiddle[i][j] =  c;
					
					
					if(a>=11 && a<15) {
						c+=0.25;
					}

					else if(a>15 && a<=19) {
						c-=0.25;
					}else if(a>=19) {
						c=0.0f;
					}
					
					if(c<=0.0){
						c = 0.0f;
					}
					
					}
					
					//System.out.printf("Term middle [%d][%d] = %f \n", i, j ,tempMiddle [i][j]);
					
				}

		}
	}
	
	public static void fillHigh(float a, float c) {
		
		for(int i=0; i<tempHigh.length; i++) {
		
				for(int j=0; j<2; j++) {
					
					if(j==0) {
						
					tempHigh[i][j] = a;
					a+=1;
					} else if(j ==1) {
					tempHigh[i][j] =  c;
					
					if(a>18 && a<24) {
						c +=0.25;
					}
					if(c>=1.0){
						c = 1.0f;
					}
					}
					
					//System.out.printf("Term high [%d][%d] = %f \n", i, j ,tempHigh [i][j]);
					
				}

		}
	}
	
	public static void fillGasLow(float a, float b) {
		
		for(int i=0; i<gasLow.length; i++) {
			
			for(int j=0; j<2; j++) {
				if(j==0) {
				gasLow [i][j] = a;
				a+=1;
				}
				if(j==1) {
					gasLow[i][j] = b;
					
					if(a<26) {
						b=1.0f;
					}
					if(a>=26 && a<30)
						b-=0.25;
					if(b<=0.0) {
						b=0.0f;
					}
				}
				//System.out.printf("Term gasLow [%d][%d] = %f \n", i, j ,gasLow [i][j]);
			}
			
		}
	}
	
	public static void fillGasHigh(float a, float c) {

		
		for(int i=0; i<gasHigh.length; i++) {
			
			for(int j=0; j<2; j++) {
				if(j==0) {
				gasHigh [i][j] = a;
				a+=1;
				}
				if(j==1) {
					gasHigh[i][j] = c;
					
					if(a<=25) {
						c=0.0f;
					}
					if(a>25 && a<30)
						c+=0.25;
					if(c>1.0) {
						c=1.0f;
					}
				}
				//System.out.printf("Term gasHigh [%d][%d] = %f \n", i, j ,gasHigh [i][j]);
			}
			
		}
	}
	
	public static void fillCO2Low(float a, float b) {
		
		for(int i=0; i<CO2Low.length; i++) {
			
			for(int j=0; j<2; j++) {
				if(j==0) {
				CO2Low [i][j] = a;
				a+=1;
				}
				if(j==1) {
					CO2Low[i][j] = b;
					
					if(a<26) {
						b=1.0f;
					}
					if(a>=26 && a<30)
						b-=0.25;
					if(b<=0.0) {
						b=0.0f;
					}
				}
				//System.out.printf("Term CO2Low [%d][%d] = %f \n", i, j ,CO2Low [i][j]);
			}
			
		}
	}
	
	public static void fillCO2High(float a, float c) {
		
		for(int i=0; i<CO2High.length; i++) {
			
			for(int j=0; j<2; j++) {
				if(j==0) {
				CO2High [i][j] = a;
				a+=1;
				}
				if(j==1) {
					CO2High[i][j] = c;
					
					if(a<=25) {
						c=0.0f;
					}
					if(a>25 && a<30)
						c+=0.25;
					if(c>1.0) {
						c=1.0f;
					}
				}
				//System.out.printf("Term CO2High [%d][%d] = %f \n", i, j ,CO2High [i][j]);
			}
			
		}
	}

	public static void climaZero(float a, float c) {
		
		for(int i=0; i<ClimaZero.length; i++) {
			
			for(int j=0; j<2; j++) {
				
				if(j==0) {
					
				ClimaZero[i][j] = a;
				if(a==0.0f){
					c = 1.0f;
				}else if(a!=0.0f) {
					c=0.0f;
				}
				a+=1;
				} else if(j == 1) {
					ClimaZero[i][j] =  c;
				
				}
				
				//System.out.printf("ClimaZero [%d][%d] = %f \n", i, j ,ClimaZero [i][j]);
				
			}

		}
		
	}
	
	public static void climaLow(float a, float c) {
		
		for(int i=0; i<ClimaLow.length; i++) {
		
				for(int j=0; j<2; j++) {
					
					if(j==0) {
						
					ClimaLow[i][j] = a;
					a+=1;
					} else if(j ==1) {
					ClimaLow[i][j] =  c;
					
					if(a==20.0f) {
						c=1.0f;
						}
					if(a<20.0f || a>20.0f){
						c = 0.0f;
					}
					
					}
					
					//System.out.printf("ClimaLow [%d][%d] = %f \n", i, j ,ClimaLow [i][j]);
					
				}

		}
	}
	
	public static void climaMiddle(float a, float c) {
		
		for(int i=0; i<ClimaMiddle.length; i++) {
		
				for(int j=0; j<2; j++) {
					
					if(j==0) {
						
					ClimaMiddle[i][j] =a;
					a+=1;
					} else if(j ==1) {
					ClimaMiddle[i][j] =  c;
					

					if(a==50.0f) {
						c=1.0f;
					}

					if(a<50.0f || a>50.0f){
						c = 0.0f;
					}
					
					}
					
					//System.out.printf("ClimaMiddle [%d][%d] = %f \n", i, j ,ClimaMiddle [i][j]);
					
				}

		}
	}
	
	public static void climaHigh(float a, float c) {
		
		for(int i=0; i<ClimaHigh.length; i++) {
		
				for(int j=0; j<2; j++) {
					
					if(j==0) {
						
					ClimaHigh[i][j] = a;
					a+=1;
					} else if(j ==1) {
					ClimaHigh[i][j] = c;
					
					if(a==70.0f) {
						c = 1.0f;
					}
					if(a<70.0f || a>70.0f){
						c = 0.0f;
					}
					}
					
					//System.out.printf("ClimaHigh [%d][%d] = %f \n", i, j ,ClimaHigh [i][j]);
					
				}

		}
	}
	
	//wype�nienie term�w
	public static void buildTerms() {
		
		fillLow(a, b);
		fillMiddle(a, c);
		fillHigh(a, c);
		fillGasLow(a, b);
		fillGasHigh(a, c);
		fillCO2Low(a, b);
		fillCO2High(a, c);
		climaZero(a, c);
		climaLow(a, b);
		climaMiddle(a, c);
		climaHigh(a, c);
		
	}
	
	//rozmywanie term�w
	public void fuzzifyTerms() {
		
		cutTemp(temperature);
		cutGas(gas);
		cutCO2(CO2);
		
	}
	
	//metoda wnioskuj�ca
	public  String defuzzifyClima(float x1, float x2, float x3, float x4, float x5, float x6, float x7, String termTemp, String termGas, String termCO2, String state ) {
		
		//x1, x2, x3- temperatura; x4, x5 - gaz; x6, x7 - CO2; y - poziom klimatyzatora
		
		/* Regu�y wnioskowania Gaz:(MIN)
		 * Rule1: 	IF tempLow AND gasLow THEN ClimaMid 
		 * Rule2: 	IF tempLow AND gasHigh THEN ClimaHigh
		 * 
		 * Rule3: 	IF tempMiddle AND gasLow THEN ClimaLow
		 * Rule4: 	IF tempMiddle AND gasHigh Then ClimaHigh
		 * 
		 * Rule5: 	IF tempHigh AND gasLow THEN ClimaHigh
		 * Rule6: 	IF tempHigh AND gasHigh THEN CLimaHigh
		 * 
		 * Regu�y wnioskowania CO2:(MIN)
		 * Rule7: 	IF tempLow AND CO2Low THEN ClimaMid
		 * Rule8: 	IF tempLow AND CO2High THEN ClimaHigh
		 * 
		 * Rule9: 	IF tempMiddle AND CO2Low THEN ClimaLow
		 * Rule10: 	IF tempMiddle AND CO2High THEN ClimaHigh
		 * 
		 * Rule11: 	IF tempHigh AND CO2Low THEN ClimaHigh
		 * Rule12: 	IF tempHigh AND CO2High THEN ClimaZero
		 */

		java.text.DecimalFormat df = new java.text.DecimalFormat("0.0000");
		
		//float y = 0;
		
		float tempLow = 0;
		float tempMid = 0; 
		float tempHigh = 0; 
		
		float gasLow = 0;
		float gasHigh = 0;
		
		float co2Low = 0;
		float co2High = 0;
		
		if(state.equals("gas")) {
		if(termTemp.equals("tempLow") && termGas.equals("gasLow")) {
			
			tempLow = x1;
			tempMid = x2;
			tempHigh = x3;
			gasLow = x4;
			gasHigh = x5;
			
			
			float h1 = Math.min(tempLow, gasLow);//ClimaMid
			float h2 = Math.min(tempLow, gasHigh);//ClimaHigh
			float h3 = Math.min(tempMid, gasHigh);//ClimaHigh
			float h4 = Math.min(tempMid, gasLow);//ClimaLow
			
			float h = Math.max(h2, h3);
			
			y=(0*0+20*h4+50*h1+70*h)/(0+h4+h1+h);
			
		}
		
		if(termTemp.equals("tempLow") && termGas.equals("gasHigh")) {
			
			tempLow = x1;
			tempMid = x2;
			tempHigh = x3;
			gasLow = x4;
			gasHigh = x5;
			
			
			float h1 = Math.min(tempLow, gasLow);//ClimaMid
			float h3 = Math.min(tempMid, gasHigh);//ClimaHigh
			float h4 = Math.min(tempMid, gasLow);//ClimaLow
			float h5 = Math.min(tempLow, gasHigh);//ClimaHigh
			
			float h7 = Math.max(h3, h5);
			

			
			y=(0*0+20*h4+50*h1+70*h7)/(0+h4+h1+h7);
			
		}
		
		if(termTemp.equals("tempMiddle") && termGas.equals("gasLow")) {
			
			tempLow = x1;
			tempMid = x2;
			tempHigh = x3;
			gasLow = x4;
			gasHigh = x5;
			
			
			float h1 = Math.min(tempMid, gasLow);//ClimaLow
			float h2 = Math.min(tempMid, gasHigh);//ClimaHigh
			float h3 = Math.min(tempLow, gasLow);//ClimaMid
			float h4 = Math.min(tempLow, gasHigh);//ClimaHigh
			
			float h8 = Math.max(h2, h4);
			
			y=(0*0+20*h1+50*h3+70*h8)/(0+h1+h3+h8);
			
		}
		
		if(termTemp.equals("tempMiddle") && termGas.equals("gasHigh")) {
			
			tempLow = x1;
			tempMid = x2;
			tempHigh = x3;
			gasLow = x4;
			gasHigh = x5;
			
			
			float h1 = Math.min(tempMid, gasHigh);//ClimaHigh
			float h2 = Math.min(tempLow, gasHigh);//ClimaHigh
			float h3 = Math.min(tempMid, gasLow);//ClimaLow
			float h4 = Math.min(tempLow, gasLow);//ClimaMid
			
			float h5 = Math.max(h1, h2);
			
			y=(0*0+20*h3+50*h4+70*h5)/(0+h3+h4+h5);
			
		}
		
		if(termTemp.equals("tempHigh") && termGas.equals("gasLow")) {
			
			tempLow = x1;
			tempMid = x2;
			tempHigh = x3;
			gasLow = x4;
			gasHigh = x5;
			
			float h1 = Math.min(tempHigh, gasLow);//ClimaHigh
			float h2 = Math.min(tempHigh, gasHigh);//ClimaHigh
			float h3 = Math.min(tempMid, gasLow);//ClimaLow
			float h4 = Math.min(tempMid, gasHigh);//ClimaHigh
			
			float h5 = Math.max(Math.max(h1, h2),h4);
			
			y=(0*0+20*h3+50*0+70*h5)/(0+h3+0+h5);
			
			
		}
		
		if(termTemp.equals("tempHigh") && termGas.equals("gasHigh")) {
			
			tempLow = x1;
			tempMid = x2;
			tempHigh = x3;
			gasLow = x4;
			gasHigh = x5;
			
			float h1 = Math.min(tempHigh, gasHigh);//ClimaHigh
			float h2 = Math.min(tempHigh, gasLow);//ClimaHigh
			float h3 = Math.min(tempMid, gasLow);//ClimaLow
			float h4 = Math.min(tempMid, gasHigh);//ClimaHigh
			
			float h5 = Math.max(Math.max(h1, h2), h4);
			
			y=(0*0+20*h3+50*0+70*h5)/(0+h3+0+h5);
			
			
		}
		}else if(state.equals("co2")) {
		if(termTemp.equals("tempLow") && termCO2.equals("CO2Low")) {
		
			tempLow = x1;
			tempMid = x2;
			tempHigh = x3;
			co2Low = x6;
			co2High = x7;
			
			float h1 = Math.min(tempLow, co2Low);//ClimaMid
			float h2 = Math.min(tempLow, co2High);//ClimaHigh
			float h3 = Math.min(tempMid, co2Low);//ClimaLow
			float h4 = Math.min(tempMid, co2High);//ClimaHigh

			
			float h5 = Math.max(h2, h4);
			
			y = (0*0+20*h3+50*h1+70*h5)/(0+h3+h1+h5);
			
			
		}
	
		if(termTemp.equals("tempLow") && termCO2.equals("CO2High")) {
			
			tempLow = x1;
			tempMid = x2;
			tempHigh = x3;
			co2Low = x6;
			co2High = x7;
			
			float h1 = Math.min(tempLow, co2High);//ClimaHigh
			float h2 = Math.min(tempLow, co2Low);//ClimaMid
			float h3 = Math.min(tempMid, co2Low);//ClimaLow
			float h4 = Math.min(tempMid, co2High);//ClimaHigh
			
			float h5 = Math.max(h1, h4);
			
			y=(0*0+20*h3+50*h2+70*h5)/(0+h3+h2+h5);
			
		}
		
		if(termTemp.equals("tempMiddle") && termCO2.equals("CO2Low")) {
			
			tempLow = x1;
			tempMid = x2;
			tempHigh = x3;
			co2Low = x6;
			co2High = x7;
			
			float h1 = Math.min(tempMid, co2Low);//ClimaLow
			float h2 = Math.min(tempMid, co2High);//ClimaHigh
			float h3 = Math.min(tempLow, co2Low);//ClimaMid
			float h4 = Math.min(tempLow, co2High);//ClimaHigh
			
			float h5 = Math.max(h2, h4);
			
			y=(0*0+20*h1+50*h3+70*h5)/(0+h1+h3+h5);
			
		}
		
		if(termTemp.equals("tempMiddle") && termCO2.equals("CO2High")) {
			
			tempLow = x1;
			tempMid = x2;
			tempHigh = x3;
			co2Low = x6;
			co2High = x7;
			
			float h1 = Math.min(tempMid, co2High);//ClimaHigh
			float h2 = Math.min(tempMid, co2Low);//ClimaLow
			float h3 = Math.min(tempHigh, co2Low);//ClimaMid
			float h4 = Math.min(tempHigh, co2High);//ClimaHigh
			
			
			float h5 = Math.max(h1, h4);
			
			y=(0*0+20*h2+50*h3+70*h5)/(0+h2+h3+h5);
		}
		
		if(termTemp.equals("tempHigh") && termCO2.equals("CO2Low")) {
			
			
			tempMid = x2;
			tempHigh = x3;
			co2Low = x6;
			co2High = x7;
			
			float h1 = Math.min(tempHigh, co2Low);//ClimaHigh
			float h2 = Math.min(tempHigh, co2High);//ClimaZero
			float h3 = Math.min(tempMid, co2Low);//ClimaLow
			float h4 = Math.min(tempMid, co2High);//ClimaHigh
			
			float h5 = Math.max(h1, h4);
			
			y=(0*h2+20*h3+50*0+70*h5)/(h2+h3+0+h5);
		}
		//Rule12 tempHigh, CO2High - FireState
		if(termTemp.equals("tempHigh") && termCO2.equals("CO2High")) {
			//ClimaZero
			
			y=0.0f;
			
		}
		}
		return df.format(y);
		
	}

	public static void cutTemp(float temp) {
		
		float maxTemp;
		
		float c1= 0.0f;
		float c2= 0.0f;
		float c3= 0.0f;
		
		if(temp==0) {
			x1 = tempLow[0][0];
			c1 = tempLow[0][1];
		}
		if(temp>100) {
			x1 = 100;
			c1 = 1.0f;
		}
		else if(temp!=0) {
			if(temp>0 && temp<14.0f) {
				for(int i=0; i<tempLow.length; i++) {
					for(int j=0; j<tempLow.length; j++) {
						if(j==0) {
							float x1=tempLow[i][j];
							if(x1 == temp) {
								c1 = tempLow[i][j+1];
							}
						}
					}
				}
			}
			if(temp>10 && temp<20) {
				for(int i=0; i<tempMiddle.length; i++) {
					for(int j=0; j<tempMiddle.length; j++) {
						if(j==0) {
							float x1=tempMiddle[i][j];
							if(x1 == temp) {
								c2 = tempMiddle[i][j+1];
							}
						}
					}
				}
			}
			
			if(temp>17) {
				
				for(int i=0; i<tempHigh.length; i++) {
					for(int j=0; j<tempHigh.length; j++) {
						if(j==0) {
							float x1=tempHigh[i][j];
							if(x1 == temp) {
								c3 = tempHigh[i][j+1];
							}
						}
					}
				}
			}
		}
		
		if(c1!=0 && c2!=0 ) {
			maxTemp = Math.max(c1, c2);
			if(c1>c2) {
				for(int i=0; i<tempLow.length; i++) {
					for(int j=0; j<tempLow.length; j++) {
						if(j==1) {
							if(maxTemp<tempLow[i][j]) {
								tempLow[i][j]=maxTemp;
							}
						}
					}
				}
			}
			
			if(c1<c2) {
				for(int i=0; i<tempMiddle.length; i++) {
					for(int j=0; j<tempMiddle.length; j++) {
						if(j==1) {
							if(maxTemp<tempMiddle[i][j]) {
								tempMiddle[i][j]=maxTemp;
							}
						}
					}
				}
			}
			
		}
		if(c2!=0 && c3!=0) {
			maxTemp = Math.max(c2, c3);
			
			if(c2>c3) {
				for(int i=0; i<tempMiddle.length; i++) {
					for(int j=0; j<tempMiddle.length; j++) {
						if(j==1) {
							if(maxTemp<tempMiddle[i][j]) {
								tempMiddle[i][j]=maxTemp;
							}
						}
					}
				}
			}
			
			if(c2<c3) {
				for(int i=0; i<tempHigh.length; i++) {
					for(int j=0; j<tempHigh.length; j++) {
						if(j==1) {
							if(maxTemp<tempHigh[i][j]) {
								tempHigh[i][j]=maxTemp;
							}
						}
					}
				}
			}
			
		}		
		float temp1 = Math.max(c1, c2);
		float temp2 = Math.max(c2, c3);
		maxTemp = Math.max(temp1, temp2);
		
		whatCollectionTemp(c1, c2, c3);
		
		x1 = c1;
		x2 = c2;
		x3 = c3;
		
		
	}
	public static void cutGas(float gas) {
		
		float maxGas;
		float c4= 0.0f;
		float c5= 0.0f;
		
		if(gas==0) {
			x4 = gasLow[0][0];
			c4 = gasLow[0][1];
		}
		if(gas>50) {
			x1 = 50;
			c4 = 1.0f;
		}
		else if(gas!=0) {
		
		if(gas>0 && gas<30.0f) {
			for(int i=0; i<gasLow.length; i++) {
				for(int j=0; j<gasLow.length; j++) {
					if(j==0) {
						float x1=gasLow[i][j];
						if(x1 == gas) {
							c4 = gasLow[i][j+1];
						}
					}
				}
			}
		}
		
		if(gas>25) {
			
			for(int i=0; i<gasHigh.length; i++) {
				for(int j=0; j<gasHigh.length; j++) {
					if(j==0) {
						float x1=gasHigh[i][j];
						if(x1 == gas) {
							c5 = gasHigh[i][j+1];
						}
					}
				}
			}
		}
		
	}
		
		if(c4!=0 && c5!=0) {
			maxGas=Math.max(c4, c5);
			if(c4>c5) {
				for(int i=0; i<gasLow.length; i++) {
					for(int j=0; j<gasLow.length; j++) {
						if(j==1) {
							if(maxGas<gasLow[i][j]) {
								gasLow[i][j]=maxGas;
							}
						}
					}
				}
			}
			
			if(c4<c5) {
				for(int i=0; i<gasHigh.length; i++) {
					for(int j=0; j<gasHigh.length; j++) {
						if(j==1) {
							if(maxGas<gasHigh[i][j]) {
								gasHigh[i][j]=maxGas;
							}
						}
					}
				}
			}
			
		}
		maxGas = Math.max(c4, c5);
		whatCollectionGas(c4, c5);
		x4 = c4;
		x5 = c5;
	}
	public static void cutCO2(float CO2) {
		float maxCO2;
		float c6= 0.0f;
		float c7= 0.0f;
	
		if(CO2==0) {
			x6 = CO2Low[0][0];
			c6 = CO2Low[0][1];
		}
		if(CO2>50) {
			x1 = 50;
			c6 = 1.0f;
		}
		else if(CO2!=0) {
		
		if(CO2>0 && CO2<30) {
			for(int i=0; i<CO2Low.length; i++) {
				for(int j=0; j<CO2Low.length; j++) {
					if(j==0) {
						float x1=CO2Low[i][j];
						if(x1 == CO2) {
							c6 = CO2Low[i][j+1];
						}
					}
				}
			}
		}
		
		if(CO2>25 && CO2<50) {
			
			for(int i=0; i<CO2High.length; i++) {
				for(int j=0; j<CO2High.length; j++) {
					if(j==0) {
						float x1=CO2High[i][j];
						if(x1 == CO2) {
							c7 = CO2High[i][j+1];
						}
					}
				}
			}
		}
		
	}
		
		if(c6!=0 && c7!=0) {
			maxCO2 = Math.max(c6, c7);
			if(c6>c7) {
				for(int i=0; i<CO2Low.length; i++) {
					for(int j=0; j<CO2Low.length; j++) {
						if(j==1) {
							if(maxCO2<CO2Low[i][j]) {
								CO2Low[i][j]=maxCO2;
							}
						}
					}
				}
			}
			
			if(c6<c7) {
				for(int i=0; i<CO2High.length; i++) {
					for(int j=0; j<CO2High.length; j++) {
						if(j==1) {
							if(maxCO2<CO2High[i][j]) {
								CO2High[i][j]=maxCO2;
							}
						}
					}
				}
			}
		}
		
		maxCO2 = Math.max(c6,c7);
		whatCollectionCO2(c6, c7);
		x6 = c6;
		x7 = c7;
		//return maxCO2;
	}
	
	public static String whatCollectionTemp(float x, float y, float z) {
		
		if(x>y) {
			return whatTemp = new String("tempLow");
		}else if( y>z) {
			return whatTemp = new String("tempMiddle");
		}else if(y<z) {
			return whatTemp = new String ("tempHigh");
		}
		return whatTemp;
	}
	
	public static void whatCollectionGas(float x, float y) {
		
		if(x>y) {
			whatGas = new String("gasLow");
		}else if( y>x) {
			 whatGas = new String("gasHigh");
		}else if(x==0 || y==0) {
			state = new String("co2");
		}
		
	}
	
	public static void whatCollectionCO2(float x, float y) {
		
		if(x>y) {
			 whatCO2 = new String("CO2Low");
		}else if( y>x) {
			 whatCO2 = new String("CO2High");
		}else if(x==0 || y==0) {
			state = new String("gas");
		}
		
	}

	public void update() {
		
		defuzzifyClima(x1, x2, x3, x4, x5, x6, x7, whatTemp, whatGas, whatCO2, state);
		
		
		System.out.println("x1: "+x1);
		System.out.println("x2: "+x2);
		System.out.println("x3: "+x3);
		System.out.println("x4: "+x4);
		System.out.println("x5: "+x5);
		System.out.println("x6: "+x6);
		System.out.println("x7: "+x7);
		System.out.println(whatTemp);
		System.out.println(whatGas);
		System.out.println(whatCO2);
		System.out.println(state);
		System.out.println("Warto�� klimy: "+ y);
	}


}

