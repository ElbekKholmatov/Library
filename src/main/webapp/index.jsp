<%--
  Created by IntelliJ IDEA.
  User: jason
  Date: 2/12/23
  Time: 6:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <meta name="description" content="">
  <meta name="author" content="">

  <title>Home</title>

  <!-- CSS FILES -->
  <link rel="preconnect" href="https://fonts.googleapis.com">

  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

  <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400&family=Sono:wght@200;300;400;500;700&display=swap"
        rel="stylesheet">

  <link rel="stylesheet" href="/resources/css/bootstrap.min.css">

  <link rel="stylesheet" href="/resources/css/bootstrap-icons.css">

  <link rel="stylesheet" href="/resources/css/owl.carousel.min.css">

  <link rel="stylesheet" href="/resources/css/owl.theme.default.min.css">

  <link href="/resources/css/templatemo-pod-talk.css" rel="stylesheet">

</head>

<body>

<main>
  <nav class="navbar navbar-expand-lg">
    <div class="container">
      <a class="navbar-brand me-lg-5 me-0" href="/index.jsp">
        <img src="/resources/img/logo.png" class="logo-image img-fluid" alt="sheengo logo">
      </a>

      <form action="#" method="get" class="custom-form search-form flex-fill me-3" role="search">
        <div class="input-group input-group-lg">
          <input name="search" type="search" class="form-control" id="search" placeholder="Search Podcast"
                 aria-label="Search">

          <button type="submit" class="form-control" id="submit">
            <i class="bi-search"></i>
          </button>
        </div>
      </form>

      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
              aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ms-lg-auto">
          <li class="nav-item">
            <a class="nav-link active" href="/index.jsp">Home</a>
          </li>

          <li class="nav-item">
            <a class="nav-link" href="/about.html">About</a>
          </li>


          <li class="nav-item">
            <a class="nav-link" href="/contact.html">Contact</a>
          </li>
        </ul>

        <div class="ms-4">
          <a href="/user/sign_up.jsp" class="btn custom-btn custom-border-btn smoothscroll">Get Started</a>
        </div>
      </div>
    </div>
  </nav>


  <section class="hero-section">
    <div class="container">
      <div class="row">

        <div class="col-lg-12 col-12">
          <div class="text-center mb-5 pb-2">
            <h1 class="text-white">Home(Asosiy/kirish)</h1>

            <p class="text-white">Bizda eng so'nggi eBooks</p>

            <a href="#section_2" class="btn custom-btn smoothscroll mt-3">Find eBook</a>
          </div>

          <div class="owl-carousel owl-theme">

            <div class="owl-carousel-info-wrap item">
              <img src="/resources/images/profile/smiling-business-woman-with-folded-hands-against-white-wall-toothy-smile-crossed-arms.jpg"
                   class="owl-carousel-image img-fluid" alt="">
              <div class="owl-carousel-info">
                <h4 class="mb-2">
                  Candice
                  <img src="/resources/images/verified.png"
                       class="owl-carousel-verified-image img-fluid" alt="">
                </h4>

                <span class="badge">Storytelling</span>

                <span class="badge">Business</span>
              </div>

              <div class="social-share">
                <ul class="social-icon">
                  <li class="social-icon-item">
                    <a href="#" class="social-icon-link bi-twitter"></a>
                  </li>
                  <li class="social-icon-item">
                    <a href="#" class="social-icon-link bi-facebook"></a>
                  </li>
                </ul>
              </div>
            </div>


          </div>
        </div>

      </div>
    </div>
  </section>

  <section class="topics-section section-padding pb-0" id="section_2">
    <div class="container">
      <div class="row">
        <div class="col-lg-12 col-12">
          <div class="section-title-wrap mb-5">
            <h4 class="section-title">Topics</h4>
          </div>
        </div>
        <div class="col-lg-3 col-md-6 col-12 mb-4 mb-lg-0">
          <div class="custom-block custom-block-overlay">
            <a href="detail-page.html" class="custom-block-image-wrap">
              <img src="/resources/images/topics/physician-consulting-his-patient-clinic.jpg"
                   class="custom-block-image img-fluid" alt="">
            </a>

            <div class="custom-block-info custom-block-overlay-info">
              <h5 class="mb-1">
                <a href="listing-page.html">
                  Productivity
                </a>
              </h5>
              <p class="badge mb-0">50 Episodes</p>
            </div>
          </div>
        </div>

        <div class="col-lg-3 col-md-6 col-12 mb-4 mb-lg-0">
          <div class="custom-block custom-block-overlay">
            <a href="detail-page.html" class="custom-block-image-wrap">
              <img src="/resources/images/topics/repairman-doing-air-conditioner-service.jpg"
                   class="custom-block-image img-fluid" alt="">
            </a>

            <div class="custom-block-info custom-block-overlay-info">
              <h5 class="mb-1">
                <a href="listing-page.html">
                  Technician
                </a>
              </h5>

              <p class="badge mb-0">12 Episodes</p>
            </div>
          </div>
        </div>
        <div class="col-lg-3 col-md-6 col-12 mb-4 mb-lg-0">
          <div class="custom-block custom-block-overlay">
            <a href="detail-page.html" class="custom-block-image-wrap">
              <img src="/resources/images/topics/woman-practicing-yoga-mat-home.jpg"
                   class="custom-block-image img-fluid" alt="">
            </a>

            <div class="custom-block-info custom-block-overlay-info">
              <h5 class="mb-1">
                <a href="listing-page.html">
                  Mindfullness
                </a>
              </h5>
              <p class="badge mb-0">35 Episodes</p>
            </div>
          </div>
        </div>

        <div class="col-lg-3 col-md-6 col-12 mb-4 mb-lg-0">
          <div class="custom-block custom-block-overlay">
            <a href="detail-page.html" class="custom-block-image-wrap">
              <img src="/resources/images/topics/delicious-meal-with-sambal-arrangement.jpg"
                   class="custom-block-image img-fluid" alt="">
            </a>

            <div class="custom-block-info custom-block-overlay-info">
              <h5 class="mb-1">
                <a href="listing-page.html">
                  Cooking
                </a>
              </h5>

              <p class="badge mb-0">12 Episodes</p>
            </div>
          </div>
        </div>

      </div>
    </div>
  </section>
  <section class="trending-podcast-section section-padding">
    <div class="container">
      <div class="row">
        <div class="col-lg-12 col-12">
          <div class="section-title-wrap mb-5">
            <h4 class="section-title">eBook examples</h4>
          </div>
        </div>
        <div class="col-lg-4 col-12 mb-4 mb-lg-0">
          <div class="custom-block custom-block-full">
            <div class="custom-block-image-wrap">
              <a href="detail-page.html">
                <img src="/resources/images/podcast/27376480_7326766.jpg"
                     class="custom-block-image img-fluid"
                     alt="">
              </a>
            </div>
            <div class="custom-block-info">
              <h5 class="mb-2">
                <a href="detail-page.html">
                  Vintage Show
                </a>
              </h5>
              <div class="profile-block d-flex">
                <img src="/resources/images/profile/woman-posing-black-dress-medium-shot.jpg"
                     class="profile-block-image img-fluid" alt="">
                <p>Elsa
                  <strong>Influencer</strong></p>
              </div>

              <p class="mb-0">Lorem Ipsum dolor sit amet consectetur</p>

              <div class="custom-block-bottom d-flex justify-content-between mt-3">
                <a href="#" class="bi-headphones me-1">
                  <span>100k</span>
                </a>
                <a href="#" class="bi-heart me-1">
                  <span>2.5k</span>
                </a>
                <a href="#" class="bi-chat me-1">
                  <span>924k</span>
                </a>
              </div>
            </div>
            <div class="social-share d-flex flex-column ms-auto">
              <a href="#" class="badge ms-auto">
                <i class="bi-heart"></i>
              </a>
              <a href="#" class="badge ms-auto">
                <i class="bi-bookmark"></i>
              </a>
            </div>
          </div>
        </div>
        <div class="col-lg-4 col-12 mb-4 mb-lg-0">
          <div class="custom-block custom-block-full">
            <div class="custom-block-image-wrap">
              <a href="detail-page.html">
                <img src="/resources/images/podcast/27670664_7369753.jpg"
                     class="custom-block-image img-fluid"
                     alt="">
              </a>
            </div>
            <div class="custom-block-info">
              <h5 class="mb-2">
                <a href="detail-page.html">
                  Vintage Show
                </a>
              </h5>
              <div class="profile-block d-flex">
                <img src="/resources/images/profile/cute-smiling-woman-outdoor-portrait.jpg"
                     class="profile-block-image img-fluid" alt="">
                <p>
                  Taylor
                  <img src="/resources/images/verified.png" class="verified-image img-fluid" alt="">
                  <strong>Creator</strong>
                </p>
              </div>
              <p class="mb-0">Lorem Ipsum dolor sit amet consectetur</p>
              <div class="custom-block-bottom d-flex justify-content-between mt-3">
                <a href="#" class="bi-headphones me-1">
                  <span>100k</span>
                </a>
                <a href="#" class="bi-heart me-1">
                  <span>2.5k</span>
                </a>
                <a href="#" class="bi-chat me-1">
                  <span>924k</span>
                </a>
              </div>
            </div>
            <div class="social-share d-flex flex-column ms-auto">
              <a href="#" class="badge ms-auto">
                <i class="bi-heart"></i>
              </a>
              <a href="#" class="badge ms-auto">
                <i class="bi-bookmark"></i>
              </a>
            </div>
          </div>
        </div>
        <div class="col-lg-4 col-12">
          <div class="custom-block custom-block-full">
            <div class="custom-block-image-wrap">
              <a href="/detail-page.html">
                <img src="/resources/images/podcast/12577967_02.jpg"
                     class="custom-block-image img-fluid" alt="">
              </a>
            </div>
            <div class="custom-block-info">
              <h5 class="mb-2">
                <a href="/detail-page.html">
                  Daily Talk
                </a>
              </h5>
              <div class="profile-block d-flex">
                <img src="/resources/images/profile/handsome-asian-man-listening-music-through-headphones.jpg"
                     class="profile-block-image img-fluid" alt="">
                <p>
                  William
                  <img src="/resources/images/verified.png" class="verified-image img-fluid" alt="">
                  <strong>Vlogger</strong></p>
              </div>
              <p class="mb-0">Lorem Ipsum dolor sit amet consectetur</p>
              <div class="custom-block-bottom d-flex justify-content-between mt-3">
                <a href="#" class="bi-headphones me-1">
                  <span>100k</span>
                </a>
                <a href="#" class="bi-heart me-1">
                  <span>2.5k</span>
                </a>
                <a href="#" class="bi-chat me-1">
                  <span>924k</span>
                </a>
              </div>
            </div>
            <div class="social-share d-flex flex-column ms-auto">
              <a href="#" class="badge ms-auto">
                <i class="bi-heart"></i>
              </a>
              <a href="#" class="badge ms-auto">
                <i class="bi-bookmark"></i>
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</main>


<footer class="site-footer">
  <div class="container">
    <div class="row">
      <!--            <div class="col-lg-6 col-12 mb-5 mb-lg-0">-->
      <!--                <div class="subscribe-form-wrap">-->
      <!--                    <h6>Subscribe. Every weekly.</h6>-->

      <!--                    <form class="custom-form subscribe-form" action="#" method="get" role="form">-->
      <!--                        <input type="email" name="subscribe-email" id="subscribe-email" pattern="[^ @]*@[^ @]*"-->
      <!--                               class="form-control" placeholder="Email Address" required="">-->
      <!--                        <div class="col-lg-12 col-12">-->
      <!--                            <button type="submit" class="form-control" id="submit">Subscribe</button>-->
      <!--                        </div>-->
      <!--                    </form>-->
      <!--                </div>-->
      <!--            </div>-->
      <!--            <div class="col-lg-3 col-md-6 col-12 mb-4 mb-md-0 mb-lg-0">-->
      <!--                <h6 class="site-footer-title mb-3">Contact</h6>-->
      <!--                <p class="mb-2"><strong class="d-inline me-2">Phone:</strong></p>-->
      <!--                <p>-->
      <!--                    <strong class="d-inline me-2">Email:</strong>-->
      <!--                    <a href="#">inquiry@pod.co</a>-->
      <!--                </p>-->
      <!--            </div>-->
      <div class="col-lg-3 col-md-6 col-12">
        <h6 class="site-footer-title mb-3">Social</h6>
        <ul class="social-icon">
          <li class="social-icon-item">
            <a href="#" class="social-icon-link bi-instagram"></a>
          </li>
          <li class="social-icon-item">
            <a href="#" class="social-icon-link bi-twitter"></a>
          </li>
          <li class="social-icon-item">
            <a href="#" class="social-icon-link bi-whatsapp"></a>
          </li>
        </ul>
      </div>
    </div>
  </div>
  <div class="container pt-5">
    <div class="row align-items-center">
      <div class="col-lg-2 col-md-3 col-12">
        <a class="navbar-brand" href="/index.jsp">
          <img src="/resources/img/logo.png" class="logo-image img-fluid" alt="templatemo pod talk">
        </a>
      </div>
      <div class="col-lg-7 col-md-9 col-12">
        <ul class="site-footer-links">
          <li class="site-footer-link-item">
            <a href="/main" class="site-footer-link">Homepage</a>
          </li>
          <li class="site-footer-link-item">
            <a href="#" class="site-footer-link">Help Center</a>
          </li>
          <li class="site-footer-link-item">
            <a href="#" class="site-footer-link">Contact Us</a>
          </li>
        </ul>
      </div>
    </div>
  </div>
</footer>


<!-- JAVASCRIPT FILES -->
<script src="/resources/js/jquery.min.js"></script>
<script src="/resources/js/bootstrap.bundle.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<script src="/resources/js/owl.carousel.min.js"></script>
<script src="/resources/js/custom.js"></script>

</body>
</html>

