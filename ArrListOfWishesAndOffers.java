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
		
		//Вариант с Arrays.asList в качестве аргумента работает
		
		ArrayList<String> listOfWishes = new ArrayList<String> (Arrays.asList( 
				"Spaghetti,2", 
				"Pepper,5",
				"Sugar,1"));
				
		ArrayList<String> listOfOffers = new ArrayList<String> (Arrays.asList( 
			    "Spaghetti,10.00", 
			    "Sugar,5.00",
			    "Water,2.50"));
		
		//Выделяем Spaghetti в виде String отдельно, и двойку в виде Integer отдельно
		
		String newSpaghetti = listOfWishes.get(0).substring(0, listOfWishes.get(0).indexOf(','));
		Integer newQuantitySpaghetti = Integer.parseInt(listOfWishes.get(0).substring(listOfWishes.get(0).indexOf(',') + 1));
		System.out.println(newSpaghetti);
		System.out.println(newQuantitySpaghetti);
		
		ArrayList<String> listOfPurchases = new ArrayList<String>();
		
		for(String w : listOfWishes) {
			for(String o : listOfOffers) {
				if(o.substring(0, o.indexOf(',')).compareTo(w.substring(0, w.indexOf(','))) == 0) {
					String newStringForPurchases = "";
					newStringForPurchases = newStringForPurchases.concat(w + "=");
							
					Integer concatW = Integer.parseInt(w.substring(w.indexOf(',') + 1));
					Double concatO = Double.parseDouble(o.substring(o.indexOf(',') + 1));
					Double sumConcat = concatW * concatO;
			
					newStringForPurchases = newStringForPurchases.concat(sumConcat.toString());
			
					listOfPurchases.add(newStringForPurchases);
				}
			}
		}
		
		System.out.println("List Of Wishes");
		listOfWishes.forEach(w->System.out.println(w));
		System.out.println("List Of Offers");
		listOfOffers.forEach(o->System.out.println(o));
		System.out.println("List Of Purchases");
		listOfPurchases.forEach(p -> System.out.println(listOfPurchases.indexOf(p) + " -> \""+ p + "\""));
	}
}
