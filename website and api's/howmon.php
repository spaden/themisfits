<?php
class Kal {
    private $conn,$how,$res,$upd;
    function __construct(){
        $this->conn=mysqli_connect("localhost","root","kalyan","testusers");
       
       $who= $_REQUEST["usname"];
        $this->how="SELECT id,buyername,tellme from refusers where orreff='$who' order by tellme desc";
        $this->res=mysqli_query($this->conn,$this->how);
    }
    function __destruct(){
        mysqli_close($this->conn);
    }
    function giveme(){
        $resp=$this->res;
        $response=array();
        $response['success']=1;
        $response['products']=array();
        while(list($id,$name,$tellme)=$resp->fetch_row()){
             $product=array();
             $product["id"]=$id;
             $product["name"]=$name;
             $product["tellme"]=$tellme;
             array_push($response["products"],$product);
        }
        echo json_encode($response);

    }
    function updateclaim(){
         $id=$_REQUEST["updateclaim"];
         $this->upd="UPDATE refusers set claim = claim + 1 where id='$id'";
         $re2=mysqli_query($this->conn,$this->upd);
         if($re2){
             echo "claim updated";
         }     
   }
}
    
if(isset($_REQUEST["usname"]) && !isset($_REQUEST["updateclaim"])){
    $kk=new Kal();
    $kk->giveme();
        
}else if(isset($_REQUEST["updateclaim"])){

    $kk=new Kal();
    $kk->updateclaim();
}
else {
    $warn=array();
    $warn["error"]="Please relogin to continue";
    echo json_encode($warn);
}

?>