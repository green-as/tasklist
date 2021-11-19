package controllers;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.task;
import utils.DBUtil;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */

    /*↓ブラウザからのhttpリクエスト（getかpostか）よって
     dogetメソッドが呼び出される
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();
        /*先ほどJPQLの文につけた名前 getAllMessages を
         * createNamedQuery メソッドの引数に指定してあげることで、
         * データベースへの問い合わせを実行できます。*/
        List<task> tasks = em.createNamedQuery("getAllMessages", task.class).getResultList();
        /*その問い合わせ結果を getResultList() メソッドを使って
         * リスト形式で取得します。データベースに保存されたデータは
         * Hibernateによって自動で task クラスのオブジェクトに
         * なってこのリストの中に格納されるので便利です。*/


        /*↓レスポンスとしてクライアントに返すメソッド*/
        response.getWriter().append(Integer.valueOf(tasks.size()).toString());

        em.close();
    }

}
