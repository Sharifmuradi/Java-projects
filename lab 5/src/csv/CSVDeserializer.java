package csv;

import models.Product;

import java.util.TreeMap;
interface DeserializationValidate{
    boolean isValid (Product product);
}
public class CSVDeserializer {
    private TreeMap<Integer, Product> collection;
    private String csv;
    public CSVDeserializer (String csv){
         this.csv = csv;
         this.collection = new TreeMap<>();
    }
    public TreeMap<Integer,Product> deserialize(){

    }
  private static boolean validate (Product product){
        return product.getName()!=null && !product.getName().equals("")
                && product.getCoordinates().getX()<495
                && product.getCoordinates().getY()> -226
                && product.getCreationDate()!=null
                &&
  }
}

