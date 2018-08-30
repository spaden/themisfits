<?php
class Downto {
   private $conn,$how,$res,$who;
   function __construct(){
    $this->conn=mysqli_connect("localhost","misfit","misfitsstartup","testusers"); 
    $this->who=$_REQUEST["reffno"];
    $this->how="Select count(*) from apptest where reffno = $this->who";
    $this->res=mysqli_query($this->conn,$this->how);
    
   }
   function display(){
      list($re)=$this->res->fetch_row();
    
      $response=array();
      $response['total']=$re; 
    //  $response['products']=array();
      $this->how="SELECT  SUM(mytime) from apptest where reffno=$this->who AND intern=0";
      $this->res=mysqli_query($this->conn,$this->how);
      list($re2)=$this->res->fetch_row();
      $response['reftime']=$re2;
      $this->how="SELECT mytime from apptest where reffno=$this->who AND intern=20";
      $this->res=mysqli_query($this->conn,$this->how);
      list($re3)=$this->res->fetch_row();
      $response['itime']=$re3; 
      
      echo json_encode($response);
   }
   function __destruct(){
       mysqli_close($this->conn);
   }
   



}
$name=new Downto();
$name->display();


?>