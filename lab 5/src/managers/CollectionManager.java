package managers;

import models.Product;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class CollectionManager {
    private TreeMap<Integer,Product> collection;
    private ZonedDateTime creationDate;
    private HashSet<Long> uniqueIds;
    public CollectionManager (){
        this.collection = new TreeMap<>();
        this.creationDate = ZonedDateTime.now();
        this.uniqueIds = new HashSet<>();
    }

    public void setCollection(TreeMap<Integer, Product> collection) {
        this.collection = collection;
    }

    public TreeMap<Integer, Product> getCollection() {
        return collection;
    }

    private Long generateNextId (){
        if (uniqueIds.isEmpty()){
            uniqueIds.add(1l);
            return 1l;
        }else{
            Long id = collection.get(collection.size()-1).getId()+1;
            if (uniqueIds.contains(id))
                while (uniqueIds.contains(id))
                    id +=1;
            uniqueIds.add(id);
            return id;
        }
    }
    public void insert (Integer key,Product product){
        Long id = generateNextId();
        product.setId(id);
        collection.put(key,product);
        System.out.println(product+"\n");
    }
    public String collectionInfo (){
        return "TreeMap of Product has #"+collection.size()+"# elements and was created in #"+creationDate+"#";
    }
    public boolean update (Long id,Product product){
        if (!uniqueIds.contains(id)) return false;
        AtomicBoolean isUpdated = new AtomicBoolean(false);
        collection.values().forEach(p -> {
            if (p.getId() == id){
                p.setCoordinates(product.getCoordinates());
                p.setName(product.getName());
                p.setOwner(product.getOwner());
                p.setPrice(product.getPrice());
                p.setCreationDate(product.getCreationDate());
                p.setUnitOfMeasure(product.getUnitOfMeasure());
                isUpdated.set(true);
            }
        });
        return isUpdated.get();
    }
    public boolean removeKey (Integer key){
        Product product = collection.remove(key);
        return !collection.containsValue(product) && collection.remove(key,product);
    }
    public void clear (){
        collection.clear();
    }
    public boolean removeGreater(Product product){
        boolean removed = collection.values().removeIf(p -> p.compareTo(product)<0);
        if (removed) removed = collection.keySet().removeIf(k -> product.getId() == k);
        return removed;
    }
    public boolean removeLower (Product product){
        boolean removed = collection.values().removeIf(p -> p.compareTo(product)>0);
        if (removed) removed = collection.keySet().removeIf(k -> product.getId() == k);
        return removed;
    }
    public boolean removeLowerKey (Integer key){
        return collection.tailMap(key,false).keySet().removeIf(k -> k < key);
    }
    public double sumOfPrice (){
        double sum = 0;
        for (Product product : collection.values()) {
            sum += product.getPrice();
        }
        return sum;
    }
    public double averageOfPrice (){
        double average = 0;
        average = sumOfPrice()/collection.values().size();
        return average;
    }
    public Set<Double> descendingPrice (){
        Set<Double> descendingPrice =  new TreeSet<>(Comparator.reverseOrder());
        collection.values().forEach(p -> descendingPrice.add(p.getPrice()));
        return descendingPrice;
    }
}
