package usermodel;


import org.apache.commons.lang3.RandomStringUtils;


public class GenerateUser {

    public static User getRandom(int lengthPassword) {
        String email = RandomStringUtils.randomAlphabetic(15) + "@yandex.ru";
        String password = RandomStringUtils.randomAlphabetic(lengthPassword);
        String name = RandomStringUtils.randomAlphabetic(15);
        return new User(email, password, name);
    }
}
