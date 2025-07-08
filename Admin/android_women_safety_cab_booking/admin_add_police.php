<?php
include("dbconnect.php");
extract($_POST);
 
$name=$_REQUEST['name'];
$cont=$_REQUEST['contact'];
$email=$_REQUEST['email'];
$address=$_REQUEST['address'];
$station=$_REQUEST['station'];
 
$area=$_REQUEST['area'];
$password=$_REQUEST['password'];
 
 

$sql = "SELECT id FROM police_details order by id ASC";

 $sid=0;
  $result = $conn->query($sql);
  while($row = $result->fetch_assoc()) 
  {
       $sid=$row['id'];
  }
    $sid=$sid+1;



$qrys=("insert into police_details values('$sid','$name','$cont','$email','$address','$station','$area','$password','0','0')");
if ($conn->query($qrys) === TRUE) 
{
echo "success";
}
else
{
echo "failed";
}	
?>