<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>
<div class="container mt-4">
    <div class="card">
        <div class="card-header">
            <h4>Productos</h4>
        </div>
        <table class="table">
            <thead class="table-dark text-white">
                <tr>
                    <th>#</th>
                    <th>Nombre</th>
                    <th>Precio</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="producto" items="${productos}" varStatus="status">
                <div class="modal fade" id="agregarAlCarro${producto.nombre}">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5>${producto.nombre}</h5>
                                <button type="button" class="close" data-dismiss="modal"/>&times;</button>
                            </div>
                            <div class="modal-body">
                                <form class="was-validated" action="${pageContext.request.contextPath}/producto?accion=insertar" method="POST">
                                    <div class="form-group">
                                        <label for="stock">Cantidad: </label>
                                        <input type="number" class="form-control" name="cantidad" required/>
                                    </div>

                                    <button type="submit" class="btn btn-primary mt-2">Agregar</button>
                                </form>
                            </div>
                        </div>

                    </div>
                </div>
                <tr>
                    <td>${status.count}</td>
                    <td>${producto.nombre}</td>
                    <td><fmt:formatNumber value="${producto.costo}" type="currency"></fmt:formatNumber></td>
                        <td>
                            <div class="container">
                                <a class="btn btn-success" data-toggle="modal" data-target="#agregarAlCarro${producto.nombre}">
                                    <i class="fa-solid fa-plus"></i> Agregar al carrito
                                </a>
                            </div>

                        </td>
                    </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
