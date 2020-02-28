<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 검색 폼 -->
    <form id="search-popup" class="white-popup-block mfp-hide">
        <div class="popup_box ">
            <div class="popup_inner">
                <aside class="single_sidebar_widget search_widget">
                    <form action="#">
						<div class="row d-flex justify-content-center">
							<div class="row d-flex align-content-between flex-wrap mt-5">
								<div class="col-xl-12 d-flex bd-highlight mb-1">
									<ul id="addedKeywords">
										<c:set var="tag" value="#" />
										<c:set var="keywordId" value="keyword" />
			
										<c:choose>
											<c:when test="${previewProjectKeywordList eq null }">
											</c:when>
											<c:when test="${previewProjectKeywordList ne null }">
											
												<c:forEach var="previewProjectKeyword"
													items="${previewProjectKeywordList }" varStatus="step">
													<li id="${keywordId }${step.count}"
														class="btn-sm btn-bd-keyword d-none d-lg-inline-block m-1">
														<a href="javascript:void(0);" class="addedKeyword">${previewProjectKeyword.keyword }</a>
													</li>
												</c:forEach>
												
											</c:when>
										</c:choose>
									</ul>
									
									<script>
								         $(function (){
								        	 $(".addedKeyword").removeAttr("href")
								      
									     });
									</script>
									
								</div>
							</div>
						</div>

                    

                    
                        <div class="form-group">
                            <div class="input-group mb-3">
                                <input type="text" class="form-control" placeholder='찾으시는 프로젝트가 있으신가요?'
                                    onfocus="this.placeholder = ''" onblur="this.placeholder = '검색어를 입력해 주세요.'">
                                <div class="input-group-append">
                                    <button class="btn" type="button"><i class="ti-search"></i></button>
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <aside class="single_sidebar_widget post_category_widget">
                                    <h4 class="widget_title">인기 검색어</h4>
   
                                </aside>
                                <aside class="single_sidebar_widget tag_cloud_widget">
                                    <h4 class="widget_title">Tag Clouds</h4>
                                    <ul class="list">
                                        <li>
                                            <a href="#" class="genric-btn primary small tag-keyword">#여긴 어디</a>
                                        </li>
                                        <li>
                                            <a href="#" class="genric-btn info small tag-keyword">#여긴 어디</a>
                                        </li>
                                        <li>
                                            <a href="#" class="genric-btn primary small tag-keyword">#나는 누구</a>
                                        </li>
                                        <li>
                                            <a href="#" class="genric-btn info small tag-keyword">#여긴 어디</a>
                                        </li>
                                        <li>
                                            <a href="#" class="genric-btn primary small tag-keyword">#나는 어디</a>
                                        </li>
                                        <li>
                                            <a href="#" class="genric-btn primary small tag-keyword">#여긴 누구</a>
                                        </li>
                                    </ul>
                                </aside>
                            </div>
                        </div>
                    </form>
                </aside>
            </div>
        </div>
    </form>
    <!-- 검색폼 end -->