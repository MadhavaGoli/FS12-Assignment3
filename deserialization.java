import java.io.*;

class Product implements Serializable {
    private int id;
    private String name;
    private String category;
    private double price;

    public Product(int id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

public class SerializationExample {

    // Serialization method
    public static void serialize(Product product, String filename) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(product);
            System.out.println("Product serialized successfully.");
        }
    }

    // Deserialization method
    public static Product deserialize(String filename) throws IOException, ClassNotFoundException {
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            Product product = (Product) objectIn.readObject();
            System.out.println("Product deserialized successfully.");
            return product;
        }
    }

    public static void main(String[] args) {
        Product originalProduct = new Product(1, "Laptop", "Electronics", 999.99);

        // Serialization
        String filename = "product.ser";
        try {
            serialize(originalProduct, filename);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialization
        try {
            Product deserializedProduct = deserialize(filename);
            System.out.println("Deserialized Product Details:");
            System.out.println("ID: " + deserializedProduct.getId());
            System.out.println("Name: " + deserializedProduct.getName());
            System.out.println("Category: " + deserializedProduct.getCategory());
            System.out.println("Price: $" + deserializedProduct.getPrice());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}