package com.uwiener.das.javaweb;

import static com.uwiener.das.javaweb.BDConexion.initializeDatabases;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Doctor", urlPatterns = {"/Doctor"})
public class Doctor extends HttpServlet {

    
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    Connection cnx;
    String sTabla = "";
    try {
        cnx = initializeDatabases();
        PreparedStatement st = cnx.prepareStatement("SELECT Id_Medico, Nombre, Apellido, IdEspecialidad, Email, Telefono, Id_Turno, IdTUsuario FROM medico");
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            String idMedico = rs.getString("Id_Medico");
            String nombre = rs.getString("Nombre");
            String apellido = rs.getString("Apellido");
            String idEspecialidad = rs.getString("IdEspecialidad");
            String email = rs.getString("Email");
            String telefono = rs.getString("Telefono");
            String idTurno = rs.getString("Id_Turno");
            String idTUsuario = rs.getString("IdTUsuario");

            sTabla += "<tr>\n";
            sTabla += "<td>" + idMedico + "</td>\n";
            sTabla += "<td>" + nombre + "</td>\n";
            sTabla += "<td>" + apellido + "</td>\n";
            sTabla += "<td>" + idEspecialidad + "</td>\n";
            sTabla += "<td>" + email + "</td>\n";
            sTabla += "<td>" + telefono + "</td>\n";
            sTabla += "<td>" + idTurno + "</td>\n";
            sTabla += "<td>" + idTUsuario + "</td>\n";
            sTabla += "<td><a href=./Editardoctor.jsp><button class=\"glyphicon glyphicon-edit btn btn-warning\">Editar</a></button></td>\n";
            sTabla += "<td><a href=./Borrardoctor.jsp><button class=\"glyphicon glyphicon-hand-down btn btn-danger\">Borrar</a></button></td>\n";
            sTabla += "</tr>\n";
        }

        cnx.close();
    } catch (SQLException | ClassNotFoundException ex) {
        ex.toString();
    }

    String htmlResponse =  "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "<meta charset=\"utf-8\">\n" +
            "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n" +
            "<title>Lista de Doctores</title>\n" +
            "<meta name=\"description\" content=\"\">\n" +
            "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
            "<link rel=\"apple-touch-icon\" href=\"apple-touch-icon.png\">\n" +
            "<link rel=\"stylesheet\" href=\"webjars/bootstrap/5.2.2/css/bootstrap.css\">\n" +
            "<style>\n" +
            "p {\n" +
            "    text-align: center;\n" +
            "    color: white;\n" +
            "}\n" +
            "a, h3, th,td {\n" +
            "    text-decoration: none;\n" +
            "    color: white;\n" +
            "    font-weight: 600;\n" +
            "    text-align: center;\n" +
            "    color: white;\n" +
            "}\n" +
            ".col-md-6 {\n" +
            "    flex: auto;\n" +
            "}\n" +
            "</style>\n" +
            "</head>\n" +
            "<body class=\"img-responsive center-block\" background=\"img/bg4.jpg\">\n" +
            "<nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\n" +
            "<div class=\"container-fluid\">\n" +
            "<a class=\"navbar-brand\" href=\"Principal.html\">Home</a>\n" +
            "<button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarScroll\" aria-controls=\"navbarScroll\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
            "<span class=\"navbar-toggler-icon\"></span>\n" +
            "</button>\n" +
            "</div>\n" +
            "</nav>\n" +
            "<br><br>\n" +
            "<div class=\"container\">\n" +
            "<div class=\"row\">\n" +
            "<div class=\"col-md-6\">\n" +
            "<h3 class=\"text-success\">Listado de Doctores</h3>\n" +
            "<br>\n" +
            "<a href=\"nuevodoctor.jsp\"><button class=\"btn btn-success glyphicon glyphicon-new-window\">Nuevo Doctor</button></a>\n" +
            "<a href=\"index.html\"><button class=\"btn btn-success glyphicon glyphicon-new-window\">Menú</button></a>\n" +
            "<table class=\"table table\">\n" +
            "<tr>\n" +
            "<th>Id_Medico</th>\n" +
            "<th>Nombre</th>\n" +
            "<th>Apellido</th>\n" +
            "<th>IdEspecialidad</th>\n" +
            "<th>Email</th>\n" +
            "<th>Telefono</th>\n" +
            "<th>Id_Turno</th>\n" +
            "<th>IdTUsuario</th>\n" +
            "<th>Editar</th>\n" +
            "<th>Borrar</th>\n" +
            "</tr>\n" +
            sTabla +
            "</table>\n" +
            "</div>\n" +
            "</div>\n" +
            "</div>\n" +
            "</body>\n" +
            "</html>";

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println(htmlResponse);
}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection cnx;
        try{
            cnx = initializeDatabases();
            PreparedStatement st =null;
            if(request.getParameter("accion").equals("I"))
            {                           
                st = cnx.prepareStatement("insert into medico (Id_Medico, Nombre, Apellido, IdEspecialidad, Email, Telefono, Id_Turno, IdTUsuario) values (?,?,?,?,?,?,?,?)");
                st.setString(1,request.getParameter("id_Medico").toString());
                st.setString(2,request.getParameter("nombre").toString());
                st.setString(3,request.getParameter("apellido").toString());
                st.setString(4,request.getParameter("idespecialidad").toString());
                st.setString(5,request.getParameter("email").toString());
                st.setString(6,request.getParameter("telefono").toString());
                st.setString(7,request.getParameter("idhorario").toString());
                st.setString(8, request.getParameter("idTUsuario").toString());
                st.executeUpdate();
                    response.sendRedirect("./listadedoctores.html");
            }else if(request.getParameter("accion").equals("E"))
            {
                st = cnx.prepareStatement("update medico set  Nombre=?,Apellido=?,IdEspecialidad=?,Email=?,Telefono=?,Id_Turno=?,IdTUsuario=?  where Id_Medico=?");
                st.setString(1,request.getParameter("nombre").toString());
                st.setString(2,request.getParameter("apellido").toString());
                st.setString(3,request.getParameter("idespecialidad").toString());
                st.setString(4,request.getParameter("email").toString());
                st.setString(5,request.getParameter("telefono").toString());
                st.setString(6,request.getParameter("idhorario").toString());
                st.setString(7,request.getParameter("idTUsuario").toString());
                st.setString(8,request.getParameter("id_Medico"));
                st.executeUpdate();
                response.sendRedirect("./Doctor");
            }else if(request.getParameter("accion").equals("B")){
                st = cnx.prepareStatement("delete from medico where Id_Medico=?");                
                st.setString(1,request.getParameter("id_Medico"));
                st.executeUpdate();
                response.sendRedirect("./Doctor");
            }
           
        }catch(SQLException | ClassNotFoundException ex){
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(ex.toString()+" - "+request.getParameter("nombre")+
                    " - "+request.getParameter("apellido")+
                    " - "+request.getParameter("idespecialidad")+" - "
                    +request.getParameter("email")+" - "
                    +request.getParameter("telefono")+" - "
                    +request.getParameter("idhorario")+" - "
                    +request.getParameter("idTUsuario")+" - "
                    +request.getParameter("id_Medico")); 
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
