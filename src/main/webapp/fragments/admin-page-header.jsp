<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-01-12
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar fixed-top navbar-expand-lg navbar-light white scrolling-navbar">
    <div class="container">
        <a href="/home" class="navbar-brand waves-effect">
            <strong class="blue-text">OnlineShop</strong>
        </a>
        <button class="navbar-toggler" type="button"
                data-toggle="collapse" data-target="#navbarContent"
                aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a href="/add-producer" class="nav-link waves-effect">Producer</a>
                </li>
                <li class="nav-item">
                    <a href="/add-model" class="nav-link waves-effect">Model</a>
                </li>
                <li class="nav-item">
                    <a href="/add-phone" class="nav-link waves-effect">Phone</a>
                </li>
            </ul>
            <ul class="navbar-nav nav-flex-icons">
                <li class="nav-item">
                    <span class="blue-text nav-link waves-effect">Hello, ${pageContext.session.getAttribute("userDto").nickname}</span>
                </li>
                <li class="nav-item">
                    <a href="/log-out" class="nav-link waves-effect">
                        <span class="clearfix d-none d-sm-inline-block">Sign out</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="#" class="nav-link waves-effect">
                        <i class="fab fa-facebook"></i>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="#" class="nav-link waves-effect">
                        <i class="fab fa-twitter"></i>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="#" class="nav-link border border-light rounded waves-effect">
                        <i class="fab fa-github"></i>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>

