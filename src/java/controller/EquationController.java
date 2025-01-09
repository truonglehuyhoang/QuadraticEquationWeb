package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/equation"})
public class EquationController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        
        String aStr = request.getParameter("a");
        String bStr = request.getParameter("b");
        String cStr = request.getParameter("c");
        
        try{
            double a = Double.parseDouble(aStr);
            double b = Double.parseDouble(bStr);
            double c = Double.parseDouble(cStr);
            
            if (a==0){
                request.setAttribute("msg", "a phải khác 0");
            }else{
                double delta = b * b - 4 * a * c;
                if(delta > 0){
                    double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                    double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                    //result = String.format("Phương trình có hai nghiệm: x1 = %.2f, x2 = %.2f", x1, x2);
                    request.setAttribute("toyspromax", String.format("Phương trình có hai nghiệm: x1 = %.2f, x2 = %.2f", x1, x2));
                }else if(delta == 0){
                    double x = -b / (2 * a);
                    //result = String.format("Phương trình có nghiệm kép: x = %.2f", x);
                    request.setAttribute("toyspromax", String.format("Phương trình có nghiệm kép: x = %.2f", x));
                }else{
                    //result = "Phương trình vô nghiệm";
                    request.setAttribute("toyspromax", "Phương trình vô nghiệm");
                }
            }
        }catch(NumberFormatException e){
            request.setAttribute("msg", "Vui lòng nhập số");
            //e.printStackTrace();
        }
        
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

}
