<?php
include("dbconnect.php");
extract($_POST);
 
$name=$_REQUEST['name'];
$cont=$_REQUEST['cont'];
$email=$_REQUEST['email'];
$addre=$_REQUEST['address'];
$area=$_REQUEST['area'];
 
$pass=$_REQUEST['pass'];
 
 

$sql = "SELECT id FROM user_details order by id ASC";

 $sid=0;
  $result = $conn->query($sql);
  while($row = $result->fetch_assoc()) 
  {
       $sid=$row['id'];
  }
    $sid=$sid+1;



$qrys=("insert into user_details values('$sid','$name','$cont','$email','$area','$addre','$pass','0','0','0','0')");
if ($conn->query($qrys) === TRUE) 
{
echo "success";
}
else
{
echo "failed";
}	
?>