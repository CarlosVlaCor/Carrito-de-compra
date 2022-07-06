<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrito de compra</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    </head>
    <body class="bg-light d-flex flex-column min-vh-100">
        <jsp:include page="/WEB-INF/paginas/sinLogin/headerSinLogin.jsp"/>
        <div class="container mt-4">
            <div class="card">
                <div class="card-header">
                    <h3>Login</h3>
                </div>
            <form class="was-validated p-4" action="${pageContext.request.contextPath}/login" method="POST">
                <c:if test="${param.error != null}">
                    <div class="bg-danger text-white  rounded">
                        <h5 class="py-2 px-2 ">Verifique el email o la contraseña</h5>
                    </div>
                </c:if>
                <div class="form-group">
                    <label for="email">Email: </label>
                    <input type="email" placeholder="Coloca tu email" class="form-control" name="email" required/>
                </div>
                <div class="form-group">
                    <label for="password">Contraseña </label>
                    <input type="password" placeholder="Coloca tu Contraseña:" class="form-control" name="password" required/>
                </div>
                <button type="submit" class="btn btn-primary mt-2">Inicia sesión</button>
            </form>
             </div>
            <div>¿No tienes una cuenta? <a href="${pageContext.request.contextPath}/registro">¡Registrate!</a></div>
        </div>
            <jsp:include page="/WEB-INF/paginas/comunes/piePagina.jsp"/>
        <jsp:include page="/WEB-INF/paginas/comunes/scriptsBoostrap.jsp"/>
    </body>
</html>
