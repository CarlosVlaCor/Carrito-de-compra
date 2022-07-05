<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
          <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    </head>
    <body>
        <jsp:include page="/WEB-INF/paginas/sinLogin/headerSinLogin.jsp"/>
        <div class="container mt-4">
            <div class="card">
                <div class="card-header">
                    <h3>Registro</h3>
                </div>
        <form class="was-validated p-4" action="${pageContext.request.contextPath}/registro" method="POST">
            <div class="form-group" >
            <label for="nombre">Nombre: </label>
            <input type="text" placeholder="Coloca tu nombre" class="form-control" name="nombre" required/>
            </div>
            <div class="form-group">
            <label for="apellido">Apellido: </label>
            <input type="text" placeholder="Coloca tu apellido" class="form-control" name="apellido" required/>
            </div>
            <div class="form-group">
            <label for="email">Email: </label>
            <input type="email" placeholder="Coloca tu email" class="form-control" name="email" required/>
            </div>
            <div class="form-group">
            <label for="password">Contraseña </label>
            <input type="password" placeholder="Coloca tu Contraseña:" class="form-control" name="password" required/>
            </div>
            <button type="submit" class="btn btn-primary mt-2">Registrarte</button>
        </form>
            </div>
        <div>¿Ya tienes una cuenta? <a href="${pageContext.request.contextPath}/login"/>inicia sesión aquí</a></div>
        </div>
        <jsp:include page="/WEB-INF/paginas/comunes/piePagina.jsp"/>
        <jsp:include page="/WEB-INF/paginas/comunes/scriptsBoostrap.jsp"/>
    </body>
</html>
