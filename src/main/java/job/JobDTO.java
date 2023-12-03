package job;

import java.io.Serializable;

/*職業マスタの内容を保持するクラス*/

public class JobDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String job;
	
	//コンストラクタ
    public JobDTO(){
    	
    }

	/*jobの内容を取得する*/
	public String getJob() {
		return job;
	}
	
	/*jobを設定する*/
	public void setJob(String job) {
		this.job = job;
	}
}


