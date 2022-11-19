package com.green.pds.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.pds.dao.PdsDao;
import com.green.pds.vo.CommentsVo;
import com.green.pds.vo.FilesVo;
import com.green.pds.vo.PdsPagingVo;
import com.green.pds.vo.PdsVo;

import javax.swing.*;

@Repository("pdsDao")
public class PdsDaoImpl implements PdsDao {

	@Autowired
	private  SqlSession  sqlSession;
	
	@Override
	public void setWrite(HashMap<String, Object> map) {
		
		// db 정보 저장
		System.out.println("dao map:" + map);
		// Board table 에 저장
		int  bnum  = Integer.parseInt( map.get("bnum").toString() );
		if( bnum == 0  ) { //  새글   Board
			sqlSession.insert("Pds.PdsInsert",  map );
		} else {		   //  답글 쓰기  	
			sqlSession.insert("Pds.UpdateRef",  map );
			sqlSession.insert("Pds.PdsReply",   map );			
		}
		
		
	}

	@Override
	public List<PdsVo> getPdsList(HashMap<String, Object> map) {
		
		
		List<PdsVo>  pdsList =  sqlSession.selectList("Pds.PdsList", map);
		
System.out.println("김인영의pdsList:" + pdsList);
		return       pdsList;
		
	}

	@Override
		// 조회수 증가
	public PdsVo getPds(HashMap<String, Object> map) {
		sqlSession.update("Pds.ReadCountUpdate", map );
		PdsVo  pdsVo  =  sqlSession.selectOne("Pds.GetPds", map);
		map.put("totCnt", 12345);
		return pdsVo;
		
	}
	
//	@Override
//	public PdsVo getPds2(HashMap<String, Object> map) {
//		// 조회수 증가
//		sqlSession.update("Pds.ReadCountUpdate", map );
//		
//		// idx 로 게시물 조회
//		PdsVo  pdsVo  =  sqlSession.selectOne("Pds.GetPds2", map);
//		map.put("totCnt", 12345);
//		return pdsVo;
//		
//	}
	
	
	

	@Override
	public List<FilesVo> getFilesList(HashMap<String, Object> map) {
		
		List<FilesVo>  filesList   =  sqlSession.selectList("Pds.PdsFileList", map);
		return         filesList;
		
	}

	   @Override
	   public void deleteFileData(HashMap<String, Object> map) {
	      sqlSession.delete( "Pds.DeleteFiles", map );  // Files 테이블 정보 삭제(idx)
	   }
	   
	   @Override
	   public void deleteBoardData(HashMap<String, Object> map) {
	      sqlSession.delete( "Pds.DeletePds",   map );  // Board 테이블 정보 삭제(idx)
	   }

	@Override
	public void setUpdate(HashMap<String, Object> map) {
		System.out.println("고등어");
		
		// 1. Board 정보 수정
		sqlSession.update("Pds.UpdatePds", map);
		
		System.out.println("update가자:" + map);
		

		
	}

	@Override
	public void deleteUploadedFile(HashMap<String, Object> map) {
		
		sqlSession.delete("Pds.deleteUploadedFile", map);
		
	}

	@Override
	public List<PdsPagingVo> getPdsPagingList(HashMap<String, Object> map) {
		
		System.out.println("DAO getPdsPaging " + map);
	
		int                totalcount    = sqlSession.selectOne("Pds.GetTotalCount", map);
		map.put( "totalcount", totalcount);
		List<PdsPagingVo>  pdsPagingList =  sqlSession.selectList("Pds.PdsPagingList", map);
		
		return pdsPagingList;
	}

	@Override
	public void pdsInsert(PdsVo pdsVo) {
		int bnum = pdsVo.getBnum();
		if(bnum == 0) { // 새글쓰기
			sqlSession.insert("Pds.PdsInsert", pdsVo);
		} else {        // 답글 쓰기
			sqlSession.update("Pds.UpdateRef", pdsVo);
			sqlSession.insert("Pds.PdsReply",  pdsVo);
		}
		
	}

	@Override
	public int BoardImageUpload(PdsVo pdsVo) {
	return sqlSession.insert("Pds.BoardImageUpload", pdsVo);
	}

		@Override
	public int FileImageUpload(FilesVo filesVo) {
		return sqlSession.insert("Pds.FileImageUpload", filesVo);
	}

	@Override
	public int selectBoardIdx() {
		return sqlSession.selectOne("Pds.selectBoardIdx");
	}

	@Override
	public List<FilesVo> selectImage(PdsVo pdsVo) {
		return sqlSession.selectList("Pds.selectImage",pdsVo);
	}

	@Override
	public PdsVo getPds2(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<CommentsVo> getCommentsList(int board_idx) {
		List<CommentsVo> CommentsList = sqlSession.selectList("Pds.getCommentsList", board_idx);
		return CommentsList;
	}

	@Override
	public void InputComments(Map<String, Object> map) {
		sqlSession.insert("Pds.inputComments", map);
		
	}

	@Override
	public List<PdsVo> getHiBoardList(String moim_idx) {
		List<PdsVo> pdsVo = sqlSession.selectList("Pds.getHiBoardList", moim_idx);
		return pdsVo;
	}
	
	
	
}






