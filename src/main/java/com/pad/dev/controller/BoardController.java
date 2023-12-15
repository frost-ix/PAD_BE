package com.pad.dev.controller;

import java.util.*;
import java.nio.file.*;

import com.pad.dev.vo.boardVO.BoardImgCateVO;
import com.pad.dev.vo.boardVO.BoardImgVO;
import com.pad.dev.vo.boardVO.BoardVO;
import com.pad.dev.vo.cateVO.CateVO;
import com.pad.dev.vo.favVO.FavVO;
import com.pad.dev.vo.imgVO.ImgVO;

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

import com.pad.dev.service.BoardService;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
@RequestMapping("/proxy/board")
public class BoardController {
	private final BoardService bs;
	// private Path path = Paths.get("C:\\Users\\YongQ\\OneDrive\\바탕
	// 화면\\PadImages");
	private Path path = Paths.get("/images");
	// private Path localPath =
	// Paths.get("/Users/sung/Desktop/PAD_project/tempImg");

	@PostMapping("/category")
	public List<BoardImgVO> boardImgVO(@RequestBody BoardImgVO boardImgVO) {
		System.out.println(boardImgVO.getCateID());
		return bs.getCateBoard(boardImgVO);
	}

	@PostMapping("/cate")
	public List<CateVO> postMethodName() {
		return bs.getCategory();
	}

	@PostMapping("/myBoard")

	public List<BoardImgCateVO> getMyBoardVO(@RequestBody BoardImgCateVO boardImgCateVO, HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println("Start : " + boardImgCateVO.getStart());
		System.out.println("End : " + boardImgCateVO.getEnd());
		boardImgCateVO.setMemID(session.getAttribute("memID").toString());
		List<BoardImgCateVO> boardVO = bs.getMyBoardVO(boardImgCateVO);
		return boardVO;
	}

	@PostMapping("/myBoardCount")
	public int getMyBoardMax(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String member = (String) session.getAttribute("memID");
		int maxCount = bs.getMyBoardMax(member);
		return maxCount;
	}

	@PostMapping("/watch")
	public BoardImgCateVO getBoardOne(HttpServletRequest request, @RequestBody BoardVO boardVO) {
		BoardImgCateVO board = bs.getBoardOne(boardVO);
		HttpSession session = request.getSession();
		List<ImgVO> imgList = board.getImageVO();
		ArrayList<String> tempList = new ArrayList<String>();
		FavVO dum = new FavVO();
		dum.setMemID((String) session.getAttribute("memID"));
		dum.setBoardID(boardVO.getBoardID());
		FavVO favVO = bs.isFav(dum);
		Boolean tf = false;
		if (favVO != null)
			tf = true;
		board.setFavv(tf);
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAA: " + board.getFavv());
		imgList.forEach(img -> {
			String imgVO = new String();
			imgVO = img.getImagePath();
			tempList.add(path + "/" + imgVO);
		});
		board.setImagePath(tempList);

		System.out.println(board.getImageVO());

		return board;
	}

	@PostMapping("")
	public List<BoardImgCateVO> getBoardList(@RequestBody BoardImgCateVO boardImgCateVO) {
		System.out.println("start: " + boardImgCateVO.getStart());
		System.out.println("end: " + boardImgCateVO.getEnd());
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
		// Path path = Paths.get("/image/" + fileName);
		String fileName = new String();
		if (file.isEmpty()) {
			fileName = null;
		} else {
			fileName = file.getOriginalFilename();
		}
		// path = Paths.get(path + "/" + fileName);

		Path path = Paths.get("/image");
		// Path localPath = Paths.get("/Users/sung/Desktop/PAD_project/tempImg");
		path = Paths.get(path + "/" + fileName);

		String list = new String();
		ArrayList<String> imgList = new ArrayList<String>();
		try {
			byte[] bytes = file.getBytes();
			// Files.write(path, bytes);
			Files.write(path, bytes);
			System.out.println(fileName + " | " + path);
			list = fileName;
			imgList.add(list);
			System.out.println(list + " | " + imgList + " | " + option);
			return imgList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return imgList;
	}

	@PostMapping("/Write")
	public int postBoardWrite(HttpServletRequest request, @RequestBody BoardImgVO boardImgVO) {
		HttpSession session = request.getSession();
		boardImgVO.setMemID(session.getAttribute("memID").toString());
		System.out.println(boardImgVO);
		return bs.postBoard(boardImgVO);
	}

	@PostMapping("/Update")
	public int postBoardUpdate(@RequestBody BoardImgVO boardVO) {
		int boardID = bs.putBoard(boardVO);
		return boardID;
	}

	@PostMapping("/Delete")
	public int postBoardDelete(@RequestBody BoardImgVO boardVO) {
		int result = bs.deleteBoard(boardVO);
		return result;
	}

	@PostMapping("/latestBoard")
	public List<BoardImgVO> getLatestBoard() {
		System.out.println("latestBoard");
		return bs.getLatestBoard();
	}

}
