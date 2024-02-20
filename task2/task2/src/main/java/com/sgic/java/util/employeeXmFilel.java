package com.sgic.java.util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class employeeXmFilel {
    public static void main(String[] args) {
        try {
            // Step 1: Parse XML file
            File xmlFile = new File("Employee.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // Step 2: Connect to the database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company1", "root", "");

            // Step 4: Insert data into the database
            NodeList nodeList = doc.getElementsByTagName("employee");
            String insertQuery = "INSERT INTO employee(Id, Name, Position, Department) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element EmployeeElement = (Element) node;
                    String position = getTextContent(EmployeeElement, "position");
                    if(position.equals("Quality Engineer")) {

                        String id = getTextContent(EmployeeElement, "id");
                        String name = getTextContent(EmployeeElement, "name");
                        position = getTextContent(EmployeeElement, "position");
                        String department = getTextContent(EmployeeElement, "department");

                        preparedStatement.setString(1, id);
                        preparedStatement.setString(2, name);
                        preparedStatement.setString(3, position);
                        preparedStatement.setString(4, department);
                        preparedStatement.addBatch();
                        preparedStatement.executeBatch();
                    }

                }
            }



            conn.close();
            System.out.println("Data inserted successfully!");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getTextContent(Element element, String tagName) {
        return element.getElementsByTagName(tagName).item(0).getTextContent();
    }
}

