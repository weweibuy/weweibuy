package com.weweibuy.webuy.learning.event.event.parser;

import org.junit.Test;

public class EventRuleParserTest {


    @Test
    public void parse() throws Exception {
        Long parse = EventRuleParser.parse("1s 10s 60s end", 1572181781532L, 6);
        System.err.println(parse);
        System.err.println(1572181781532L + 1000);
    }

}