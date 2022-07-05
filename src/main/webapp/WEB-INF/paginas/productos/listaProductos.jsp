<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>
<div class="container mt-4">
    <a class="btn btn-primary" data-toggle="modal" data-target="#agregarProducto">
        <i class="fa-solid fa-plus"></i> Agregar producto
    </a>
</div>
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
                    <th>En almacen</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="producto" items="${productos}" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${producto.nombre}</td>
                        <td><fmt:formatNumber value="${producto.costo}" type="currency"></fmt:formatNumber></td>
                        <td>${producto.stock}</td>
                        <td>
                            <div class="container">
                                <a class="btn btn-primary" href="${pageContext.request.contextPath}/producto?idProducto=${producto.idProducto}">
                                 <i class="fa-solid fa-file-pen"></i>
                                </a>
                                
                                <a class="btn btn-danger">
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

<jsp:include page="/WEB-INF/paginas/productos/agregarProducto.jsp"/>
