package murach.cart;

import java.io.*;
import java.util.Arrays;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import jakarta.servlet.annotation.WebServlet;

import murach.business.*;

@WebServlet("/cart")
public class CartSevlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Item[] items = {
            new Item("01","86 (the band) - True Life Songs and Pictures", 14.95, 1),
            new Item("02","Paddle - The first CD", 12.95, 1),
            new Item("03","Paddle - The second CD", 14.95, 1),
            new Item("04","Joe Rut - Genuine Wood Grained Finish", 14.95, 1)
        };

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        String url = "/index.html";

        String action = request.getParameter("action");

        if (action == null) {
            action = "cart";
        } 

        if (action.equals("cart")) {
            
        } else if (Arrays.asList("id01","id02","id03","id04").contains(action)) {
            if(cart == null) {
                cart = new Cart();
            }
            for(int i=1; i<5; i++) {
                if (("id0" + String.valueOf(i)).equals(action)) {
                    cart.addItem(items[i-1]);
                    break;
                }
            }
            
            request.setAttribute("cart", cart);
            session.setAttribute("cart", cart);
            url = "/cart.jsp";
        }    
        else if (Arrays.asList("u01","u02","u03","u04").contains(action)) {
            int quantity = Integer.valueOf(request.getParameter(action));
            for(int i=1; i<5; i++) {
                if (("u0" + String.valueOf(i)).equals(action)) {
                    cart.findItemOfId("0" + String.valueOf(i)).setQuantity(quantity);
                    break;
                }
            }
            request.setAttribute("cart", cart);
            session.setAttribute("cart", cart);
            url = "/cart.jsp";

        } 
        else if (Arrays.asList("r01","r02","r03","r04").contains(action)) {
            for(int i=1; i<5; i++) {
                if (("r0" + String.valueOf(i)).equals(action)) {
                    cart.removeItemOfId("0" + String.valueOf(i));
                    break;
                }
            }
            request.setAttribute("cart", cart);
            session.setAttribute("cart", cart);
            url = "/cart.jsp";
        }
        else if (action.equals("check")) {
            request.setAttribute("cart", cart);
            session.setAttribute("cart", cart);
            url = "/checkout.jsp";
        } 
        else if (action.equals("back")) { 
            session.removeAttribute("cart");
            url = "/index.html";
        }

        request.getRequestDispatcher(url).forward(request, response);
    } 


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
