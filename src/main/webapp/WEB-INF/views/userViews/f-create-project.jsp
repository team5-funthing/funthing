<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!doctype html>

<html class="no-js" lang="zxx">


<head>

	<jsp:include page="./include/i-head-setting.jsp"/>
	
</head>

<body>

    <jsp:include page="./include/i-popupover-mypage.jsp"/>
    <jsp:include page="./include/i-header.jsp"/>
    

    <section class="main-wrapper pt-xl-5 ">
        <div class="main-content">
            
            <div class="d-flex justify-content-center">
                <h2>개인 회원의 스튜디오</h2>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col">
                    </div>
                    <div class="col-8">
                        <div class="d-flex justify-content-center">
                            <nav>
                                <div class="nav nav-tabs" id="nav-tab" role="tablist">
                                    <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home"
                                        role="tab" aria-controls="nav-home" aria-selected="true">홈</a>
                                    <a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab" href="#nav-contact"
                                        role="tab" aria-controls="nav-contact" aria-selected="false">새소식</a>
                                    <a class="nav-item nav-link" id="nav-createProjectForm-tab" data-toggle="tab"
                                        href="#nav-createProjectForm" role="tab" aria-controls="nav-profile"
                                        aria-selected="false">프로젝트 만들기</a>
                                </div>
                            </nav>
                        </div>

                        <br>
                            <div class="tab-content" id="nav-tabContent">
                                <div class="tab-pane fade show active" id="nav-home" role="tabpanel"
                                    aria-labelledby="nav-home-tab"></div>
                                <div class="tab-pane fade" id="nav-createProjectForm" role="tabpanel"
                                    aria-labelledby="nav-createProjectForm-tab">
                                    <h3 class="mb-4">프로젝트 등록 폼</h3>
                                    <div class="row">
                                        <div class="col-3">
                                            <div class="list-group" id="list-tab" role="tablist">
                                                <a class="list-group-item list-group-item-action active" id="list-home-list"
                                                    data-toggle="list" href="#list-home" role="tab"
                                                    aria-controls="home">기본 설정</a>
                                                <a class="list-group-item list-group-item-action" id="list-profile-list"
                                                    data-toggle="list" href="#list-profile" role="tab"
                                                    aria-controls="profile">프로젝트 소개</a>
                                                <a class="list-group-item list-group-item-action" id="list-messages-list"
                                                    data-toggle="list" href="#list-messages" role="tab"
                                                    aria-controls="messages">스토리</a>
                                                <a class="list-group-item list-group-item-action" id="list-settings-list"
                                                    data-toggle="list" href="#list-settings" role="tab"
                                                    aria-controls="settings">리워드 설계</a>
                                                <a class="list-group-item list-group-item-action" id="list-introducemk-list"
                                                    data-toggle="list" href="#list-introducemk" role="tab"
                                                    aria-controls="settings">창작자 정보</a>
                                                <a class="list-group-item list-group-item-action" id="list-account-list"
                                                    data-toggle="list" href="#list-account" role="tab"
                                                    aria-controls="settings">계좌설정</a>
                                            </div>
                                            
                                            <div class="col-xl-12 mt-10 d-flex justify-items-center">
                                                <a class="btn btn-lg btn-registry-way d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3"
                                                    href="create-myProject.html">작성완료</a>
                                                    
                                            </div>
                                        </div>


                                        <div class="col-8">
                                            <div class="tab-content" id="nav-tabContent">

                                                    <!-- 프로젝트 기본설정 [ Project T ] -->
                                                    <div class="tab-pane fade show active" id="list-home" role="tabpanel"
                                                        aria-labelledby="list-home-list">
                                                        <div class="h4" style="color:black;  font-weight: bolder;">기본설정</div>
                                                        <div class="d-flex flex-column bd-highlight mb-3">
                                                        <form action="insertProject.udo" id="projectBasicForm" method="POST">
                                                            <div class="p-2 bd-highlight">
                                                                <span>창작자 | 업체명</span>
                                                                <input type="text" name="creator" placeholder="creator"
                                                                    onfocus="this.placeholder = ''"
                                                                    onblur="this.placeholder = 'First Name'"  
                                                                    class="single-input">
                                                            </div>
                                                            <div class="p-2 bd-highlight">
                                                                <span>이메일</span>
                                                                <input type="text" name="email" placeholder="email"
                                                                    onfocus="this.placeholder = ''"
                                                                    onblur="this.placeholder = 'First Name'"  
                                                                    class="single-input">
                                                            </div>
                                                            
                                                            <div class="p-2 bd-highlight">
                                                                <span>개인 정보 수집 동의</span><br>
                                                                <span>(선택)funThing의 유용한 뉴스레터 받기</span>
                                                            </div>
                                                            <div class="col-xl-12 mt-10 d-flex justify-content-center">
                                                                <a class="btn btn-lg btn-registry-way d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3"
                                                                    href="#" onclick="document.getElementById('projectBasicSettingForm').submit();" >저장하기</a>
                                                            </div>
                                                        </form>    
                                                    </div>
                                                </div>
                                                
                                                
                                                <!-- 프로젝트 소개 [ Project T ] -->
                                                <div class="tab-pane fade" id="list-profile" role="tabpanel"
                                                    aria-labelledby="list-profile-list">
                                                    <div class="h4" style="color:black;  font-weight: bolder;">프로젝트 소개</div>
                                                    <div class="d-flex flex-column bd-highlight mb-3">
                                                        <form action="insertProject.udo" id="projectIntroduceForm" method="POST">
                                                        	<div class="p-2 bd-highlight">
                                                                <span>펀딩 목표 금액</span>
                                                                <input type="text" name="goalMoney" placeholder="펀딩 목표 금액을 입력하세요." onfocus="this.placeholder = ''" onblur="this.placeholder = '펀딩 목표 금액을 입력하세요.'" class="single-input">
                                                            </div>
                                                            <div class="p-2 bd-highlight">
                                                                <span>프로젝트 제목</span>
                                                                <input type="text" name="projectTitle" placeholder="프로젝트 제목을 입력해주세요!" onfocus="this.placeholder = ''" onblur="this.placeholder = '프로젝트 제목을 입력해주세요!'" class="single-input">
                                                            </div>
                                                            <div class="p-2 bd-highlight">
                                                                <span>프로젝트 소제목</span>
                                                                <input type="text" name="projectSubTitle" placeholder="소제목을 입력해주세요!" onfocus="this.placeholder = ''" class="single-input">
                                                            </div>
                                                            <div class="p-2 bd-highlight">
                                                                <span>프로젝트 대표 이미지</span>
                                                                <div class="input-group mb-3">
                                                                    <div class="form-group">
                                                                        <label for="projectMainImageFile">대표 이미지 선택하기</label>
                                                                        <!-- <input type="file" name="projectMainImage" class="form-control-file select-project-image" id="projectMainImageFile"> -->
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="p-2 bd-highlight">
                                                                <span>프로젝트 분류</span>
                                                            </div>
                                                            <div class="p-2 bd-highlight">
                                                                <span>프로젝트 기간 설정</span>
                                                            </div>
                                                            <div class="p-2 bd-highlight">
                                                                <span>검색용 태그* </span>
                                                            </div>
                                                            <div class="p-2 bd-highlight">
                                                                <span>개인 정보 수집 동의</span><br>
                                                                <span>(선택)funThing의 유용한 뉴스레터 받기</span>
                                                            </div>
                                                            <div class="col-xl-12 mt-10 d-flex justify-content-center">
                                                                <a class="btn btn-lg btn-registry-way d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3"
                                                                    href="#" onclick="document.getElementById('projectIntroduceForm').submit();" >저장하기</a>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>

                                                <!-- 스토리 작성 [ Project T ] -->
                                                <div class="tab-pane fade" id="list-messages" role="tabpanel"
                                                    aria-labelledby="list-messages-list">
                                                    <div class="h4" style="color:black;  font-weight: bolder;">스토리 작성</div>
                                                    <form action="insertProject.udo" id="projectStoryForm" method="POST">
                                                        <div class="p-2 bd-highlight">
                                                            <span>소개 컨텐츠 [영상]</span>
                                                            <div class="input-group mb-3">
                                                                <div class="form-group">
                                                                    <label for="exampleFormControlFile1">소개 컨텐츠를 선택하세요.(영상)</label>
                                                                    <input type="file" name="" class="form-control-file select-project-image" id="exampleFormControlFile1">
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="p-2 bd-highlight">
                                                            <span>프로젝트 요약</span>
                                                            <div class="form-group">
                                                                <label for="exampleFormControlTextarea1">프로젝트에 대해 간략하게 설명해주세요.</label>
                                                                <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                                                            </div>
                                                        </div>
                                                        <div class="p-2 bd-highlight">
                                                            <span>오픈 예정 프로젝트 설정 []</span>
                                                            <p>오픈예정 서비스를 이용하면 프로젝트를 오픈하기 전, 미리 서포터에게 알림·홍보할 수 있으며 펀딩 성공에 도움을 줄 수
									                                                                있습니다. 오픈예정 서비스를 신청한다면 누구나 오픈예정 서비스를 이용하실 수 있습니다. 지금 바로 신청해보세요!
									                                                                오픈예정 서비스 신청하러 가기
			                                                </p>
                                                        </div>
                                                        <div class="col-xl-12 mt-10 d-flex justify-content-center">
                                                            <a class="btn btn-lg btn-registry-way d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3"
                                                                href="#" onclick="document.getElementById('projectStoryForm').submit();" >저장하기</a>
                                                        </div>
                                                    </form>
                                                </div>

                                                <!-- 펀딩 안내 [ Reward T ]-->
                                                <div class="tab-pane fade" id="list-settings" role="tabpanel"
                                                    aria-labelledby="list-settings-list">
                                                    
                                                    <div class="h4" style="color:black;  font-weight: bolder;">리워드 설계</div>                                            
                                                    <div class="p-2 bd-highlight">
                                                        <span>펀딩 안내</span>
                                                    </div>
                                                    <div class="p-2 bd-highlight">
                                                        <span>환불 및 교환 정책</span>
                                                    </div>
                                                    <div class="p-2 bd-highlight">
                                                        <span> 상품 정보 고시 [상품 분류] </span>
                                                        <p></p>
                                                    </div>
                                                    <div class="p-2 bd-highlight">
                                                        <span> 인증 서류 제출 [파일 업로드 ]</span>
                                                    </div>
                                                    <div class="col-xl-12 mt-10 d-flex justify-content-center">
                                                        <a class="btn btn-lg btn-registry-way d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3"
                                                            href="create-myProject.html">저장하기</a>
                                                    </div>
                                                </div>

                                                <!-- 창작자 설정-->
                                                <div class="tab-pane fade" id="list-introducemk" role="tabpanel"
                                                    aria-labelledby="list-introducemk-list">
                                                    <div class="h4" style="color:black;  font-weight: bolder;">창작자 설정[ 프로젝트 진행자 상세 설정 ]</div>
                                                    <div class="p-2 bd-highlight">
                                                        <span>창작자명 or 업체명?[기본적으로 닉네임이나 변경 가능]</span>
                                                    </div>
                                                    <div class="p-2 bd-highlight">
                                                        <span>창작자 프로필</span>
                                                    </div>
                                                    <div class="p-2 bd-highlight">
                                                        <span> 함께 하는 멤버 [회원 검색 기능] </span>
                                                        <p></p>
                                                    </div>
                                                    <div class="p-2 bd-highlight">
                                                        <span> 문의 이메일</span>
                                                    </div>

                                                    <div class="p-2 bd-highlight">
                                                        <span> 기타 홈페이지 카톡채널 SNS</span>
                                                    </div>
                                                    <div class="p-2 bd-highlight">
                                                        <span> 업체일 경우</span>
                                                        <p>대표자 정보 사업자 구분 통장사본 대표자명 대표자 이메일 공동대표자 등등등등등</p>
                                                    </div>
                                                    <div class="col-xl-12 mt-10 d-flex justify-content-center">
                                                        <a class="btn btn-lg btn-registry-way d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3"
                                                            href="create-myProject.html">저장하기</a>
                                                    </div>
                                                </div>


                                                <div class="tab-pane fade" id="list-account" role="tabpanel"
                                                    aria-labelledby="list-account-list">
                                                    <h3>계좌 설정</h3>
                                                    <div class="p-2 bd-highlight">
                                                        <span>본인 인증 [넣어 말어]</span>
                                                    </div>
                                                    <div class="p-2 bd-highlight">
                                                        <span>환불 및 교환 정책</span>
                                                    </div>
                                                    <div class="p-2 bd-highlight">
                                                        <span>입금 계좌</span>
                                                    </div>
                                                    <div class="p-2 bd-highlight">
                                                        <span>세금 계산서 발행</span>
                                                    </div>
                                                    <div class="col-xl-12 mt-10 d-flex justify-content-center">
                                                        <a class="btn btn-lg btn-registry-way d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3"
                                                            href="create-myProject.html">저장하기</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="tab-pane fade" id="nav-contact" role="tabpanel"
                                    aria-labelledby="nav-contact-tab">...</div>
                            </div>
                    </div>
                    <div class="col">
                    </div>
                </div>
            </div>
        </div>
    </section>



    <jsp:include page="./include/i-footer.jsp"></jsp:include>
    <jsp:include page="./include/i-popup-login.jsp"></jsp:include>
	<jsp:include page="./include/i-popup-search.jsp"></jsp:include>
    <jsp:include page="./include/i-body-js.jsp"></jsp:include>


</body>

</html>