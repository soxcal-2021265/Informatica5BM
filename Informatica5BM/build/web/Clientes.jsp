<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="Styles/style.css" />
        <title>Gestión de Clientes</title>
    </head>

    <body>

        <main class="crud-main">
            <section class="top-container">
                <div class="formulario">
                    <h2>Agregar / Modificar Cliente</h2>
                    <form action="Controlador?menu=Clientes" method="POST">
                        
                        <input type="hidden" value="${cliente.getCodigoCliente()}" name="txtCodigoCliente" />
                        
                        <label for="codigoZapato">Código Zapato</label>
                        <input type="text" value="${cliente.getCodigoZapato()}" name="txtCodigoZapato" required />
                        
                        <label for="nombreCliente">Nombre</label>
                        <input type="text" value="${cliente.getNombre()}" name="txtNombre" required />
                        
                        <label for="telefonoCliente">Teléfono</label>
                        <input type="text" value="${cliente.getTelefono()}" name="txtTelefono" required />
                        
                        <label for="correoCliente">Correo</label>
                        <input type="text" value="${cliente.getCorreo()}" name="txtCorreo" required />
                        
                        <label for="direccionCliente">Dirección</label>
                        <input type="text" value="${cliente.getDireccion()}" name="txtDireccion" required />

                        <div class="btn-group">
                            <button name="accion" value="Agregar" class="btn btn-primary btn-block">Agregar</button>
                            <button name="accion" value="Actualizar" class="btn btn-primary btn-block">Actualizar</button>
                        </div>
                    </form>
                </div>

                <div class="tabla-registros">
                    <h2>Clientes Registrados</h2>
                    <table>
                        <thead>
                            <tr>
                                <th>Código Cliente</th>
                                <th>Código Zapato</th>
                                <th>Nombre</th>
                                <th>Teléfono</th>
                                <th>Correo</th>
                                <th>Dirección</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="cliente" items="${clientes}">
                                <tr>
                                    <td>${cliente.getCodigoCliente()}</td>
                                    <td>${cliente.getCodigoZapato()}</td>
                                    <td>${cliente.getNombre()}</td>
                                    <td>${cliente.getTelefono()}</td>
                                    <td>${cliente.getCorreo()}</td>
                                    <td>${cliente.getDireccion()}</td>
                                    <td>
                                        <a name="accion" value="Buscar" href="Controlador?menu=Clientes&accion=Editar&codigoCliente=${cliente.getCodigoCliente()}" class="btn btn-actualizar">Editar</a>
                                        <a name="accion" value="Buscar" href="Controlador?menu=Clientes&accion=Eliminar&codigoCliente=${cliente.getCodigoCliente()}" class="btn btn-eliminar">Eliminar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </section>
        </main>

    </body>

</html>