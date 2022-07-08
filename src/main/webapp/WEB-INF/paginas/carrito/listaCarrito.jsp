<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>
<div class="container mt-4">
    <div class="row">
        <div class="col-md-9">
            <div class="card">
                <div class="card-header">
                    <h4>Carrito</h4>
                </div>
                <table class="table">
                    <thead class="table-dark text-white">
                        <tr>
                            <th>#</th>
                            <th>Nombre</th>
                            <th>Precio</th>
                            <th>Fecha de compra</th>
                            <th>cantidad</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="usuarioProducto" items="${usuarioProductos}" varStatus="status">
                        <div class="modal fade" id="modificarDelCarrito${usuarioProducto.producto.nombre}">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5>${usuarioProducto.producto.nombre}</h5>
                                        <button type="button" class="close" data-dismiss="modal"/>&times;</button>
                                    </div>
                                    <div class="modal-body">
                                        <form class="was-validated" action="${pageContext.request.contextPath}/carrito?idUsuarioProducto=${usuarioProducto.id}&accion=modificar" method="POST">

                                            <div class="form-group">
                                                <label for="stock">Cantidad: </label>
                                                <input type="number" class="form-control" name="cantidad" value="${usuarioProducto.cantidad}" required/>
                                            </div>

                                            <button type="submit" class="btn btn-primary mt-2">Editar producto</button>
                                        </form>
                                    </div>
                                </div>

                            </div>
                        </div>

                        <tr>
                            <td>${status.count}</td>
                            <td>${usuarioProducto.producto.nombre}</td>
                            <td><fmt:formatNumber value="${usuarioProducto.producto.costo}" type="currency"></fmt:formatNumber></td>
                            <td>${usuarioProducto.fecha}</td>
                            <td>${usuarioProducto.cantidad}</td>
                            <td>
                                <div class="container">
                                    <a class="btn btn-primary" data-toggle="modal" data-target="#modificarDelCarrito${usuarioProducto.producto.nombre}">
                                        <i class="fa-solid fa-file-pen"></i>
                                    </a>
                                    <a class="btn btn-danger" href="${pageContext.request.contextPath}/carrito?idUsuarioProducto=${usuarioProducto.id}&accion=eliminar">
                                        <i class="fa-solid fa-trash"></i>
                                    </a>
                                </div>

                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="col-md-3">
            <div class="card text-center bg-success text-white mb-3">
                <div class="card-body">
                    <h3>Total</h3>
                    <h4 class="display-4">
                        <i class="fa-solid fa-cart-shopping"></i>
                    </h4>
                    <h4><fmt:formatNumber value="${total}" type="currency"></fmt:formatNumber></h4>
                </div>
            </div>
        </div>
    </div>
</div>
