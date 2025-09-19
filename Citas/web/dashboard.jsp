<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Dashboard - Sistema de Citas</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="${pageContext.request.contextPath}">Sistema de Citas</a>
            <div class="navbar-nav ms-auto">
                <span class="navbar-text me-3">Bienvenido, ${usuario}</span>
                <a class="nav-link" href="${pageContext.request.contextPath}/logout">Cerrar Sesión</a>
            </div>
        </div>
    </nav>

    <div class="container mt-4">
        <h2>Panel de Control</h2>
        
        <c:choose>
            <c:when test="${rol eq 'admin'}">
                <div class="alert alert-info">
                    <h4>Bienvenido Administrador</h4>
                    <p>Tienes acceso completo al sistema.</p>
                </div>
            </c:when>
            <c:otherwise>
                <div class="alert alert-info">
                    <h4>Bienvenido Usuario</h4>
                    <p>Acceso estándar al sistema.</p>
                </div>
            </c:otherwise>
        </c:choose>
        
        <!-- Contenido del dashboard aquí -->
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>