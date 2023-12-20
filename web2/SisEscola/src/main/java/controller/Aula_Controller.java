package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AulaDAO;
import model.Aula;

@WebServlet("/aula")
public class Aula_Controller extends HttpServlet {


	private static final long serialVersionUID = 1L;
	private AulaDAO aulaDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        // Inicializa o DAO aqui (pode ser feito usando um framework de injeção de dependência)
        aulaDAO = new AulaDAO(null);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("acao");

        if ("cadastrar".equals(acao)) {
            cadastrarAula(request, response);
        } else {
            // Trate outras ações conforme necessário
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("acao");

        if ("listar".equals(acao)) {
            listarAulasPorDisciplina(request, response);
        } else {
            // Trate outras ações conforme necessário
        }
    }

    private void cadastrarAula(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtenha os parâmetros do formulário
        String dataStr = request.getParameter("data");
        Date data = null;

        // Converta a string de data para um objeto Date (você pode precisar ajustar isso)
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            data = dateFormat.parse(dataStr);
        } catch (ParseException e) {
            e.printStackTrace(); // Lide com a exceção conforme necessário
            response.sendRedirect(request.getContextPath() + "/erro.jsp");
            return;
        }

        // Outros parâmetros podem ser obtidos aqui conforme necessário

        // Crie um objeto Aula com os parâmetros
        Aula aula = new Aula (data);

        // Chame o DAO para cadastrar a aula
        aulaDAO.cadastrarAula(aula);

        // Encaminhe para uma página de confirmação ou outra página apropriada
        response.sendRedirect(request.getContextPath() + "/confirmacao.jsp");
    }

    private void listarAulasPorDisciplina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Chame o DAO para obter a lista de aulas
        List<Aula> aulas = aulaDAO.listarAulasPorDisciplina(null);

        // Armazene a lista de aulas no escopo da requisição para uso na JSP
        request.setAttribute("aulas", aulas);

        // Encaminhe para a página de listagem de aulas (pode ser uma JSP)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listagemAulas.jsp");
        dispatcher.forward(request, response);
    }
}