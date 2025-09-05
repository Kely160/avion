<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="col-lg-8">
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">Ajouter un nouveau vol</h5>

            <% String erreur = (String) request.getAttribute("erreur"); %>
            <% if(erreur != null) { %>
            <div class="alert alert-danger mb-3"><%= erreur %></div>
            <% } %>

            <form action="saveVol" method="post">
                <!-- Identification -->
                <div class="row mb-3">
                    <label for="identification" class="col-sm-3 col-form-label">Identification</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="identification" 
                               name="vol.identification" placeholder="Code du vol" required>
                    </div>
                </div>

                <!-- Date et heure de départ -->
                <div class="row mb-3">
                    <label for="dateHeureDepart" class="col-sm-3 col-form-label">Date et heure de départ</label>
                    <div class="col-sm-9">
                        <input type="datetime-local" class="form-control" id="dateHeureDepart" 
                               name="vol.dateHeureDepart" required>
                    </div>
                </div>

                <!-- Avion -->
                <div class="row mb-3">
                    <label for="avion" class="col-sm-3 col-form-label">Avion</label>
                    <div class="col-sm-9">
                        <select class="form-select" id="avion" name="vol.avionId" required>
                            <option value="">-- Sélectionner un avion --</option>
                            <%
                                java.util.List<models.Avion> avions = 
                                    (java.util.List<models.Avion>) request.getAttribute("avions");
                                if(avions != null) {
                                    for(models.Avion a : avions) {
                            %>
                                <option value="<%= a.getId() %>"><%= a.getNom() %></option>
                            <%
                                    }
                                }
                            %>
                        </select>
                    </div>
                </div>

                <!-- Bouton submit -->
                <div class="row mb-3">
                    <div class="col-sm-9 offset-sm-3">
                        <button type="submit" class="btn btn-primary">
                            <i class="bi bi-plus-circle me-2"></i> Enregistrer
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
