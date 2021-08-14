import java.util.Scanner;

public class ProductMenu {
    private Scanner sc;
    private ProductManager pm;

    public ProductMenu() {
        this.sc = new Scanner(System.in);
        this.pm = new ProductManager();
    }

    private int menu() {
        System.out.println("|---------------------------------------|");
        System.out.println("|+++++++++++++ PRODUCT MENU ++++++++++++|");
        System.out.println("|---------------------------------------|");
        System.out.println("|           1. Add Product              |");
        System.out.println("|           2. Show All Products        |");
        System.out.println("|           3. Remove Products          |");
        System.out.println("|           0. Exit                     |");
        System.out.println("=========================================");
        int choice = readInt(0, 3);
        return choice;
    }

    public void start() {
        while (true) {
            int choice = menu();
            switch (choice) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    addProduct();
                    break;
                case 2:
                    showAll();
                    break;
                case 3:
                    removeProduct();
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

    private int readInt(int min, int max) {
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice >= min && choice <= max) {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return choice;
    }

    private float readFloat(int min, float max) {
        float price;
        while (true) {
            try {
                price = Float.parseFloat(sc.nextLine());
                if (price >= min && price <= max) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid value. Try to Enter a float value!");
            }
        }
        return price;
    }

    private void addProduct() {
        System.out.println("Enter product ID:");
        int id = readInt(0, Integer.MAX_VALUE);
        System.out.println("Enter Product Name:");
        String name = sc.nextLine();
        System.out.println("Enter Product Price:");
        float price = readFloat(0, Float.MAX_VALUE);
        Products p = new Products(id, name, price);
        this.pm.addProduct(p);
        System.out.println("Product Added!");
    }

    private void showAll() {
        System.out.println("|------------  ALL Product ------------|");
        System.out.println("|\t   ID \t Name \t Price \t|");
        for (int i = 0; i < this.pm.count(); i++) {
            Products p = this.pm.getProduct(i);
            System.out.println("|\t" + p.getId() + "\t" + p.getName() + "\t" + p.getPrice() + "\t|");
        }
        System.out.println("|---------------------------------------|");
    }

    private void removeProduct() {
        System.out.println("Enter ID of the product");
        int id = readInt(0, Integer.MAX_VALUE);
        boolean result = this.pm.removeProduct(id);
        if (result) {
            System.out.println();
            System.out.println("Product REMOVED!");
        } else {
            System.out.println();
            System.out.println("Product Not Found!");
        }
    }
}