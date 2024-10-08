package lk.ijse.posbackend.controller;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.posbackend.bo.ItemBo;
import lk.ijse.posbackend.bo.ItemBoImpl;
import lk.ijse.posbackend.bo.OrderBo;
import lk.ijse.posbackend.bo.OrderBoImpl;
import lk.ijse.posbackend.data.ItemDTO;
import lk.ijse.posbackend.data.OrderDTO;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/order", initParams = {
        @WebInitParam(name = "driver-class", value = "com.mysql.cj.jdbc.Drive"),
        @WebInitParam(name = "dbURL", value = "jdbc:mysql://localhost:3306/TechNexus"),
        @WebInitParam(name = "dbUserName", value = "root"),
        @WebInitParam(name = "dbPassword", value = "1234")
},loadOnStartup = 1)
public class OrderController extends HttpServlet {
    ItemBo itemBo=new ItemBoImpl();
    Connection connection;
    OrderBo dataProcess = new OrderBoImpl();
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
        OrderDTO order;
        try {
            Jsonb jsonb = JsonbBuilder.create();
            System.out.println("aaaaaaaaaaaa");
            order = jsonb.fromJson(requestBody.toString(), OrderDTO.class);
            System.out.println("Parsed OrderDTO: " +order);
            System.out.println("bbbbbbbbbbbbb");

        } catch (Exception e) {
            //resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid JSON");
            e.printStackTrace();
            return;
        }

        // Process data and send response
        String saveItem = dataProcess.saveOrder(order, connection);
        System.out.println("after save "+saveItem);
        PrintWriter writer = resp.getWriter();

        if ("Saved".equals(saveItem)) {
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
        super.doPatch(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
