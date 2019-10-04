/**
 * @author Dr. Manal Helal
 * @date created: September 2019
 * @Module COM2031 Advanced Computer Algorithms - Computer Science Department
 * @University of Surrey
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GenerateData {
	
	private static int pinCount;
	
	public static int generateRndUniqueNum(int[] pins) throws Exception {
		
		final Random random = new Random();
		 
		
	    if (pinCount >= pins.length)
	        throw new IllegalStateException();
	    int index = random.nextInt(pins.length - pinCount) + pinCount;
	    int pin = pins[index];
	    pins[index] = pins[pinCount++];
	    return pin;
		
	}

	public static int [] genRndNumbers (int n, int d, String filename) {
		
		int[] num = new int[n];
		pinCount = 0;
		StringBuilder minstr = new StringBuilder("1");
		StringBuilder maxstr = new StringBuilder("9");
		
		for (int i = 1; i < d; i++) {
			minstr.append("0");
			maxstr.append("0");
		}
		
		int min = Integer.parseInt(minstr.toString());
		int max = Integer.parseInt(maxstr.toString());
		
		final int[] pins = new int[max];
		 FileWriter fw;
		try {
			fw = new FileWriter(filename);
		  
		    for (int i = 0; i < pins.length; i++)
		        pins[i] = min + i;
			for (int i = 0;i<n;i++) {
				try {
					num[i] = generateRndUniqueNum (pins);
					fw.write(String.valueOf(num[i]));  
					fw.write(System.getProperty("line.separator"));
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				//System.out.println(num[i]);
			}
			
	        fw.close(); 
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
		return num;
		
	}
	
	public static int [] genNumbers (int n, int d, String filename) {
		int[] num = new int[n];
		
		StringBuilder minstr = new StringBuilder("1");
		StringBuilder maxstr = new StringBuilder("9");
		
		for (int i = 1; i < d; i++) {
			minstr.append("0");
			maxstr.append("9");
		}
		
		int min = Integer.parseInt(minstr.toString());
		int max = Integer.parseInt(maxstr.toString());
		
		
		FileWriter fw;
		try {
			fw = new FileWriter(filename);
			int ind = 0;
			for (int i = min;i<=max && ind < n;i++) {
				try {
					num[ind] = i;
					fw.write(String.valueOf(num[ind]));  
					fw.write(System.getProperty("line.separator"));
					ind ++;
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				//System.out.println(num[i]);
			}
			fw.close(); 
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}  
		
		return num;
	
	}
	
	public static int [] genNumbers (int n, String filename) {
		int[] num = new int[n];
		
		
		
		int min = 1;
		
		
		
		FileWriter fw;
		try {
			fw = new FileWriter(filename);
			int ind = 0;
			for (int i = min;i<=n && ind < n;i++) {
				try {
					num[ind] = i;
					fw.write(String.valueOf(num[ind]));  
					fw.write(System.getProperty("line.separator"));
					ind ++;
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				//System.out.println(num[i]);
			}
			fw.close(); 
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}  
		
		return num;
	
	}
	
	public static void remove_1 (int n, String filename) {
		FileWriter fw;
		try {
			String name = filename.substring(0, filename.lastIndexOf('.'));
			
			
			final Random random = new Random();
			 
			
		    // first quarter index
			int rmInd = random.nextInt(n / 4);
			fw = new FileWriter(name + "_rm1.txt");
			
			List<Integer> l = new ArrayList<>();
			for (int i = 1; i <= n; i++) {
				if (i != rmInd)
					l.add(i);
			}
			Collections.shuffle(l);
			
			
			for (int i = 0;i< l.size() ;i++) {
				try {
					fw.write(String.valueOf(l.get(i)));  
					fw.write(System.getProperty("line.separator"));
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				//System.out.println(num[i]);
			}
			fw.close(); 
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
	}
	
	public static void remove_2 (int n, String filename) {
		FileWriter fw;
		try {
			String name = filename.substring(0, filename.lastIndexOf('.'));
			
			
			final Random random = new Random();
			 
			
		    // middle index
			int rmInd = random.nextInt(n / 2) + n / 4;
			fw = new FileWriter(name + "_rm2.txt");
			List<Integer> l = new ArrayList<>();
			for (int i = 1; i <= n; i++) {
				if (i != rmInd)
					l.add(i);
			}
			Collections.shuffle(l);
			
			for (int i = 0;i< l.size() ;i++) {
				try {					
					fw.write(String.valueOf(l.get(i)));  
					fw.write(System.getProperty("line.separator"));					
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				//System.out.println(num[i]);
			}
			fw.close(); 
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
	}

	public static void remove_3 (int n, String filename) {
		FileWriter fw;
		try {
			String name = filename.substring(0, filename.lastIndexOf('.'));
			
			
			//final Random random = new Random();
			 
			
		    // last quarter indexs
			//int rmInd = random.nextInt(n / 4) + (3*(n / 4));
			fw = new FileWriter(name + "_rm3.txt");
			List<Integer> l = new ArrayList<>();
			for (int i = 1; i <= n; i++) {
				//if (i != rmInd)
					l.add(i);
			}
			Collections.shuffle(l);
			
			for (int i = 0;i< l.size() ;i++) {
				try {	
					fw.write(String.valueOf(l.get(i)));  
					fw.write(System.getProperty("line.separator"));
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				//System.out.println(num[i]);
			}
			
			fw.close(); 
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
	}
	public static void main(String args[])  {
		String filenamePrefix = "numbers_"; 
		String filename = filenamePrefix;
		
		for (int n=10000; n<=100000; n=n+10000) {
			filename = filenamePrefix + n +  ".txt";			
			
			//remove_1 (n+1, filename);
			//remove_2 (n+1, filename);
			remove_3 (n+1, filename);
		}
		
		
	}
}
