import java.io.*;
import java.util.*;

public class Driver {


	public static int calculate(int num1, int num2) throws DivisionByZeroException
	{
		if (num2 == 0)
			throw new DivisionByZeroException();
		return num1 / num2;
	}
	
	public static void main(String[] args) {
		//Employee e = new Employee();		// can't instantiate abstract class
		int [] arr = {1, 2, 3};
		int y = 0;
		Scanner keyboard = new Scanner(System.in);
		HourlyEmployee hr = new HourlyEmployee(160, 7.25);
		SalariedEmployee sal = new SalariedEmployee(12500.0);
		PrintWriter outputStream = null;
		String filename = null;
		File fileObject = null;
		ObjectOutputStream os = null;
		
		System.out.println("Enter filename: ");
		filename = keyboard.next();
		fileObject = new File(filename);
		
		
		try {
			if (!fileObject.exists())
			{
				os = new ObjectOutputStream(new FileOutputStream(filename, false));
				System.out.println("File has been created");
				os.writeUTF("Welcome to WCC");
				os.writeInt(15);
				os.writeDouble(99.45);
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (os != null)
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
		System.out.println("Enter filename: ");
		filename = keyboard.next();
		fileObject = new File(filename);
		
		try {
			if (fileObject.exists())
			{
				outputStream = new PrintWriter(new FileOutputStream(filename, false));
				System.out.println("File has been created");
				outputStream.println("Welcome to WCC");
				outputStream.println(15);
				outputStream.println(99.45);
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			System.exit(0);
		} finally {
			if (outputStream != null)
				outputStream.close();
		}
		
		
		try {
			Scanner inputStream = new Scanner(new FileInputStream(filename));
			System.out.println("The first line " + inputStream.nextLine());
			System.out.println("The integer is " + inputStream.nextInt());
			System.out.println("The double is " + inputStream.nextDouble());
			inputStream.close();
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		try {
			BufferedReader binputStream = new BufferedReader(new FileReader(filename));
			System.out.println("The first line " + binputStream.readLine());
			System.out.println("The integer is " + Integer.parseInt(binputStream.readLine()));
			System.out.println("The double is " + Double.parseDouble(binputStream.readLine()));
			binputStream.close();
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		do
		{
			System.out.println("Enter a positive number");
			y = keyboard.nextInt();
		
			try {
				if (y < 0)
					throw new NoZeroException(y);
				if (y == 0)
					throw new NoZeroException();
			} catch (NoZeroException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				System.out.println("Try again");
			}
			
		} while (y == 0 || y < 0);
		
		y = 0;
		try
		{
			System.out.println("element is " + calculate (arr[2], y));
			System.out.println("Done");
		}
		catch(ArrayIndexOutOfBoundsException ex)
		{
			System.out.println("Index is out of range: " + ex.getMessage());		
		}
		catch(DivisionByZeroException ex)
		{
			ex.printStackTrace();
		}
		catch(Exception ex)
		{
			System.out.println("array index is wrong " + ex.getMessage());		
		}
		finally			// the code will be executed always
		{
			y = 10;
			System.out.println(" y is " + y);
		}
		
		if (hr.samePay(sal))
			System.out.println(hr.getPay() + " same as " + sal.getPay());
		else
			System.out.println(hr.getPay() + " different from " + sal.getPay());
	}
}
