<?php
echo "called";
if(isset($_REQUEST["usname"])){
  callme();  
}else {
  echo "please enter your name";
}


class Referred {
   var $username,$uemail,$usstate,$usreff,$orreff,$buy,$pos,$bploc,$usip;
   function setnames(){
      $this->username=$_REQUEST["usname"];
      $this->uemail=$_REQUEST["uemail"];
      $this->usreff=$_REQUEST["usreff"];
      $this->usstate=$_REQUEST["usloc"];
      $this->orreff=$_REQUEST["orreff"];
      $this->buy=$_REQUEST["buy"];
      $this->pos=$_REQUEST["pos"];
      
      if($_COOKIE["beft"]==7.56){
          $this->bploc="nw";
      }else {
        $this->bploc="ce";
      }
      $this->usip=$_SERVER['REMOTE_ADDR'];        
    }
   function tellme() {
      echo "entered";
      $dt=date('Y-m-d H:i:s');
      $connection= mysqli_connect("localhost","misfit","misfitsstartup","testusers");
     if($connection) //echo "success";
     $how = "INSERT INTO  refusers (buyername,byemail,buystate,buyreff,buybuy,orreff,tellme) VALUES ('$this->username','$this->uemail','$this->usstate','$this->usreff'
                                                     ,'$this->buy','$this->orreff','$dt')";
      $re2= mysqli_query($connection,$how);  
      if($re2) //echo $this->usip +" "+$this->bploc;
      mysqli_close($connection);
   }
}


function callme(){
 $se=new Referred;
 $se->setnames();
 $se->tellme();
}

?>