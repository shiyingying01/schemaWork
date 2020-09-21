package com.thoughtworks.basic.course;

import com.thoughtworks.basic.course.Args;
import com.thoughtworks.basic.course.FlagSchema;
import com.thoughtworks.basic.course.KeyValuePair;
import com.thoughtworks.basic.course.Schema;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by dell on 2020/9/18.
 */
public class ArgsTest {
    @Test
    public void should_return_string_when_scan_given_string(){
        //given
        Set<FlagSchema> flagSchemaSet = new HashSet<FlagSchema>();
        flagSchemaSet.add(new FlagSchema("l",Boolean.TYPE));
        Schema schema = new Schema(flagSchemaSet);
        String argsText = "-l true -p 8080 -d /usr/logs";
        //Args args = new Args(argsText);
        Args args = new Args(argsText, schema);
        //when
        //List<String> keyValues = args.scan();
        List<KeyValuePair> keyValuePairs = args.scan();


        //then
        //keyvalue字符串
        assertEquals(3,keyValuePairs.size());
//        assertTrue(keyValues.contains("l true"));
        assertTrue(keyValuePairs.contains(new KeyValuePair("l", "true")));
    }

    @Test
    public void should_Return_String_When_Scan_Given_String(){

        Set<FlagSchema> flagSchemaSet = new HashSet<FlagSchema>();
        flagSchemaSet.add(new FlagSchema("l",Boolean.TYPE));
        Schema schema = new Schema(flagSchemaSet);

        String argsTest = "-l true -p 8080 -d usr/logs";
        Args args = new Args(argsTest, schema);
        List<KeyValuePair> keyValuePairs = args.scan();
        assertEquals(3,keyValuePairs.size());
        assertTrue(keyValuePairs.contains(new KeyValuePair("l", "true")));
    }

    @Test
    public void should_Return_IntType_Value_When_Scan_GetValueOfFlag(){

        Set<FlagSchema> flagSchemaSet = new HashSet<FlagSchema>();
        flagSchemaSet.add(new FlagSchema("p",Integer.TYPE));
        Schema schema = new Schema(flagSchemaSet);

        String argsTest = "-l true -p 8080 -d usr/logs";
        Args args = new Args(argsTest,schema);
        Object value = args.getValueOf("p");

        assertEquals(value,8080);
    }
}
