<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Editar Doctor</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">
        <link rel="stylesheet" href="webjars/bootstrap/5.2.2/css/bootstrap.css">
    </head>
    <body>        
        <div class="container">
            <div class="row">
                <div class="md-4"></div>
                <div class="md-4">
                    <h3>Registro de Doctor</h3>
                    <form class="form" action="./Doctor" method="POST">
                        <div class="form-group">
                            <label  for="iddoctor" class="form-label">ID</label>
                            <input class="form-control" value="<%= request.getParameter("iddoctor") %>"  name="iddoctor" readonly="readonly" type="text" placeholder="Ingrese ID"/>
                        </div>
                        <div class="form-group">
                            <label  for="nombre" class="form-label">Nombre</label>
                            <input class="form-control"  name="nombre" value="<%= request.getParameter("nombre") %>" type="text" placeholder="Ingrese Nombre"/>
                        </div>
                        <div class="form-group">
                            <label  for="idespecialidad" class="form-label">Especialidad</label>
                            <select class="form-control" style="width: 250px" name="idespecialidad"> 
                                <option value="-1">Selecciona una especialidad</option>
                                <% 
                                    try
                                    {
                                        String Query = "SELECT * FROM tbespecialidad";
                                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_das","root", "");
                                        Statement stm = conn.createStatement();
                                        ResultSet rs = stm.executeQuery(Query);
                                        while(rs.next())
                                        {  
                                            %>
                                            <option value="<%=rs.getInt("ID")%>" <% if(rs.getString("ID").equals((request.getParameter("idespecialidad")))){out.println("SELECTED");} %> > <%=rs.getString("Nombre")%></option>

                                            <%
                                        }
                                    }
                                    catch(Exception ex)
                                    {
                                        ex.printStackTrace();
                                        out.println("Error: "+ex.getMessage());
                                    }
                                %>  
                            </select> 
                        </div>
                        <div class="form-group">
                            <label  for="idhorario" class="form-label">Turno</label>
                            <select class="form-control" style="width: 250px" name="idhorario"> 
                                <option value="-1">Selecciona un turno</option>
                                <% 
                                    try
                                    {
                                        String Query = "SELECT * FROM tbturno";
                                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_das","root", "");
                                        Statement stm = conn.createStatement();
                                        ResultSet rs = stm.executeQuery(Query);
                                        while(rs.next())
                                        {  
                                            %>
                                                <option value="<%=rs.getInt("ID")%>" <% if(rs.getString("ID").equals((request.getParameter("idhorario")))){out.println("SELECTED");} %> ><%=rs.getString("Nombre")%></option>

                                            <%
                                        }
                                    }
                                    catch(Exception ex)
                                    {
                                        ex.printStackTrace();
                                        out.println("Error: "+ex.getMessage());
                                    }
                                %>  
                            </select> 
                        </div>
                        <div class="form-group">
                            <label  for="telefono" class="form-label">Telefono</label>
                            <input class="form-control" name="telefono" value="<%= request.getParameter("telefono") %>" type="text" placeholder="Ingrese Telefono"/>
                        </div>
                        <input type="hidden" value="E" name="accion" />
                        <br>
                        <button type="submit" class="btn btn-success">Actualizar</button>
                    </form>
                        <a href="./Login"><button class="btn btn-success">Cancelar</button></a>
                </div>
                <div class="md-4"></div>
            </div>
        </div>
    </body>
</html>
