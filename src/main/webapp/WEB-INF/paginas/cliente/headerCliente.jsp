<header class="bg-dark text-white py-2">
    <div class="container ">
        <div class="row ">
            <%@include file="/WEB-INF/paginas/comunes/logo.jsp" %>
            <div class="mt-2">
                <a href="${pageContext.request.contextPath}/carrito"class="btn btn-dark" >
                    <i class="fa-solid fa-cart-shopping"></i> Carrito
                </a>
                
            </div>
            <div class="dropdown pt-2">
                <button type="button" class="btn btn-dark dropdown-toggle" data-toggle="dropdown">
                    ${usuario.nombre}
                </button>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Cerrar sesión</a>
                </div>
            </div>
        </div>

    </div>

</header>
