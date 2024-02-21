package by.yudzin.controller;

import by.yudzin.model.entity.User;
import by.yudzin.service.LoginService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(
            HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String body = req.getReader().lines().collect(Collectors.joining());

        String[] loginParameters = body.split("&");
        String login = loginParameters[0].substring(loginParameters[0].indexOf("=") + 1);
        String password = loginParameters[1].substring(loginParameters[1].indexOf("=") + 1);

        LoginService loginService = new LoginService();

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");

        if (loginService.checkCredentials(login, password)) {
            HttpSession httpSession = req.getSession();

            User user = new User(login, password);
            httpSession.setAttribute("user", user);

            out.println("Hello user " + login);
        } else {
            out.println("User not found");
        }

        out.println("</body>");
        out.println("</html>");

    }
}