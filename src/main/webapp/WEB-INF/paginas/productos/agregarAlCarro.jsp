<div class="modal fade" id="agregarAlCarro">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5>Agregar al carrito</h5>
                <button type="button" class="close" data-dismiss="modal"/>&times;</button>
            </div>
            <div class="modal-body">
                <p>${producto.nombre}</p>
                <form class="was-validated p-4" action="${pageContext.request.contextPath}/carrito?idProductoaccion=insertar" method="POST">
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