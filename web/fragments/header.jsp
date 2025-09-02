<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<header id="header" class="header fixed-top d-flex align-items-center">
  <div class="d-flex align-items-center justify-content-between">
    <a href="index.jsp" class="logo d-flex align-items-center">
      <img src="assets/img/logo-avion.jpg" alt="Logo Avion" class="w-12 h-12 object-contain">
      <span class="logo-text text-3xl ml-2">SkyWings</span>
    </a>
    <i class="bi bi-list toggle-sidebar-btn"></i>
  </div>

  <nav class="header-nav ms-auto">
    <ul class="d-flex align-items-center">

      <!-- Notifications avion -->
      <li class="nav-item dropdown">
        <a class="nav-link nav-icon" href="#" data-bs-toggle="dropdown">
          <i class="bi bi-bell"></i>
          <span class="badge bg-primary badge-number">4</span>
        </a>
        <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow notifications">
          <li class="dropdown-header">
            Vous avez 4 nouvelles alertes de vol
            <a href="#"><span class="badge rounded-pill bg-primary p-2 ms-2">Tout voir</span></a>
          </li>
          <li><hr class="dropdown-divider" /></li>

          <li class="notification-item">
            <i class="bi bi-airplane text-info"></i>
            <div>
              <h4>Vol AF 302</h4>
              <p>Prêt pour l’embarquement - Porte 12</p>
              <p>30 min. ago</p>
            </div>
          </li>

          <li><hr class="dropdown-divider" /></li>
          <li class="notification-item">
            <i class="bi bi-exclamation-circle text-warning"></i>
            <div>
              <h4>Retard</h4>
              <p>Vol MD 112 retardé de 1h</p>
              <p>1 hr. ago</p>
            </div>
          </li>

          <li><hr class="dropdown-divider" /></li>
          <li class="dropdown-footer"><a href="#">Voir toutes les notifications</a></li>
        </ul>
      </li>

      <!-- Messages pilotes / crew -->
      <li class="nav-item dropdown">
        <a class="nav-link nav-icon" href="#" data-bs-toggle="dropdown">
          <i class="bi bi-chat-left-text"></i>
          <span class="badge bg-success badge-number">3</span>
        </a>
        <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow messages">
          <li class="dropdown-header">
            Vous avez 3 nouveaux messages
            <a href="#"><span class="badge rounded-pill bg-primary p-2 ms-2">Voir tout</span></a>
          </li>
          <li><hr class="dropdown-divider" /></li>

          <li class="message-item">
            <a href="#">
              <img src="assets/img/pilot1.jpg" alt="" class="rounded-circle" style="width:40px;height:40px;"/>
              <div>
                <h4>Capitaine Louis</h4>
                <p>Briefing météo avant décollage</p>
                <p>4 hrs. ago</p>
              </div>
            </a>
          </li>

          <li><hr class="dropdown-divider" /></li>
          <li class="message-item">
            <a href="#">
              <img src="assets/img/stewardess.jpg" alt="" class="rounded-circle" style="width:40px;height:40px;"/>
              <div>
                <h4>Équipage cabine</h4>
                <p>Passagers installés, prêts au roulage</p>
                <p>6 hrs. ago</p>
              </div>
            </a>
          </li>

          <li><hr class="dropdown-divider" /></li>
          <li class="dropdown-footer"><a href="#">Voir tous les messages</a></li>
        </ul>
      </li>

      <!-- Profil utilisateur -->
      <li class="nav-item dropdown pe-3">
        <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown">
          <span class="d-none d-md-block dropdown-toggle ps-2">
            <%= session.getAttribute("nomUtilisateur") != null ? session.getAttribute("nomUtilisateur") : "Pilote invité" %>
          </span>
        </a>
        <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
          <li class="dropdown-header">
            <h6><%= session.getAttribute("nomUtilisateur") != null ? session.getAttribute("nomUtilisateur") : "Utilisateur" %></h6>
          </li>
          <li><hr class="dropdown-divider" /></li>

          <li>
            <a href="users-profile.jsp" class="dropdown-item d-flex align-items-center">
              <i class="bi bi-person"></i>
              <span>Mon profil</span>
            </a>
          </li>
    </ul>
  </nav>
</header>
