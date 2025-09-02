<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Connexion - AeroPlan Gestion de Vols</title>
  <script src="https://cdn.tailwindcss.com"></script>
  <script src="https://unpkg.com/lucide@latest"></script>
  <style>
    body {
      background: #f6f9ff; /* Fond clair façon NiceAdmin */
    }
    .logo-text {
      font-family: 'Segoe UI', sans-serif;
      font-weight: 700;
      color: #012970; /* Bleu NiceAdmin */
    }
  </style>
</head>
<body class="flex items-center justify-center min-h-screen">
  <main class="w-full max-w-md">
    <div class="bg-white rounded-xl shadow-lg border border-gray-100 p-8">
      
      <!-- Logo AeroPlan -->
      <div class="flex flex-col items-center mb-6">
        <div class="flex items-center justify-center mb-2">
          <img src="assets/img/logo-avion.jpg" alt="Logo Avion" class="w-12 h-12 object-contain">
          <span class="logo-text text-3xl ml-2">Avion</span>
        </div>
        <p class="text-sm text-gray-500">Gestion des vols aéroportuaires</p>
      </div>

      <h2 class="text-xl font-semibold text-center text-gray-700 mb-6">
        Se connecter à votre compte
      </h2>

      <!-- Affichage du message d'erreur -->
      <% String erreur = (String) request.getAttribute("erreur"); %>
      <% if (erreur != null) { %>
        <div class="mb-4 p-3 text-red-700 bg-red-100 border border-red-400 rounded-lg text-sm flex items-start">
          <i data-lucide="alert-circle" class="w-4 h-4 mt-0.5 mr-2 flex-shrink-0"></i>
          <span><%= erreur %></span>
        </div>
      <% } %>

      <form action="login" method="post" class="space-y-4">
        <div>
          <label class="block text-gray-600 text-sm font-medium mb-1">Identifiant</label>
          <div
            class="flex items-center border border-gray-300 rounded-lg px-3 py-2 focus-within:border-blue-500 focus-within:ring-1 focus-within:ring-blue-500">
            <i data-lucide="user" class="w-5 h-5 text-gray-400"></i>
            <input type="email" name="utilisateur.email" placeholder="rakotondratsimbakevin@gmail.com"
              class="w-full outline-none pl-2 text-gray-700 placeholder-gray-400 text-sm bg-transparent">
          </div>
        </div>

        <div>
          <label class="block text-gray-600 text-sm font-medium mb-1">Mot de passe</label>
          <div
            class="flex items-center border border-gray-300 rounded-lg px-3 py-2 focus-within:border-blue-500 focus-within:ring-1 focus-within:ring-blue-500">
            <i data-lucide="lock" class="w-5 h-5 text-gray-400"></i>
            <input type="password" name="utilisateur.mdp" placeholder="••••••••"
              class="w-full outline-none pl-2 text-gray-700 placeholder-gray-400 text-sm bg-transparent">
          </div>
        </div>

        <div class="flex items-center justify-between text-sm">
          <label class="flex items-center space-x-2">
            <input type="checkbox" class="rounded text-blue-600 focus:ring-0">
            <span class="text-gray-600">Se souvenir de moi</span>
          </label>
          <a href="#" class="text-blue-600 hover:underline">Mot de passe oublié ?</a>
        </div>

        <button type="submit"
          class="w-full bg-blue-600 text-white py-2.5 rounded-lg font-semibold hover:bg-blue-700 transition flex items-center justify-center">
          <i data-lucide="log-in" class="w-4 h-4 mr-2"></i>
          Connexion
        </button>
      </form>
    </div>

    <!-- Footer -->
    <p class="text-center text-xs text-gray-500 mt-6">
      © 2025 <span class="font-semibold text-blue-600">Avion</span>. Tous droits réservés.
    </p>
  </main>

  <script>
    lucide.createIcons();
  </script>
</body>
</html>
