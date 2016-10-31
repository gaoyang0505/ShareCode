<%@ taglib uri="http://www.springframework.org/tags/form" prefix="formSpring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up| TVXQ</title>
<link href="/project/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="/project/resources/css/font-awesome.min.css"
	rel="stylesheet">
<link href="/project/resources/css/lightbox.css" rel="stylesheet">
<link href="/project/resources/css/animate.min.css" rel="stylesheet">
<link href="/project/resources/css/main.css" rel="stylesheet">
<link href="/project/resources/css/responsive.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</head>
<body>
	
	     <!-- <section id="coming-soon">        
         <div class="container">
            <div class="row">
               
                <div class="col-sm-12">
                    <div class="time-count">
                    <h1>Time To Summer Vacation:</h1>
                        <ul id="countdown">
                            <li class="angle-one">
                                <span class="days time-font">00</span>
                                <p>Days</p>
                            </li>
                            <li class="angle-two">
                                <span class="hours time-font">00</span>
                                <p>Hours</p>
                            </li>
                            <li class="angle-three">
                                <span class="minutes time-font">00</span>
                                <p class="minute">Mins</p>
                            </li>                            
                            <li class="angle-four">
                                <span class="seconds time-font">00</span>
                                <p>Secs</p>
                            </li>               
                        </ul>   
                    </div>
                </div>
            </div>
        </div>       
    </section> -->
    <section id="subscribe">
        <div class="container">
            <div class="row">
                <div class="col-sm-10 col-sm-offset-1">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2><i class="fa fa-envelope-o"></i> IT IS TIME TO JOIN US</h2>
                            <p>E-Mail would be your unique Log in name.<br /> Hope you find your ideal house here.</p>
                        </div>
                        <div class="col-sm-6 newsletter">
                            <formSpring:form commandName="client" method="post" id="newsletter" action="signup.htm">
                                <formSpring:input path="userEMail" class="form-control emailCheck" type="email" name="email" placeholder="Enter Your email" onfocusout="checkUser(this.form)"/>
                                <font color="red"><formSpring:errors path="userEMail"/></font>
                                
                                <div class="emailadd"></div>
                                <p id="informationMessage">Don't worry we will not use your email for spam</p>

                                <formSpring:input path="userFirstName" class="form-control" type="text" style="width:200px;float:right" placeholder="First Name"/>
								<font color="red"><formSpring:errors path="userLastName"/></font>
								
								
								<formSpring:input path="userLastName" class="form-control" type="text" style="width:150px;" placeholder="Last Name"/>
								<font color="red"><formSpring:errors path="userLastName"/></font>
								
								Password:<formSpring:input path="userPassword" class="form-control" type="password" id="passInup"/>
								<font color="red"><formSpring:errors path="userPassword"/></font>
								<input type="submit" value="Sign In" id="signinBtn" class="btn btn-submit" onclick="checkUser(this.form)"/>
                            </formSpring:form>
                            
                        </div>    
                    </div>
                </div>     
            </div>
        </div> 
    </section>

    <section id="coming-soon-footer" class="container">
        <div class="row">
            <div class="col-sm-12">
                <div class="text-center">
                    <p>Designed by <a target="_blank" href="https://www.google.com/">Gao Yang</a></p>
                </div>
            </div>
        </div>       
    </section>
    
	
    <script type="text/javascript" src="/project/resources/js/jquery.js"></script>
    <script type="text/javascript" src="/project/resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/project/resources/js/coundown-timer.js"></script>
    <script type="text/javascript" src="/project/resources/js/wow.min.js"></script>
    <script type="text/javascript" src="/project/resources/js/main.js"></script>
    <script src="resources/signupFunction.js"></script>
    <script type="text/javascript">
            //Countdown js
         $("#countdown").countdown({
                date: "30 april 2016 12:00:00",
                format: "on"
            },      
            function() {
                // callback function
        });
    </script>
</body>
</html>