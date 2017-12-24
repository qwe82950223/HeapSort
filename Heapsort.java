import java.io.PrintWriter;
import java.util.Scanner;
/**
 * a class to put heap and sort it 
 * @author xiao lin
 *
 */
public class Heapsort{
	int array[];
	int arraySize;
	
	Heapsort(int size){
		arraySize=size;
		array=new int[size];
		array[0]=1;//set first null element
	}//end Heapsort
/**
 * insert number into array one by one
 * @param br input file
 * @param printer output file
 * @throws IOException if file can not read
 */
	public void buildHeap(Scanner scan,PrintWriter printer){
		while(scan.hasNextInt()){
				int number = scan.nextInt();
				insertOneDataItem(number);//insert number to array
				printer.print("insert "+number+"	");
				printHeap(printer);
		}//end while
		scan.close(); //close input file
		printer.println();
		printer.println("Final Heap :");
		for(int i=1;i<arraySize;i++){
			printer.print(array[i]+" "); //print whole array
		}//end for
		printer.println();
		printer.println();
	}//end buildHeap
/**
 * deleted number from array one by one 
 * @param printer out put
 */
	public void delectHeap(PrintWriter printer){
		while(!isHeapEmpty()){//when array is not empty, keep delect first element, and print
			int number=delectRoot(); 
			printer.print("delete "+number+"	");
			printHeap(printer);
		}//end while
		printer.println();
		printer.print("Final Heap :");
		int firstnumber=array[0];
		for(int i=1;i<firstnumber;i++){//print whole array
			printer.print(array[i]+" ");
		}
		printer.println();
		printer.close();
	}//end delectHeap
/**
 * add one number to array and sort it 
 * @param number the number need to insert
 */
	private void insertOneDataItem(int number) {
		int index=array[0];//insert the number to the position of first element point
		array[index]=number;
		array[0]+=1;
		bubbleUp(index);//swap it 		
	}//end insertOneDataItem
/**
 * deleted first number from array, then sort array	
 * @return the number deleted
 */
	private int delectRoot(){
		int index=array[0]-1;//deleted first element 
		int number=array[1];
		array[1]=array[index];//change first element to last element
		array[0]-=1;
		bubbleDown(index);//swap
		return number; //return first number that delect
	}//end delectRoot
/**
 * sort array	
 * @param index what is first data in array
 */
	private void bubbleUp(int index) {
		if(index==1){
			return;
		}//end if 
		while(index/2>0&&array[index]<array[index/2]){//swap it when its parent is not null and larger than it
			int temp=array[index];
			array[index]=array[index/2];
			array[index/2]=temp;
			index=index/2;
		}//end while
		
	}//end bubbleUp
/**
 * sort array	
 * @param index first number in array
 */
	private void bubbleDown(int index){
		if(index==1){
			return;
		}
		int current=1;//set parent and children
		int left=2;
		int right=3;
		while((left<index||right<index)&&(array[current]>array[left]||array[current]>array[right])){//if one of its child is not null and smaller than its
			if(left>index&&right<index){ //left child is null
				int temp=array[current];
				array[current]=array[right];
				array[right]=temp;//swap with left child 
				current=right;
				left=current*2;//set parent to left child
				right=current*2+1;
			}//end if
			if(right>index&&left<index){//right child is null
				int temp=array[current];
				array[current]=array[left];//swap with right child
				array[left]=temp;
				current=left;
				left=current*2;
				right=current*2+1;
			}//end if 
			if(array[left]<array[right]){//left child smaller than right child
				int temp=array[current];
				array[current]=array[left];
				array[left]=temp;//swap with left child
				current=left;
				left=current*2;
				right=current*2+1;
			}//end if 
			else{//left child larger than right child 
				int temp=array[current];
				array[current]=array[right];
				array[right]=temp;
				current=right;//swap with right child 
				left=current*2;
				right=current*2+1;
			}//end else
		}//end while 
	}//end bubbleDown
/**
 * check is array empty	
 * @return array is empty
 */
	private boolean isHeapEmpty(){
		if(array[0]==1){
			return true;
		}//end if 
		return false;
	}//end isHeapEmpty
/**
 * check is array full
 * @return array is full
 */
	private boolean isHeapFull(){
		if(array[0]>arraySize){
			return true;
		}//end if
		return false;
	}//end isHeapFull
/**
 * print first ten number of array
 * @param printer output file
 */
	private void printHeap(PrintWriter printer) {
		int size = array[0];
		if(size<=10&&size>1){//print the all number in array if only less ten element in array
			for(int i=1;i<size;i++){
				printer.print(array[i]+" ");
			}//end for
			printer.println();
			
			return;
		}//end if 
		if(size>10){//print only ten number if there is more than then number in array
			for(int i=1;i<11;i++){
				printer.print(array[i]+" ");
			}//end for 
			printer.println();
			return;
		}//end if
		else{//if there is no number
			printer.println();
			return;
		}//end else
		
	}//end printHeap
}//end class 