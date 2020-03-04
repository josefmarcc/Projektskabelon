package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class RemoveCustomer extends Command {


    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {


        String s = LogicFacade.removeCustomer(request.getParameter("email"));


        ArrayList<User> customerList = LogicFacade.customerList();

        HttpSession session = request.getSession();
        session.setAttribute("email",s);
        session.setAttribute("customerlist",customerList);

        return "oversigt";
    }
}