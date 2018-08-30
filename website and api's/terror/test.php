<?php

class appmama {
    private $conn,$how,$res;
    public function __construct(){
     $this->conn=mysqli_connect("localhost","misfit","misfitsstartup","testusers"); 
    }
    public function __destruct(){
        mysqli_close($this->conn);
    }
    public function olduser(){
        $newtime=$_REQUEST["ustime"];
        $nname=$_REQUEST["usname"];
        $newreff=$_REQUEST["usreff"];
        $adsshown=$_REQUEST["adsshown"];
        $this->how="UPDATE apptest set mytime=mytime+'$newtime',adsshown='$adsshown' where reffno='$newreff' AND name='$nname'";
        $this->res=mysqli_query($this->conn,$this->how);
        if($this->res){
            echo "ok";
        }
    }
    public function registeruser(){
        $nname=$_REQUEST["usname0"];
        $newreff=$_REQUEST["usreff0"];
        $this->how="INSERT INTO apptest (name,reffno) VALUES ('$nname','$newreff')";
        $this->res=mysqli_query($this->conn,$this->how);
        if($this->res){
            echo "proceed";
        }else {
            echo "forbid";
        }
    }
    public function registerintern(){
        $nname=$_REQUEST["usname0"];
        $newreff=$_REQUEST["usreff0"];
        $this->how="INSERT INTO apptest (name,reffno,intern) VALUES ('$nname','$newreff',20)";
        $this->res=mysqli_query($this->conn,$this->how);
        if($this->res){
            echo "proceed";
        }else {
            echo "forbid";
        }
    }
   
}

$ne=new appmama();
if(isset($_REQUEST["ustime"])){
    $ne->olduser();
}else if(isset($_REQUEST["usname0"]) && isset($_REQUEST["internme"])){
    if($_REQUEST["internme"]==20){
        $ne->registerintern();
    }else {
        $ne->registeruser();
    }
}
?>