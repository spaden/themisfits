<?php
class appmama {
    private $conn,$how,$res;
    private function __construct(){
     $this->conn=mysqli_connect("localhost","misfit","misfitsstartup","testusers"); 
    }
    private function __destruct(){
        mysqli_close($this->conn);
    }
    private function newuser(){
        $newname=$_REQUEST["usname"];
        $newreff=$_REQUEST["usreffno"];
        $this->how="INSERT into downusers (name,reffno) VALUES ('$newname','$newreff')";
        $this->res=myslqi_query($this->conn,$this->how);
        if($this->res){
            echo "ok";
        }
    }
    private function upolduser(){
        $id=$_REQUEST["myid"];
        $this->how="update downusers set numtimes=numtimes+1, "
    }
}

$ne=new appmama();
$ne->newuser();

?>