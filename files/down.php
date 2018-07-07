<?php
class Downto {
   private $conn,$how,$res;
   function __construct(){
    $this->conn=mysqli_connect("localhost","root","kalyan","testusers");
    $who=20;
    $this->how="Select count(*) from downusers where reffno = $who";
    $this->res=mysqli_query($this->conn,$this->how);

   }
   function display(){
      list($re)=$this->res->fetch_row();
      echo $re;
   }
   function __destruct(){
       mysqli_close($this->conn);
   }
   



}
$name=new Downto();
$name->display();


?>