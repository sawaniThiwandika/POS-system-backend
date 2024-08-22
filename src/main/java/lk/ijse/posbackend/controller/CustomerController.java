package lk.ijse.posbackend.controller;


import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.posbackend.CustomerIDWrapper;
import lk.ijse.posbackend.bo.CustomerBo;
import lk.ijse.posbackend.bo.CustomerBoImpl;
import lk.ijse.posbackend.data.CustomerDTO;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/Customer", initParams = {
        @WebInitParam(name = "driver-class", value = "com.mysql.cj.jdbc.Drive"),
        @WebInitParam(name = "dbURL", value = "jdbc:mysql://localhost:3306/TechNexus"),
        @WebInitParam(name = "dbUserName", value = "root"),
        @WebInitParam(name = "dbPassword", value = "1234")
},loadOnStartup = 1)

public class CustomerController extends HttpServlet {

    CustomerBo dataProcess = new CustomerBoImpl();
    Connection connection;

    @Override
    public void init() throws ServletException {
        try {
            System.out.println("Start");


            var ctx = new InitialContext();
            DataSource pool= (DataSource) ctx.lookup("java:comp/env/jdbc/techNexus");
            this.connection=pool.getConnection();


            System.out.println(" after var");/*
            System.out.println(driverClass);
            Class.forName(driverClass);*/
            System.out.println(" after for name");
            // Establish a connection to the database
            //this.connection = DriverManager.getConnection(dbURl, dbUserName, dbPassword);
            System.out.println("end");
            // Perform database operations here (e.g., store the connection as a servlet context attribute)

        } catch ( SQLException e) {

            throw new RuntimeException(e);

        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        CustomerDTO dto = new CustomerDTO();
        ArrayList<CustomerDTO>customerDTOArrayList=new ArrayList<>();

        try (PrintWriter writer = resp.getWriter()) {


            customerDTOArrayList = dataProcess.getCustomerList( connection);
            if (customerDTOArrayList== null) {
                resp.sendError(HttpServletResponse.SC_NO_CONTENT);
            } else {
                resp.setContentType("application/json");// json type response ekk enw kyl kynnn onima ne eth dana eka hodai
                System.out.println(customerDTOArrayList);
                Jsonb jsonb = JsonbBuilder.create();// create json object
                jsonb.toJson(customerDTOArrayList, resp.getWriter());// convert to json type (object , response eke writer) //serialization
            }
        }
        ;


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("I'm in doPost method");

        // Validate Content-Type
        String contentType = req.getContentType();
        if (contentType == null || !contentType.toLowerCase().startsWith("application/json")) {
            resp.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, "Unsupported Media Type");
            return;
        }

        // Log headers for debugging
        String myHeader = req.getHeader("myHeader");
        System.out.println("myHeader: " + myHeader);

        // Read and log the request body
        StringBuilder requestBody = new StringBuilder();
        try (BufferedReader reader = req.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                requestBody.append(line);
            }
        }
        System.out.println("Request Body: " + requestBody.toString());

        // Parse JSON to DTO
        CustomerDTO customer;
        try {
            Jsonb jsonb = JsonbBuilder.create();
            System.out.println("aaaaaaaaaaaa");
            customer = jsonb.fromJson(requestBody.toString(), CustomerDTO.class);
            System.out.println("Parsed CustomerDTO: " + customer);
            System.out.println("bbbbbbbbbbbbb");

        } catch (Exception e) {
            //resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid JSON");
            e.printStackTrace();
            return;
        }

        // Process data and send response
        String saveCustomer = dataProcess.saveCustomer(customer, connection);
        System.out.println("after save "+saveCustomer);
        PrintWriter writer = resp.getWriter();

        if ("Saved".equals(saveCustomer)) {
            writer.write("Saved successfully");
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            writer.write("Cannot save");
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Cannot save");
        }

        writer.flush(); // Ensure all data is sent
        }




    @Override
    protected void doPatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("I'm in doPatch method");

        // Validate Content-Type
        String contentType = req.getContentType();
        if (contentType == null || !contentType.toLowerCase().startsWith("application/json")) {
            resp.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, "Unsupported Media Type");
            return;
        }

        // Log headers for debugging
        String myHeader = req.getHeader("myHeader");
        System.out.println("myHeader: " + myHeader);

        // Read and log the request body
        StringBuilder requestBody = new StringBuilder();
        try (BufferedReader reader = req.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                requestBody.append(line);
            }
        }
        System.out.println("Request Body: " + requestBody.toString());

        // Parse JSON to DTO
        CustomerDTO customer;
        try {
            Jsonb jsonb = JsonbBuilder.create();
            System.out.println("aaaaaaaaaaaa");
            customer = jsonb.fromJson(requestBody.toString(), CustomerDTO.class);
            System.out.println("Parsed CustomerDTO: " + customer);
            System.out.println("bbbbbbbbbbbbb");

        } catch (Exception e) {
            //resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid JSON");
            e.printStackTrace();
            return;
        }

        // Process data and send response
            boolean updateCustomer = dataProcess.updateCustomer(customer, connection);
        System.out.println("after save "+updateCustomer);
        PrintWriter writer = resp.getWriter();

        if (updateCustomer) {
            writer.write("Update successfully");
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            writer.write("Cannot Update");
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Cannot save");
        }

        writer.flush(); // Ensure all data is sent


    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("I'm in doDelete method");

        // Validate Content-Type
        String contentType = req.getContentType();
        if (contentType == null || !contentType.toLowerCase().startsWith("application/json")) {
            resp.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, "Unsupported Media Type");
            return;
        }

        // Log headers for debugging
        String myHeader = req.getHeader("myHeader");
        System.out.println("myHeader: " + myHeader);

        // Read and log the request body
        StringBuilder requestBody = new StringBuilder();
        try (BufferedReader reader = req.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                requestBody.append(line);
            }
        }
        System.out.println("Request Body: " + requestBody.toString());

        // Parse JSON to DTO
       String customerId;
        try {
            Jsonb jsonb = JsonbBuilder.create();
            CustomerIDWrapper wrapper = jsonb.fromJson(requestBody.toString(), CustomerIDWrapper.class);
            customerId = wrapper.cusId;
            System.out.println("delete customer ID: " + customerId);
            System.out.println("bbbbbbbbbbbbb");

        } catch (Exception e) {
            //resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid JSON");
            e.printStackTrace();
            return;
        }

        // Process data and send response
        boolean deleteCustomer = dataProcess.deleteCustomer(customerId, connection);
        System.out.println("after delete "+deleteCustomer);
        PrintWriter writer = resp.getWriter();

        if (deleteCustomer) {
            writer.write("delete successfully");
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            writer.write("Cannot delete");
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Cannot delete");
        }

        writer.flush(); // Ensure all data is sent
    }
}
