<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<aside id="sidebar" class="sidebar">
  <ul class="sidebar-nav" id="sidebar-nav">

    <li class="nav-item">
      <a class="nav-link" href="index.jsp">
        <i class="bi bi-speedometer2"></i>
        <span>Tableau de bord de vol</span>
      </a>
    </li>

    <li class="nav-item">
      <a class="nav-link collapsed" data-bs-target="#avionics-nav" data-bs-toggle="collapse" href="#">
        <i class="bi bi-airplane"></i><span>Systèmes avioniques</span><i class="bi bi-chevron-down ms-auto"></i>
      </a>
      <ul id="avionics-nav" class="nav-content collapse" data-bs-parent="#sidebar-nav">
        <li>
          <a href="flight-alerts.jsp">
            <i class="bi bi-circle"></i><span>Alertes de vol</span>
          </a>
        </li>
        <li>
          <a href="flight-crew.jsp">
            <i class="bi bi-circle"></i><span>Équipage</span>
          </a>
        </li>
        <li>
          <a href="passengers.jsp">
            <i class="bi bi-circle"></i><span>Passagers</span>
          </a>
        </li>
        <li>
          <a href="maintenance.jsp">
            <i class="bi bi-circle"></i><span>Maintenance</span>
          </a>
        </li>
        <li>
          <a href="navigation.jsp">
            <i class="bi bi-circle"></i><span>Navigation</span>
          </a>
        </li>
        <li>
          <a href="weather.jsp">
            <i class="bi bi-circle"></i><span>Météo</span>
          </a>
        </li>
      </ul>
    </li>

    <li class="nav-heading">Gestion</li>

    <li class="nav-item">
      <a class="nav-link collapsed" href="utilisateurs.jsp">
        <i class="bi bi-person"></i>
        <span>Gestion des utilisateurs</span>
      </a>
    </li>

    <li class="nav-item">
      <a class="nav-link collapsed" href="flights.jsp">
        <i class="bi bi-geo-alt"></i>
        <span>Gestion des vols</span>
      </a>
    </li>

    <li class="nav-item">
      <a class="nav-link collapsed" href="reservations.jsp">
        <i class="bi bi-ticket"></i>
        <span>Réservations</span>
      </a>
    </li>

  </ul>
</aside>
