package com.green.pds.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.green.pds.vo.CommentsVo;
import com.green.pds.vo.FilesVo;
import com.green.pds.vo.PdsPagingVo;
import com.green.pds.vo.PdsVo;

public interface PdsService {

	void setWrite(HashMap<String, Object> map, HttpServletRequest request);

	List<PdsVo> getPdsList(HashMap<String, Object> map);

	PdsVo getPds(HashMap<String, Object> map);
	
	PdsVo getPds2(HashMap<String, Object> map);

	List<FilesVo> getFilesList(HashMap<String, Object> map);

	void boardDelete(HashMap<String, Object> map);

	void setUpdate(HashMap<String, Object> map);

	void deleteUploadedFile(HashMap<String, Object> map);

	List<PdsPagingVo> getPdsPagingList(HashMap<String, Object> map);

	void pdsInsert(PdsVo pdsVo);
	
	void ImageUpload(PdsVo pdsVo,String imageFileName);

	List<FilesVo>  selectImage (PdsVo pdsVo);

	void setWrite(HashMap<String, Object> map);
	
	List<CommentsVo> getCommentsList(int board_idx);

	void InputComments(Map<String, Object> map);

	List<PdsVo> getHiBoardList(String moim_idx);
}
