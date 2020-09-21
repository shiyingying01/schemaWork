package com.thoughtworks.basic.course;

import com.thoughtworks.basic.course.Args;
import com.thoughtworks.basic.course.FlagSchema;
import com.thoughtworks.basic.course.KeyValuePair;
import com.thoughtworks.basic.course.Schema;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThat;

/**
 * Created by dell on 2020/9/18.
 */
public class ArgsTest {
    @Test
    public void should_return_string_when_scan_given_string(){
        //given
        Set<FlagSchema> flagSchemaSet = new HashSet<FlagSchema>();
        flagSchemaSet.add(new FlagSchema("l",ValueFeature.BOOLEAN));
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
        flagSchemaSet.add(new FlagSchema("l",ValueFeature.BOOLEAN));
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
        flagSchemaSet.add(new FlagSchema("p",ValueFeature.INTEGER));
        Schema schema = new Schema(flagSchemaSet);

        String argsTest = "-l true -p 8080 -d usr/logs";
        Args args = new Args(argsTest,schema);
        Object value = args.getValueOf("p");

        assertEquals(value,8080);
    }

    @Test
    public void should_Return_StringType_When_Scan_Given_GetValueOfFlag(){

        Set<FlagSchema> flagSchemaSet = new HashSet<FlagSchema>();
        flagSchemaSet.add(new FlagSchema("d",ValueFeature.STRING));
        Schema schema = new Schema(flagSchemaSet);

        String argsTest = "-l true -p 8080 -d usr/logs";
        Args args = new Args(argsTest,schema);
        Object value = args.getValueOf("d");

        assertEquals(value,"usr/logs");
    }

    @Test
    public void should_throw_error_no_legal_when_repeat_flag() throws Exception {
        Set<FlagSchema> flagSchemaSet = new HashSet<FlagSchema>();
        Schema schema = new Schema(flagSchemaSet);
        String argsTest = "-l true -l false";

        try {
            Args args = new Args(argsTest,schema);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            assertThat(exception.getMessage(), is("不允许输入重复flag"));
        }
    }
}
