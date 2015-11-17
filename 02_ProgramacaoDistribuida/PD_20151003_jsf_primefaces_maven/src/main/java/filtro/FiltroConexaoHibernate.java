package filtro;

import org.hibernate.SessionFactory;
import util.HibernateUtil;

import javax.servlet.*;
import java.io.IOException;

public class FiltroConexaoHibernate implements Filter {

    private SessionFactory sf;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.sf = HibernateUtil.getSessionFactory();
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            this.sf.getCurrentSession().beginTransaction();
            chain.doFilter(request, response);
            this.sf.getCurrentSession().getTransaction().commit();
            this.sf.getCurrentSession().close();
        } catch (Throwable e){
            try {
                if (this.sf.getCurrentSession().getTransaction().isActive()){
                    this.sf.getCurrentSession().getTransaction().rollback();
                }
            } catch (Throwable t){
                t.printStackTrace();
            }
        }
    }

    public void destroy(){
        /* destroy */
    }

}
