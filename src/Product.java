/*Class:
    Product(super/parent class)
        inherit and define child classes from it
        int weight(member variable of Product)
        -extends
        pick 5 products extends product class
        String name;
*/

//POJO Plain Old Java Object
public abstract class Product {


    int weight;
    String name;

    public Product(int weight, String name) {
        this.weight = weight;
        this.name = name;
    }

    public Product( ) {

    }

    public int getWeight( ) {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName( ) {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString( ) {
        return "Product " +
                name + " " + weight;
    }
}
