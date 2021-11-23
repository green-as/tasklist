package controllers;

import java.io.IOException;
import java.util.List;

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

        /*↓ページネーションのための設定
        開くページ数を取得*/
        int page = 1;
        try {
            page = Integer.parseInt(request.getParameter("page"));
        }catch(NumberFormatException e) {}

        /*先ほどJPQLの文につけた名前 getAllMessages を
         * createNamedQuery メソッドの引数に指定してあげることで、
         * データベースへの問い合わせを実行できます。*/

        /*↓ページネーションのための設定
         * 最大件数と開始位置を指定してメッセージを取得
         * */
        List<task> tasks = em.createNamedQuery("getAllMessages", task.class)
                .setFirstResult(15 * (page - 1))
                .setMaxResults(15)
                .getResultList();
        /*その問い合わせ結果を getResultList() メソッドを使って
         * リスト形式で取得します。データベースに保存されたデータは
         * Hibernateによって自動で task クラスのオブジェクトに
         * なってこのリストの中に格納されるので便利です。*/

        //全件数を取得
        long tasks_count = (long)em.createNamedQuery("getMessagesCount", Long.class)
                                         .getSingleResult();

        em.close();

        request.setAttribute("tasks", tasks);
        request.setAttribute("tasks_count", tasks_count);
        request.setAttribute("page", page);

        //リクエストスコープを利用しサーブレットからJSPへ値を渡す
        //request.setAttribute("tasks", tasks);
        /*↑データベースから取得したメッセージ一覧（messages）
         * をリクエストスコープにセットし、index.jsp
         * を呼び出しています。*/




        // フラッシュメッセージがセッションスコープにセットされていたら
        // リクエストスコープに保存する（セッションスコープからは削除）
        if(request.getSession().getAttribute("flush") != null) {
            request.setAttribute("flush", request.getSession().getAttribute("flush"));
            request.getSession().removeAttribute("flush");
        }

        //ビューとなるJSPを指定して呼び出す
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/tasks/index.jsp");
        rd.forward(request, response);


        /*↓レスポンスとしてクライアントに返すメソッド*/
        //response.getWriter().append(Integer.valueOf(tasks.size()).toString());

        em.close();
    }

}
