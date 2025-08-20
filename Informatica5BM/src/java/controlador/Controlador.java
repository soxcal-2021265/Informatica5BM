package controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Zapato;
import modelo.ZapatoDAO;
import modelo.Cliente;
import modelo.ClienteDAO;

public class Controlador extends HttpServlet {

    // Instancias de las entidades y DAOs para Zapatos y Clientes
    Zapato zapato = new Zapato();
    ZapatoDAO zapatoDAO = new ZapatoDAO();
    Cliente cliente = new Cliente();
    ClienteDAO clienteDAO = new ClienteDAO();
    int codZapato;
    int codCliente;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        // Si no se especifica un menú, se redirige a la página principal.
        if (menu == null) {
            request.getRequestDispatcher("Index.jsp").forward(request, response);
            return;
        }

        switch (menu) {
            case "Clientes":
                switch (accion) {
                    case "Listar":
                        List listaClientes = clienteDAO.listar();
                        request.setAttribute("clientes", listaClientes);
                        break;
                    case "Agregar":
                        int codigoZapato = Integer.parseInt(request.getParameter("txtCodigoZapato"));
                        String nombre = request.getParameter("txtNombre");
                        String telefono = request.getParameter("txtTelefono");
                        String correo = request.getParameter("txtCorreo");
                        String direccion = request.getParameter("txtDireccion");
                        cliente.setCodigoZapato(codigoZapato);
                        cliente.setNombre(nombre);
                        cliente.setTelefono(telefono);
                        cliente.setCorreo(correo);
                        cliente.setDireccion(direccion);
                        clienteDAO.agregar(cliente);
                        request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                        break;
                    case "Editar":
                        codCliente = Integer.parseInt(request.getParameter("codigoCliente"));
                        Cliente cl = clienteDAO.listarCodigoCliente(codCliente);
                        request.setAttribute("cliente", cl);
                        request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                        break;
                    case "Actualizar":
                        int codigoCliente = Integer.parseInt(request.getParameter("txtCodigoCliente"));
                        int codigZapato = Integer.parseInt(request.getParameter("txtCodigoZapato"));
                        String nombreCliente = request.getParameter("txtNombre");
                        String telefonoCliente = request.getParameter("txtTelefono");
                        String correoCliente = request.getParameter("txtCorreo");
                        String direccionCliente = request.getParameter("txtDireccion");
                        cliente.setCodigoCliente(codigoCliente);
                        cliente.setCodigoZapato(codigZapato);
                        cliente.setNombre(nombreCliente);
                        cliente.setTelefono(telefonoCliente);
                        cliente.setCorreo(correoCliente);
                        cliente.setDireccion(direccionCliente);
                        clienteDAO.actualizar(cliente);
                        request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                        break;
                    case "Eliminar":
                        int cdCliente = Integer.parseInt(request.getParameter("codigoCliente"));
                        clienteDAO.eliminar(cdCliente);
                        request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                        break;
                }
                request.getRequestDispatcher("Clientes.jsp").forward(request, response);
                break;

            case "Zapatos":
                switch (accion) {
                    case "Listar":
                        List listaZapatos = zapatoDAO.listar();
                        request.setAttribute("zapatos", listaZapatos);
                        break;
                    case "Agregar":
                        String nombre = request.getParameter("txtNombre");
                        String marca = request.getParameter("txtMarca");
                        String talla = request.getParameter("txtTalla");
                        String color = request.getParameter("txtColor");
                        zapato.setNombre(nombre);
                        zapato.setMarca(marca);
                        zapato.setTalla(talla);
                        zapato.setColor(color);
                        zapatoDAO.agregar(zapato);
                        request.getRequestDispatcher("Controlador?menu=Zapatos&accion=Listar").forward(request, response);
                        break;
                    case "Editar":
                        codZapato = Integer.parseInt(request.getParameter("codigoZapato"));
                        Zapato zp = zapatoDAO.listarCodigoZapato(codZapato);
                        request.setAttribute("zapato", zp);
                        request.getRequestDispatcher("Controlador?menu=Zapatos&accion=Listar").forward(request, response);
                        break;
                    case "Actualizar":
                        int codigoZapato = Integer.parseInt(request.getParameter("txtCodigoZapato"));
                        String nombreZapato = request.getParameter("txtNombre");
                        String marcaZapato = request.getParameter("txtMarca");
                        String tallaZapato = request.getParameter("txtTalla");
                        String colorZapato = request.getParameter("txtColor");
                        zapato.setCodigoZapato(codigoZapato);
                        zapato.setNombre(nombreZapato);
                        zapato.setMarca(marcaZapato);
                        zapato.setTalla(tallaZapato);
                        zapato.setColor(colorZapato);
                        zapatoDAO.actualizar(zapato);
                        request.getRequestDispatcher("Controlador?menu=Zapatos&accion=Listar").forward(request, response);
                        break;
                    case "Eliminar":
                        int codZapato = Integer.parseInt(request.getParameter("codigoZapato"));
                        zapatoDAO.eliminar(codZapato);
                        request.getRequestDispatcher("Controlador?menu=Zapatos&accion=Listar").forward(request, response);
                        break;
                }
                request.getRequestDispatcher("Zapatos.jsp").forward(request, response);
                break;

            case "MenuInicio":
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;

            default:
                // Redirige a index.jsp si el menú no coincide
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Controlador principal para el proyecto de zapatos y clientes.";
    }
}
