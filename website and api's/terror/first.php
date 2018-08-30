<?php
$connect=new mysqli("localhost","misfit","misfitsstartup","testusers"); 
if($connect->connect_error) {
  echo "success";
}
$email=$_POST['username'];
if(isset($_POST['username']) && isset($_POST['pass'])){
$que="select name,pass from uspas where name='".$email."';";
$result = $connect->query($que);
   if($result->num_rows > 0){
            echo "cool";
      while($row =$result->fetch_assoc()){
            echo $row["name"]," ",$row["pass"];

      }

   }  

}

?>