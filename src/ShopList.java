
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ShopList {
	static File file = new File("shopList.txt");
	static Scanner fileRead;
	static String list[];
	
	static void read() throws FileNotFoundException {
		
		fileRead = new Scanner(file);
		int count = 0;
		while(fileRead.hasNextLine()) {
			fileRead.nextLine();
			count++;
		}
		list = new String[count];
		fileRead = new Scanner(file);
		count = 0;
		if(list.length > 0) {
			while(fileRead.hasNextLine()) {
				list[count] = fileRead.nextLine();
				count++;
			}
			System.out.println(Arrays.toString(list));
		}
	}
	
	static void save() throws IOException {
		FileWriter writer = new FileWriter(file);
		BufferedWriter bWriter = new BufferedWriter(writer);
		for(int i = 0; i < list.length; i++) {
			bWriter.write(list[i]);
			bWriter.newLine();
		}
		bWriter.flush();
	}
	
	static void  addItem(String arr[]) throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Add item: ");
		String item = scan.nextLine();
		
		arr = new String[list.length];
		for(int i = 0; i < list.length; i ++) {
			arr[i] = list[i];
		}
		System.out.println(Arrays.toString(arr));
		list = new String[arr.length + 1];
		for(int i = 0; i < arr.length; i++) {
			list[i] = arr[i];
		}
		list[arr.length] = item;
		save();
		
	}
	
	static void edit() throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("number to Edit:");
		int itemToEdit = scan.nextInt();
		System.out.println("Type the correct item:");
		scan = new Scanner(System.in);
		String item = scan.nextLine();
		System.out.println(item);
		list[itemToEdit - 1] = item;
		save();
	}
	
	static void shopingList () throws IOException {
	
	}
	
	public static void main(String[] args) throws IOException {
	read();
//	addItem(list);
	edit();
	read();
	
	}

}
