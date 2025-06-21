import java.util.*;
public class ProductSearch {
    public static Product linearSearch(List<Product> products, String targetName){
        for(Product c : products){
            if(c.productName.equalsIgnoreCase(targetName)) return c;
        }
        return null;
    }
    public static Product binarySearch(List<Product> products,String targetName){
        int start=0,last=products.size()-1;
        while(start<=last){
            int mid=(last+start)/2;
            int k=products.get(mid).productName.compareToIgnoreCase(targetName);
            if(k==0)
                return products.get(mid);
            else if(k>0) last=mid-1;
            else start=mid+1;

        }
        return null;
    }
    public static void main(String[] args){
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop", "Electronics"));
        products.add(new Product(2, "Bat", "Sports"));
        products.add(new Product(3, "Phone", "Electronics"));
        products.add(new Product(4, "Ball", "Sports"));
        Product result1=linearSearch(products,"Bat");
        System.out.println("Linear Search: "+result1);
        products.sort(Comparator.comparing(p -> p.productName.toLowerCase()));
        Product result2=binarySearch(products,"Phone");
        System.out.print("Binary Search: "+result2);
    }
}
