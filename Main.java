import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * project to reorder numbers by heap sort
 * @author xiao lin
 *
 */
public class Main{
	public static void main(String[] args){
		File inFile = new File(args[0]); //input file
		File output = new File(args[1]); //output file
		Scanner scan = null;
		PrintWriter printer = null;
		
		int count=0; 
		try {
			scan = new Scanner(inFile);
			while(scan.hasNextInt()){//count the number of integer
				scan.nextInt();
				count++;
			}//end while
			scan.close();//close input file
			
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try{
			scan =new Scanner(inFile); //open input file second time 
			printer = new PrintWriter(output); //open output file
			Heapsort heap=new Heapsort(count+1); 
			printer.println("Build Heap :");
			heap.buildHeap(scan,printer);
			printer.println("Delete Heap :");
			heap.delectHeap(printer);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//end main
}//end class