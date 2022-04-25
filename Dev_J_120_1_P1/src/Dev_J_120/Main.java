package Dev_J_120;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {


    public static void main(String[] args) {
        
    Set <PhoneNum> set = new HashSet<>();
       set.add(new PhoneNum("054", "3214598"));
       set.add(new PhoneNum("054", "3214598"));
       set.add(new PhoneNum("054", "3214598"));
// пытались добавить три одинаковых номера - добавился только один из них.
       set.add(new PhoneNum("954", "3214599"));
       set.add(new PhoneNum("8549", "032199"));
    set.forEach(x -> System.out.println(x.toString())); 
    
        System.out.println();
        
    Map<PhoneNum, String> map = new HashMap<>();
        map.put(new PhoneNum("812", "1235498"), "Иван Иванов");
        map.put(new PhoneNum("812", "1235498"), "Петр Петров");
        map.put(new PhoneNum("812", "1235498"), "Сидор Сидоров");
// пытались добавить три одинаковых номера - добавился только один из них.        
        map.put(new PhoneNum("001", "984587"), "Александр Александров");
        map.put(new PhoneNum("65987", "6658745"), "Борис Борисов");
    map.forEach((x, y) -> System.out.println(x + " = " + y)); 

    }
    
}
