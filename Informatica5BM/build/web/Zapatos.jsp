<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="Styles/style.css" />
        <title>Gestión de Zapatos</title>
    </head>

    <body>

        <main class="crud-main">
            <section class="top-container">
                <div class="formulario">
                    <h2>Agregar / Modificar Zapato</h2>
                    <form action="Controlador?menu=Zapatos" method="POST">
                        
                        <input type="hidden" value="${zapato.getCodigoZapato()}" name="txtCodigoZapato" />
                        
                        <label for="nombreZapato">Nombre</label>
                        <input type="text" value="${zapato.getNombre()}" name="txtNombre" required />

                        <label for="marcaZapato">Marca</label>
                        <input type="text" value="${zapato.getMarca()}" name="txtMarca" required />

                        <label for="tallaZapato">Talla</label>
                        <input type="text" value="${zapato.getTalla()}" name="txtTalla" required />

                        <label for="colorZapato">Color</label>
                        <input type="text" value="${zapato.getColor()}" name="txtColor" required />

                        <div class="btn-group">
                            <button name="accion" value="Agregar" class="btn btn-primary btn-block">Agregar</button>
                            <button name="accion" value="Actualizar" class="btn btn-primary btn-block">Actualizar</button>
                        </div>
                    </form>
                </div>

                <div class="tabla-registros">
                    <h2>Zapatos Registrados</h2>
                    <table>
                        <thead>
                            <tr>
                                <th>Código</th>
                                <th>Nombre</th>
                                <th>Marca</th>
                                <th>Talla</th>
                                <th>Color</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="zapato" items="${zapatos}">
                                <tr>
                                    <td>${zapato.getCodigoZapato()}</td>
                                    <td>${zapato.getNombre()}</td>
                                    <td>${zapato.getMarca()}</td>
                                    <td>${zapato.getTalla()}</td>
                                    <td>${zapato.getColor()}</td>
                                    <td>
                                        <a name="accion" value="Buscar" href="Controlador?menu=Zapatos&accion=Editar&codigoZapato=${zapato.getCodigoZapato()}" class="btn btn-actualizar">Editar</a>
                                        <a name="accion" value="Buscar" href="Controlador?menu=Zapatos&accion=Eliminar&codigoZapato=${zapato.getCodigoZapato()}" class="btn btn-eliminar">Eliminar</a>
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