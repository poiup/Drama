package kr.co.drama;

public class drama_commentDTO {
	private int comtCount; // 전체 글
	private int currentPage; // 현재 페이지
	private int totalPages; // 전체 페이지
	private	int startPage; // 시작 페이지
	private int endPage; // 끝 페이지
	private static final int NAV_NUM = 5; // 하단에 깔 버튼
	private static final int COMT_NUM = 5; // 댓글 5개씩 표시
	
	public drama_commentDTO(int comtCount, int currentPage) {
		
		this.comtCount = comtCount;
		this.currentPage = currentPage;
		
		if(comtCount == 0) {
			this.totalPages = 0;
			this.startPage = 0;
			this.endPage = 0;	
		} else {
			
			if(comtCount % COMT_NUM == 0) {
				// 전체 글 개수 % 10이 0으로 떨어짐 => 10의 배수 갯수로 페이지 갯수는 10을 나눈 결과값
				totalPages = comtCount / COMT_NUM;
			} else {
				totalPages = (comtCount / COMT_NUM) + 1;
			} 
			
			// <<현재 조회중인 페이지 그룹의 시작 페이지 구하기(startPage값 구하기)>>
			// * 시작, 끝 페이지는 게시글이 아닌 아래 깔릴 페이지 버튼이므로 NAV_NUM을 사용합니다.
			int navNum = 0; //식별번호
			if(currentPage % NAV_NUM == 0) {
				// 10번대 페이지는 자신이 속한 그룹보다 페이지 식별숫자가 1 크게 나옴.
				navNum = (currentPage - 1) / NAV_NUM; // (50번 페이지의 경우 41~50그룹에 속하므로 실제로는 4가 나와야 하므로)
			} else {
				navNum = currentPage / NAV_NUM; // (51페이지 -1 / 10 해도 5가 나옴, 50 - 1 / 10하면 4가 나옴.)
			}
			// (navNum = currentPage - 1) / 10;
			
			// 식별번호 navNum이 구해졌으면 * 10 + 1을 해서 시작번호를 구합니다.
			startPage = (navNum * NAV_NUM) + 1;
			
			// <<현재 조회중인 페이지 그룹의 끝페이지 구하기 (endPage값 구하기)>>
			endPage = startPage + (NAV_NUM - 1);
			if(endPage > totalPages) {
				endPage = totalPages;
			}
			// endPage = Math.min(startPage + (NAV_NUM - 1), totalPages);
			// endPage = (startPage + (NAV_NUM - 1) > totalPages) ? totalPages : (startPage + (10 - 1);
		}
	}// 생성자 닫는 부분
	
	public int getComtCount() {
		return comtCount; // 총 글 개수
	}
	
	// 밑에 버튼을 깔지 말지를 결정하기 위한 bool 자료형
	public boolean hasNoBoard() {
		return comtCount == 0; // 표시할 게시물이 없으면 버튼도 깔 필요 없음
	}
	
	public boolean hasBoard() {
		return comtCount > 0; // 표시할 게시물이 있다면 버튼을 깔아줘야함
	}
	
	// 페이지의 총 개수를 알려주는 getter
	public int getTotalPages() {
		return totalPages;
	}
	
	// 해당 페이지 그룹의 시작페이지
	public int getStartPage() {
		return startPage;
	}
	
	// 해당 페이지 그룹의 끝 페이지
	public int getEndPage() {
		return endPage;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}


	@Override
	public String toString() {
		return "drama_commentDTO [comtCount=" + comtCount + ", currentPage=" + currentPage + ", totalPages="
				+ totalPages + ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}

}
