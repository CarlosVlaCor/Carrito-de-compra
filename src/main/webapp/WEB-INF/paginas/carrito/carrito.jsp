<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/2c301b3f37.js" crossorigin="anonymous"></script>
        <title>Carrito de Compra</title>
    </head>
    <body class="bg-light d-flex flex-column min-vh-100">
        <jsp:include page="/WEB-INF/paginas/cliente/headerCliente.jsp"/>
        <jsp:include page="/WEB-INF/paginas/carrito/listaCarrito.jsp"/>
        <jsp:include page="/WEB-INF/paginas/comunes/piePagina.jsp"/>
        <jsp:include page="/WEB-INF/paginas/comunes/scriptsBoostrap.jsp"/>
    </body>
</html>
