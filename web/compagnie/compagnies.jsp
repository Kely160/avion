<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="models.Compagnie" %>

<div class="row">
    <div class="col-lg-12">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">Liste des compagnies</h5>
                <table class="table">
                    <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Nom</th>
                                <th scope="col">Adresse</th>
                                <th scope="col">Contact</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% 
                                List<Compagnie> compagnies = (List<Compagnie>) request.getAttribute("compagnies");
                                if (compagnies != null) {
                                    for (Compagnie c : compagnies) {
                            %>
                            <tr>
                                <td scope="row"><%= c.getId() %></td>
                                <td><%= c.getNom() %></td>
                                <td><%= c.getAdresse() %></td>
                                <td><%= c.getContact() %></td>
                            </tr>
                            <% 
                                    }
                                } else { 
                            %>
                            <tr>
                                <td colspan="4" class="px-6 py-4 text-center text-gray-500">Aucune compagnie trouvée.</td>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>

                    <div class="mt-4 text-end">
                        <a href="ajouterCompagnie" class="btn btn-primary">Ajouter une nouvelle compagnie</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
