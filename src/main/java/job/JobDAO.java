package job;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//職業マスタの一覧を取得するためのクラス
public class JobDAO{
	
	public static void main(String args[]) {
		/*データベースのURL*/
		final String url = "jdbc:mysql://localhost:3306/t_address";
		/*DBにアクセスするユーザ*/
		final String user = "root";
		/*パスワード*/
		final String pass = "F4akyz3C";
		/*DBから職業を取得するSQL文*/
		final String sql = "select job from t_address.m_job;";
		/*接続先情報*/
		Connection con = null;
		/*ステートメント*/
		Statement st = null;
		/*検索結果*/
		ResultSet rs = null;
		
		try {
			/*JDBCドライバの読み込み*/
			Class.forName("com.mysql.cj.jdbc.Driver");
			/*DB接続*/
			con = DriverManager.getConnection(url,user,pass);
			/*ステートメント生成*/
			st = con.createStatement();
			/*検索結果を格納*/
			rs = st.executeQuery(sql);
			/*検索結果を出力*/
			while(rs.next()) {
				System.out.println(rs.getString("job"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {//必ず実行する
			try {
				//リソースを開放する
				if(rs != null) {
					rs.close();
				}
				if(st != null) {
					st.close();
				}
				if(con != null) {
					con.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
}
}