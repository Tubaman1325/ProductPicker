import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

    static Coke coke;
    static Pepsi pepsi;
    static Dew dew;

    public static void main(String args[]) {

        Random rand = new Random();


        coke = new Coke(rand.nextInt(100));
        System.out.println(coke); //add
        pepsi = new Pepsi(rand.nextInt(100));
        System.out.println(pepsi);
        dew = new Dew(rand.nextInt(100));
        System.out.println(dew);

        Map<String, Integer> countMap = new HashMap<>(); // Initialize empty hashmap

        //Loop for picking products
        for (int p = 0; p <= 10000; p++) {
            String productName = productPick(); // Call productPick method and assign the returned productName string to a String variable
            Integer x = countMap.get(productName); // Get the current Integer value from the hashmap with key productName
            if (x == null) {  // x will be null if this is the first time that product has been picked (no key in the hashmap)
                x = 0;
            }
            x++; // Increment the temporary value that we pulled from the hashmap by one
            countMap.put(productName, x); // Store the value back into the hashmap, so we pulled it out, incremented it, then stored it back in the hashmap
        }

        System.out.println(countMap);
    }

    public static String productPick( ) {
        //TODO random product logic goes here
        String name;

//         pick a random weight
        Random rand = new Random();
        int n = rand.nextInt(-1 + coke.getWeight() + pepsi.getWeight()+ dew.getWeight()) +1;

//        product weighted values
//        Coke.getWeight();
//        Pepsi.getWeight();
//        Dew.getWeight();
        if (n > 0 && n <= coke.getWeight()) {
            name = "coke";
        } else if (n > coke.getWeight() && n <= coke.getWeight() + pepsi.getWeight()) {
            name = "pepsi";
        } else if (n > coke.getWeight() + pepsi.getWeight() && n <= coke.getWeight() + pepsi.getWeight()+ dew.getWeight()) {
            name = "dew";
        } else {
            name = "Something went wrong";
        }
        //add up how many times each product was picked


        return name;

    }



}
// The results will be compared to the weights
// I will print the results:
//     How many times each product was picked
//     How closely does it correlate to the current weighted values
