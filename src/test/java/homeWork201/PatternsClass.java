package homeWork201;

        import org.junit.jupiter.api.*;

        import java.util.ArrayList;

        import static homeWork201.desktop.RegExMethods.*;

public class PatternsClass {

    @DisplayName("Test different patterns")
    @Tag("testTag")
    @Test
    public void addToCartTest() {
        String bankCardPattern = "^((([0-9]{4} ){3}[0-9]{4})|([0-9]{16}))$";
        String ipAddressPattern = "^(?:[0-9]{1,3}\\.){3}[0-9]{1,3}$";
        String emailAddressPattern = "^([a-z0-9!#$%^&*()_\\-=+<>\"':]+(\\.[a-z0-9!#$%^&*()_\\-=+<>\"':]+)?@[a-z]+(\\.[a-z]+)?\\.[a-z]+)$";
        java.util.List<String> list = new ArrayList<>();
        list.add("1234 5678 9012 3456");
        list.add("1234567890123456");
        list.add("1234 5678 9012");
        list.add("qwer tyui opas dfgh");
        list.add("1a2s 1a2a 1a2s 1s2a");
        list.add("qwertyuioplkjhgf");
        list.add("1234 5678 9012 3456 7890");
        list.add("!@#$ !#^$ &%#@ *&13");
        list.add("192.168.2.154");
        list.add("192.1680.2.154");
        list.add("192.168.2.1540");
        list.add("66.249.73.38");
        list.add("test@me.com");
        list.add("test.new@me.com.ua");
        list.add("test123.new1@me.com");
        list.add("t!#$%^&*()_-=+<>\"':@er.me");
        list.add("test123.!#$%@me.com");
        list.add("t!@#$%^&*()_-=+<>\"':@er.me");
        list.add("asdas.sasad.sd");
        list.add("a@a.a");

        System.out.println("The list of bank cards: " + getListOfMatchedTexts(list, bankCardPattern));
        System.out.println("The list of ip addresses: " + getListOfMatchedTexts(list, ipAddressPattern));
        System.out.println("The list of email addresses: " + getListOfMatchedTexts(list, emailAddressPattern));


    }
}