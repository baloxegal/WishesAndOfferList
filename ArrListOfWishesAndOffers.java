import java.util.ArrayList;
//import java.util.Collections;
import java.util.Arrays;

public class ArrListOfWishesAndOffers {

	public static void main(String[] args) {
		
		//Вариант с коллекциями работает
		
//		ArrayList<String> listOfWishes = new ArrayList<String>();
//		Collections.addAll(listOfWishes,
//			"Spaghetti,2", 
//		    "Pepper,5",
//		    "Sugar,1");

		
		//Вариант с кастом не работает - Exception
		
//		ArrayList<String> listOfWishes = (ArrayList<String>)Arrays.asList(  
//				"Spaghetti,2", 
//				"Pepper,5",
//				"Sugar,1");
		
		ArrayList<String> listOfWishes = new ArrayList<String> (Arrays.asList( 
				"Spaghetti,2", 
				"Pepper,5",
				"Sugar,1"));
				
		ArrayList<String> listOfOffers = new ArrayList<String> (Arrays.asList( 
			    "Spaghetti,10.00", 
			    "Sugar,5.00",
			    "Water,2.50"));
		
		//Выделяем Spaghetti в виде String отдельно, а двойку в виде Integer отдельно
		
		String newSpaghetti = listOfWishes.get(0).substring(0, listOfWishes.get(0).indexOf(','));
		Integer newQuantitySpaghetti = Integer.parseInt(listOfWishes.get(0).substring(listOfWishes.get(0).indexOf(',') + 1));
		System.out.println(newSpaghetti);
		System.out.println(newQuantitySpaghetti);
		
		ArrayList<String> listOfPurchases = new ArrayList<String>();
		
		for(String w : listOfWishes) {
			String newO = "";
			listOfOffers.forEach(o -> {if(o.substring(0, o.indexOf(',')).compareTo(w.substring(0, w.indexOf(','))) < 0)
				newO.concat(w);
			newO.concat("=");
			newO.concat(o.substring(o.indexOf(',') + 1));
			listOfPurchases.add(newO);
			listOfPurchases.forEach(p -> System.out.println(p));
			System.out.println(newO);
			});
		}
		// 0 -> "Spaghetti,2=20.00"
		// 1 -> "Sugar,1=5.00"
	}
}
