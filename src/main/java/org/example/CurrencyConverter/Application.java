package org.example.CurrencyConverter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        XMLParser xmlParser = new XMLParser();
        xmlParser.readXMLData();
        SpringApplication.run(Application.class, args);
    }
}
