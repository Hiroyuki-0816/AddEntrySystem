package Bean;
import java.io.Serializable;

/*検索結果を取得するためのBeanクラス*/
public class JobBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/*職業ID*/
	private int id;
	
	/*職業名*/
	private String job;
	
	/*コンストラクタ*/
	public JobBean() {
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getJob() {
		return job;
	}
	
	public void setJob(String job) {
		this.job = job;
	}
	
}
