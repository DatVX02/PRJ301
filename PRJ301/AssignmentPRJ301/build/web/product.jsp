
<%@page import="web.models.tblProduct.ProductDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="web.models.tblCategory.CategoryDTO"%>
<%@page import="java.util.List"%>
<%@page import="web.models.tblUser.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Food Store | Home</title>

        <!--Bootstrap CSS--> 
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css" />

        <!--font awesome cdn link-->  
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

        <!--custom css file link-->  
        <link rel="stylesheet" href="css/style.css">

    </head>

    <body>
        <c:if test="${sessionScope.LOGIN_USER==NULL || sessionScope.LOGIN_USER.roleID ne 'US'}">
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>
        <!--header section starts-->  

        <header class="header">

            <a href="#" class="logo"> <i class="fas fa-shopping-basket"></i> food store </a>

            <nav class="navbar">
                <a href="MainController?action=LoadInfor">home</a>
                <a href="#">categories</a>
                <a href="#">products</a>
            </nav>

            <div class="icons">
                <div class="fas fa-bars" id="menu-btn"></div>
                <div class="fas fa-search" id="search-btn"></div>
                
                <a href="viewCart.jsp">
                    <div class="fas fa-shopping-cart" id="cart-btn"></div>
                </a>
                <form action="MainController" method="POST" style="display: inline">
                    <input type="submit" name="action" value="Logout" class="btn" style="margin-top: 0; margin-bottom: 1rem"/>
                </form>

            </div>

            <form action="MainController" class="search-form">
                <input type="text" name="search" value="${param.search}" required="" id="search-box" placeholder="search here...">
                <input type="submit" name="action" value="Search" class="btn" id="sub">
            </form>

        </header>

        <!--header section ends--> 

        <!--home section starts-->  

        <section class="home" id="home">

            <div class="content">
                <h3><span>welcome user </span>${sessionScope.LOGIN_USER.fullName}</h3>
                <a href="#" class="btn">shop now</a>
            </div>

        </section>

        <!--home section ends--> 

        <!--products section starts-->  

        <section class="products" id="products">

            <div class="row">
                <div class="col-md-3 category">
                    <h1 class="heading"><span>categorys</span></h1>
                    <c:if test="${requestScope.LIST_CATEGORY != null}">
                        <c:if test="${not empty requestScope.LIST_CATEGORY}">
                            <ul class="list-group">
                                <c:forEach var="cate" items="${requestScope.LIST_CATEGORY}">
                                    <li class="list-group-item"><a href="MainController?action=Filter&categoryID=${cate.categoryID}">${cate.categoryName}</a></li>
                                </c:forEach>
                            </ul>
                        </c:if>
                    </c:if>
                    <h3 style="color: red; margin-left: 1rem; margin-top: 1rem;"><i class="fas fa-bell"></i> ${requestScope.CART_ERROR}</h3>
                </div>

                <div class="col-md-9 product">
                    <h1 class="heading"> our <span>products</span> </h1>
                    <c:choose>
                        <c:when test="${requestScope.LIST_PRODUCT == null || requestScope.LIST_PRODUCT.size() == 0}">
                            <h3>Not founds</h3>
                        </c:when>
                        <c:otherwise>
                            <div class="box-container">

                                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 justify-content-center">

                                    <c:forEach var="product" items="${requestScope.LIST_PRODUCT}">
                                        <div class="box">
                                            <a href="MainController?action=Detail&productID=${product.productID}"><img src="${product.image}" alt=""></a>
                                            <h3>${product.productName}</h3>
                                            <p class="price">$${product.price}</p>
                                            <div class="stars">
                                                <i class="fas fa-star"></i>
                                                <i class="fas fa-star"></i>
                                                <i class="fas fa-star"></i>
                                                <i class="fas fa-star"></i>
                                                <i class="fas fa-star-half-alt"></i>
                                            </div>
                                            <c:url var="addToCartLink" value="MainController">
                                                <c:param name="action" value="AddToCart"></c:param>
                                                <c:param name="productID" value="${product.productID}"></c:param>
                                            </c:url>
                                            <a href="${addToCartLink}" class="btn">add to cart</a>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>

        </section>

        <!--products section ends--> 

        <!--footer section starts-->  

        <section class="footer">

            <div class="box-container">

                <div class="box">
                    <h3> food store <i class="fas fa-shopping-basket"></i> </h3>
                    <div class="share">
                        <a href="#" class="fab fa-facebook-f"></a>
                        <a href="#" class="fab fa-twitter"></a>
                        <a href="#" class="fab fa-instagram"></a>
                        <a href="#" class="fab fa-linkedin"></a>
                    </div>
                </div>

                <div class="box">
                    <h3>contact info</h3>
                    <a href="#" class="links"> <i class="fas fa-phone"></i> +399-997-857 </a>
                    <a href="#" class="links"> <i class="fas fa-envelope"></i> NongsanVinhomes@gmail.com </a>
                    <a href="#" class="links"> <i class="fas fa-map-marker-alt"></i> Vinhomes Grand Park, Thu Duc </a>
                </div>

                <div class="box">
                    <h3>quick links</h3>
                    <a href="#home" class="links"> <i class="fas fa-arrow-right"></i> home </a>
                    <a href="#products" class="links"> <i class="fas fa-arrow-right"></i> products </a>
                </div>

                <div class="box">
                    <h3>newsletter</h3>
                    <p>subscribe for latest updates</p>
                    <input type="email" placeholder="your email" class="email">
                    <input type="submit" value="subscribe" class="btn">
                    <img src="image/payment.png" class="payment-img" alt="">
                </div>
        </section>

        <!--footer section ends--> 

        <!--Optional JavaScript--> 
        <!--jQuery first, then Popper.js, then Bootstrap JS--> 
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
                integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
                integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

        <script src="https://unpkg.com/swiper@7/swiper-bundle.min.js"></script>

        <!--custom js file link-->  
        <script src="js/script.js"></script>

    </body>

</html>
