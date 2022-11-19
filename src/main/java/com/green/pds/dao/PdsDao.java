package com.green.pds.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.green.pds.vo.CommentsVo;
import com.green.pds.vo.FilesVo;
import com.green.pds.vo.PdsPagingVo;
import com.green.pds.vo.PdsVo;

public interface PdsDao {

	void setWrite(HashMap<String, Object> map);

	List<PdsVo> getPdsList(HashMap<String, Object> map);

	PdsVo getPds(HashMap<String, Object> map);

	List<FilesVo> getFilesList(HashMap<String, Object> map);

	void deleteFileData(HashMap<String, Object> map);

	void deleteBoardData(HashMap<String, Object> map);

	void setUpdate(HashMap<String, Object> map);

	void deleteUploadedFile(HashMap<String, Object> map);

	List<PdsPagingVo> getPdsPagingList(HashMap<String, Object> map);

	void pdsInsert(PdsVo pdsVo);

	int BoardImageUpload(PdsVo pdsVo);
	
	int FileImageUpload (FilesVo filesVo);

	int selectBoardIdx();

	List<FilesVo>  selectImage (PdsVo pdsVo);
	
	PdsVo getPds2(HashMap<String, Object> map);
	
	List<CommentsVo> getCommentsList(int board_idx);

	void InputComments(Map<String, Object> map);

	List<PdsVo> getHiBoardList(String moim_idx);
	
}
