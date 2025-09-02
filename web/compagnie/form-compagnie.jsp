<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="col-lg-6">
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">Ajouter une nouvelle compagnie</h5>

            <% String erreur = (String) request.getAttribute("erreur"); %>
            <% if(erreur != null) { %>
            <div class="alert alert-danger mb-3"><%= erreur %></div>
            <% } %>

            <form action="saveCompagnie" method="post">
                <div class="row mb-3">
                    <label for="nom" class="col-sm-2 col-form-label">Nom</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="nom" name="compagnie.nom" placeholder="Nom de la compagnie" required>
                    </div>
                </div>
                <div class="row mb-3">
                    <label for="adresse" class="col-sm-2 col-form-label">Adresse</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="adresse" name="compagnie.adresse" placeholder="Adresse de la compagnie" required>
                    </div>
                </div>
                <div class="row mb-3">
                    <label for="contact" class="col-sm-2 col-form-label">Contact</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="contact" name="compagnie.contact" placeholder="Numéro de contact" required>
                    </div>
                </div>
                <div class="row mb-3">
                    <div class="col-sm-10 offset-sm-2">
                        <button type="submit" class="btn btn-primary">
                        <i class="bi bi-plus-circle me-2"></i> Enregistrer
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
