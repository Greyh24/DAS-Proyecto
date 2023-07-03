<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Editar registros de Pacientes</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">
        <link rel="stylesheet" href="webjars/bootstrap/5.2.2/css/bootstrap.css">
         <style>
            p{
                text-align: center;
                
                
            }
            
            .col-md-6 {
            flex: auto;
      
            }
            .container{
                background: snow;
                opacity: inherit;
                border-color: #1a2537;
                border-radius: 10px;
                margin-left: 50%;
                max-width: 800px;
                margin: auto; 
                width: 30vw;
                height: 100%;
                
            }
           
            
            h3,th{
            padding-top: 15px;
            font-size: 40px;
            text-align: center;
            margin-bottom: 20px;
            color: #46A2FD;
            }
            a{
                padding: 0;
                margin: 0;
                font-size: 14px;
            }
             .btn-success{
                margin-bottom: 15px;
                background-color: #1a2537;
                color: #fff;
                padding: 10px 25px;
                margin-left: 45%;
                border-radius: 5px;
                transition: background-color 0.3s;
    } .btnn{
                margin-bottom: 15px;
                background-color: #1a2537;
                color: #fff;
                padding: 10px 20px;
                margin-left: 46%;
                border-radius: 5px;
                transition: background-color 0.3s;

    .btnn:hover {
        background-color: #fff;
         color: #1a2537;
        </style>
    </head>
    <body class="img-responsive center-block" background="img/bg4.jpg">     
         <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
              <a class="navbar-brand" href="Principal.html">Home</a>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
            </div>
        </nav>
        <br><br>
            <div class="container">
            <div class="row">
                <div class="md-4"></div>
                <div class="md-4 center-block">
                    <h3>Editar registros de Pacientes</h3>
                    <form class="form" action="./Paciente" method="POST">
                        <div class="form-group">
                            <label  for="idPaciente" class="form-label">IdPaciente</label>
                            <input class="form-control" name="idPaciente" type="text" placeholder="Ingrese idPaciente"/>
                        </div><br>
                        <div class="form-group">
                            <label  for="nombre" class="form-label">Nombre</label>
                            <input class="form-control" name="nombre" type="text" placeholder="Ingrese Nombre"/>
                        </div><br>
                         <div class="form-group">
                            <label  for="apellido" class="form-label">Apellido</label>
                            <input class="form-control" name="apellido" type="text" placeholder="Ingrese Apellido"/>
                        </div><br>
                        <div class="form-group">
                            <label  for="email" class="form-label">Email</label>
                            <input class="form-control" name="email" type="text" placeholder="Ingrese email"/>
                        </div><br>
                        <div class="form-group">
                            <label  for="telefono" class="form-label">Telefono</label>
                            <input class="form-control" name="telefono" type="number" placeholder="Ingrese Telefono"/>
                        </div><br>
                        <div class="form-group">
                            <label  for="fechadeNacimiento" class="form-label">Fecha de Nacimiento</label>
                            <input class="form-control" name="fechadeNacimiento" type="date" placeholder="Ingrese Fecha de Nacimiento"/>
                        </div><br>
                        <div class="form-group">
                            <label  for="idTUsuario" class="form-label">IdTUsuario</label>
                            <select class="form-control" style="width: 250px" name="idTUsuario"> 
                                <option value="-1">Selecciona un turno</option>
                                <% 
                                    try
                                    {
                                        String Query = "SELECT * FROM tipousuario";
                                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_s","root", "");
                                        Statement stm = conn.createStatement();
                                        ResultSet rs = stm.executeQuery(Query);
                                        while(rs.next())
                                        {  
                                            %>
                                                <option value="<%=rs.getInt("id")%>"><%=rs.getString("Tipo")%></option>

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
                        </div><br>
                        <input type="hidden" value="E" name="accion" />
                        <br>
                        <button type="submit" class="btn btn-success">Editar</button><br>
                    </form>
                        <a href="./Paciente"><button  class="btnn">Cancelar</button></a>
                </div>
                <div class="md-4"></div>
            </div>
        </div><br><br><br>
    </body>
</html>
