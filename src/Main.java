import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

    static Coke coke;
    static Pepsi pepsi;
    static Dew dew;


    public static void main(String args[]) {

        Random rand = new Random();
        double b; //integer for comparing values and expected values
        long iterations = 1500000;


        coke = new Coke(rand.nextInt(1000));
        System.out.println(coke); //add
        pepsi = new Pepsi(rand.nextInt(1000));
        System.out.println(pepsi);
        dew = new Dew(rand.nextInt(1000));
        System.out.println(dew);
        System.out.println("\n");


        b = coke.getWeight() + pepsi.getWeight() + dew.getWeight();
//        System.out.println(coke.getWeight() / b);

        Map<String, Integer> countMap = new HashMap<>(); // Initialize empty hashmap

        //Loop for picking products
        for (int p = 0; p <= iterations; p++) {
            String productName = productPick(); // Call productPick method and assign the returned productName string to a String variable
            Integer x = countMap.get(productName); // Get the current Integer value from the hashmap with key productName
            if (x == null) {  // x will be null if this is the first time that product has been picked (no key in the hashmap)
                x = 0;
            }
            x++; // Increment the temporary value that we pulled from the hashmap by one
            countMap.put(productName, x); // Store the value back into the hashmap, so we pulled it out, incremented it, then stored it back in the hashmap

        }

//      change order of countMap by manually looping over the elements of the countMap
        System.out.println(countMap);
        System.out.println("\n");
        //System.out.println(countMap.containsValue(coke.getWeight()));

        
        String longestString = "pepsi percent difference of expected vs actual ";
        
        String formatString = "%" + longestString.length() + "s = %9.5f\n";
        //COKE OUTPUTS
        double cokeExpectedPer = (double) coke.getWeight() / b * 100;
        System.out.printf(formatString , "coke expected percentage ",  cokeExpectedPer);

        double cokeActualPer = (double)(countMap.get(coke.getName())) / (double)iterations * 100.0;
        System.out.printf(formatString  , "coke actual percentage " , cokeActualPer);

        System.out.printf(formatString , "coke percent difference of expected vs actual " , cokeActualPer-cokeExpectedPer);
        System.out.println("\n");


        // PEPSI OUTPUTS
        double pepsiExpectedPer = (double) pepsi.getWeight() / b * 100;
        System.out.printf(formatString , "pepsi expected percentage ",  pepsiExpectedPer);

        double pepsiActualPer = (double)(countMap.get(pepsi.getName())) / (double)iterations * 100.0;
        System.out.printf(formatString  , "pepsi actual percentage " , pepsiActualPer);

        System.out.printf(formatString , "pepsi percent difference of expected vs actual " , pepsiActualPer-pepsiExpectedPer);
        System.out.println("\n");



        //DEW OUTPUTS
        double dewExpectedPer = (double) dew.getWeight() / b * 100;
        System.out.printf(formatString , "dew expected percentage ",  dewExpectedPer);

        double dewActualPer = (double)(countMap.get(dew.getName())) / (double)iterations * 100.0;
        System.out.printf(formatString  , "dew actual percentage " , dewActualPer);

        System.out.printf(formatString , "dew percent difference of expected vs actual " , dewActualPer-dewExpectedPer);
        System.out.println("\n");




    }


    public static String productPick( ) {
        //TODO random product logic goes here
        String name;


//         pick a random weight
        Random rand = new Random();
        int n = rand.nextInt(-1 + coke.getWeight() + pepsi.getWeight()+ dew.getWeight()) + 1;

//        product weighted values
//        Coke.getWeight();
//        Pepsi.getWeight();
//        Dew.getWeight();
        if (n > 0 && n <= coke.getWeight()) {
            name = coke.getName();
        } else if (n > coke.getWeight() && n <= coke.getWeight() + pepsi.getWeight()) {
            name = pepsi.getName();
        } else if (n > coke.getWeight() + pepsi.getWeight() && n <= coke.getWeight() + pepsi.getWeight()+ dew.getWeight()) {
            name = dew.getName();
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
