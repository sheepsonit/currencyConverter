package org.example.CurrencyConverter;

import org.example.CurrencyConverter.domain.Valute;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;

public class XMLParser {

    private static ArrayList<Valute> valutesList = new ArrayList<>();

    public void readXMLData() {
        try {
            // Создается построитель документа
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            // Создается дерево DOM документа из файла
            Document document = documentBuilder.parse("http://www.cbr.ru/scripts/XML_daily.asp");

            // Получаем корневой элемент
            Node root = document.getDocumentElement();

            System.out.println("List of valutes:");
            System.out.println();
            // Просматриваем все подэлементы корневого - т.е. книги
            NodeList valutes = root.getChildNodes();
            for (int i = 0; i < valutes.getLength(); i++) {
                Node valute = valutes.item(i);
                // Если нода не текст, то это книга - заходим внутрь
                if (valute.getNodeType() != Node.TEXT_NODE) {
                    System.out.println("AAAA:");
                    NamedNodeMap valuteAttributes = valute.getAttributes();
                    NodeList valuteProperties = valute.getChildNodes();
                    createValute(valuteAttributes, valuteProperties);
                    System.out.println("===========>>>>");
                }
            }
            for (Valute val : valutesList) {
                System.out.println(val.toString());
            }

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public void createValute(NamedNodeMap valuteAttributes, NodeList valuteProperties) {
        System.out.println(" createValute(NodeList valuteProperties)::");
        System.out.println("BB:" + valuteAttributes.getLength());
        Valute valute = new Valute();
        for (int k = 0; k < valuteAttributes.getLength(); k++) {
            valute.setValute_id(valuteAttributes.item(k).getNodeValue());
        }
        for (int j = 0; j < valuteProperties.getLength(); j++) {
            Node valuteProperty = valuteProperties.item(j);
            // Получение атрибутов каждого элемента
            if (valuteProperty.getNodeType() != Node.TEXT_NODE) {
                System.out.println(j);
                switch (valuteProperties.item(j).getNodeName()) {
                    case "NumCode":
                        System.out.println("NumCode " + valuteProperties.item(j).getNodeName() + " " + valuteProperties.item(j).getTextContent());
                        valute.setNumCode(valuteProperties.item(j).getTextContent());
                        break;
                    case "CharCode":
                        System.out.println("CharCode " + valuteProperties.item(j).getNodeName() + " "  + valuteProperties.item(j).getTextContent());
                        valute.setCharCode(valuteProperties.item(j).getTextContent());
                        break;
                    case "Nominal":
                        System.out.println("Nominal " + valuteProperties.item(j).getNodeName() + " "  + valuteProperties.item(j).getTextContent());
                        valute.setNominal(Integer.parseInt(valuteProperties.item(j).getTextContent()));
                        break;
                    case "Name":
                        System.out.println("Name " + valuteProperties.item(j).getNodeName() + " "  + valuteProperties.item(j).getTextContent());
                        valute.setName(valuteProperties.item(j).getTextContent());
                        break;
                    case "Value":
                        System.out.println("Value " + valuteProperties.item(j).getNodeName() + " "  + valuteProperties.item(j).getTextContent());
                        valute.setValue(Float.parseFloat(valuteProperties.item(j).getTextContent().replace(",",".")));
                        break;
                }
            }
        }
        valutesList.add(valute);

    }
}
