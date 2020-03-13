package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Register extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        String name = request.getParameter( "name" );
        String email = request.getParameter( "email" );
        String password1 = request.getParameter( "password1" );
        String password2 = request.getParameter( "password2" );
       if ( password1.equals( password2 ) ) {
            User user = LogicFacade.createUser( name, email, password1 );
            HttpSession session = request.getSession();

            session.setAttribute("email",email);
            session.setAttribute("name", name);
            session.setAttribute( "user", user );
            return "../index.jsp";
        } else {
            throw new LoginSampleException( "the two passwords did not match" );
        }
    }

}
