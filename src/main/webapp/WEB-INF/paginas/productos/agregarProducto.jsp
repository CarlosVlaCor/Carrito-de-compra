<div class="modal fade" id="agregarProducto">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5>Nuevo producto</h5>
                <button type="button" class="close" data-dismiss="modal"/>&times;</button>
            </div>
            <div class="modal-body">
                <form class="was-validated p-4" action="${pageContext.request.contextPath}/producto?accion=insertar" method="POST">
                    <div class="form-group" >
                        <label for="nombre">Nombre: </label>
                        <input type="text" placeholder="Coloca el nombre del producto" class="form-control" name="nombre" required step="any"/>
                    </div>
                    <div class="form-group">
                        <label for="precio">Precio $: </label>
                        <input type="number" placeholder="Coloca el precio" class="form-control" name="costo" required step="any" />
                    </div>
                    <div class="form-group">
                        <label for="stock">Stock: </label>
                        <input type="number" placeholder="Coloca el stock" class="form-control" name="stock" required/>
                    </div>
                    
                    <button type="submit" class="btn btn-primary mt-2">Agregar</button>
                </form>
            </div>
        </div>

    </div>
</div>

