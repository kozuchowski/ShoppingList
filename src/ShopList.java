
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
	static int end;
	
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
		
		list = new String[arr.length + 1];
		for(int i = 0; i < arr.length; i++) {
			list[i] = arr[i];
		}
		list[arr.length] = item;
		save();
		
	}
	
	static void edit() throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Number to Edit:");
		int itemToEdit = scan.nextInt();
		System.out.println("Type the correct item:");
		scan = new Scanner(System.in);
		String item = scan.nextLine();
		System.out.println(item);
		list[itemToEdit - 1] = item;
		save();
	}
	
	static void delete(String arr[]) throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Number to delete");
		int itemToDelete = scan.nextInt();
		arr = new String[list.length - 1]; 
		for(int i = itemToDelete - 1; i < list.length - 1; i++) {
			arr[i] = list[i + 1]; 
		}
		String temp[] = list;
		list = new String[arr.length];
		list = arr;
		for(int i = 0; i < itemToDelete - 1; i++) {
			list[i] = temp[i];
		}
		save();
		
		
	}
	
	static void shoppingList () throws IOException {
		System.out.println("Choose action:");
		System.out.println("a - add item");
		System.out.println("e - edit");
		System.out.println("s - show list");
		System.out.println("d - delete item");
		System.out.println("q - quit");
		
		Scanner scanner = new Scanner(System.in);
		String action = scanner.nextLine();
		
		if(action.equals("a")) {
			addItem(list);
		}else if(action.equals("e")) {
			edit();
		}else if(action.equals("s")) {
//			show();
		}else if(action.equals("d")) {
			delete(list);
		}else if(action.equals("q")) {
			end = 1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		read();
		
		while(end != 1) {
			shoppingList();
		}
	}
}
