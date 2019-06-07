package com.example.resttofile;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class Routes extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("rest:POST:/hello")
                .process(exchange -> {
                    String body = exchange.getIn().getBody(String.class).toUpperCase();
                    exchange.getIn().setBody(body + "\n" + body);
                })
                .to("file:/home/sol/workspace/dummies/190605_restToFile_camel/fileOut?fileName=macska.txt");

        from("rest:Post:/greetings")
                .process(new GreetingProcessor())
                .to("file:/home/sol/workspace/dummies/190605_restToFile_camel/fileOut?fileName=greeter.txt");
    }
}
