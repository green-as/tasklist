package controllers;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.task;
import utils.DBUtil;

/**
 * Servlet implementation class ShowServlet
 */
@WebServlet("/show")
                         /*↓extendsは継承の印なので
                          * 継承を復習する*/
public class ShowServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        //データベースから該当のIDのメッセージ1件のみを取得
        /*クエリ・パラメータの id は request.getParameter("id")
         * で取得できますが、注意したいのが
         * request.getParameter() はどのようなデータもString型
         * のデータとして取得するという特徴です。
         * データベースの id は整数値です。そこで
         *  Interger.parseInt() メソッドを利用して
         *  String型の”1”を整数値の1に変えてから
         *   find メソッドの引数にしています。*/
        task t = em.find(task.class, Integer.parseInt(request.getParameter("id")));

        em.close();

        //メッセージデータをリクエストスコープにセットしてshow.jspを呼び出す
        request.setAttribute("task", t);

        //フォワードで処理を転送
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/tasks/show.jsp");
        rd.forward(request, response);

    }

}
