package controllers;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.task;
import models.validators.TaskValidator;
import utils.DBUtil;


/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/create")
public class CreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*↓postリクエスト（フォームに入力されたもの（_token）を
         * 受け取る）*/
        String _token = request.getParameter("_token");

        /*↓CSRF対策のチェックを行っています。
         * _token に値がセットされていなかったりセッションIDと
         * 値が異なったりしたらデータの登録ができないように
         * しています。*/
        if(_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();
            em.getTransaction().begin();

            task t = new task();

            //↓content はフォームから入力された内容をセットします。
            String content = request.getParameter("content");
            t.setContent(content);

            /*created_at と updated_atは↓ように記述することで
             * 現在日時の情報を持つ日付型のオブジェクトを
             * 取得できます（Javaでは日時情報もオブジェクトで
             * 管理します）
             */
            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            t.setCreated_at(currentTime);
            t.setUpdated_at(currentTime);

            //バリデーションを実行してエラーがあったら新規登録のフォームに戻る
            List<String> errors = TaskValidator.validate(t);
            if(errors.size() > 0) {
                em.close();

                //フォームに初期値を設定、さらにエラーメッセージを送る
                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("task", t);
                request.setAttribute("errors", errors);


                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/tasks/new.jsp");
                rd.forward(request, response);
            }else {

            /*データベースに保存*/
            em.persist(t);
            em.getTransaction().commit();
            request.getSession().setAttribute("flush", "登録が完了しました。");
            em.close();

            response.sendRedirect(request.getContextPath() + "/index");
            }
            /*データベースへの保存が完了したら、
             * indexページへリダイレクト（遷移）
             * させるようにしています。*/
            //response.sendRedirect(request.getContextPath() + "/index");
        }
    }

}
