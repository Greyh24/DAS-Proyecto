<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Borrar Paciente</title>
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
                    <h3>Registro de Paciente</h3>
                    <form class="form" action="./Paciente" method="POST">
                        <div class="form-group">
                            <label  for="id" class="form-label">ID</label>
                            <input class="form-control" name="id" value="<%= request.getParameter("id") %>" type="text" placeholder="Ingrese ID" readonly="readonly"/>
                        </div>
                        <div class="form-group">
                            <label  for="nombre" class="form-label">Nombre</label>
                            <input class="form-control" name="nombre" value="<%= request.getParameter("nombre") %>" type="text" placeholder="Ingrese Nombre" disabled="disabled"/>
                        </div>
                        <div class="form-group">
                            <label  for="direccion" class="form-label">Direccion</label>
                            <input class="form-control" name="direccion" value="<%= request.getParameter("direccion") %>" type="text" placeholder="Ingrese Direccion" disabled="disabled"/>
                        </div>
                        <div class="form-group">
                            <label  for="telefono" class="form-label">Telefono</label>
                            <input class="form-control" name="telefono" value="<%= request.getParameter("direccion") %>" type="text" placeholder="Ingrese Telefono" disabled="disabled"/>
                        </div>
                        <div class="form-group">
                            <label  for="correo" class="form-label">Correo</label>
                            <input class="form-control" name="correo" type="text"  value="<%= request.getParameter("correo") %>"placeholder="Ingrese Correo" disabled="disabled"/>
                        </div>
                        <input type="hidden" value="B" name="accion" />
                        <br>
                        <p class="text-center red">ESTA ACCION ELIMINA EL REGISTRO,¿DESEA PROCEDER?</p>
                        <button type="submit" class="btn btn-success">SI, Borrar</button>
                    </form>
                        <a href="./Login"><button class="btn btn-warning">Cancelar</button></a>
                </div>
                <div class="md-4"></div>
            </div>
        </div>
    </body>
</html>
