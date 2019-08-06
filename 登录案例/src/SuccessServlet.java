import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author rui
 * @create 2019-08-06 12:56
 */
@WebServlet("/SucessServlet")
public class SuccessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=(User)request.getAttribute("user");
        System.out.println(user);
        if(user!=null){
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(user.getUsername()+"登录成功");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
