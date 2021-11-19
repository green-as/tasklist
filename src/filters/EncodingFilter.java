package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter("/*")
public class EncodingFilter implements Filter {

    /**
     * Default constructor.
     */
    public EncodingFilter() {
        /*コンストラクタ（フィルタのインスタンスが
         * 生成される際に実行されます）*/
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        /*「（フィルタの処理が不要になったため）フィルタを
         * 破棄する」というときの処理を定義します*/
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */

    /*↓フィルタとしての実行内容を定義するメソッドです。*/
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        /*chain.doFilter(request, response);より前に書いた処理だと
         * サーブレットが処理を実行する前にフィルタの処理が実行*/
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        chain.doFilter(request, response);
        /*chain.doFilter(request, response);より後に書いた処理だと
         * サーブレットが処理を実行した後にフィルタの処理が実行*/
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        /*フィルタの処理がはじめて実行されるとき
         * の処理を定義します。*/
    }

}
