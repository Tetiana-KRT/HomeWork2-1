package homeWork201.desktop;

import homeWork201.abstractClasses.BasePage;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExMethods extends BasePage {
    public static String getValueByRegEx(String text, String pattern, int group){
        Pattern replacementPattern = Pattern.compile(pattern);
        Matcher matcher = replacementPattern.matcher(text);
        matcher.find();
        return matcher.group(group);
    }

    public static String getValueByRegEx(String text, String pattern){
        int firstGroup = 0;
        return getValueByRegEx(text, pattern, firstGroup);
    }

    public static Boolean regExMatchText(String text, String pattern){
        boolean match = Pattern.matches(pattern, text);
        return match;
    }

    public static List<String> getListOfMatchedTexts (List<String> listOfTexts, String pattern){
        java.util.List<String> listOfMatchedTexts = new ArrayList<>();
        for (int i = 0; i < listOfTexts.size(); i++) {
            if (regExMatchText(listOfTexts.get(i), pattern)==true){
                listOfMatchedTexts.add(listOfTexts.get(i));
            }
        }
        return listOfMatchedTexts;
    }
}
