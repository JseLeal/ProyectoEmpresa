<!DOCTYPE html>
<% 
   String usuario=(String)session.getAttribute("US");
            %>
<html >
    <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Empresa</title>    <!-- Bootstrap Core CSS -->
    <link href="Estilo/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="Estilo/css/sb-admin.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="Estilo/css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="Estilo/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    </head>
<body>
    
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="Home.jsp">Home</a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
             
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> <%= usuario %> <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="CContra.jsp"><i class="fa fa-fw fa-gear"></i>Cambiar Contraseña</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="index.jsp"><i class="fa fa-fw fa-power-off"></i> Salir</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                   <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo"><i class="glyphicon glyphicon-shopping-cart"></i> Compras <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo" class="collapse">
                            <li>
                               <a href="Proveedores.jsp"><i class="glyphicon glyphicon-globe"></i> Proveedores</a>
                            </li>
                            <li>
                                <a href="#"><i class="glyphicon glyphicon-save-file"></i>Facturas de Compra</a>
                            </li>
                        </ul>
                    </li>       
                   <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo2"><i class="glyphicon glyphicon-credit-card"></i> Ventas <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo2" class="collapse">
                            <li>
                                 <a href="Clientes.jsp"><i class="glyphicon glyphicon-heart-empty"></i>Clientes</a>
                            </li>
                            <li>
                                <a href="#"><i class="glyphicon glyphicon-open-file"></i>Facturas de Ventas</a>
                            </li>
                        </ul>
                    </li>
                   <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo3"><i class="glyphicon glyphicon-list-alt"></i> Organizacion <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo3" class="collapse">
                            <li>
                                <a href="puestos.jsp"><i class="glyphicon glyphicon-bookmark"></i>Puestos</a>
                            </li>
                            <li>
                                <a href="Usuarios.jsp"><i class="glyphicon glyphicon-user"></i>Usuarios</a>
                            </li>
                            <li>
                               <a href="#"><i class="glyphicon glyphicon-modal-window"></i>Empleados</a>
                            </li>
                              <li>
                                  <a href="Marcas.jsp"><i class="glyphicon glyphicon-tags"></i>Marcas</a>
                            </li>
                        </ul>
                    </li>
                   <li>
                       <a href="Productos.jsp"><i class="glyphicon glyphicon-leaf"></i>Productos</a>
                   </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>
    
      <!-- jQuery -->
    <script src="Estilo/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="Estilo/js/bootstrap.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="Estilo/js/plugins/morris/raphael.min.js"></script>
    <script src="Estilo/js/plugins/morris/morris.min.js"></script>
    <script src="Estilo/js/plugins/morris/morris-data.js"></script>
</body>

</html>

