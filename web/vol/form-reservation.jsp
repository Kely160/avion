<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container">
  <div class="d-flex align-items-center justify-content-between mb-3">
    <h5 class="mb-0">Réserver un siège</h5>
  </div>

  <% if (request.getAttribute("erreur") != null) { %>
    <div class="alert alert-danger"><%= request.getAttribute("erreur") %></div>
  <% } %>
  <% if (request.getAttribute("success") != null) { %>
    <div class="alert alert-success"><%= request.getAttribute("success") %></div>
  <% } %>

  <% java.util.List vols = (java.util.List) request.getAttribute("vols"); %>
  <% java.util.List classes = (java.util.List) request.getAttribute("classes"); %>

  <div class="row g-4">
    <% if (vols != null) { %>
      <% for (Object o : vols) { models.Vol v = (models.Vol) o; %>
        <div class="col-12 col-sm-6 col-lg-4">
          <div class="card h-100 shadow-sm border-0">
            <img src="assets/img/card.jpg" class="card-img-top" alt="Vol <%= v.getIdentification() %>">
            <div class="card-body d-flex flex-column">
              <h6 class="card-title mb-1"><%= v.getIdentification() %></h6>
              <small class="text-muted mb-3">Départ: <%= v.getDateHeureDepart() %></small>

              <form action="reserver" method="post" class="mt-auto">
                <input type="hidden" name="reservation.idVol" value="<%= v.getId() %>" />
                <div class="mb-2">
                  <select name="reservation.idClasse" class="form-select form-select-sm">
                    <% if (classes != null) { %>
                      <% for (Object oc : classes) { models.Classe c = (models.Classe) oc; %>
                        <option value="<%= c.getId() %>"><%= c.getNom() %></option>
                      <% } %>
                    <% } %>
                  </select>
                </div>
                <div class="mb-3">
                  <input type="date" name="reservation.date" class="form-control form-control-sm" value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()) %>" required />
                </div>
                <button type="submit" class="btn btn-primary w-100">
                  Réserver ce vol
                </button>
              </form>
            </div>
          </div>
        </div>
      <% } %>
    <% } else { %>
      <div class="col-12">
        <div class="alert alert-info">Aucun vol disponible pour le moment.</div>
      </div>
    <% } %>
  </div>
</div>


