<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Iniciar Sesión - Sistema de Citas</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .app-container {
            display: flex;
            flex-direction: column;
            min-height: 100vh;
            background-color: #f8f9fa;
        }
        .main-content {
            flex: 1;
            display: flex;
            align-items: center;
            padding: 2rem 0;
        }
        .login-card {
            border: none;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
            margin: 0 auto;
        }
        .login-header {
            background: linear-gradient(135deg, #6a11cb 0%, #2575fc 100%);
            color: white;
            padding: 1.5rem;
            border-radius: 10px 10px 0 0;
            text-align: center;
        }
        .login-body {
            padding: 2rem;
            background: white;
            border-radius: 0 0 10px 10px;
        }
        .form-control:focus {
            border-color: #6a11cb;
            box-shadow: 0 0 0 0.25rem rgba(106, 17, 203, 0.25);
        }
        .btn-login {
            background: linear-gradient(135deg, #6a11cb 0%, #2575fc 100%);
            border: none;
            width: 100%;
            padding: 0.75rem;
            font-weight: 600;
        }
        .btn-login:hover {
            opacity: 0.9;
        }
        .footer {
            background-color: #343a40;
            color: white;
            padding: 1.5rem 0;
            text-align: center;
        }
    </style>
</head>
<body class="app-container">
    <!-- Header -->
    <header>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="${pageContext.request.contextPath}">Sistema de Citas</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                    <span class="navbar-toggler-icon"></span>
                </button>
            </div>
        </nav>
    </header>

    <!-- Main Content -->
    <main class="main-content">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-6 col-lg-4">
                    <div class="login-card">
                        <div class="login-header">
                            <h3 class="mb-0">Iniciar Sesión</h3>
                        </div>
                        <div class="login-body">
                            
                            <!-- 
                                c:if - Etiqueta de JSTL que evalúa una expresión.
                                En este caso, verifica si existe un atributo "error" en alguno de los ámbitos (page, request, session, application).
                                Si existe, muestra un mensaje de error.
                            -->
                            <c:if test="${not empty error}">
                                <div class="alert alert-danger" role="alert">
                                    <!-- 
                                    ${error} - (Expression Language) que imprime el valor del atributo "error".
                                                Este atributo será establecido por un servlet cuando hay un error de autenticación.
                                    -->
                                </div>
                            </c:if>
                            
                            <!-- 
                                Formulario que enví­a los datos al servidor mediante POST.
                                La acción se construye dinámicamente con ${pageContext.request.contextPath} para asegurar
                                que la ruta sea correcta independientemente del contexto de la aplicación.
                            -->
                            <form action="${pageContext.request.contextPath}/login" method="POST">
                                <div class="mb-3">
                                    <label for="username" class="form-label">Usuario</label>
                                    <input type="text" class="form-control" id="username" name="username" required>
                                </div>
                                
                                <div class="mb-4">
                                    <label for="password" class="form-label">Contraseña</label>
                                    <input type="password" class="form-control" id="password" name="password" required>
                                </div>
                                
                                <!-- Botón de enví­o del formulario, usamos el tipo submit para que lo reciba la función -->                            
                                <button type="submit" class="btn btn-primary btn-login mb-3">
                                    Iniciar Sesión
                                </button>
                                
                                <!-- Pie de la tarjeta con enlace de regreso al inicio -->
                                <div class="card-footer text-center">
                                    <!-- 
                                        Enlace que usa ${pageContext.request.contextPath} para volver a la página principal.
                                        Esto asegura que el enlace funcione correctamente en cualquier entorno de despliegue.
                                    -->
                                    <a class="fas fa-arrow-left me-1" href="${pageContext.request.contextPath}">Volver al inicio</a>
                                </div>

                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>

    <!-- Footer -->
    <footer class="footer">
        <div class="container">
            <p class="mb-0">&copy; 2025 Sistema de Citas. Todos los derechos reservados.</p>
        </div>
    </footer>

    <!-- Scripts -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
</body>
</html>