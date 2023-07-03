<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Registrar Cita Medica</title>
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
                    <h3>Registro de Citas Medicas</h3>
                    <form class="form" action="./CitaMedica" method="POST">
                        <div class="form-group">
                            <label for="id_Cita" class="form-label">IdCita</label>
                            <input class="form-control" name="id_Cita" type="text" placeholder="Ingrese IdCita">
                        </div><br>
                        <div class="form-group">
                            <label  for="idPaciente" class="form-label">IdPaciente</label>
                             <input class="form-control" name="idPaciente" type="text" placeholder="Ingrese IdPaciente">                                                
                        </div><br>
                        <div class="form-group">
                            <label  for="idMedico" class="form-label">IdMedico</label>
                             <input class="form-control" name="idMedico" type="text" placeholder="Ingrese IdMedico">                                                                         
                        </div><br>
                        <div class="form-group">
                            <label for="fecha" class="form-label">Fecha</label>
                            <input class="form-control" name="fecha" type="date" placeholder="Ingrese la Fecha">
                        </div><div class="form-group">
                            <label for="hora" class="form-label">Hora</label>
                            <input class="form-control" name="hora" type="time" placeholder="Ingrese Hora">
                        </div><br>
                         <div class="form-group">
                            <label for="motivo" class="form-label">Motivo</label>
                            <input class="form-control" name="motivo" type="text" placeholder="Ingrese Motivo">
                        </div><br>
                        <div class="form-group">
                            <label for="ubicacion" class="form-label">Ubicación</label>
                            <input class="form-control" name="ubicacion" type="text" placeholder="Ingrese Ubicación">
                        </div><br>                       
                        <input type="hidden" value="I" name="accion">
                        <br>
                        <button type="submit" class="btn btn-success">Registrar</button><br>
                    </form>
                        <a href="./CitaMedica"><button  class="btnn">Cancelar</button></a>
                </div>
                <div class="md-4"></div>
            </div>
        </div><br><br><br>
    </body>
</html>
