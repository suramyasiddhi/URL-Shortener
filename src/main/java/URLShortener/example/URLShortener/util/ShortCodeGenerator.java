package URLShortener.example.URLShortener.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ShortCodeGenerator {

    public String generate(){
        String characters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ" ;
        Random random = new Random();
        String shortUrl = "" ;

        while(shortUrl.length() < 6){

            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);

            shortUrl += randomChar ;

        }

        return shortUrl ;
    }
}
