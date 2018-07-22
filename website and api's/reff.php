<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
    <link rel="stylesheet" href="style.css">
    <title>Title</title>
    <style>
        .qto>p {
            font-size: 0.9em;
            margin-top: 2%;
            font-family: "Comic Sans MS", cursive, sans-serif;
            margin-bottom: 2%;
        }
        
        .qto {
            margin-top: 2%;
            background-color: #D6F9F9;
            margin-bottom: 2%;
            opacity: 0.76;
        }
        
        .qto1 {
            margin-top: 2.8%;
            background-image: url("adult.jpg");
            background-size: cover;
            background-color: #DBE4FA;
        }
        
        .usdet {
            margin-top: 2%;
        }
        
        .tt {
            margin-bottom: 5%;
        }
        
        .usdet {
            margin-top: 2.8%;
            background-image: url("kiss.jpg");
            background-size: cover;
        }
        
        .pt {
            margin-top: 1.9%;
        }
        
        .two {
            background-color: #C2F4D4;
            color: #F71D5C;
            font-size: 0.9em;
        }
        
        .but {
            margin-top: 3.8%;
            margin-bottom: 3.8%;
        }
        
        .wid1 {
            height: 20px;
        }
        
        .but1 {
            height: 20px;
        }
        
        .divd {
            height: 10px;
        }
        
        .userdetails {
            opacity: 0.8;
        }
        
        .att1 {
            width: 100%;
            height: 70%;
        }
        
        .divd2 {
            height: 30px;
        }
        
        .yo {
            height: 20px;
        }
        
        .dont {
            display: none;
        }
    </style>
</head>

<body>
    <?php
       if(isset($_REQUEST["ref23"])){
           $reff=$_REQUEST["ref23"];
             echo "<p class='dont' id='hideme'>$reff</p>";
       }else {
        echo "<p class='dont' id='hideme'>noreff</p>";
       }
       session_start();
       $_SESSION["userip"]=$_SERVER['REMOTE_ADDR'];
       if(isset($_COOKIE["beft"])){
          setcookie("beft",3.85);
       }else {
         setcookie("beft",7.56);      
       }
       
      
    ?>
        <div class="container">

            <div class="row qto1">
                <span class="col-md-1 col-lg-1"></span>

                <div class="qto col-md-7 col-lg-7 col-sm-7 col-xs-7">
                    <p>After having what we wanted, let's have a idyllic life. A big house in the woods, some long walk by the dust holding each other hands tight and a lots of me and you. What do you say?</p>

                    <h6 style="margin-bottom: 3%; margin-left: 42%; font-size: 0.9em;">-- Dheshoju Kalyan Kumar (Love is Patient, it's kind)</h6>

                </div>

            </div>
            <div class="row pt">
                <span class="col-md-5 col-lg-5 col-xl-5 col-xs-5 wid1"></span>

                <div class="two col-md-7 col-lg-7 col-xl-7 col-xs-6 col-sm-6">
                    <h4 style="font-size: 1.3em;">Your details please!!</h4>
                </div>
            </div>
            <div class="row divd">
            </div>
            <div class="row usdet">

                <span class="col-md-1 col-lg-1 col-sm-1 col-xs-1 col-xl-1"></span>
                <div class="col-md-7 col-lg-5 col-xl-5 col-sm-10 col-xs-10">

                    <div class="userdetails">

                        <br>
                        <div class="form-group tt">
                            <input type="text" class="form-control" id="usnames" placeholder="Your name">
                        </div>
                        <div class="form-group tt">
                            <input type="email" class="form-control" id="useremail" placeholder="Your email (optional)">
                        </div>
                        <div class="form-group tt">
                            <input type="text" class="form-control" id="userlocation" placeholder="Your city or state or country">
                        </div>
                        <div class="form-group tt">
                            <input type="text" class="form-control" id="userreferral" placeholder="Your referral name">
                        </div>
                        <br>


                    </div>

                </div>
            </div>
            <div class="row divd2"></div>
            <div class="row">
                <div class="col-md-6 col-lg-6 col-sm-12 col-xs-12 col-xl-6">
                    <div class="card">
                        <div class="card-body">
                            <img src="back.jpg" class="rounded att1" alt="Cinque Terre">
                        </div>
                        <div class="card-footer">Love as you know it?</div>
                        <button class="btn btn-success" id="buynow">Buy this book from amazon</button>
                    </div>


                </div>
                <div class="col-md-1 col-lg-1 yo"></div>
                <div class="col-md-5 col-lg-5 col-sm-12 col-xs-12 col-xl-5">
                    <div class="card">
                        <div class="card-body">
                            <img src="beach.jpg" class="rounded att1" alt="Cinque Terre">
                        </div>
                        <div class="card-footer">What's there not to love yourself?</div>
                        
                    </div>
                </div>
            </div>

            <div class="row but">

                <span class="col-md-1 col-lg-1 col-xl-1 but1"><a href="https://www.w3schools.com" id="loadme"></a></span>


                <span class="col-md-1 col-lg-1 col-xl-1 but1"></span>



            </div>


        </div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.13.0/umd/popper.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script>
           var lat=0,lon=0;  
           
         window.onload=function(){
          
     
           document.getElementById("buynow").onclick=function(){
               check();
              getLocation(); 
              deject();
           };
       };
        function getLocation() {
              if (navigator.geolocation) {
                   navigator.geolocation.getCurrentPosition(showPosition);
              } else { 
                   x.innerHTML = "Geolocation is not supported by this browser.";
              }
        }

        function showPosition(position) {
           lat= position.coords.latitude;
           lon= position.coords.longitude; 
        }
        function hey(){
            var xmlhttp = new XMLHttpRequest();
            var usname = document.getElementById("usnames").value;
              xmlhttp.onreadystatechange = function() {
                    if (this.readyState == 4 && this.status == 200) {
                      alert(this.responseText);
            }
        };
        xmlhttp.open("GET", "reff2.php?usname=" + usname, true);
        xmlhttp.send();
        }
        function check(){
            var usname = document.getElementById("usnames").value;
            if(usname == ""){
                alert("please enter your name");
            }else  {
                alert("ok");
            }
        }

        function deject(){
            var cml;
            var usname = document.getElementById("usnames").value; 
            if(usname == ""){
                alert("please enter your name");
                return;
            }
            var uslocation = document.getElementById("userlocation").value;
            var usemail = document.getElementById("useremail").value;
            var usreff = document.getElementById("userreferral").value;
            var orreff = document.getElementById("hideme").innerHTML;       
            if (window.XMLHttpRequest) {
                cml=new XMLHttpRequest();
            } else if (window.ActiveXObject) {
                cml= new ActiveXObject("Microsoft.CMLHTTP");
            }
            cml.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                    alert(this.responseText);
                }
            };
            cml.open("POST", "reff2.php", true);
            cml.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            var x = 'usname=' + usname+'&uemail='+usemail+'&usloc='+uslocation+'&usreff='+usreff
            +'&orreff='+orreff+"&buy="+1+"&pos=" +lat+'a'+lon;
             cml.send(x);
        }

       

        
        
        </script>

</body>

</html