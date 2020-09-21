package com.thoughtworks.basic.course;

import org.junit.Test;


import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by dell on 2020/9/18.
 */
public class SchemaTest {
    @Test
    public void should_return_boolean_when_get_type_given_flag(){
        //given
        Set<FlagSchema> flagSchema = new HashSet<>();
        flagSchema.add(new FlagSchema("l",ValueFeature.BOOLEAN));
        Schema schema = new Schema(flagSchema);
        //when
        Object type = schema.getTypeOf("l");
        //then
        assertEquals(Boolean.TYPE,type);
    }

    @Test
    public void should_Return_FlagType_When_Given_VlaueOf_P(){
        Set<FlagSchema> flagSchemaSet = new HashSet<FlagSchema>();
        flagSchemaSet.add(new FlagSchema("p",ValueFeature.INTEGER));
        Schema schema = new Schema(flagSchemaSet);
        Object type = schema.getTypeOf("p");
        assertEquals("java.lang.Integer",type);
    }
}
