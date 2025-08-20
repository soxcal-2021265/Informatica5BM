<%-- 
    Document   : Index
    Created on : 20 ago 2025, 07:43:10
    Author     : informatica
--%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menú de Zapatos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="Styles/style.css">
</head>
<body>

<div class="menu-container">
    <div class="card">
        <div id="carouselExample" class="carousel slide">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="Images/zapatos.jpeg" class="d-block w-100" alt="Imagen de Zapatos 1">
                </div>
                <div class="carousel-item">
                    <img src="Images/zapatos2.jpeg" class="d-block w-100" alt="Imagen de Zapatos 2">
                </div>
                <div class="carousel-item">
                    <img src="Images/zapatos3.jpeg" class="d-block w-100" alt="Imagen de Zapatos 3">
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>

        <div class="card-body">
            <h5 class="card-title">Gestión de Zapatos</h5>
            <p class="card-text">Administra la información de todos los zapatos disponibles en la tienda.</p>
            <a class="btn btn-primary" href="Controlador?menu=Zapatos&accion=Listar" target="myFrame">Ir a Zapatos</a>
        </div>
    </div>

    <div class="card">
        <div id="carouselClientes" class="carousel slide">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="Images/cliente1.jpg" class="d-block w-100" alt="Imagen de Clientes 1">
                </div>
                <div class="carousel-item">
                    <img src="Images/cliente2.jpg" class="d-block w-100" alt="Imagen de Clientes 2">
                </div>
                <div class="carousel-item">
                    <img src="Images/cliente3.jpg" class="d-block w-100" alt="Imagen de Clientes 3">
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselClientes" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselClientes" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
        <div class="card-body">
            <h5 class="card-title">Gestión de Clientes</h5>
            <p class="card-text">Administra la información de los clientes registrados y sus compras.</p>
            <a class="btn btn-primary" href="Controlador?menu=Clientes&accion=Listar" target="myFrame">Ir a Clientes</a>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>