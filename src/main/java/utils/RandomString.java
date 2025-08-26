package utils;

import java.util.Random;

public class RandomString {
	

    static String CHARSET = "ABCD1234";
    static Random RAND = new Random();

   public static String randomAlphanumeric(int length) {
       StringBuilder sb = new StringBuilder(length);
       for (int i = 0; i < length; i++) {
           int index = RAND.nextInt(CHARSET.length());
           sb.append(CHARSET.charAt(index));
       }
       return sb.toString();
   }

   public static String generateWithPrefix(String prefix, int randomLength) {
       return prefix + randomAlphanumeric(randomLength);
   }

  

}
