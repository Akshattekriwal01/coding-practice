import java.util.* ;
/**
 * Implement Comparator when you want to compare to objects to them selves.  compare(x,y)
 * Implement Comparable<T> to make this object comparable with 0 . this.compareTo(x);
 the question is when to implement which abstract class.
 */ 
class Detail implements Comparable<Detail> {
    int[] arr ;
    public Detail(int[] arr){
        this.arr = arr; 
    }
    public int compareTo(Detail o){
        return Integer.compare(this.arr[0],o.arr[0]);
    }
}
class MovieRentingSystem {
   // [shopi, moviei, pricei]
    HashMap<Integer, Shop> map ; 
    HashMap<Integer, PriorityQueue< Detail>> system ; 
    PriorityQueue<Detail> cheapestRented = new PriorityQueue<>( (Detail a , Detail b)-> -1 * Integer.compare(a.arr[2],b.arr[2]));

    public MovieRentingSystem(int n, int[][] entries) {
        map = new HashMap<>();
        for(int i = 0 ; i< n ; i++){
            map.put(i,new Shop(i));
        }

        for(int[] arr : entries){
            map.get(arr[0]).addToInventory(arr[1],arr[2]);
        }
      system = new HashMap<>();
        Comparator<Detail> comp = ( (Detail a , Detail b)-> -1 * Integer.compare(a.arr[2],b.arr[2]) );
      for(int i = 0 ; i< n ; i++){
        system.put(i, new PriorityQueue<Detail>(comp));
      }
        for(int[] arr : entries){
            addToSystem(arr);
        }
    }
    public void addToSystem(int[] entry){
        PriorityQueue<Detail> pq = system.get(entry[1]);
        if(pq.size()<=5){
            pq.add(new Detail(entry));
        }else{
            if(pq.peek().arr[2] > entry[2]){
                pq.poll();
                pq.add(new Detail(entry));
            }    
        }
    }
    public void addToRented(int[] entry){
        if(cheapestRented.size()<=5){
            cheapestRented.add(new Detail(entry));
        }else{
            if(cheapestRented.peek().arr[2] > entry[2]){
                cheapestRented.poll();
                cheapestRented.add(new Detail(entry));
            }    
        }
    }
    
    public List<Integer> search(int movie) { //
        List<int[]> al = new ArrayList<int[]>();
        PriorityQueue<Detail> pq = system.get(movie);

        for(Detail d : pq){
            al.add(d.arr);
        }
        Collections.sort(al, (int[] a, int[] b)-> {
            int i = Integer.compare(a[2],b[2]);
            if(i != 0){
                return i ;
            }else{
                return Integer.compare(a[0],b[0]);
            }
        });
        List<Integer> ans = new ArrayList<Integer>();
        for(int[] arr : al ){
            ans.add(arr[0]);
        }
        return ans;
    }
    
    public void rent(int shop, int movie) {
        int[] arr = new int[3];
        arr[0] = shop;
        arr[1] = movie;
        arr[2] = 0;
        system.get(movie).remove(arr);
        addToRented(arr);

    }
    
    public void drop(int shop, int movie) { 
        Shop s = map.get(shop);
        int price = s.getPrice(movie);
        int [] entry = {shop,movie,price};
        addToSystem(entry);
        removeFromRented(entry);
    }
    
    public List<List<Integer>> report() { // o(1) with heap        

    }
}
class Shop {
    int id ;
    Inventory InventoryObj ;
    public Shop(int id){
        this.id = id;
         Inventory InventoryObj = new Inventory() ;
    }
    public void addToInventory(int movie, int price){
        InventoryObj.add(movie,price);
    } 
    public void remove(int movie){
        InventoryObj.remove(movie);
    }
    public String toString(){
        return ""+this.id;
    }
    public int getPrice(int movie){
        return InventoryObj.getPrice(movie) ;
    }
}
class Inventory {
    
    HashMap<Integer,MovieDetail> map;
    public Inventory(){
        HashMap<Integer,MovieDetail> map= new HashMap<Integer,MovieDetail>();  
    }
    public void add(int movie,int price){
        if(map.containsKey(movie)){
            map.get(movie).increment();
        }else{
            map.put(movie, new MovieDetail(price));
        }
    }
    public boolean remove(int movie){
        if(map.containsKey(movie)){
            map.get(movie).decrement();
            if(map.get(movie).quantity == 0 ){
                map.remove(movie);
            }
        }else{
            return false;
        }
        
    }
    public int getPrice(int movie){
        return map.get(movie).price;
    }
}
class MovieDetail {
    int price ;
    int quantity ;
    public MovieDetail(int price){
        this.price = price;
        this.quantity = 1;
    }
    public int increment(){
       return ++quantity;
    }
    public int decrement(){
      return --quantity;
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */