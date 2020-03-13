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
                                        <li><a href="create-project-start.html">프로젝트 올리기</a></li>
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
                                    <a class="popup-with-form" href="#report-popup"><span
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



    <!-- footer -->
    <footer class="footer">
    </footer>

    <!-- <div class="form-check primary-radio">
        <input class="form-check-input primary-radio checkbox" type="radio" name="exampleRadios" id="primary-radio" value="option1" checked>
        <label for="primary-radio"></label>
        </label>
    </div> -->

    <!-- 신고하기 폼 -->
    <form id="report-popup" class="white-popup-block mfp-hide">
        <div class="report_popup_box ">
            <div class="popup_inner ">
                <div class="container ">
                    <div class="row pb-1">
                        <h4>프로젝트 신고하기</h4>
                    </div>
                    <hr>
                    <div class="row">
                        <span>신고 이유가 무엇인가요?</span>
                    </div>
                    <div class="row d-flex align-items-center">
                        <div class="p-2 bd-highlight">
                            <div class="form-check primary-radio ">
                                <input class="form-check-input primary-radio checkbox" type="radio" name="exampleRadios"
                                    id="primary-radio1" value="option1" checked>
                                <label for="primary-radio1"></label>
                            </div>
                        </div>
                        <div class="d-flex p-2 bd-highlight">스토리에 허위사실이 있습니다.</div>
                    </div>
                    <div class="row d-flex align-items-center">
                        <div class="p-2 bd-highlight">
                            <div class="form-check primary-radio ">
                                <input class="form-check-input primary-radio checkbox" type="radio" name="exampleRadios"
                                    id="primary-radio2" value="option1" checked>
                                <label for="primary-radio2"></label>
                            </div>
                        </div>
                        <div class="d-flex p-2 bd-highlight">지적 재산권을 침해하고 있습니다.</div>
                    </div>
                    <div class="row d-flex align-items-center">
                        <div class="p-2 bd-highlight">
                            <div class="form-check primary-radio ">
                                <input class="form-check-input primary-radio checkbox" type="radio" name="exampleRadios"
                                    id="primary-radio3" value="option1" checked>
                                <label for="primary-radio3"></label>
                            </div>
                        </div>
                        <div class="d-flex p-2 bd-highlight">다른 채널에서 판매되고 있는 제품입니다.</div>
                    </div>
                    <div class="row d-flex align-items-center">
                        <div class="p-2 bd-highlight">
                            <div class="form-check primary-radio ">
                                <input class="form-check-input primary-radio checkbox" type="radio" name="exampleRadios"
                                    id="primary-radio4" value="option1" checked>
                                <label for="primary-radio4"></label>
                            </div>
                        </div>
                        <div class="d-flex p-2 bd-highlight">메이커와 오랫동안 연락이 되지 않습니다.</div>
                    </div>
                    <div class="row d-flex align-items-center">
                        <div class="p-2 bd-highlight">
                            <div class="form-check primary-radio ">
                                <input class="form-check-input primary-radio checkbox" type="radio" name="exampleRadios"
                                    id="primary-radio5" value="option1" checked>
                                <label for="primary-radio5"></label>
                            </div>
                        </div>
                        <div class="d-flex p-2 bd-highlight">사회적 공익을 저해할 우려가 있습니다.</div>
                    </div>
                    <div class="row d-flex align-items-center">
                        <div class="p-2 bd-highlight">
                            <div class="form-check primary-radio ">
                                <input class="form-check-input primary-radio checkbox" type="radio" name="exampleRadios"
                                    id="primary-radio6" value="option1" checked>
                                <label for="primary-radio6"></label>
                            </div>
                        </div>
                        <div class="d-flex p-2 bd-highlight">기타</div>
                    </div>
                    <div class="row mt-30">
                        <h6>상세내용을 작성해주세요.</h6>
                    </div>
                    <div class="row">
                        <div class="form-group col-12 ">
                            <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                        </div>
                    </div>
                    <div class="row">
                        <p>
                            - 신고/제보를 통해 접수된 의견은 와디즈 프로젝트 운영에 반영되며 별도로 제보자에게 회신드리지 않습니다.<br>
                            - 와디즈가 건전한 크라우드펀딩 생태계 조성을 할 수 있도록 도움을 주심에 감사드리며, 
                                    근거 없는 비방 내용의 경우에는 법적 처벌대상이 될 수 있사오니 유의해주시기 바랍니다.
                        </p>
                    </div>

                    <div class="row d-flex justify-content-end">
                        <div>
                            <a class="btn btn-lg btn-report-cancel d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3"
                                href="#">취소</a>
                        </div>
                        <div>
                            <a class="btn btn-lg btn-report-submit d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3"
                                href="#">제출하기</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
    <!-- ---------- -->


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