package com.topvel.comment.model;

public class PaginationInfo {

  private int currentPageNo = 1;
  private int recordCountPerPage = 10;
  private int pageSize = 10;
  private int totalRecordCount;
  
  private int startRecord = 0;

  public int getRecordCountPerPage() {
    return recordCountPerPage;
  }

  public void setRecordCountPerPage(int recordCountPerPage) {
    this.recordCountPerPage = recordCountPerPage;
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public int getCurrentPageNo() {
    return currentPageNo;
  }

  public void setCurrentPageNo(int currentPageNo) {
    this.currentPageNo = currentPageNo;
  }

  public void setTotalRecordCount(int totalRecordCount) {
    this.totalRecordCount = totalRecordCount;
  }

  public int getTotalRecordCount() {
    return totalRecordCount;
  }

  public int getStartRecord() {
	// 페이지 조회를 위한 시작 페이지 번호 
	if(this.currentPageNo == 0) {
		return startRecord;
	}
	else {
		return (this.currentPageNo-1) * this.recordCountPerPage;  
	}
  }


  private int totalPageCount;
  private int firstPageNoOnPageList;
  private int lastPageNoOnPageList;
  private int firstRecordIndex;
  private int lastRecordIndex;

  public int getTotalPageCount() {
    totalPageCount = ((getTotalRecordCount() - 1) / getRecordCountPerPage()) + 1;
    return totalPageCount;
  }

  public int getFirstPageNo() {
    return 1;
  }

  public int getLastPageNo() {
    return getTotalPageCount();
  }

  public int getFirstPageNoOnPageList() {
    firstPageNoOnPageList = ((getCurrentPageNo() - 1) / getPageSize()) * getPageSize() + 1;
    return firstPageNoOnPageList;
  }

  public int getLastPageNoOnPageList() {
    lastPageNoOnPageList = getFirstPageNoOnPageList() + getPageSize() - 1;
    if (lastPageNoOnPageList > getTotalPageCount()) {
      lastPageNoOnPageList = getTotalPageCount();
    }
    return lastPageNoOnPageList;
  }

  public int getFirstRecordIndex() {
    firstRecordIndex = (getCurrentPageNo() - 1) * getRecordCountPerPage();
    return firstRecordIndex;
  }

  public int getLastRecordIndex() {
    lastRecordIndex = getCurrentPageNo() * getRecordCountPerPage();
    return lastRecordIndex;
  }
}
