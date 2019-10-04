/**
 * @author Dr. Manal Helal
 * @date created: September 2019
 * @Module COM2031 Advanced Computer Algorithms - Computer Science Department
 * @University of Surrey
 */
import java.awt.BasicStroke;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.LogAxis;
import org.jfree.chart.axis.LogarithmicAxis;

import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.demo.BarChartDemo1;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYStepRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetGroup;
import org.jfree.data.xy.*;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;



public class FindMinMissing extends ApplicationFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	// A utility function to get maximum value in arr[] 
    static int getMax(int arr[], int n) 
    { 
        int mx = arr[0]; 
        for (int i = 1; i < n; i++) 
            if (arr[i] > mx) 
                mx = arr[i]; 
        return mx; 
    } 
    
	// A function to do counting sort of arr[] according to 
    // the digit represented by exp. 
    static int radixCount_FM(int arr[], int n) 
    { 
        
        int i; 
        int m = getMax(arr, n); 
        int count[] = new int[m]; 
        Arrays.fill(count,0); 
  
        // Store count of occurrences in count[] 
        for (i = 0; i < n; i++) 
            count[(arr[i])-1]++; 
  
        //Find Minimum not used index
        for (i = 0; i < n; i++) 
        { 
            if (count[i] == 0) 
            	return i+1; 
        } 
  
        return -1;
    } 


	public FindMinMissing(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public static int bruteForce_FM (int [] num, int n) {
		// TODO will remove the contents of these functions
		
		int min = 1;
		
		for (int i = 0; i < n; i++)	// Traverse the numbers 
			if (min == num[i]) { 	// if you find the current minimum, 
				min ++;				// increment its value, and search again from first element. should be easier if list is already sorted
				i=-1; 				// it will be incremented to zero in the loop
			}
		//System.out.println(min);
		return min;
	}
	
	public static int sorted_FM (int [] num, int n) {
		// TODO will remove the contents of these functions
		
		int min = 1;
		
		for (int i = 0; i < n; i++)	// Traverse the numbers 
			if (min == num[i]) { 	// if you find the current minimum, 
				min ++;				// increment its value, and search again from first element. should be easier if list is already sorted
								// it will be incremented to zero in the loop
			}
		//System.out.println(min);
		return min;
	}
	
	public static void selectionSort(int arr[]) 
    { 
        int n = arr.length; 
  
        // One by one move boundary of unsorted sub-array 
        for (int i = 0; i < n-1; i++) 
        { 
            // Find the minimum element in unsorted array 
            int min_idx = i; 
            for (int j = i+1; j < n; j++) 
                if (arr[j] < arr[min_idx]) 
                    min_idx = j; 
  
            // Swap the found minimum element with the first 
            // element 
            int temp = arr[min_idx]; 
            arr[min_idx] = arr[i]; 
            arr[i] = temp; 
        } 
    } 
	
	public static int bruteForceSort_FM (int [] num, int n) {
		
	
		selectionSort(num); // O(N^2)
		
		return sorted_FM (num, n);
	}
	
	public static int divConqSort_FM (int [] num, int n) {
		
		Arrays.sort(num); //Dual-Pivot Quicksort - O(N log N)
		
		
		return sorted_FM (num, n);
	}
	
	public static int radixSort_FM (int [] num, int n) {
		
		Radix.radixsort(num, n); 
		
		
		return sorted_FM (num, n);
	}
	
	public static int [] readNumbers (int n, String filename) {
		
		
		int [] num = new int[n];
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(filename));
			String line = reader.readLine();
			int i = 0;
			while ((line != null) && (i < n)) {
				//System.out.println(line);
				num[i] = Integer.parseInt(line);
				i ++;
				// read next line
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return num;
		
	}
	
	private JFreeChart createChart(/*CategoryDataset */ XYDataset dataset, String chartName)
	{
		 //create the chart...
		JFreeChart chart = ChartFactory.createXYLineChart(chartName,
				"Data Size",
				"Execution Time",
				dataset, // data
				PlotOrientation.VERTICAL, 
				true, // include legend
				true, // tooltips
				false // urls
				);
		
		//JFreeChart chart = ChartFactory.createBarChart(
		//	chartName,           
	//		"Data Size",            
//			"Execution Time",            
//			dataset,          
//	         PlotOrientation.VERTICAL,           
//	         true, true, false);
		
		
		// NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
		chart.setBackgroundPaint(Color.lightGray);
		
		
		// get a reference to the plot for further customisation...
		XYPlot plot = (XYPlot) chart.getPlot();
		
		// change to logarithmic scale in the range axis
		//ValueAxis x = plot.getDomainAxis();
		//ValueAxis y = plot.getRangeAxis();
		
		//LogarithmicAxis ly = new LogarithmicAxis("Execution Time");
		//ly.setDefaultAutoRange(y.getDefaultAutoRange());
		//plot.setRangeAxis(ly);
		//LogAxis lx = new LogAxis("Data Size");
		//lx.setDefaultAutoRange(x.getDefaultAutoRange());
		//plot.setDomainAxis(lx);


		plot.setBackgroundPaint(Color.lightGray);
		plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
		plot.setDomainGridlinePaint(Color.white);
		plot.setRangeGridlinePaint(Color.white);

		// step render
		XYStepRenderer renderer = new XYStepRenderer();
		renderer.setBaseShapesVisible(true);
		renderer.setSeriesStroke(0, new BasicStroke(2.0f));
		//renderer.setSeriesStroke(1, new BasicStroke(5.0f));
		renderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
		renderer.setDefaultEntityRadius(6);
		plot.setRenderer(renderer);

		//SymbolAxis rangeAxis = new SymbolAxis("", labels);
		//rangeAxis.setTickUnit(new NumberTickUnit(1));
		//rangeAxis.setRange(0, noprocess);
		//plot.setRangeAxis(rangeAxis);

		//NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		//rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		// OPTIONAL CUSTOMISATION COMPLETED.
		return chart;
	}
	
	public long getElapsedTime (long endTime, long startTime) {
		return (endTime - startTime)/100;		
	}
	
	public  void startSimulating()  {
		
		
		String filenamePrefix = "numbers_"; 
		String filename = filenamePrefix;
		int [] num_orig, num ;
		long startTime, endTime, elapsedtime;
		//XYSeries series_a1 = new XYSeries ("A) Brute Force - No Sorting - Best Case");
		//XYSeries series_a2 = new XYSeries ("A) Brute Force - No Sorting - Average Case");
		XYSeries series_a3 = new XYSeries ("A) Brute Force - No Sorting - Worst Case");
		//XYSeries series_b1 = new XYSeries ("B) Brute Force Sorting - Best Case");
		//XYSeries series_b3 = new XYSeries ("B) Brute Force Sorting - Worst Case");
		//XYSeries series_b2 = new XYSeries ("B) Brute Force Sorting - Average Case");
		//XYSeries series_c1 = new XYSeries ("C) Divide & Conquer - Best Case");
		//XYSeries series_c2 = new XYSeries ("C) Divide & Conquer - Average Case");
		XYSeries series_c3 = new XYSeries ("C) Divide & Conquer - Worst Case");
		//XYSeries series_d1 = new XYSeries ("D) Radix Sorting - Best Case");
		//XYSeries series_d2 = new XYSeries ("D) Radix Sorting - Average Case");
		XYSeries series_d3 = new XYSeries ("D) Radix Sorting - Worst Case");
		
		final String bf = "Brute Force - No Sorting";        
		final String bf_sort = "Brute Force Sorting";        
		final String divConqSort = "Divide & Conquer";        
		final String radixSort = "Radix Sorting";  
		
		final String bestCase = "Best Case";        
	    final String avgCase = "Average Case";        
	    final String worstCase = "Worst Case"; 
	      
		//DefaultCategoryDataset dataset = 
		//	      new DefaultCategoryDataset( ); 

		
		
	    for (int n=10000; n<=100000; n=n+10000) {
	    	
	    	/*
			// Best case for current n for the four algorithms
			filename = filenamePrefix + n +  "_rm1.txt";
			num_orig = readNumbers (n, filename);
			
			
			startTime = System.currentTimeMillis();
			int result = bruteForce_FM (num_orig, n);
			endTime = System.currentTimeMillis();
			
			
			elapsedtime = getElapsedTime(endTime, startTime);
			//elapsedtime = ((elapsedtime > 0)? elapsedtime: elapsedtime+2);
			//series_a1.add( n, elapsedtime ,false);
			//dataset.addValue(elapsedtime, bf, bestCase);
			System.out.println ("bruteForce_FM Best Case for n =: " + n + " = "+ result);
			*/
			
			/*
			// return num to originally read from file, such that previous sorting is cancelled for the next simulation
			num = new int[num_orig.length];
			System.arraycopy(num_orig, 0, num, 0, num_orig.length);
			
			startTime = System.currentTimeMillis();
			result = bruteForceSort_FM (num, n);
			endTime = System.currentTimeMillis();
			elapsedtime = getElapsedTime(endTime, startTime);
			//elapsedtime = ((elapsedtime > 0)? elapsedtime: elapsedtime+2);
			series_b1.add( n, elapsedtime ,false);
			
			System.out.println ("bruteForceSort_FM Best Case for n =: " + n + " = "+ result);
			
			*/
	    	
	    	/*
			
			// return num to originally read from file, such that previous sorting is cancelled for the next simulation
			num = new int[num_orig.length];
			System.arraycopy(num_orig, 0, num, 0, num_orig.length);
			
			startTime = System.currentTimeMillis();
			result = divConqSort_FM (num, n);
			endTime = System.currentTimeMillis();
			elapsedtime = getElapsedTime(endTime, startTime);
			//elapsedtime = ((elapsedtime > 0)? elapsedtime: elapsedtime+2);
			//series_c1.add( n, elapsedtime ,false);
			
			System.out.println ("divConqSort_FM Best Case for n =: " + n + " = "+ result);
			
			
			// return num to originally read from file, such that previous sorting is cancelled for the next simulation
			num = new int[num_orig.length];
			System.arraycopy(num_orig, 0, num, 0, num_orig.length);
					
			startTime = System.currentTimeMillis();
			result = radixCount_FM(num, n); // radixSort_FM (num, n);
			endTime = System.currentTimeMillis();
			elapsedtime = getElapsedTime(endTime, startTime);
			//elapsedtime = ((elapsedtime > 0)? elapsedtime: elapsedtime+2);
			//series_d1.add( n, elapsedtime ,false);
			
			System.out.println ("radixCount_FM Best Case for n =: " + n + " = "+ result);
			
			
			// Average case for current n for the four algorithms
			filename = filenamePrefix + n +  "_rm2.txt";
			num_orig = readNumbers (n, filename);
			
			startTime = System.currentTimeMillis();
			result = bruteForce_FM (num_orig, n);
			endTime = System.currentTimeMillis();
			elapsedtime = getElapsedTime(endTime, startTime);
			//elapsedtime = ((elapsedtime > 0)? elapsedtime: elapsedtime+2);
			//series_a2.add( n, elapsedtime ,false);
			
			System.out.println ("bruteForce_FM Average Case for n =: " + n + " = "+ result);
			*/
	    	
			/*
			// return num to originally read from file, such that previous sorting is cancelled for the next simulation
			num = new int[num_orig.length];
			System.arraycopy(num_orig, 0, num, 0, num_orig.length);
						
			startTime = System.currentTimeMillis();
			result = bruteForceSort_FM (num, n);
			endTime = System.currentTimeMillis();
			elapsedtime = getElapsedTime(endTime, startTime);
			//elapsedtime = ((elapsedtime > 0)? elapsedtime: elapsedtime+2);
			series_b2.add( n, elapsedtime ,false);
			
			System.out.println ("bruteForceSort_FM Average Case for n =: " + n + " = "+ result);
			
			*/
			
	    	/*
			// return num to originally read from file, such that previous sorting is cancelled for the next simulation
			num = new int[num_orig.length];
			System.arraycopy(num_orig, 0, num, 0, num_orig.length);
						
			startTime = System.currentTimeMillis();
			result = divConqSort_FM (num, n);
			endTime = System.currentTimeMillis();
			elapsedtime = getElapsedTime(endTime, startTime);
			//elapsedtime = ((elapsedtime > 0)? elapsedtime: elapsedtime+2);
			//series_c2.add( n, elapsedtime ,false);
			
			System.out.println ("divConqSort_FM Average Case for n =: " + n + " = "+ result);
			
			
			// return num to originally read from file, such that previous sorting is cancelled for the next simulation
			num = new int[num_orig.length];
			System.arraycopy(num_orig, 0, num, 0, num_orig.length);
						
			startTime = System.currentTimeMillis();
			result = radixCount_FM(num, n); //radixSort_FM (num, n);
			endTime = System.currentTimeMillis();
			elapsedtime = getElapsedTime(endTime, startTime);
			//elapsedtime = ((elapsedtime > 0)? elapsedtime: elapsedtime+2);
			//series_d2.add( n, elapsedtime ,false);
			
			System.out.println ("radixCount_FM Average Case for n =: " + n + " = "+ result);
			*/
			
			// Worst case for current n for the four algorithms
			
			filename = filenamePrefix + n +  "_rm3.txt";
			num_orig = readNumbers (n, filename);
			startTime = System.currentTimeMillis();
			int result = bruteForce_FM (num_orig, n);
			endTime = System.currentTimeMillis();
			elapsedtime = getElapsedTime(endTime, startTime);
			//elapsedtime = ((elapsedtime > 0)? elapsedtime: elapsedtime+2);
			series_a3.add( n, elapsedtime ,false);
			
			System.out.println ("bruteForce_FM Worst Case for n =: " + n + " = "+ result);
			
			/*
			// copy to num to preserve originally read from file, for the next simulation
			num = new int[num_orig.length];
			System.arraycopy(num_orig, 0, num, 0, num_orig.length);
			
			startTime = System.currentTimeMillis();
			result = bruteForceSort_FM (num, n);
			endTime = System.currentTimeMillis();
			elapsedtime = getElapsedTime(endTime, startTime);
			//elapsedtime = ((elapsedtime > 0)? elapsedtime: elapsedtime+2);
			series_b3.add( n, elapsedtime ,false);
			
			System.out.println ("bruteForceSort_FM Worst Case for n =: " + n + " = "+ result);
			
			*/
			// return num to originally read from file, such that previous sorting is cancelled for the next simulation
			num = new int[num_orig.length];
			System.arraycopy(num_orig, 0, num, 0, num_orig.length);
			
			startTime = System.currentTimeMillis();
			result = divConqSort_FM (num, n);
			endTime = System.currentTimeMillis();
			elapsedtime = getElapsedTime(endTime, startTime);
			//elapsedtime = ((elapsedtime > 0)? elapsedtime: elapsedtime+2);
			series_c3.add( n, elapsedtime ,false);
			
			System.out.println ("divConqSort_FM Worst Case for n =: " + n + " = "+ result);
			
			// return num to originally read from file, such that previous sorting is cancelled for the next simulation
			num = new int[num_orig.length];
			System.arraycopy(num_orig, 0, num, 0, num_orig.length);

			startTime = System.currentTimeMillis();
			result = radixCount_FM(num, n); //radixSort_FM (num, n);
			endTime = System.currentTimeMillis();
			elapsedtime= getElapsedTime(endTime, startTime);
			//elapsedtime = ((elapsedtime > 0)? elapsedtime: elapsedtime+2);
			series_d3.add( n, elapsedtime ,false);
		
			System.out.println ("radixCount_FM Worst Case for n =: " + n + " = "+ result);
			
		}
		
				

		XYSeriesCollection dataset = new XYSeriesCollection();
		
		//dataset.addSeries (series_a1);
		//dataset.addSeries (series_a2);
		dataset.addSeries (series_a3);
		//dataset.addSeries (series_b1);
		//dataset.addSeries (series_b2);
		//dataset.addSeries (series_b3);
		//dataset.addSeries (series_c1);
		//dataset.addSeries (series_c2);
		dataset.addSeries (series_c3);
		//dataset.addSeries (series_d1);
		//dataset.addSeries (series_d2);
		dataset.addSeries (series_d3);
		
		//JFreeChart chart=ChartFactory.createXYLineChart("Performance Evaluation","N","Execution Time",dataset,PlotOrientation.VERTICAL,true,false,false);
		//XYPlot plot=(XYPlot)chart.getPlot();
		  // discrete
		   // plot.setRenderer(new XYLineAndShapeRenderer());
		   //continous
		   // XYSplineRenderer renderer=new XYSplineRenderer();
		   // renderer.setBaseShapesVisible(false);
		   // plot.setRenderer(renderer);
		    
		    JFreeChart chart = createChart(dataset, "Execution Time Comparison");
			ChartPanel chartPanel = new ChartPanel(chart);
			chartPanel.setPreferredSize(new java.awt.Dimension(750, 400));
			
			setContentPane(chartPanel);
		  }
	
	        
	
	public static void main(String args[])  {
		FindMinMissing findMinimum = new FindMinMissing ("Find Minimum Algorithms");
		findMinimum.startSimulating();
		
		
		
		findMinimum.pack();
		RefineryUtilities.centerFrameOnScreen(findMinimum);
		findMinimum.setVisible(true);
		
		
	}

}
