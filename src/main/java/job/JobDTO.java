package job;

import java.io.Serializable;
import java.util.ArrayList;

/*職業マスタの内容を保持するクラス*/

public class JobDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	/*JobBeanクラスのオブジェクトが格納されている*/
	private ArrayList<JobBean> jlist; 
	
	/*ArrayListを新規作成*/
	public JobDTO() {
		jlist = new ArrayList<JobBean>();
	}
	
	/*ArrayListにオブジェクトを格納する*/
	public void add(JobBean jb) {
		jlist.add(jb);
	}
	
	/*ArrayListに対してgetメソッドを取得*/
	public JobBean get(int i) {
		return jlist.get(i);
	}
	
	/*ArrayListに対してデータの個数を格納*/
	public int size() {
		return jlist.size();
	}
}


