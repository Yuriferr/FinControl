<nav class="navbar navbar-expand-lg navbar-dark bg-success" data-bs-theme="dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="usuario.jsp">FinControl</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="usuario.jsp">Perfil</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="ReceitasServlet?acao=listar&codigoUsuario=${usuario.codigo}">Receitas</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="DespesasServlet?acao=listar&codigoUsuario=${usuario.codigo}">Despesas</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="MetasServlet?acao=listar&codigoUsuario=${usuario.codigo}">Metas</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="InvestimentosServlet?acao=listar&codigoUsuario=${usuario.codigo}">Investimentos</a>
        </li>
      </ul>
    </div>
  </div>
</nav>