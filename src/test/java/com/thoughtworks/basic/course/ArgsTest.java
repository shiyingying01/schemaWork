package com.thoughtworks.basic.course;

import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by dell on 2020/9/18.
 */
public class ArgsTest {
    @Test
    public void should_return_string_list_when_scan_given_string(){
        //given
        String argsText = "-l true -p 8080 -d /usr/logs";
        Args args = new Args(argsText);

        //when
        List<String> keyValues = args.scan();
        //List<KeyValuePair> keyValuePairs = args.scan();

        //then
        //keyvalue字符串
        assertEquals(3,keyValues.size());
        assertTrue(keyValues.contains("l true"));
    }
}
