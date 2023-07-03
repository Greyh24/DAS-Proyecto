package com.uwiener.das.javaweb;
import static com.uwiener.das.javaweb.BDConexion.*;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "Log", urlPatterns = {"/Log"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        String user = request.getParameter("textuser");
        String Pass = request.getParameter("textPass");
            try {
            Connection connection = BDConexion.initializeDatabases();
            
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM usuario WHERE Usuario = ? AND Password = ?");
            statement.setString(1, user);
            statement.setString(2, Pass);
            
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                // Credenciales válidas, el usuario ha iniciado sesión correctamente
                // Redirigir a una página de inicio o mostrar contenido adicional
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                response.sendRedirect("index.html");                
            } else {
                // Credenciales incorrectas, redirigir nuevamente a la página de inicio de sesión o mostrar mensaje de error
                response.sendRedirect("Principal.html");
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();                
            }
            
            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            // Manejar la excepción de conexión o consulta SQL
            // Redirigir a una página de error o mostrar un mensaje de error adecuado
            response.sendRedirect("error.html");
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
