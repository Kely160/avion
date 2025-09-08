<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="container py-4">
  <div class="row justify-content-center">
    <div class="col-lg-12">
      <div class="card">
        <div class="card-header d-flex justify-content-between align-items-center">
          <h5 class="mb-0">Mes Réservations</h5>
        </div>

        <div class="card-body">
          <% if (request.getAttribute("erreur") != null) { %>
            <div class="alert alert-danger"><%= request.getAttribute("erreur") %></div>
          <% } %>

          <div class="table-responsive">
            <table class="table table-hover table-bordered align-middle">
              <thead class="table-light">
                <tr>
                  <th>#</th>
                  <th>Date Réservation</th>
                  <th>Vol</th>
                  <th>Classe</th>
                  <th>Statut</th>
                  <th>Actions</th>
                </tr>
              </thead>
              <tbody>
                <% 
                  java.util.List list = (java.util.List) request.getAttribute("reservations"); 
                  if (list != null) {
                    int i = 1;
                    for (Object o : list) {
                      models.Reservation r = (models.Reservation) o;
                %>
                  <tr>
                    <td><%= i++ %></td>
                    <td><%= r.getDateReservation() %></td>
                    <td><%= r.getVol().getIdentification() %></td>
                    <td><%= r.getClasse().getNom() %></td>
                    <td><%= r.getStatus().getNom() %></td>
                    <td>
                      <div class="d-flex gap-2">
                        <!-- Bouton Payer -->
                        <form action="payerReservation" method="post" class="d-inline">
                          <input type="hidden" name="idReservation" value="<%= r.getId() %>">
                          <button type="submit" class="btn btn-success btn-sm">
                            <i class="bi bi-credit-card"></i> Payer
                          </button>
                        </form>

                        <!-- Bouton Annuler -->
                        <form action="annulerReservation" method="post" class="d-inline">
                          <input type="hidden" name="idReservation" value="<%= r.getId() %>">
                          <button type="submit" class="btn btn-danger btn-sm" onclick="return confirm('Confirmer l’annulation ?');">
                            <i class="bi bi-x-circle"></i> Annuler
                          </button>
                        </form>
                      </div>
                    </td>
                  </tr>
                <% 
                    }
                  } else {
                %>
                  <tr>
                    <td colspan="6" class="text-center text-muted">Aucune réservation trouvée.</td>
                  </tr>
                <% } %>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
