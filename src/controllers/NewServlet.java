package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.task;

/*
 * Servlet implementation class NewServlet
 */
@WebServlet("/new")
public class NewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //CSRF対策
        /*request.setAttribute("_token", request.getSession().getId());
         * の部分は CSRF と呼ばれるセキュリティへの脅威に対する対策です。
        フォームから hidden 要素で送られた値とセッションに格納された値が
        同一であれば送信を受け付けるようにする、というものです。
        こうすることで、サイト外からPOST送信された投稿を拒否できます。
        ここではセッションIDと呼ばれるものを利用しています。*/
            request.setAttribute("_token", request.getSession().getId());

            //おまじないとしてインスタンスを作成
            /*おまじないとはリクエストスコープに task が
             * 入っていなければエラーが表示されます。
             * NewServlet で「おまじない」として
             * request.setAttribute("message", new Message());
             * を記述したのは、画面表示時のエラー回避のため、
             * とりあえず “文字数0のデータ” を
             * フォームに渡すためです。
             * 入力値エラーがあってフォームのページを
             * 再度表示する際に役立ちます。*/
            /*Message のインスタンスを生成して
             * リクエストスコープに格納しています。*/
            request.setAttribute("task", new task());

            //EntityManager em = DBUtil.createEntityManager();
            //em.getTransaction().begin();

            /*task(modelであるDTOクラス)のインスタンスを生成*/
            //task t = new task();

            /*tの各フィールド（content、created_at、updated_at）にデータを代入してみる
             * ちなみにIDは自動裁判されるので上の（）には入っていない*/
            //String content = "hello";
            //t.setContent(content);

            //// 現在の日時を取得
            //Timestamp currentTime = new Timestamp(System.currentTimeMillis());
           // t.setCreated_at(currentTime);
            //t.setUpdated_at(currentTime);

            // データベースに保存
            //em.persist(t);

            //データの新規登録を確定（コミット）させる命令です。
            //em.getTransaction().commit();

         // 自動採番されたIDの値を表示
        //response.getWriter().append(Integer.valueOf(t.getId()).toString());

        //em.close();

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/tasks/new.jsp");
            rd.forward(request, response);


    }

}
