package com.pad.dev.controller;

import java.util.*;
import java.nio.file.*;

import com.pad.dev.vo.boardVO.BoardImgCateVO;
import com.pad.dev.vo.boardVO.BoardImgVO;
import com.pad.dev.vo.boardVO.BoardVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pad.dev.serviceImpl.BoardServiceImple;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
@RequestMapping("/proxy/board")
public class BoardController {
	private final BoardServiceImple bs;

	@PostMapping("/category")
	public void postMethodName(@RequestBody String dump) {
		// TODO: process POST request

	}

	@PostMapping("/myBoard")
	public List<BoardImgVO> getMyBoardVO(@RequestBody BoardImgVO boardImgVO, HttpServletRequest request) {
		HttpSession session = request.getSession();
		int currentBoardID = boardImgVO.getCurrentBoardID();
		String member = (String) session.getAttribute("memID");
		List<BoardImgVO> boardVO = bs.getMyBoardVO(currentBoardID, member);
		return boardVO;
	}

	@PostMapping("/myBoardCount")
	public int getMyBoardMax(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String member = (String) session.getAttribute("memID");
		int maxCount = bs.getMyBoardMax(member);
		return maxCount;
	}

	/***
	 * <h2>R : read one board</h2>
	 * 
	 * @author Frost-ix
	 * @apiNote
	 *          <p>
	 *          resource path : /board/{boardID}
	 *          </p>
	 * @param boardVO : One board's article id.
	 */
	@PostMapping("/watch")
	public BoardImgCateVO getBoardOne(@RequestBody BoardVO boardVO) {
		BoardImgCateVO board = bs.getBoardOne(boardVO);
		return board;
	}

	/***
	 * <h2>R : read all boards</h2>
	 * 
	 * @author Frost-ix
	 * @apiNote
	 *          resource path : /board
	 */
	@PostMapping("")
	public List<BoardImgCateVO> getBoardList(@RequestBody BoardImgCateVO boardImgCateVO) {
		List<BoardImgCateVO> boardList = bs.getThumbnailList(boardImgCateVO);
		return boardList;
	}

	@PostMapping("/count")
	public int getBoardMax() {
		int maxCount = bs.getBoardMax();
		return maxCount;
	}

	@ResponseBody
	@PostMapping("/image")
	public ArrayList<String> getBoardImage(HttpServletRequest req, HttpServletResponse res,
			@RequestPart("file") MultipartFile file,
			@RequestPart("option") String option) {
		res.setCharacterEncoding("UTF-8");
		res.setContentType("application/json; charset=UTF-8");
		String fileName = file.getOriginalFilename();
		// Path path = Paths.get("/image/" + fileName);
		Path path = Paths.get("/Users/sung/Desktop/PAD_project/tempImg/" + fileName);
		ArrayList<String> list = new ArrayList<String>();
		try {
			if (option.equals("upload")) {
				byte[] bytes = file.getBytes();
				Files.write(path, bytes);
				System.out.println(fileName + " | " + path);
				list.add("imgName");
				list.add("delete");
				return list;
			} else {
				Files.delete(path);
				list.add("upload");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/***
	 * <h2>C : Create Board</h2>
	 * 
	 * @apiNote
	 *          resource path : /board/write
	 */
	@PostMapping("/Write")
	public int postBoardWrite(@RequestBody BoardImgVO boardImgVO, HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println(boardImgVO + " | " + session.getAttribute("Member"));
		boardImgVO.setMemID(session.getAttribute("memID").toString());
		return bs.postBoardWrite(boardImgVO);
	}

	@PostMapping("/Update")
	public int postBoardUpdate(@RequestBody BoardImgVO boardVO) {
		int boardID = bs.postBoardUpdate(boardVO);
		return boardID;
	}

	@PostMapping("/Delete")
	public int postBoardDelete(@RequestBody BoardImgVO boardVO) {
		int result = bs.postBoardDelete(boardVO);
		return result;
	}

}
