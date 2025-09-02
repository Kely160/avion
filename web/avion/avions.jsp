<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="models.Avion" %>

<div class="row">
    <div class="col-lg-12">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">Liste des avions</h5>
                <table class="table">
                    <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Nom</th>
                                <th scope="col">Compagnie</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% 
                                List<Avion> avions = (List<Avion>) request.getAttribute("avions");
                                if (avions != null) {
                                    for (Avion a : avions) {
                            %>
                            <tr>
                                <td scope="row"><%= a.getId() %></td>
                                <td><%= a.getNom() %></td>
                                <td><%= a.getCompagnie().getNom() %></td>
                            </tr>
                            <% 
                                    }
                                } else { 
                            %>
                            <tr>
                                <td colspan="4" class="px-6 py-4 text-center text-gray-500">Aucun avion trouvé.</td>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
