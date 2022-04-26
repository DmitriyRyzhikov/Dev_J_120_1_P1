
package Dev_J_120;

import java.util.Arrays;

public class PhoneNum {
    
    private char [] code;
    private char [] number;
    
    public PhoneNum(String code,  String number) {
        setCode(code);
        setNumber(number); 
    }
    /* Сеттеры для кода города и телефонного номера. Проверка строки с номерами
    осуществляется на null, пустую строку, лишние пробелы и на символы - цифры.
    */
    public final void setCode(String code) {
       if(code != null && !code.isEmpty()) {
          char[] temp = code.trim().toCharArray();
          for(char ch : temp) {
              if(!Character.isDigit(ch)) 
                 throw new IllegalArgumentException("Код города указан некорректно");
          }
          if(temp.length < 6)
             this.code = temp;
          else
              throw new IllegalArgumentException("В коде города указаны лишние цифры");
       }
       else
           throw new IllegalArgumentException("Не указан код города");
    }
       
    public final void setNumber(String number) {
        if(number != null && !number.isEmpty()) {
           char[] temp = number.trim().toCharArray();
          for(char ch : temp) {
              if(!Character.isDigit(ch)) 
                 throw new IllegalArgumentException("Номер телефона указан некорректно");
          }
          if(temp.length >= 2 && temp.length < 10)
             this.number = temp;
          else
              throw new IllegalArgumentException("Номер телефона указан некорректно");
       }
       else
           throw new IllegalArgumentException("Не указан номер телефона");
    }

    public char [] getCode() {
        return code; 
    }

    public char [] getNumber() {
        return number; 
    }
    
    //переопределенные методы toString, equals и hashCode.
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for(char c : code)
            sb.append(c);
        sb.append(")");
        if(number.length % 2 == 0) {
            sb.append(number[0]).append(number[1]);
            for(int i = 2; i < number.length; i++) {
                sb.append('-').append(number[i]).append(number[++i]); }
        }
        else {
            sb.append(number[0]).append(number[1]).append(number[2]);
            for(int i = 3; i < number.length; i++) {
                sb.append('-').append(number[i]).append(number[++i]); }
        }        
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || !(obj instanceof PhoneNum))
            return false;
        PhoneNum temp = (PhoneNum)obj;
        return Arrays.equals(temp.getCode(), code) && Arrays.equals(temp.getNumber(), number) && temp.hashCode() == this.hashCode(); 
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(number) - Arrays.hashCode(code);  
    }
}
   