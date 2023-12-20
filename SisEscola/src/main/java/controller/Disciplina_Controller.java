package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DisciplinasDAO;
import model.Disciplina;
@WebServlet("/disciplina")
public class Disciplina_Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private DisciplinasDAO disciplinaDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        // Inicializa o DAO aqui (pode ser feito usando um framework de injeção de dependência)
        setDisciplinaDAO(new DisciplinasDAO());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("acao");

        if ("cadastrar".equals(acao)) {
            cadastrarDisciplina(request, response);
        } else {
            // Trate outras ações conforme necessário
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("acao");

        if ("listar".equals(acao)) {
            listarDisciplinas(request, response);
        } else {
            // Trate outras ações conforme necessário
        }
    }

    private void cadastrarDisciplina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtenha os parâmetros do formulário
    	String codigo = request.getParameter("codigo");
        String nome = request.getParameter("nome");
        String professor = request.getParameter("professor");

        // Crie um objeto Disciplina com os parâmetros
        Disciplina disciplina = new Disciplina(codigo, nome, professor);

        // Chame o DAO para cadastrar a disciplina
        DisciplinasDAO.cadastrarDisciplina(disciplina);

        // Encaminhe para uma página de confirmação ou outra página apropriada
        response.sendRedirect(request.getContextPath() + "/confirmacao.jsp");
    }

    private void listarDisciplinas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Chame o DAO para obter a lista de disciplinas
        List<Disciplina> disciplinas = DisciplinasDAO.listarDisciplinas();

        // Armazene a lista de disciplinas no escopo da requisição para uso na JSP
        request.setAttribute("disciplinas", disciplinas);

        // Encaminhe para a página de listagem de disciplinas (pode ser uma JSP)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listagemDisciplinas.jsp");
        dispatcher.forward(request, response);
    }

	public DisciplinasDAO getDisciplinaDAO() {
		return disciplinaDAO;
	}

	public void setDisciplinaDAO(DisciplinasDAO disciplinaDAO) {
		this.disciplinaDAO = disciplinaDAO;
	}
}