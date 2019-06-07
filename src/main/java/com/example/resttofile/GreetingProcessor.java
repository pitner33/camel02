package com.example.resttofile;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class GreetingProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        String body = exchange.getIn().getBody(String.class);
        exchange.getIn().setBody("Hello " + body + "!");
    }
}
