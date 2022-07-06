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
                </tr>
            </thead>
            <tbody>
                <c:forEach var="producto" items="${productos}" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${producto.nombre}</td>
                        <td><fmt:formatNumber value="${producto.costo}" type="currency"></fmt:formatNumber></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
