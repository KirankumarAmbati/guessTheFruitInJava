import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainFile
{

	public static void main(String[] args) throws IOException, InterruptedException
	{
		File fruitNames = new File("C:/Users/KIRAN/Desktop/fruitNamesList.txt"); 
		Scanner sc = null;
		int health = 10;
		List<String> fruitNamesList = new ArrayList<String>();
		
		try
		{
			sc = new Scanner(fruitNames);
		} catch (FileNotFoundException e) {
			System.out.println("File not Found !!");
		}
		
		while(sc != null && sc.hasNextLine())
		{
			fruitNamesList.add(sc.nextLine());
		}
		
		String desiredFruit = fruitNamesList.get((int)Math.floor(Math.random()*10));
		StringBuilder desiredFruitName = new StringBuilder(desiredFruit) ;
		
		for(int i = 0; i < desiredFruit.length(); i++){
			desiredFruitName.setCharAt(i, '_');
		}
		
		Scanner userScanner = new Scanner(System.in);
		
		char ch;
		int index;
		
		while(health > 0)
		{
//			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			
			System.out.print("\t\t\t\t\t\tHealth: ");
			for(int i=0;i<health;i++)
			{
				System.out.print("* ");
			}
			System.out.println("\nGUESS THE FRUIT !!!");
			
			for(int i = 0; i < desiredFruit.length(); i++)
			{
				System.out.print(desiredFruitName.charAt(i) + " ");
			}
			System.out.println("\nGuess a letter: ");
			
			ch = userScanner.next().charAt(0);
			
			index = desiredFruit.indexOf(ch);
			
			while(index >= 0 && desiredFruitName.charAt(index) != '_')
			{
				index = desiredFruit.indexOf(ch, index + 1);
			}
			
			if(index < 0)
			{
				System.out.println("\nGuess failed !!! Try guessing another letter.. \n");
				health--;
			}
			if(index >= 0 && desiredFruitName.charAt(index) == '_')
			{
				System.out.println("\nGood Guess !!");
				desiredFruitName.setCharAt(index, ch);
			}
			

			for(int i = 0; i < desiredFruit.length(); i++)
			{
				System.out.print(desiredFruitName.charAt(i) + " ");
			}
			
			System.out.println("\n\n");
			
			if(desiredFruit.equalsIgnoreCase(desiredFruitName.toString()))
			{
				System.out.println("Yureka !! You did it !!!");
				break;
			}	
//			Thread.sleep(3000);
		}
		
		if(health == 0)
		{
			System.out.println("Well tried !! The answer is " + desiredFruit);
		}
	}

}
