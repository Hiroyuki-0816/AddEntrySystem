package job;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

	//職業マスタの一覧を取得するためのクラス
	public class JobDAO{
		/*データベースのURL*/
		private final String url = "jdbc:mysql://localhost:3306/AddEntryDB";
		/*DBにアクセスするユーザ*/
		private final String user = "root";
		/*パスワード*/
		private final String pass = "password";
		/*DBから職業を取得するSQL文*/
		private final String sql = "select * from t_address.m_job;";
		/*接続先情報*/
		Connection con = null;
		/*ステートメント*/
		Statement st = null;
		/*検索結果*/
		ResultSet rs = null;
		/*検索結果転送用オブジェクト*/
		JobDTO jdto = new JobDTO();
		
		/*DBに接続するためのメソッド*/
		public void connect() {
			try {
				/*JDBCドライバの読み込み*/
				Class.forName("com.mysql.cj.jdbc.Driver");
				/*DB接続*/
				con = DriverManager.getConnection(url,user,pass);
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
		
		public JobDTO select() {
			try {
				connect();
				/*ステートメント生成*/
				st = con.createStatement();
				
				/*検索結果を格納*/
				rs = st.executeQuery(sql);
				
				/*検索結果を出力*/
				while(rs.next()) {
					JobBean jb = new JobBean();
					jb.setId(rs.getInt("id"));
					jb.setJob(rs.getString("job"));
					jdto.add(jb);				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(rs != null) {
						rs.close();
					}
					if(st != null) {
						st.close();
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			disconnect();
			return jdto;
		}
		
		public void disconnect() {
			try {
				/*DBを切断*/
				if(con != null) {
					con.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

