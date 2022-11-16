package com.green.pds.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.pds.dao.PdsDao;
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
		
		// Files 테이블에 저장
		List<FilesVo>  filesList   = (List<FilesVo>) map.get("filesList");
		System.out.println(filesList.size());
		if(filesList.size() > 0) {
			sqlSession.insert("Pds.FileInsert", map);   // 파일정보 저장
	    }
		
	}

	@Override
	public List<PdsVo> getPdsList(HashMap<String, Object> map) {
		
		
		List<PdsVo>  pdsList =  sqlSession.selectList("Pds.PdsList", map);
		
		System.out.println("김인영" + pdsList);
		return       pdsList;
		
	}

	@Override
	public PdsVo getPds(HashMap<String, Object> map) {
		
		PdsVo  pdsVo  =  sqlSession.selectOne("Pds.GetPds", map);
		return pdsVo;
		
	}

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
		
		// 2. Files 에 추가된 파일 정보 저장		
		List<FilesVo> filesList = (List<FilesVo>) map.get("filesList") ;
		if( !filesList.isEmpty() ) 
			sqlSession.insert("Pds.FileInsert", map);   // 파일정보 저장		    

		
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
}






