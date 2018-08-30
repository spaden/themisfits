<?php
class newsfeed {
    private $conn,$how,$res;
    public function __construct(){
     $this->conn=mysqli_connect("localhost","misfit","misfitsstartup","testusers"); 
    }
    public function __destruct(){
        mysqli_close($this->conn);
    }
    function newtp(){
     
        $this->how="Select id,post,name,likes,dislikes,tellme from newsfeed order by tellme desc";
        $re2=mysqli_query($this->conn,$this->how);    
        $response=array();
        $response['products']=array();
            while(list($id,$po,$na,$li,$di,$te)=$re2->fetch_row()){
                         $product=array();
                         $product['id']=$id;
                         $product['post']=$po;
                         $product['name']=$na;
                         $product['likes']=$li;
                         $product['dislikes']=$di;
                         $product['timeline']=$te;
                         array_push($response['products'],$product);
            }
            echo json_encode($response);
            //mysqli_close($conn);     
    }
    function plus(){
    
        $dt=date('Y-m-d H:i:s');
        $npost=$_REQUEST["upost"];
        $esp=mysqli_real_escape_string($this->conn, $_REQUEST["upost"]);
        $name=$_REQUEST["uname"];
        $this->how = "INSERT INTO newsfeed (post,name, likes,dislikes,tellme) VALUES ('$esp','$name',0,0,'$dt')";
         
        $this->res=mysqli_query($this->conn,$this->how);    
        //mysqli_close($conn);     
        newtp(); 
    }

    function likes(){
        $who=$_REQUEST["id"];
        $this->how="UPDATE  newsfeed set likes=likes+1 where id='$who'";
        $this->res=mysqli_query($this->conn,$this->how);
    
    }

    function dislikes(){
        $who=$_REQUEST["id"];
        $this->how="UPDATE  newsfeed set dislikes=dislikes+1 where id='$who'";
        $re2=mysqli_query($this->conn,$this->how);
    } 

}
$qume=new newsfeed();
if($_REQUEST["data"]=="newposts"){
  $qume->newtp();
} 
if($_REQUEST["data"]=="newwod") $qume->plus();
if($_REQUEST["data"]=="like") $qume->likes();
if($_REQUEST["data"]=="dislike") $qume->dislikes();








?>