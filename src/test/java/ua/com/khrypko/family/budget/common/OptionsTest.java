package ua.com.khrypko.family.budget.common;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Maks on 17.01.2018.
 */
public class OptionsTest {

    @Test
    public void testAddOption(){
        String optionName = "test";
        String value = "testValue";
        Options.StringOption optionValue = Options.stringOption(value);
        Options<Options.StringOption> options = new Options<>();

        options.add(optionName, optionValue);

        Assert.assertNotNull(options.get(optionName));
        Assert.assertEquals(value, options.get(optionName).getValue());
    }

}