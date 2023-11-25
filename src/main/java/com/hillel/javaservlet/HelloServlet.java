package com.hillel.javaservlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //        1. Set Content type
        response.setContentType("text/html");

//        2. Get PrintWriter
        PrintWriter printWriter = response.getWriter();

//        3. Prepare content
        StringBuilder builder = new StringBuilder();
        builder.append("<html><body>" +
                "<h2>" +
                message +
                "</h2>" +
                "<hr>" +
                "Current Date Time: " + new java.util.Date() +
                "</body></html>"
        );

//        4. Generate Dynamic Content
        printWriter.println(builder);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("param1 : " + request.getParameter("param1"));
        System.out.println("param2 : " + request.getParameter("param2"));
    }
//    POST example:
//    http://localhost:8080/JavaServlet/hello-servlet?param1=test1&param2=test2

    public void destroy() {
    }
}