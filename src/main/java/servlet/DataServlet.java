package servlet;

import DAOs.DataDAO;
import Services.AppService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DataServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //send POST with body containing string, integer and bool
        String s = req.getParameter("string");
        Integer i = Integer.parseInt(req.getParameter("integer"));
        boolean b = Boolean.parseBoolean(req.getParameter("bool"));

        DataDAO data = new DataDAO(s, i, b);

        AppService.setData(data);

        resp.setStatus(202);
        resp.getWriter().print("Data accepted.");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataDAO data = AppService.getData();

        String s = data.getString();
        Integer i = data.getInteger();
        boolean b = data.isBool();

        resp.setStatus(202);
        resp.getWriter().print("Data: " + s + ", " + i.toString() + ", " + b);
    }
}
