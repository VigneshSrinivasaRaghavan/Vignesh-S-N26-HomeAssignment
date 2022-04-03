package framework.utils;

import com.github.javafaker.Faker;

public class FakerUtils {

    public static String generateName(){
        Faker faker = new Faker();
        return faker.regexify("[A-Za-z0-9]{10}");
    }
}
