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

@WebServlet(name = "CitaMedica", urlPatterns = {"/CitaMedica"})
public class CitaMedica extends HttpServlet {

    
    @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    Connection cnx;
    String sTabla = "";
    try {
        cnx = initializeDatabases();
        PreparedStatement st = cnx.prepareStatement("SELECT Id_Cita, Id_Paciente, Id_Medico, Fecha, Hora, Motivo, Ubicacion FROM cita_medica");
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            String idCita = rs.getString("Id_Cita");
            String idPaciente = rs.getString("Id_Paciente");
            String idMedico = rs.getString("Id_Medico");
            String fecha = rs.getString("Fecha");
            String hora = rs.getString("Hora");
            String motivo = rs.getString("Motivo");
            String ubicacion = rs.getString("Ubicacion");

            sTabla += "<tr>\n";
            sTabla += "<td>" + idCita + "</td>\n";
            sTabla += "<td>" + idPaciente + "</td>\n";
            sTabla += "<td>" + idMedico + "</td>\n";
            sTabla += "<td>" + fecha + "</td>\n";
            sTabla += "<td>" + hora + "</td>\n";
            sTabla += "<td>" + motivo + "</td>\n";
            sTabla += "<td>" + ubicacion + "</td>\n";
            sTabla += "<td><a href=./EditarCitaMedica.jsp><button class=\"glyphicon glyphicon-edit btn btn-warning\">Editar</button></a></td>\n";
            sTabla += "<td><a href=./BorrarCitaMedica.jsp><button class=\"glyphicon glyphicon-hand-down btn btn-danger\">Borrar</button></a></td>\n";
            sTabla += "</tr>\n";
        }
        cnx.close();
    } catch (SQLException | ClassNotFoundException ex) {
        ex.toString();
    }

    String htmlResponse = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "<meta charset=\"utf-8\">\n" +
            "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n" +
            "<title>Lista de Citas Medicas</title>\n" +
            "<meta name=\"description\" content=\"\">\n" +
            "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
            "<link rel=\"apple-touch-icon\" href=\"apple-touch-icon.png\">\n" +
            "<link rel=\"stylesheet\" href=\"webjars/bootstrap/5.2.2/css/bootstrap.css\">\n" +
            "<style>\n" +
            "p , td{\n" +
            "    text-align: center;\n" +
            "    color: white;\n" +
            "}\n" +
            "a, h3, th {\n" +
            "    text-decoration: none;\n" +
            "    color: #1a2537;\n" +
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
            "<div class=\"col-md-3\"></div>\n" +
            "<div class=\"col-md-6\">\n" +
            "<h3 class=\"text-success\">Listado de Citas Médicas</h3>\n" +
            "<br>\n" +
            "<a href=\"newCitaMedica.jsp\"><button class=\"btn btn-success glyphicon glyphicon-new-window\">Nueva Cita Médica</button></a>\n" +
            "<a href=\"index.html\"><button class=\"btn btn-success glyphicon glyphicon-new-window\">Menú</button></a>\n" +
            "<table class=\"table table\">\n" +
            "<tr>\n" +
            "<th>IdCita</th>\n" +
            "<th>IdPaciente</th>\n" +
            "<th>IdMedico</th>\n" +
            "<th>Fecha</th>\n" +
            "<th>Hora</th>\n" +
            "<th>Motivo</th>\n" +
            "<th>Ubicación</th>\n" +
            "<th>Editar</th>\n" +
            "<th>Borrar</th>\n" +
            "</tr>\n" +
            sTabla +
            "</table>\n" +
            "</div>\n" +
            "<div class=\"col-md-3\"></div>\n" +
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
                st = cnx.prepareStatement("insert into cita_medica (Id_Cita,Id_Paciente,Id_Medico,Fecha, Hora, Motivo, Ubicacion) values(?,?,?,?,?,?,?)");
                  st.setString(1,request.getParameter("id_Cita").toString());
                  st.setString(2,request.getParameter("idPaciente").toString());
                  st.setString(3,request.getParameter("idMedico").toString());
                  st.setString(4,request.getParameter("fecha").toString());
                  st.setString(5,request.getParameter("hora").toString());
                  st.setString(6,request.getParameter("motivo").toString());
                  st.setString(7,request.getParameter("ubicacion").toString());
                st.executeUpdate();
                response.sendRedirect("./CitaMedica");
            }else if(request.getParameter("accion").equals("E"))
            {
                st = cnx.prepareStatement("update cita_medica set Id_Paciente=?,Id_Medico=?,Fecha=?,Hora=?,Motivo=?,Ubicacion=? where id_Cita=?");
                st.setString(1,request.getParameter("idPaciente").toString());
                st.setString(2,request.getParameter("idMedico").toString());
                st.setString(3,request.getParameter("fecha").toString());
                st.setString(4,request.getParameter("hora").toString());
                st.setString(5,request.getParameter("motivo").toString());
                st.setString(6,request.getParameter("ubicacion").toString());
                st.setString(7,request.getParameter("id_Cita"));
                st.executeUpdate();
                response.sendRedirect("./CitaMedica");
            }else if(request.getParameter("accion").equals("B")){
                st = cnx.prepareStatement("delete from cita_medica where Id_Cita=?");                
                st.setString(1,request.getParameter("id_Cita"));
                st.executeUpdate();
                response.sendRedirect("./CitaMedica");
            }
           
        }catch(SQLException | ClassNotFoundException ex){
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(ex.toString()+" - "+request.getParameter("idPaciente")+
                    " - "+request.getParameter("idMedico")+
                    " - "+request.getParameter("fecha")+
                    " - "+request.getParameter("hora")+
                    " - "+request.getParameter("motivo")+" - "
                    +request.getParameter("ubicacion")+" - "
                    +request.getParameter("id_Cita")); 
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
