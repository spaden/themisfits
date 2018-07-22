<?php

if($_REQUEST["data"]=="newposts") newtp();
if($_REQUEST["data"]=="newwod") plus();
if($_REQUEST["data"]=="like") likes();
if($_REQUEST["data"]=="dislike") dislikes();

function newtp(){
    $conn = mysqli_connect("localhost","root","kalyan","testusers");    

    $how="Select id,post,name,likes,dislikes,tellme from newsfeed order by tellme desc ";
    $re2=mysqli_query($conn,$how);    
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
        mysqli_close($conn);     
}

function plus(){
    
    $dt=date('Y-m-d H:i:s');
    $npost=$_REQUEST["upost"];
    $name=$_REQUEST["uname"];
    $stmt = "INSERT INTO newsfeed (post,name, likes,dislikes,tellme) VALUES ('$npost','$name',0,0,'$dt')";
    $conn = mysqli_connect("localhost","root","kalyan","testusers");    
    $re2=mysqli_query($conn,$stmt);    
    mysqli_close($conn);     
    newtp(); 
}
function callme(){
    $conn = mysqli_connect("localhost","root","kalyan","testusers");    

    $q="DELETE * from newsfeed";
    $re2=mysqli_query($conn,$q);    
    mysqli_close($conn);     
    newtp();
}
function likes(){
    $conn = mysqli_connect("localhost","root","kalyan","testusers");
    $who=$_REQUEST["id"];
    $q="UPDATE  newsfeed set likes=likes+1 where id='$who'";
    $re2=mysqli_query($conn,$q);

}
function dislikes(){
    $conn = mysqli_connect("localhost","root","kalyan","testusers");
    $who=$_REQUEST["id"];
    $q="UPDATE  newsfeed set dislikes=dislikes+1 where id='$who'";
    $re2=mysqli_query($conn,$q);
}
?>