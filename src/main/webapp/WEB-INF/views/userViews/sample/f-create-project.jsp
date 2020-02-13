<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="zxx">

<head>

    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Montana</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- <link rel="manifest" href="site.webmanifest"> -->
    <link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">
    <!-- Place favicon.ico in the root directory -->

    <!-- CSS here -->
    <link rel="stylesheet" href="css/jquery.gpopover.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/themify-icons.css">
    <link rel="stylesheet" href="css/nice-select.css">
    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/gijgo.css">
    <link rel="stylesheet" href="css/animate.css">
    <link rel="stylesheet" href="css/slicknav.css">
    <link rel="stylesheet" href="css/style.css">

    <link rel="stylesheet" href="css/bootstrap.min.css">

    <!-- Include jQuery and the jquery.gpopover plugin -->
    <script src="js/vendor/jquery-1.12.4.min.js"></script>
    <script src="js/jquery.gpopover.js"></script>

    <script>
        $(function () {

            // Use default options for the left and middle buttons
            // $('#trigger-one, #trigger-two').gpopover();

            // Use custom options for the right button
            $('#mypage-btn').gpopover({
                width: 400,
                preventHide: true,
                onShow: function () {
                    if (console && console.log) console.log("Popover shown.");
                },
                onHide: function () {
                    if (console && console.log) console.log("Popover hidden.");
                }
            });



            /* Set up a click handler for the #trigger-code button which will
               cause a countdown which shows and hides the popover in code. */
            $('#trigger-code').click(function (e) {
                var remaining = 3,
                    $button = $(this),
                    originalText = $button.text();

                $button.text('Showing in ' + remaining + "...");
                $button.attr('disabled', 'disabled');

                // Set up interval
                // var interval = setInterval(function () {
                //     remaining -= 1;

                //     if (remaining > 0)
                //         $button.text('Showing in ' + remaining + "...");
                //     else
                //         $button.text('Hiding in ' + -((-remaining) - 5) + "...");

                //     if (remaining == 0) {
                //         // Trigger the show for the popover
                //         // (note: it must have been initialised first)
                //         $('#trigger-one').gpopover('show');
                //     } else if (remaining <= -5) {
                //         // Trigger the hide for the popover
                //         $('#trigger-one').gpopover('hide');

                //         // Cancel this interval
                //         clearInterval(interval);
                //         $button.text(originalText);
                //         $button.removeAttr('disabled');
                //     }
                // }, 1000);
            });

        });
    </script>
</head>

<body>


    <!-- Popover element for the 'Example 3' button -->
    <div id="popover-mypage-menu" class="gpopover">
        <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
            <li class="nav-item">
              <a class="nav-link active" id="pills-convert-my-tab" data-toggle="pill" href="#pills-convert-my" role="tab" aria-controls="pills-convert-my" aria-selected="true">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" id="pills-profile-tab" data-toggle="pill" href="#pills-profile" role="tab" aria-controls="pills-profile" aria-selected="false">Profile</a>
            </li>
        </ul>

          <div class="tab-content" id="pills-tabContent">
            <div class="tab-pane fade show active" id="pills-convert-my" role="tabpanel" aria-labelledby="pills-convert-my-tab">...</div>
            <div class="tab-pane fade" id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab">...</div>
            <div class="tab-pane fade" id="pills-contact" role="tabpanel" aria-labelledby="pills-contact-tab">...</div>
          </div>
        <div class="container-fluid">
            <div>
                <div>
                    <div class="d-flex justify-content-around bd-highlight mb-3">
                        <div class="p-2 bd-highlight">메시지</div>
                        <div class="p-2 bd-highlight">알림</div>
                    </div>
                </div>
                <div>
                    <div class="d-flex justify-content-around bd-highlight mb-3">
                        <div class="p-2 bd-highlight"><a href="show-myProjects.html">창작한</a></div>
                        <div class="p-2 bd-highlight"><a href="show-filteredProjects.html">후원한</a></div>
                        <div class="p-2 bd-highlight"><a href="show-filteredProjects.html">반응한</a></div>
                        <div class="p-2 bd-highlight"><span class="fa fa-heart"><a
                                    href="show-filteredProjects.html">좋아한</a></span></div>
                    </div>
                </div>
                <div class="row align-items-end">
                    <div class="list-group">
                        <a href="#" class="list-group-item list-group-item-action active">
                            <div class="d-flex w-100 justify-content-between">
                                <h5 class="mb-1">보안 인증 하시면 좋데요</h5>
                                <small>3 days ago</small>
                            </div>
                            <p class="mb-1">Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget
                                risus varius blandit.</p>
                            <small></small>
                        </a>
                    </div>
                </div>
                <div class="d-flex flex-column bd-highlight mb-3">
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item"><a href="#">
                                <h3>프로필 설정</h3>
                            </a></li>
                        <li class="list-group-item"><a href="#">
                                <h3>후원 결제 내역</h3>
                            </a></li>
                        <li class="list-group-item"><a href="#">
                                <h3>수입 내역</h3>
                            </a></li>
                        <li class="list-group-item"><a href="#">
                                <h3>로그아웃 하기</h3>
                            </a></li>
                    </ul>
                </div>

            </div>
        </div>
    </div>
    <!-- header-start -->
    <header>
        <div class="header-area ">
            <div id="sticky-header" class="main-header-area">
                <div class="container-fluid p-0">
                    <div id="sticky-header-align" class="row align-self-center no-gutters">
                        <div class="col-xl-5 col-lg-6">
                            <div class="main-menu d-none d-lg-block">
                                <nav>
                                    <ul id="navigation">
                                        <li><a href="#">프로젝트 보기 <i class="ti-angle-down"></i></a>
                                            <ul class="submenu">
                                                <li><a href="show-projects.html">모든 프로젝트</a></li>
                                                <li><a href="#">리워드 프로젝트</a></li>
                                                <li><a href="#">후원 프로젝트</a></li>
                                                <hr />
                                                <li><a href="#">인기 프로젝트</a></li>
                                                <li><a href="#">마감임박 프로젝트</a></li>
                                                <li><a href="#">신규 프로젝트</a></li>
                                                <hr />
                                                <li><a href="#">기획전 보러가기</a></li>
                                            </ul>
                                        <li><a href="create-myProject.html">프로젝트 올리기</a></li>
                                        <li><a href="#">더 보기 <i class="ti-angle-down"></i></a>
                                            <ul class="submenu">
                                                <li><a href="#"></a></li>
                                                <li><a href="#">반응보기</a></li>
                                                <li><a href="#">elements3</a></li>
                                                <li><a href="#">elements4</a></li>
                                                <li><a href="#">elements5</a></li>
                                            </ul>
                                        </li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                        <div class="col-xl-2 col-lg-2 ">
                            <div class="logo-img">
                                <a href="index.html">
                                    <h2 class="logo">FUN THING</h2>
                                </a>
                            </div>
                        </div>
                        <div class="col-xl-5 col-lg-4 d-none d-lg-block">
                            <div class="nav_right">

                                <div class="#">
                                    <a class="popup-with-form" href="#"><span class="fa fa-bell pr-3"></span></a>
                                </div>

                                <div class="search_icon">
                                    <a class="popup-with-form" href="#search-popup"><span
                                            class="fa fa-search pr-1"></span></a>
                                </div>
                                <div class="mypage_btn d-none d-lg-block ml-3">
                                    <button id="mypage-btn" data-popover="popover-mypage-menu">마이페이지</button>
                                </div>
                            </div>
                        </div>
                        <div class="col-12">
                            <div class="mobile_menu d-block d-lg-none"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <!-- header-end -->


    <section class="main-wrapper pt-xl-5 ">
        <div class="main-content">
            
            <div class="d-flex justify-content-center">
                <h2>누구님의 스튜디오</h2>
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
                                    <a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab" href="#nav-contact"
                                        role="tab" aria-controls="nav-contact" aria-selected="false">오픈예정 현황</a>
                                    <a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab" href="#nav-contact"
                                        role="tab" aria-controls="nav-contact" aria-selected="false">펀딩 현황</a>
                                    <a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab" href="#nav-contact"
                                        role="tab" aria-controls="nav-contact" aria-selected="false">결제 현황</a>
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
                                                aria-controls="home">기본설정</a>
                                            <a class="list-group-item list-group-item-action" id="list-profile-list"
                                                data-toggle="list" href="#list-profile" role="tab"
                                                aria-controls="profile">창작자
                                                소개</a>
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
                                                aria-controls="settings">계좌
                                                설정</a>
                                        </div>
                                        
                                        <div class="col-xl-12 mt-10 d-flex justify-items-center">
                                            <a class="btn btn-lg btn-registry-way d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3"
                                                href="create-myProject.html">작성완료</a>
                                                
                                        </div>


                                    </div>
                                    <div class="col-8">
                                        <div class="tab-content" id="nav-tabContent">
                                            <div class="tab-pane fade show active" id="list-home" role="tabpanel"
                                                aria-labelledby="list-home-list">
                                                <div class="d-flex flex-column bd-highlight mb-3">
                                                    <div class="p-2 bd-highlight">
                                                        <span>프로젝트 제목 [ 중복 체크] </span>
                                                        <input type="text" name="first_name" placeholder="First Name"
                                                            onfocus="this.placeholder = ''"
                                                            onblur="this.placeholder = 'First Name'" required=""
                                                            class="single-input">
                                                    </div>
                                                    <div class="p-2 bd-highlight">
                                                        <span>업체 명? [ ]</span>
                                                        <input type="text" name="first_name" placeholder="First Name"
                                                            onfocus="this.placeholder = ''"
                                                            onblur="this.placeholder = 'First Name'" required=""
                                                            class="single-input">
                                                    </div>
                                                    <div class="p-2 bd-highlight">
                                                        <span>창작자 명 [ 아이디 연동 ]</span>
                                                        <input type="text" name="first_name" placeholder="First Name"
                                                            onfocus="this.placeholder = ''"
                                                            onblur="this.placeholder = 'First Name'" required=""
                                                            class="single-input">
                                                    </div>

                                                    <div class="p-2 bd-highlight">
                                                        <span>창작자 이메일 [ 아이디 연동 ]</span>
                                                        <input type="text" name="first_name" placeholder="First Name"
                                                            onfocus="this.placeholder = ''"
                                                            onblur="this.placeholder = 'First Name'" required=""
                                                            class="single-input">
                                                    </div>

                                                    <div class="p-2 bd-highlight">
                                                        <span>창작자 휴대폰 번호 </span>
                                                        <input type="text" name="first_name" placeholder="First Name"
                                                            onfocus="this.placeholder = ''"
                                                            onblur="this.placeholder = 'First Name'" required=""
                                                            class="single-input">
                                                    </div>

                                                    <div class="p-2 bd-highlight">
                                                        <span>개인 정보 수집 동의</span><br>
                                                        <span>(선택)funThing의 유용한 뉴스레터 받기</span>
                                                    </div>
                                                    <div class="col-xl-12 mt-10 d-flex justify-content-center">
                                                        <a class="btn btn-lg btn-registry-way d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3"
                                                            href="create-myProject.html">저장하기</a>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="tab-pane fade" id="list-profile" role="tabpanel"
                                                aria-labelledby="list-profile-list">
                                                <!-- 창작자 소개-->
                                                <div class="d-flex flex-column bd-highlight mb-3">
                                                    <div class="p-2 bd-highlight">
                                                        <span>목표 금액</span>
                                                        <input type="text" name="first_name" placeholder="First Name"
                                                            onfocus="this.placeholder = ''"
                                                            onblur="this.placeholder = 'First Name'" required=""
                                                            class="single-input">
                                                    </div>
                                                    <div class="p-2 bd-highlight">
                                                        <span>프로젝트 대표 이미지</span>
                                                    </div>
                                                    <div class="p-2 bd-highlight">
                                                        <span>프로젝트 분류 [카테고리]</span>
                                                    </div>
                                                    <div class="p-2 bd-highlight">
                                                        <span>프로젝트 기간 설정 [datePicker]</span>
                                                    </div>
                                                    <div class="p-2 bd-highlight">
                                                        <span>검색용 태그 * </span>
                                                    </div>
                                                    <div class="p-2 bd-highlight">
                                                        <span>개인 정보 수집 동의</span><br>
                                                        <span>(선택)funThing의 유용한 뉴스레터 받기</span>
                                                    </div>
                                                    <div class="col-xl-12 mt-10 d-flex justify-content-center">
                                                        <a class="btn btn-lg btn-registry-way d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3"
                                                            href="create-myProject.html">저장하기</a>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="tab-pane fade" id="list-messages" role="tabpanel"
                                                aria-labelledby="list-messages-list">
                                                <h3>스토리 작성</h3>
                                                <div class="p-2 bd-highlight">
                                                    <span>소개 컨텐츠 [영상으로 할지 사진으로 할지 선택]</span>
                                                </div>
                                                <div class="p-2 bd-highlight">
                                                    <span>프로젝트 요약</span>
                                                </div>
                                                <div class="p-2 bd-highlight">
                                                    <span>오픈 예정 프로젝트 설정 []</span>
                                                    <p>오픈예정 서비스를 이용하면 프로젝트를 오픈하기 전, 미리 서포터에게 알림·홍보할 수 있으며 펀딩 성공에 도움을 줄 수
                                                        있습니다. 오픈예정 서비스를 신청한다면 누구나 오픈예정 서비스를 이용하실 수 있습니다. 지금 바로 신청해보세요!
                                                        오픈예정 서비스 신청하러 가기</p>
                                                </div>
                                                <div class="col-xl-12 mt-10 d-flex justify-content-center">
                                                    <a class="btn btn-lg btn-registry-way d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3"
                                                        href="create-myProject.html">저장하기</a>
                                                </div>
                                            </div>
                                            <div class="tab-pane fade" id="list-settings" role="tabpanel"
                                                aria-labelledby="list-settings-list">
                                                <h3>리워드 설계 [선물 구성]</h3>
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
                                            <div class="tab-pane fade" id="list-introducemk" role="tabpanel"
                                                aria-labelledby="list-introducemk-list">
                                                <h3>창작자 설정[ 프로젝트 진행자 상세 설정 ]</h3>
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



    <!-- footer -->
    <footer class="footer">
    </footer>

    <!-- 검색 폼 -->
    <form id="search-popup" class="white-popup-block mfp-hide">
        <div class="popup_box ">
            <div class="popup_inner">
                <aside class="single_sidebar_widget search_widget">
                    <form action="#">
                        인기태그 : #내눈깔 #하늘vs정호 #직배송 #귱
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
                                    <ul class="list cat-list">
                                        <li>
                                            <a href="#" class="d-flex">
                                                <p>Resaurant food</p>
                                                <p>(37)</p>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#" class="d-flex">
                                                <p>Travel news</p>
                                                <p>(10)</p>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#" class="d-flex">
                                                <p>Modern technology</p>
                                                <p>(03)</p>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#" class="d-flex">
                                                <p>Product</p>
                                                <p>(11)</p>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#" class="d-flex">
                                                <p>Inspiration</p>
                                                <p>(21)</p>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#" class="d-flex">
                                                <p>Health Care</p>
                                                <p>(21)</p>
                                            </a>
                                        </li>
                                    </ul>
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


    <!-- JS here -->
    <script src="js/vendor/modernizr-3.5.0.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/isotope.pkgd.min.js"></script>
    <script src="js/ajax-form.js"></script>
    <script src="js/waypoints.min.js"></script>
    <script src="js/jquery.counterup.min.js"></script>
    <script src="js/imagesloaded.pkgd.min.js"></script>
    <script src="js/scrollIt.js"></script>
    <script src="js/jquery.scrollUp.min.js"></script>
    <script src="js/wow.min.js"></script>
    <script src="js/nice-select.min.js"></script>
    <script src="js/jquery.slicknav.min.js"></script>
    <script src="js/jquery.magnific-popup.min.js"></script>
    <script src="js/plugins.js"></script>
    <script src="js/gijgo.min.js"></script>

    <!--contact js-->
    <script src="js/contact.js"></script>
    <script src="js/jquery.ajaxchimp.min.js"></script>
    <script src="js/jquery.form.js"></script>
    <script src="js/jquery.validate.min.js"></script>
    <script src="js/mail-script.js"></script>

    <script src="js/main.js"></script>

</body>

</html>