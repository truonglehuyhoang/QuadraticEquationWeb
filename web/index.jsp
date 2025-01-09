<%-- 
    Document   : huyhoang
    Created on : Dec 23, 2024, 4:41:52 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quadratic Equation</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <div class="quad_equation">
            <%
                String unbox = (String)request.getAttribute("toyspromax") ;
            %>
            <div class="image_banner">
                <img src="logo_256_vi.png" alt="gi_cung_duoc">
            </div>
            
            <div class="equation_header">
                <h1 class="header">Quadratic Equation Calculator</h1>
            </div>
            
            <form action="equation" method="post" class="equation_form">
                <p>Hãy cho ba con số (lưu ý là số)</p>
                
                <div class="number1">
                    Number 1: <input type="text" name="a" value="" />
                </div>
                
                <div class="number2">
                    Number 2: <input type="text" name="b" value="" />
                </div>
                
                <div class="number3">
                    Number 3: <input type="text" name="c" value="" />
                </div>
                
                <div class="click">
                    <input type="submit" value="Solve"/> 
                </div>            
            </form>
            
            <h2 style="color:green;" class="bad_words"> <%= unbox != null? unbox : "" %> </h2>
            <h2 style="color:red;" class="nice_words"> <%= request.getAttribute("msg") != null? request.getAttribute("msg") : "" %> </h2>
            
            <footer>
                <p>Created by: HuyHoang</p>
            </footer>
        </div>
    </body>
</html>
