package vezba1;
import java.util.ArrayList;
import vezba1.mojaklasa;
public class hello{

    public static void main(String[] args){
       ArrayList<String> kolekcija = new ArrayList<String>();
       kolekcija.add("hello world");
       kolekcija.add(1, "hello again");
       kolekcija.remove(0);
       String s= kolekcija.get(0);
       System.out.println(s);
       mojaklasa m=new mojaklasa();
       m.say();
    }
}