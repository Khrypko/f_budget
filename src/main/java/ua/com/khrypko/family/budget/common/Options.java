package ua.com.khrypko.family.budget.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Maks on 17.01.2018.
 */
public class Options<T extends Option> {

    private Map<String, T> options;

    public void add(String optionName, T optionValue) {
        if (options == null) options = new HashMap<>();

        options.put(optionName, optionValue);
    }

    public T get(String optionName) {
        return options.get(optionName);
    }

    public static StringOption stringOption(String testValue) {
        return new StringOption(testValue);
    }

    public static class StringOption implements Option {
        private String value;

        public StringOption(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
