package Back;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hashing {

    public static String doHashing(String password){

        try {
            MessageDigest hash = MessageDigest.getInstance("SHA");
            hash.update(password.getBytes());
            byte[] resultByte = hash.digest();

            StringBuilder result = new StringBuilder();
            for (byte b:resultByte){
                result.append(String.format("%02x",b));
            }

            return result.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
