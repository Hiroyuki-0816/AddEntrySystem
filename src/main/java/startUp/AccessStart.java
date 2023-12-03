package startUp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import job.JobDAO;
import job.JobDTO;

import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class AccessStart
 */
@WebServlet("/AccessStart")
public class AccessStart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 職業マスタから職業名を取得する*/
		/*DAOオブジェクトを生成*/
		JobDAO jdao = new JobDAO();
		/*全件検索した結果をDTOオブジェクトとして取得*/
		JobDTO jdto = jdao.select();
		/*検索結果をリクエストスコープに格納*/
		request.setAttribute("jdto",jdto);
		/*JSPにフォワード*/
		RequestDispatcher rd = request.getRequestDispatcher("/Search.jsp");
        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

}
