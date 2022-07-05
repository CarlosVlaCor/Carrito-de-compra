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
    <body>
        <jsp:include page="/WEB-INF/paginas/personal/headerPersonal.jsp"/>
         <div class="container mt-4">
            <div class="card">
                <div class="card-header">
                    <h3>Modificar ${producto.nombre}</h3>
                </div>
        <form class="was-validated p-4" action="${pageContext.request.contextPath}/producto?idProducto=${producto.idProducto}&accion=editar" method="POST">
                    <div class="form-group" >
                        <label for="nombre">Nombre: </label>
                        <input type="text" placeholder="Coloca el nombre del producto" class="form-control" name="nombre" required value="${producto.nombre}"/>
                    </div>
                    <div class="form-group">
                        <label for="precio">Precio $: </label>
                        <input type="number" placeholder="Coloca el precio" class="form-control" name="costo" required step="any" value="${producto.costo}" />
                    </div>
                    <div class="form-group">
                        <label for="stock">Stock: </label>
                        <input type="number" placeholder="Coloca el stock" class="form-control" name="stock" required value="${producto.stock}"/>
                    </div>
                    
                    <button type="submit" class="btn btn-primary mt-2">Agregar</button>
                    
                    <a href="${pageContext.request.contextPath}/producto?idProducto=${producto.idProducto}&accion=eliminar" class="btn btn-danger mt-2">Eliminar producto</a>
                </form>
            </div>
       
        </div>
        <jsp:include page="/WEB-INF/paginas/comunes/piePagina.jsp"/>
        <jsp:include page="/WEB-INF/paginas/comunes/scriptsBoostrap.jsp"/>
    </body>
</html>
