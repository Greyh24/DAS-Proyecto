package com.uwiener.das.javaweb;
import static com.uwiener.das.javaweb.BDConexion.*;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "RegistroServlet", urlPatterns = {"/registro"})
public class RegistroServlet1 extends HttpServlet {
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
    }

    @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection cnx = null;
        PreparedStatement st = null;
        try {
            cnx = initializeDatabases();
            String sql = "INSERT INTO usuario (Usuario, Nombre, Apellido, telefono, Password, Id_TUsuario, Fechanacimiento, Email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            st = cnx.prepareStatement(sql);

            st.setString(1, request.getParameter("txtuss"));
            st.setString(2, request.getParameter("txtnombre"));
            st.setString(3, request.getParameter("txtapellido"));
            st.setString(4, request.getParameter("txttelefono"));
            st.setString(5, request.getParameter("txtcontrasena"));
            st.setString(6, request.getParameter("txttusu"));
            st.setString(7, request.getParameter("txtfn"));
            st.setString(8, request.getParameter("txtcorreo"));

            int rowsAffected = st.executeUpdate();
            if (rowsAffected > 0) {
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println("<script>alert('Registro exitoso');</script>");
                response.sendRedirect("Principal_1.html");
            } else {
                // El registro no se insertó correctamente
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println("<script>alert('Hubo un error en el registro. Por favor, inténtalo de nuevo.');</script>");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace(); // Imprimir el stack trace completo en la consola
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('Ha ocurrido un error. Por favor, inténtalo de nuevo más tarde.');</script>");
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (cnx != null) {
                try {
                    cnx.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private Connection initializeDatabases() throws SQLException, ClassNotFoundException {
      
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/bd_s";
        String username = "root";
        String password = "";
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }
}
