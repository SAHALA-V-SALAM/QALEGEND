package Utilities;

import java.util.Random;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;

public class Fakerutility 
{
	public static String getFakeFirstName()//to generate unique testdata-
	{
	Faker faker=new Faker();
	Address address=faker.address();
	String text=address.firstName();
	return text;
		
	}
	
	public static String getFakeLastName()
	{
		Faker faker=new Faker();
		Address address=faker.address();
		String text=address.lastName();
		return text;
	}
public static String getFakeCityName()
{
	Faker faker=new Faker();
	Address address=faker.address();
	String text=address.cityName();
	return text;
}
public static int getRandomNumber()
{
	Random random=new Random();
	int randomnumber=random.nextInt(100000);
	return randomnumber;
}
}