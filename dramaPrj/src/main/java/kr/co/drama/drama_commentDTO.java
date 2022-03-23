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
				totalPages = comtCount / COMT_NUM;
			} else {
				totalPages = (comtCount / COMT_NUM) + 1;
			} 
			
			int navNum = 0; 
			if(currentPage % NAV_NUM == 0) {
				navNum = (currentPage - 1) / NAV_NUM; 
			} else {
				navNum = currentPage / NAV_NUM; 
			}
		
			startPage = (navNum * NAV_NUM) + 1;
			
			endPage = startPage + (NAV_NUM - 1);
			if(endPage > totalPages) {
				endPage = totalPages;
			}
		}
	}
	
	public int getComtCount() {
		return comtCount; 
	}
	
	public boolean hasNoBoard() {
		return comtCount == 0; 
	}
	
	public boolean hasBoard() {
		return comtCount > 0; 
	}
	
	public int getTotalPages() {
		return totalPages;
	}
	
	public int getStartPage() {
		return startPage;
	}
	
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
