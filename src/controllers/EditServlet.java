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
 * Servlet implementation class EditServlet
 */
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

      //データベースから該当のIDのメッセージ1件のみを取得
        task t = em.find(task.class, Integer.parseInt(request.getParameter("id")));

        em.close();

        //メッセージ情報とセッションIDをリクエストスコープに登録
        request.setAttribute("task", t);
        request.setAttribute("_token", request.getSession().getId());

     // タスクIDをセッションスコープに登録
        /*JSPの中で扱えるよう、セッションスコープに格納*/
        /*セッションスコープでは↓がリクエストスコープでいう
         * setAttribute()にあたる*/

        if(t != null) {
        request.getSession().setAttribute("task_id", t.getId());
        }
        // ↑メッセージデータが存在しているときのみ
        // メッセージIDをセッションスコープに登録

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/tasks/edit.jsp");
        rd.forward(request, response);
    }

}
