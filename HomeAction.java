package com.internousdev.radish.action;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.radish.dao.MCategoryDAO;
import com.internousdev.radish.dto.MCategoryDTO;
import com.internousdev.radish.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{
	private Map<String, Object>session;

	public String execute(){
		if(!session.containsKey("logined")){		/*ログインフラグを所持確認*/
			session.put("logined", 0);
		}
		String tempLogined=String.valueOf(session.get("logined"));		/*tempLoginedに入れる*/
		int logined="null".equals(tempLogined)? 0 : Integer.parseInt(tempLogined); /**/
		if(!session.containsKey("tempUserId")&&logined==0){
			CommonUtility utility =new CommonUtility();				/*仮ユーザーIDをランダム生成する(CommoｎUtility)からRandomValueを持ってきている*/

			session.put("tempUserId", utility.getRamdomValue());
		}

		if(!session.containsKey("mCategoryDTOList")) {
			List<MCategoryDTO> mCategoryDTO = new ArrayList<MCategoryDTO>();
			MCategoryDAO mCategoryDAO = new MCategoryDAO();
			mCategoryDTO = mCategoryDAO.getMCategoryList();

			session.put("mCategoryDTOList", mCategoryDTO);
		}
		return SUCCESS;
	}
	public Map<String,Object>getSession(){
		return session;
	}
	public void setSession(Map<String,Object>session){
		this.session=session;
	}

}