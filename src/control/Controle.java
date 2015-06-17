package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.ProdutoDao;
import entity.Produto;

/**
 * Servlet implementation class Controle
 */
@WebServlet("/Controle")
public class Controle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		if(cmd.equalsIgnoreCase("gravar")){
			gravar(request, response);
		}else if(cmd.equalsIgnoreCase("consultar")){
			consultar(request, response);
		}else if(cmd.equalsIgnoreCase("excluir")){
			excluir(request, response);
		}
	}
	
	protected void gravar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		Produto p = new Produto(null,
				request.getParameter("nome"),
				new Double		(request.getParameter("preco")),
				new Integer		(request.getParameter("quantidade")));
				p.setIdProduto	(new ProdutoDao().create(p));
				request.setAttribute("produto", p);
				
				request.getRequestDispatcher("consultar.jsp").forward(request, response);
			
		}catch(Exception e){;
		request.setAttribute("msg","Erro:" + e.getMessage());
		request.getRequestDispatcher("erro.jsp").forward(request, response);
		
		}
	}
	protected void consultar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
			List<Produto> lst = new ProdutoDao().findAll();
			request.setAttribute("registro", lst);
			request.getRequestDispatcher("consultar.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("msg", "ERRO:"+e.getMessage());
			request.getRequestDispatcher("erro.jsp").forward(request, response);
			// TODO: handle exception
		}
	}
	protected void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
				String cod[]={};
				
				
				if(request.getParameterValues("codigo")!=null){
					for (int i = 0; i < cod.length; i++) {
						cod = request.getParameterValues("codigo");
						int codigo = Integer.parseInt(cod[i]);
						new ProdutoDao().delete(codigo);;
						
					}
					request.setAttribute("msg","Codigo Excluido");
					request.getRequestDispatcher("consultar.jsp").forward(request, response);
					
				}else {
					request.setAttribute("msg","nenhum codigo digitado.");
					request.getRequestDispatcher("consultar.jsp").forward(request, response);
				}
			
			} catch (Exception e) {
				request.setAttribute("msg", "ERRO:"+e.getMessage());
				request.getRequestDispatcher("erro.jsp").forward(request, response);
				// TODO: handle exception
			}
	
	}


}
