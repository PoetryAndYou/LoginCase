

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;

/**
 * @author rui
 * @create 2019-08-05 22:30
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        /**
         * 方式一
         */
/*        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);*/
        /**
         *方式二
         */
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user=new User();
        //使用BeanUtils封装
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        User userDao = new UserDao().login(user);
        if(userDao==null){
             request.getRequestDispatcher("/FailServlet").forward(request,response);
        }else{
            request.setAttribute("user",userDao);
            request.getRequestDispatcher("/SucessServlet").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
