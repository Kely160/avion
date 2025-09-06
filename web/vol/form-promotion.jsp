<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="col-lg-8">
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">Ajouter une nouvelle promotion</h5>

            <% String erreur = (String) request.getAttribute("erreur"); %>
            <% if(erreur != null) { %>
            <div class="alert alert-danger mb-3"><%= erreur %></div>
            <% } %>

            <% String success = (String) request.getAttribute("success"); %>
            <% if(success != null) { %>
            <div class="alert alert-success mb-3"><%= success %></div>
            <% } %>

            <form action="savePromotion" method="post">
                <div class="row mb-3">
                    <label for="reduction" class="col-sm-3 col-form-label">Prix</label>
                    <div class="col-sm-9">
                        <input type="number" class="form-control" id="reduction" name="promotion.prix" min="1" required>
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="nbreSiege" class="col-sm-3 col-form-label">Nbre de siége</label>
                    <div class="col-sm-9">
                        <input type="number" class="form-control" id="nbreSiege" name="promotion.nbreSiege" required>
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="classe" class="col-sm-3 col-form-label">Classe</label>
                    <div class="col-sm-9">
                        <select class="form-select" id="classe" name="promotion.idClasse" required>
                            <option value="">-- Sélectionner une classe --</option>
                            <%
                                java.util.List<models.Classe> classes = 
                                    (java.util.List<models.Classe>) request.getAttribute("classes");
                                if(classes != null) {
                                    for(models.Classe c : classes) {
                            %>
                                <option value="<%= c.getId() %>"><%= c.getNom() %></option>
                            <%
                                    }
                                }
                            %>
                        </select>
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="vol" class="col-sm-3 col-form-label">Vol</label>
                    <div class="col-sm-9">
                        <select class="form-select" id="vol" name="promotion.idVol" required>
                            <option value="">-- Sélectionner un vol --</option>
                            <%
                                java.util.List<models.Vol> vols = 
                                    (java.util.List<models.Vol>) request.getAttribute("vols");
                                if(vols != null) {
                                    for(models.Vol v : vols) {
                            %>
                                <option value="<%= v.getId() %>"><%= v.getIdentification() %></option>
                            <%
                                    }
                                }
                            %>
                        </select>
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="dateFin" class="col-sm-3 col-form-label">Date fin</label>
                    <div class="col-sm-9">
                        <input type="date" class="form-control" id="dateFin" name="promotion.dateFin" placeholder="Ex: 10" min="1" max="100" required>
                    </div>
                </div>

                <div class="row mb-3">
                    <div class="col-sm-9 offset-sm-3">
                        <button type="submit" class="btn btn-primary">
                            <i class="bi bi-percent me-2"></i> Enregistrer
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
