package csv;

import models.Product;
import java.util.Map;
import java.util.TreeMap;

public class CSVSerializer {
    private TreeMap<Integer, Product> collection;
    public CSVSerializer (TreeMap<Integer,Product> collection){
        this.collection = collection;
    }
    public String serialize (){
        StringBuilder csv = new StringBuilder("");
        csv.append("Key, ProductId, ProductName, CoordinatesX, CoordinatesY, CreationDate, Price, UnitOfMeasure, OwnerName, Birthday, Weight, LocationX, LocationY, LocationName"+"\n");
        for(Map.Entry<Integer,Product> entry : collection.entrySet()){
            Integer key = entry.getKey();
            Product product = entry
                    .getValue();
            csv.append(key)
                    .append(", ")
                    .append(product.getId())
                    .append(", ")
                    .append(product.getName())
                    .append(", ")
                    .append(product.getCoordinates().getX())
                    .append(", ")
                    .append(product.getCoordinates().getY())
                    .append(", ")
                    .append(product.getCreationDate())
                    .append(", ")
                    .append(product.getPrice())
                    .append(", ")
                    .append(product.getUnitOfMeasure())
                    .append(", ")
                    .append(product.getOwner().getName())
                    .append(", ")
                    .append(product.getOwner().getBirthday())
                    .append(", ")
                    .append(product.getOwner().getWeight())
                    .append(", ")
                    .append(product.getOwner().getLocation().getX())
                    .append(", ")
                    .append(product.getOwner().getLocation().getY())
                    .append(", ")
                    .append(product.getOwner().getLocation().getName())
                    .append("\n");
        }
        return csv.toString();
    }
}
