<header class="bg-dark text-white py-2">
    <div class="container ">
        <div class="row ">
            <div class="col-md-9">
                <h1>MISAN</h1> 
            </div>
            <div class="dropdown pt-2">
                <button type="button" class="btn btn-dark dropdown-toggle" data-toggle="dropdown">
                    ${usuario.nombre}
                </button>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Cerrar sesi�n</a>
                </div>
            </div>
        </div>

    </div>

</header>