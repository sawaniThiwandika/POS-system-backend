package lk.ijse.posbackend.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.posbackend.bo.ItemBo;
import lk.ijse.posbackend.bo.ItemBoImpl;

import java.io.IOException;

@WebServlet(urlPatterns = "/item", initParams = {
        @WebInitParam(name = "driver-class", value = "com.mysql.cj.jdbc.Drive"),
        @WebInitParam(name = "dbURL", value = "jdbc:mysql://localhost:3306/TechNexus"),
        @WebInitParam(name = "dbUserName", value = "root"),
        @WebInitParam(name = "dbPassword", value = "1234")
},loadOnStartup = 1)
public class ItemController extends HttpServlet {
    ItemBo itemBo=new ItemBoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }

    @Override
    protected void doPatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPatch(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
